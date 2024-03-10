package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 容器内 CPU 负载实验场景，同基础资源的 CPU 场景
 *
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class DockerCpuLoad extends AutoAssembledChaosExperiment {
    /**
     * 指定 CPU 负载百分比，取值 0-100
     */
    private final Integer cpuPercent;

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

    // docker

    /**
     * 是否覆盖容器内已有的 chaosblade 工具，默认是 false，表示不覆盖，
     * chaosblade 在容器内的部署路径为 /opt/chaosblade
     */
    private final Boolean bladeOverride;

    /**
     * 指定本地 chaosblade-VERSION.tar.gz 工具包全路径，用于拷贝到容器内执行
     */
    private final String bladeTarFile;

    /**
     * 目标容器 ID
     */
    private final String containerId;

    /**
     * Docker server 地址，默认为本地的 /var/run/docker.sock
     */
    private final String dockerEndpoint;
}
