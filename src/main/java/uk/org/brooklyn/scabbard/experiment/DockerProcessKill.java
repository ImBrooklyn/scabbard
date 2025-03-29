package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Container process kill experiment {@link ProcessKill}
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DockerProcessKill extends AutowiredChaosExperiment {

    /**
     * Process keyword (searched across the entire command line)
     */
    private final String process;

    /**
     * Process command (searched only in the command name)
     */
    private final String processCmd;

    /**
     * Maximum number of processes to kill (0 means unlimited)
     */
    private final Integer count;

    /**
     * Kill signal (default: 9)
     */
    private final Integer signal;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;

    // Docker parameters

    /**
     * Overwrite existing chaosblade tool in container (default: false).
     * Chaosblade deployment path in container: /opt/chaosblade
     */
    private final Boolean bladeOverride;

    /**
     * Full path to local chaosblade-VERSION.tar.gz package for container deployment
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
