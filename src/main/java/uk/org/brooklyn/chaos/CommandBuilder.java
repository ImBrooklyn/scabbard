package uk.org.brooklyn.chaos;

public class CommandBuilder {
    private static final String SPACE = " ";
    private final StringBuilder sb;

    public CommandBuilder(String baseCmd) {
        sb = new StringBuilder(baseCmd);
    }

    public CommandBuilder appendIfTrue(String option, Boolean append) {
        if (option != null && !option.isBlank() && Boolean.TRUE.equals(append)) {
            sb.append(SPACE).append(option);
        }
        return this;
    }

    public CommandBuilder appendIfNonnull(String option, Object arg) {
        if (option != null && !option.isBlank() && arg != null) {
            sb.append(SPACE).append(option).append(SPACE).append(arg);
        }
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
