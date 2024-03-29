package uk.org.brooklyn.scabbard.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ImBrooklyn
 * @since 08/12/2023
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Experiment {
    /**
     * Basic command of the chaos experiment.
     *
     * @return Command
     */
    String value() default "";

    String prefix() default "blade create";
}
