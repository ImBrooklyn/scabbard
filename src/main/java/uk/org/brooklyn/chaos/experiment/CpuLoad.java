package uk.org.brooklyn.chaos.experiment;

import lombok.Builder;
import uk.org.brooklyn.chaos.AutoAssembledChaosExperiment;
import uk.org.brooklyn.chaos.annotation.Experiment;

/**
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class CpuLoad extends AutoAssembledChaosExperiment {
    private final Integer cpuPercent;
    private final Integer timeout;
    private final Integer cpuCount;
    private final String cpuList;
}
