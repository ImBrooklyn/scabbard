package uk.org.brooklyn.chaos.util;

import org.junit.jupiter.api.Test;
import uk.org.brooklyn.chaos.experiment.CpuLoad;

/**
 * @author ImBrooklyn
 * @since 09/12/2023
 */
public class TrivialTest {
    @Test
    public void testCommand() {
        CpuLoad cpuLoad = CpuLoad.builder()
                .cpuCount(1)
                .cpuPercent(100)
                .build();
        System.out.println(cpuLoad.printCommand());
    }
}
