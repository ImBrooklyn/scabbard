package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * Container network delay scenario {@link NetworkDelay}
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DockerNetworkDelay extends AutowiredChaosExperiment {

    /**
     * Target IP address(es). Supports subnet masks (e.g., 192.168.1.0/24 for 192.168.1.0-255).
     * Can specify multiple IPs as comma-separated values: 192.168.1.1,192.168.2.1.
     * Single IP formats: 192.168.1.1 or 192.168.1.1/32.
     */
    private final String destinationIp;

    /**
     * Excluded ports (preserves essential communication by default). Accepts multiple values:
     * comma-separated (22, 8000) or ranges (8000-8010). Incompatible with localPort/remotePort.
     */
    private final String excludePort;

    /**
     * Excluded IP address(es). Supports subnet masks (e.g., 192.168.1.0/24) and multiple formats:
     * single IP (192.168.1.1), CIDR notation (192.168.1.1/32), or comma-separated IPs.
     */
    private final String excludeIp;

    /**
     * --interface parameter.
     * Network interface card (NIC) name, e.g., eth0 (required).
     */
    @ExperimentArg("interface")
    private final String nic;

    /**
     * Local port(s) for exposed services. Accepts comma-separated values or ranges (80,8000-8080).
     */
    private final String localPort;

    /**
     * Delay time fluctuation range in milliseconds.
     */
    private final Long offset;

    /**
     * Remote port(s) for external services. Accepts comma-separated values or ranges (80,8000-8080).
     */
    private final String remotePort;

    /**
     * Base delay time in milliseconds (required).
     */
    private final Long time;

    /**
     * Force override existing tc rules. Use with caution.
     */
    private final Boolean force;

    /**
     * Ignore port exclusion when 'ss' command is unavailable (excludePort compatibility).
     */
    private final String ignorePeerPort;

    /**
     * Experiment duration in seconds (common parameter).
     */
    private final Integer timeout;

    // Docker parameters

    /**
     * Target container ID.
     */
    private final String containerId;

    /**
     * Docker server address, defaults to local /var/run/docker.sock.
     */
    private final String dockerEndpoint;

    /**
     * chaosblade-tool image repository, default: `registry.cn-hangzhou.aliyuncs.com/chaosblade`.
     */
    private final String imageRepo;
}
