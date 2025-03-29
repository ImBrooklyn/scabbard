package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * Network packet corruption experiment. WARNING: When applying corruption to entire NIC
 * (without specifying ports/ips), MUST set timeout or excludePort to prevent system
 * inaccessibility. If occurs, reboot required. Ports use OR logic (local|remote), while
 * IP:Port uses AND logic.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkCorrupt extends AutowiredChaosExperiment {

    /**
     * Target IP address(es). Supports CIDR notation (e.g., 192.168.1.0/24),
     * single IP (192.168.1.1), or comma-separated values (192.168.1.1,192.168.2.1)
     */
    private final String destinationIp;

    /**
     * Excluded ports (format: 22,8000 or 8000-8010). Preserves communication.
     * Cannot be used with localPort/remotePort
     */
    private final String excludePort;

    /**
     * Excluded IP address(es). Same format as destinationIp
     */
    private final String excludeIp;

    /**
     * Network Interface Card (e.g., eth0) (required)
     */
    @ExperimentArg("interface")
    private final String nic;

    /**
     * Local port(s) (services exposed locally). Format: 80,8000-8080
     */
    private final String localPort;

    /**
     * Delay offset (milliseconds)
     */
    private final Long offset;

    /**
     * Remote port(s) (external services). Format: 80,8000-8080
     */
    private final String remotePort;

    /**
     * Packet corruption percentage (1-100)
     */
    private final Integer percent;

    /**
     * Force overwrite existing tc rules (use with caution)
     */
    private final Boolean force;

    /**
     * Bypass port exclusion when ss command not found
     */
    private final String ignorePeerPort;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
