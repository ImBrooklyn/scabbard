package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * 本地端口占用，验证端口已被占用的情况下，使用此端口的业务容错能力
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkOccupy extends AutoAssembledChaosExperiment {

    /**
     * 指定被占用的端口，（必填项）
     */
    private final Integer port;

    /**
     * 强制占用此端口，会将已使用此端口的进程杀掉
     */
    private final Boolean force;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
