package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Memory load experiment. WARNING: This scenario fills memory and may enter
 * an irrecoverable state even with timeout specified. System reboot may be
 * required. Recommended to use percentage-based allocation.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class MemLoad extends AutowiredChaosExperiment {

    /**
     * Memory usage percentage (0-100)
     */
    private final Integer memPercent;

    /**
     * Memory allocation mode:
     * - "ram" (code implementation with rate control, recommended)
     * - "cache" (tmpfs mounting, default)
     */
    private final String mode;

    /**
     * Reserved memory size in MB. Ignored if memPercent is specified.
     */
    private final String reserve;

    /**
     * Memory allocation rate in MB/s (only effective in "ram" mode)
     */
    private final Integer rate;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
