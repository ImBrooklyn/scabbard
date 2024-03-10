package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * 容器内 kill 进程实验 {@link ProcessKill}
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class DockerProcessKill extends AutowiredChaosExperiment {

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
