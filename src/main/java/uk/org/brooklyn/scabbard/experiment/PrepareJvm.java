package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment(prefix = "blade prepare")
@Builder
public class PrepareJvm extends AutoAssembledChaosExperiment {

    /**
     * 指定 JAVA_HOME 路径，用于指定 java bin 和 tools.jar，如果不添加此参数，
     * 默认会优先获取 JAVA_HOME 环境变量，如果获取失败，会解析指定进程参数获取
     * JAVA_HOME，获取失败，会使用 chaosblade 自带的 tools.jar
     */
    @ExperimentArg("javaHome")
    private final String javaHome;

    /**
     * java 进程ID
     */
    private final String pid;

    /**
     * java agent 暴露服务的本地端口，用于下发实验命令
     */
    private final Integer port;

    /**
     * java 进程关键词，用于定位 java 进程
     */
    private final String process;

    /**
     * 开启 debug 模式
     */
    private final Boolean debug;
}
