package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

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
