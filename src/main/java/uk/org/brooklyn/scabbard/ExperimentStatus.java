package uk.org.brooklyn.scabbard;

/**
 * @author ImBrooklyn
 * @since 09/12/2023
 */
public enum ExperimentStatus {

    PREPARING(0, "preparing"),

    SUCCESS(1, "success"),

    DESTROYED(-1, "destroyed"),
    ;

    final int code;
    final String description;
    ExperimentStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ExperimentStatus parse(String desc) {
        for (ExperimentStatus value : values()) {
            if (value.description.equalsIgnoreCase(desc)) {
                return value;
            }
        }

        return null;
    }

    public static ExperimentStatus parse(int code) {
        for (ExperimentStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        return null;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
