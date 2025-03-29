package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Container DNS tampering experiment {@link NetworkDns}
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DockerNetworkDns extends AutowiredChaosExperiment {

    /**
     * Domain name (required)
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

    // Docker parameters

    /**
     * Target container ID
     */
    private final String containerId;

    /**
     * Docker server address, defaults to local /var/run/docker.sock
     */
    private final String dockerEndpoint;

    /**
     * chaosblade-tool image repository, default: `registry.cn-hangzhou.aliyuncs.com/chaosblade`
     */
    private final String imageRepo;
}
