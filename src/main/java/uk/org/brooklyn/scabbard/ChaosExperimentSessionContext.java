package uk.org.brooklyn.scabbard;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ImBrooklyn
 * @since 09/12/2023
 */
public class ChaosExperimentSessionContext {

    private ChaosExperimentSessionContext() {
    }

    private static final Map<String, IChaosExperiment> experiments = new ConcurrentHashMap<>();



    public static void add(String uid, IChaosExperiment experiment) {
        experiments.put(uid, experiment);
    }

    public static void remove(String uid) {
        experiments.remove(uid);
    }

    /**
     * Destroy all chaos experiments, possibly used as:
     * <code>
     *     Runtime.getRuntime().addShutdownHook(new Thread(ChaosExperimentSessionContext::destroyAll));
     * </code>
     */
    public static void destroyAll() {
        for (Map.Entry<String, IChaosExperiment> entry : experiments.entrySet()) {
            entry.getValue().destroy();
            experiments.remove(entry.getKey());
        }
    }
}
