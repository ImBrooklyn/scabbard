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
     * Target container ID
     */
    private final String containerId;

    /**
     * Docker server address, defaults to the local /var/run/docker.sock
     */
    private final String dockerEndpoint;

    /**
     * Whether to force removal
     */
    private final Boolean force;
}
