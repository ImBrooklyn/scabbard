package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 指定内存占用，注意，此场景触发内存占用满，即使指定了 timeout 参数，也可能出现
 * 通过 blade 工具无法恢复的情况，可通过重启机器解决。推荐指定内存百分比。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class MemLoad extends AutoAssembledChaosExperiment {

    /**
     * 内存使用率，取值 0 - 100
     */
    private final Integer memPercent;

    /**
     * 内存占用模式，有 ram 和 cache 两种。
     * ram 采用代码实现，可控制占用速率，优先推荐此模式。
     * cache 是通过挂载tmpfs实现，默认值为 cache。
     */
    private final String mode;

    /**
     * 保留内存的大小，单位是MB，如果 memPercent 参数存在，则优先使用 memPercent 参数
     */
    private final String reserve;

    /**
     * 内存占用速率，单位是 MB/S，仅在 mode 为 ram 时生效
     */
    private final Integer rate;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
