package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Executes latency scenarios by invoking custom script functions.
 *
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Experiment
@Builder
public class ScriptDelay extends AutowiredChaosExperiment {

    /**
     * Delay duration in milliseconds (required parameter)
     */
    private final Long time;

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
