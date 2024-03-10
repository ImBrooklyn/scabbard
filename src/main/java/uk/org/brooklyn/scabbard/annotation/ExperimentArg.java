package uk.org.brooklyn.scabbard.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ImBrooklyn
 * @since 10/03/2024
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExperimentArg {
    /**
     * Argument name of the chaos experiment.
     *
     * @return Command
     */
    String value() default "";
}
