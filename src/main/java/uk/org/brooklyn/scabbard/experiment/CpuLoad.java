package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * CPU 相关的混沌实验包含 CPU 满载，可以指定核数、具体核满载或者总 CPU 负载百分比。
 * 旨在 CPU 在特定负载下，验证服务质量、监控告警、流量调度、弹性伸缩等能力。
 *
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class CpuLoad extends AutowiredChaosExperiment {
    /**
     * 指定 CPU 负载百分比，取值 0-100
     */
    protected final Integer cpuPercent;

    /**
     * 指定 CPU 满载的个数
     */
    private final Integer cpuCount;

    /**
     * 指定 CPU 满载的具体核，核索引从 0 开始 (0-3 or 1,3)
     */
    private final String cpuList;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
