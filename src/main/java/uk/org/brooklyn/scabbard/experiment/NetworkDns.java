package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * 篡改 dns 域名解析实验场景。此实验会修改本地的 hosts，篡改域名地址映射。
 * 该场景主要验证域名解析异常的情况下，系统的自我容错能力。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkDns extends AutoAssembledChaosExperiment {

    /**
     * 域名 (必要参数)
     */
    private final String domain;

    /**
     * 映射的 ip (必要参数)
     */
    private final String ip;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
