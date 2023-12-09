package uk.org.brooklyn.chaos;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ImBrooklyn
 * @since 08/12/2023
 */
@Slf4j
public abstract class AbstractChaosExperiment implements IChaosExperiment {

    private static final String HOME;

    static {
        String bladeHome = System.getenv("CHAOS_BLADE_HOME");
        bladeHome = bladeHome == null || bladeHome.isBlank() ? "" : bladeHome;
        HOME = bladeHome.isBlank() || bladeHome.startsWith("/") ? bladeHome : bladeHome.concat("/");
    }

    private String uid = null;

    protected abstract String command();

    @Override
    public String uid() {
        return uid;
    }

    @Override
    public int status() {
        if (isPreparing()) {
            return 0;
        }
        JSONObject res = execute("blade status ".concat(uid));
        String status = res.getJSONObject("result").getString("Status");
        return Optional.ofNullable(status)
                .map(ExperimentStatus::parse)
                .map(ExperimentStatus::getCode)
                .orElse(Integer.MAX_VALUE);
    }

    @Override
    public String exec() {
        if (!isPreparing()) {
            throw new IllegalStateException("status: " + status());
        }
        JSONObject res = execute(command());
        this.uid = res.getString("result");
        return this.uid;
    }

    @Override
    public void destroy() {
        if (isPreparing()) {
            throw new IllegalStateException("status: " + status());
        }
        execute("blade destroy " + this.uid);
    }

    private boolean isPreparing() {
        return uid() == null;
    }

    private JSONObject execute(String cmd) {
        log.info("Executing command: [{}]", cmd);
        String[] commands = cmd.split(" ");
        String blade = commands[0];
        if (!"blade".equals(blade)) {
            throw new IllegalArgumentException("Bad parameter, command must start with \"blade\"");
        }
        commands[0] = HOME.concat(blade);
        Process process;
        try {
            process = new ProcessBuilder().command(commands).start();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        String output = String.join("\n", lines);
        JSONObject res = JSON.parseObject(output);
        int code = res.getInteger("code");
        boolean success = res.getBoolean("success");
        if (code != 200 || !success) {
            throw new IllegalStateException(
                    String.format("Command [%s] executing failed, code: %d, success: %s", cmd, code, success));
        }

        return res;
    }

}
