package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 提升磁盘读写 io 负载，可以指定受影响的目录，也可以通过调整读写的块大小提升 io 负载，
 * 默认值是 10，单位是 M，块的数量固定为 100，即在默认情况下，写会占用 1000M 的磁盘空间，
 * 读会固定占用 600M 的空间，因为读操作会先创建一个 600M 的固定大小文件，预计 3s之内，
 * 在创建时写 io 会升高。验证磁盘 io 高负载下对系统服务的影响，比如监控告警、服务稳定性等。
 *
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class DiskBurn extends AutoAssembledChaosExperiment {

    /**
     * 指定提升磁盘 io 的目录，会作用于其所在的磁盘上，默认值是 /
     */
    private final String path;

    /**
     * 触发提升磁盘读 IO 负载，会创建 600M 的文件用于读，销毁实验会自动删除
     */
    private final Boolean read;

    /**
     * 触发提升磁盘写 IO 负载，会根据块大小的值来写入一个文件，比如块大小是 10，
     * 则固定的块的数量是 100，则会创建 1000M 的文件，销毁实验会自动删除
     */
    private final Boolean write;

    /**
     * 块大小, 单位是 M, 默认值是 10，一般不需要修改，除非想更大的提高 io 负载
     */
    private final String size;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
