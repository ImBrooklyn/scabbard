package uk.org.brooklyn.scabbard;

import lombok.Getter;

/**
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Getter
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

}
