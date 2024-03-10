package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 此实验会指定进程号杀掉进程。支持命令行或者命令中进程匹配。
 * 此实验可以验证程序的自愈能力，或者服务进程不存在时，系统的容错能力。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ProcessKill extends AutoAssembledChaosExperiment {

    /**
     * 进程关键词，会在整个命令行中查找
     */
    private final String process;

    /**
     * 进程命令，只会在命令中查找
     */
    private final String processCmd;

    /**
     * 限制杀掉进程的数量，0 表示无限制
     */
    private final Integer count;

    /**
     * 指定杀进程的信号量，默认是 9
     */
    private final Integer signal;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
