package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;
import uk.org.brooklyn.scabbard.annotation.ExperimentArg;

/**
 * JVM preparation experiment for attaching Java agents.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment(prefix = "blade prepare")
@Builder
public class PrepareJvm extends AutowiredChaosExperiment {

    /**
     * JAVA_HOME path for java binaries and tools.jar.
     * Priority order: 1) this parameter 2) JAVA_HOME env 3) process arguments
     * 4) Built-in chaosblade tools.jar
     */
    @ExperimentArg("javaHome")
    private final String javaHome;

    /**
     * Target JVM process ID
     */
    private final String pid;

    /**
     * Local port for the Java agent service (command channel)
     */
    private final Integer port;

    /**
     * Process keyword for JVM identification
     */
    private final String process;

    /**
     * Enable debug mode
     */
    private final Boolean debug;
}
