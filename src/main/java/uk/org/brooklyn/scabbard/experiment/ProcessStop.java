package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Process suspension experiment. Validates system fault tolerance when processes
 * become unresponsive. Supports both full command-line and executable name matching.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ProcessStop extends AutowiredChaosExperiment {

    /**
     * Process keyword (searches entire command line)
     */
    private final String process;

    /**
     * Process command (searches executable name only)
     */
    private final String processCmd;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
