package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * Network packet reordering experiment. WARNING: When applying reordering to entire NIC
 * (without ports/ips), MUST set timeout/excludePort to prevent system inaccessibility.
 * Ports use OR logic (local|remote), IP:Port uses AND logic. Requires correlation/gap
 * parameters for precise reordering control.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkReorder extends AutowiredChaosExperiment {

    // Reused from NetworkCorrupt/Duplicate
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
     * Delay offset (milliseconds)
     */
    private final Long offset;

    /**
     * Packet correlation with previous (0-100) (required)
     */
    private final Integer correlation;

    /**
     * Reordering gap (packet sequence distance)
     */
    private final Integer gap;

    /**
     * Immediate packet percentage (1-100)
     */
    private final Integer percent;

    /**
     * Base network latency (milliseconds, default: 10)
     */
    private final Long time;

    // Common safety controls
    private final Boolean force;
    private final String ignorePeerPort;
    private final Integer timeout;
}
