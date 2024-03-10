package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 此实验会暂停进程。支持命令行或者命令中进程匹配。
 * 此实验可以验证程序 Hang 时，系统的容错能力。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ProcessStop extends AutowiredChaosExperiment {

    /**
     * 进程关键词，会在整个命令行中查找
     */
    private final String process;

    /**
     * 进程命令，只会在命令中查找
     */
    private final String processCmd;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
