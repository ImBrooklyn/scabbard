package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * CPU-related chaos experiments include full CPU load, allowing specification of core count,
 * specific core overload, or total CPU load percentage.
 * <p>
 * Aims to validate system capabilities such as service quality, monitoring & alerting,
 * traffic scheduling, and elastic scaling under specific CPU load conditions.
 *
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class CpuLoad extends AutowiredChaosExperiment {
    /**
     * Specifies the CPU load percentage (0-100)
     */
    protected final Integer cpuPercent;

    /**
     * Specifies the number of CPU cores to be fully loaded
     */
    private final Integer cpuCount;

    /**
     * Specifies specific CPU cores to be fully loaded (core indices start from 0, e.g., 0-3 or 1,3)
     */
    private final String cpuList;

    /**
     * Sets the experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
