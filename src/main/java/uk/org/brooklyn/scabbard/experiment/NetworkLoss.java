package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * Network packet loss experiment.
 * <p>
 * WARNING: When applying loss to entire NIC
 * (without ports/ips), MUST set timeout/excludePort to prevent system inaccessibility.
 * Ports use OR logic (local|remote), IP:Port uses AND logic. Tests system fault
 * tolerance under network stress.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkLoss extends AutowiredChaosExperiment {

    // Reused from NetworkCorrupt with identical documentation
    private final String destinationIp;
    private final String excludePort;
    private final String excludeIp;

    /**
     * Network Interface Card (e.g., eth0) (required)
     */
    @ExperimentArg("interface")
    private final String nic;

    // Standard port parameters
    private final String localPort;
    private final String remotePort;

    /**
     * Packet loss percentage [0-100] (required)
     */
    private final Integer percent;

    // Common safety controls
    private final Boolean force;
    private final String ignorePeerPort;
    private final Integer timeout;
}
