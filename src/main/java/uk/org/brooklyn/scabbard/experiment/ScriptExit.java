package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Triggers controlled process termination through custom script functions.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ScriptExit extends AutowiredChaosExperiment {

    /**
     * Exit status code (default: 1)
     */
    private final Integer exitCode;

    /**
     * Termination message for logging
     */
    private final String exitMessage;

    /**
     * Script file path (required parameter)
     */
    private final String file;

    /**
     * Target function name in script (required parameter)
     */
    private final String functionName;

    /**
     * Experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
