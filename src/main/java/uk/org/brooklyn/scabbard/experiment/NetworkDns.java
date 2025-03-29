package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * DNS tampering experiment. Modifies local hosts file to alter domain resolution.
 * Validates system fault tolerance under abnormal DNS conditions.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkDns extends AutowiredChaosExperiment {

    /**
     * Target domain name (required)
     */
    private final String domain;

    /**
     * Mapped IP address (required)
     */
    private final String ip;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
