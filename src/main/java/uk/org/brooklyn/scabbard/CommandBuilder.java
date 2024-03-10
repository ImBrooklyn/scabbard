package uk.org.brooklyn.scabbard;

import static uk.org.brooklyn.scabbard.ScabbardConstants.SPACE;

public class CommandBuilder {
    private final StringBuilder sb;

    public CommandBuilder(String baseCmd) {
        sb = new StringBuilder(baseCmd);
    }

    @SuppressWarnings("unused")
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
