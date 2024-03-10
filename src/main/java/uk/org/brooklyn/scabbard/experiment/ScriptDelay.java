package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 通过指定脚本和函数执行延迟场景。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ScriptDelay extends AutoAssembledChaosExperiment {

    /**
     * 延迟时间，单位是毫秒（必要参数）
     */
    private final Long time;

    /**
     * 脚本路径（必要参数）
     */
    private final String file;

    /**
     * 脚本中的函数名（必要参数）
     */
    private final String functionName;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
