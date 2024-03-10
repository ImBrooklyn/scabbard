package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 容器内dns篡改实验 {@link NetworkDns}
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DockerNetworkDns extends AutowiredChaosExperiment {

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

    // docker

    /**
     * 目标容器 ID
     */
    private final String containerId;

    /**
     * Docker server 地址，默认为本地的 /var/run/docker.sock
     */
    private final String dockerEndpoint;

    /**
     * chaosblade-tool 镜像仓库地址，默认是 `registry.cn-hangzhou.aliyuncs.com/chaosblade`
     */
    private final String imageRepo;
}
