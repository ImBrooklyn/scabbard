package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DockerContainerRemove extends AutowiredChaosExperiment {
    /**
     * 目标容器 ID
     */
    private final String containerId;

    /**
     * Docker server 地址，默认为本地的 /var/run/docker.sock
     */
    private final String dockerEndpoint;

    /**
     * 是否强制删除
     */
    private final Boolean force;
}
