package uk.org.brooklyn.chaos;

import lombok.SneakyThrows;
import uk.org.brooklyn.chaos.annotation.Experiment;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author ImBrooklyn
 * @since 09/12/2023
 */
public abstract class AutoAssembledChaosExperiment extends AbstractChaosExperiment {
    @Override
    @SneakyThrows(IllegalAccessException.class)
    protected String command() {

        Class<?> clazz = this.getClass();
        Experiment anno = clazz.getAnnotation(Experiment.class);

        if (anno == null) {
            throw new IllegalStateException(
                    "Sub class of AutoAssembledChaosExperiment must be annotated with @Experiment.");
        }

        String baseCommand = anno.value();
        if (baseCommand.isBlank()) {
            baseCommand = toBaseCommand(clazz.getSimpleName());
        }

        CommandBuilder cb = new CommandBuilder("blade create ".concat(baseCommand));
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            int mod = field.getModifiers();
            if (Modifier.isPrivate(mod) && Modifier.isPrivate(mod)) {
                field.setAccessible(true);
                String option = this.toOption(field.getName());
                if (boolean.class.equals(field.getType()) || Boolean.class.equals(field.getType())) {
                    Boolean val = (Boolean) field.get(this);
                    cb.appendIfTrue(option, val);
                } else {
                    cb.appendIfNonnull(option, field.get(this));
                }
            }
        }
        return cb.toString();
    }

    private String toBaseCommand(String classname) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (char c : classname.toCharArray()) {
            char ch = c;
            if (!first && Character.isUpperCase(ch)) {
                sb.append(" ");
            }
            ch = Character.toLowerCase(ch);
            sb.append(ch);
            first = false;
        }
        return sb.toString().trim();
    }

    private String toOption(String field) {
        if (field == null || field.isBlank() || !Character.isLowerCase(field.charAt(0))) {
            return null;
        }

        StringBuilder sb = new StringBuilder("--");
        for (char c : field.toCharArray()) {
            char ch = c;
            if (Character.isUpperCase(ch)) {
                sb.append('-');
                ch = Character.toLowerCase(ch);
            }
            sb.append(ch);
        }

        return sb.toString();
    }

    public String printCommand() {
        return command();
    }
}
