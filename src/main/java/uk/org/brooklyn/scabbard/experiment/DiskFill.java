package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Simulates disk filling by specifying target directories and fill size.
 * Validates system behavior under full disk conditions, including monitoring
 * alerts and service stability.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DiskFill extends AutowiredChaosExperiment {

    /**
     * Target directory for filling (default: /)
     */
    private final String path;

    /**
     * File size to fill in megabytes (M), accepts integer values (e.g., --size 1024)
     */
    private final String size;

    /**
     * Reserved disk space in MB (unitless positive integer, e.g., 1024).
     * If multiple parameters (size/percent/reserve) are present, priority order: percent > reserve > size
     */
    private final String reserve;

    /**
     * Target disk usage percentage (0-100)
     */
    private final Integer percent;

    /**
     * Whether to retain filled files after experiment
     */
    private final Boolean retainHandle;

    /**
     * Sets experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
