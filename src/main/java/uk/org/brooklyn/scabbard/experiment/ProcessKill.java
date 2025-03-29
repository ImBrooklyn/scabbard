package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Process termination experiment. Validates system self-healing capability and
 * service fault tolerance when target processes are killed. Supports both full
 * command-line matching and process command matching.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ProcessKill extends AutowiredChaosExperiment {

    /**
     * Process keyword (searches entire command line)
     */
    private final String process;

    /**
     * Process command (searches only executable name)
     */
    private final String processCmd;

    /**
     * Maximum processes to kill (0 = unlimited)
     */
    private final Integer count;

    /**
     * Termination signal (default: 9/SIGKILL)
     */
    private final Integer signal;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
