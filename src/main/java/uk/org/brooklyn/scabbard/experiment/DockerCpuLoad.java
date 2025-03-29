package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Container CPU load experiment scenario, equivalent to base resource CPU experiments
 *
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class DockerCpuLoad extends AutowiredChaosExperiment {
    /**
     * Specifies CPU load percentage (0-100)
     */
    private final Integer cpuPercent;

    /**
     * Specifies number of fully-loaded CPU cores
     */
    private final Integer cpuCount;

    /**
     * Specifies specific CPU cores to load (core indexes starting from 0, e.g., 0-3 or 1,3)
     */
    private final String cpuList;

    /**
     * Sets experiment duration in seconds (common parameter)
     */
    private final Integer timeout;

    // Docker specific parameters

    /**
     * Whether to overwrite existing chaosblade tool in container (default: false).
     * Default deployment path in container: /opt/chaosblade
     */
    private final Boolean bladeOverride;

    /**
     * Full path to local chaosblade-VERSION.tar.gz package for copying into container
     */
    private final String bladeTarFile;

    /**
     * Target container ID
     */
    private final String containerId;

    /**
     * Docker server address, defaults to local /var/run/docker.sock
     */
    private final String dockerEndpoint;
}
