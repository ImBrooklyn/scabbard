package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * Network packet duplication experiment.
 * <p>
 * WARNING: When applying duplication to entire NIC
 * (without ports/ips), MUST set timeout/excludePort to prevent system inaccessibility.
 * Ports use OR logic (local|remote), IP:Port uses AND logic.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkDuplicate extends AutowiredChaosExperiment {

    // Reused parameters with identical documentation from NetworkCorrupt
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
     * Packet duplication percentage (1-100)
     */
    private final Integer percent;

    /**
     * Delay offset (milliseconds)
     */
    private final Long offset;

    // Common safety controls
    private final Boolean force;
    private final String ignorePeerPort;
    private final Integer timeout;
}
