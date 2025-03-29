package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Local port occupation experiment. Validates system resilience when accessing
 * already occupied service ports.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkOccupy extends AutowiredChaosExperiment {

    /**
     * Target port to occupy (required)
     */
    private final Integer port;

    /**
     * Force occupation by terminating existing port processes
     */
    private final Boolean force;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
