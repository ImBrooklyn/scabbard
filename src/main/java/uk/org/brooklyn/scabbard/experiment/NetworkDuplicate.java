package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutoAssembledChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * 可以指定网卡、本地端口、远程端口、目标 IP 包重复。需要特别注意，如果不指定端口、ip 参数，
 * 而是整个网卡包重复，切记要添加 timeout 参数或者 excludePort 参数，前者是指定运行
 * 时间，自动停止销毁实验，后者是指定排除掉不受影响的端口，两者都是防止机器无法连接的情况，
 * 如果真实发生此问题，重启机器即可恢复。
 * 本地端口和远程端口之间是或的关系，即这两个端口都会生效，只要指定了本地端口或者远程端口，
 * 无需指定需要排除的端口。端口与 IP 之间是与的关系，即指定的 IP:PORT 发生包重复。
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class NetworkDuplicate extends AutoAssembledChaosExperiment {

    /**
     * 目标 IP。 支持通过子网掩码来指定一个网段的IP地址, 例如 192.168.1.0/24. 则
     * 192.168.1.0~192.168.1.255 都生效。你也可以指定固定的 IP，如
     * 192.168.1.1 或者 192.168.1.1/32，也可以通过都号分隔多个参数，例如
     * 192.168.1.1,192.168.2.1。
     */
    private final String destinationIp;

    /**
     * 排除掉的端口，默认会忽略掉通信的对端端口，目的是保留通信可用。可以指定多个，
     * 使用逗号分隔或者连接符表示范围，例如 22,8000 或者 8000-8010。 这个参数不能与
     * localPort 或者 remotePort 参数一起使用
     */
    private final String excludePort;

    /**
     * 排除受影响的 IP，支持通过子网掩码来指定一个网段的IP地址, 例如
     * 192.168.1.0/24. 则 192.168.1.0~192.168.1.255 都生效。也可以指定固定的 IP，
     * 如 192.168.1.1 或者 192.168.1.1/32，也可以通过都号分隔多个参数，例如
     * 192.168.1.1,192.168.2.1。
     */
    private final String excludeIp;

    /**
     * --interface 参数。
     * 网卡设备(network interface card)，例如 eth0 (必要参数)
     */
    @ExperimentArg("interface")
    private final String nic;

    /**
     * 本地端口，一般是本机暴露服务的端口。可以指定多个，使用逗号分隔或者连接符表示范围，
     * 例如 80,8000-8080
     */
    private final String localPort;

    /**
     * 延迟时间上下浮动的值, 单位是毫秒
     */
    private final Long offset;

    /**
     * 远程端口，一般是要访问的外部暴露服务的端口。可以指定多个，使用逗号分隔或者连接符
     * 表示范围，例如 80,8000-8080
     */
    private final String remotePort;

    /**
     * 包重复百分比，取值 1-100
     */
    private final Integer percent;

    /**
     * 强制覆盖已有的 tc 规则，请务必在明确之前的规则可覆盖的情况下使用
     */
    private final Boolean force;

    /**
     * 针对添加 excludePort 参数，报 ss 命令找不到的情况下使用，忽略排除端口
     */
    private final String ignorePeerPort;

    /**
     * 设定运行时长，单位是秒，通用参数
     */
    private final Integer timeout;
}
