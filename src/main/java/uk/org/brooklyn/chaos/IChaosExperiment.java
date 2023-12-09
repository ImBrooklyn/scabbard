package uk.org.brooklyn.chaos;

/**
 * @author ImBrooklyn
 * @since 08/12/2023
 */
public interface IChaosExperiment {
    /**
     * Experiment uid
     *
     * @return uid
     */
    String uid();

    /**
     * Experiment status
     *
     * @return status
     */
    int status();

    /**
     * Execute experiment
     *
     * @return uid
     */
    String exec();

    /**
     * Destroy experiment
     */
    void destroy();
}
