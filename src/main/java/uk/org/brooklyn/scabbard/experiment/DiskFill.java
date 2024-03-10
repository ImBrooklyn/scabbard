package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 模拟磁盘填充，可以指定填充的目录和填充大小。验证磁盘满下对系统服务的影响，比如监控告警、服务稳定性等。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DiskFill extends AutowiredChaosExperiment {

    /**
     * 需要填充的目录，默认值是 /
     */
    private final String path;

    /**
     * 需要填充的文件大小，单位是 M，取值是整数，例如 --size 1024
     */
    private final String size;

    /**
     * 保留磁盘大小，单位是MB。取值是不包含单位的正整数，例如 1024。
     * 如果 size、percent、reserve 参数都存在，优先级是 percent > reserve > size
     */
    private final String reserve;

    /**
     * 指定磁盘使用率，取值 0-100
     */
    private final Integer percent;

    /**
     * 是否保留填充
     */
    private final Boolean retainHandle;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
