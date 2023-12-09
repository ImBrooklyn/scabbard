package uk.org.brooklyn.chaos.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ImBrooklyn
 * @since 08/12/2023
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Experiment {
    /**
     * Basic command of the chaos experiment.
     *
     * @return Command
     */
    String value() default "";
}
