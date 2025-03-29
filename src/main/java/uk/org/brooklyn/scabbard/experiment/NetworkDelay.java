package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * Network latency injection experiment.
 * <p>
 * WARNING: When applying delay to entire NIC
 * (without ports/ips), MUST set timeout/excludePort to prevent system lockout.
 * Ports use OR logic (local|remote), IP:Port uses AND logic. Tests system fault
 * tolerance under network stress.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkDelay extends AutowiredChaosExperiment {

    // Reused from NetworkCorrupt with identical documentation
    private final String destinationIp;
    private final String excludePort;
    private final String excludeIp;

    /**
     * Network Interface Card (e.g., eth0) (required)
     */
    @ExperimentArg("interface")
    private final String nic;

    // Port parameters matching NetworkCorrupt format
    private final String localPort;
    private final String remotePort;

    /**
     * Base latency duration (milliseconds) (required)
     */
    private final Long time;

    /**
     * Latency fluctuation range (milliseconds)
     */
    private final Long offset;

    // Common safety parameters from NetworkCorrupt
    private final Boolean force;
    private final String ignorePeerPort;
    private final Integer timeout;
}
