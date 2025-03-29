package uk.org.brooklyn.scabbard.experiment;

import lombok.Builder;
import uk.org.brooklyn.scabbard.AutowiredChaosExperiment;
import uk.org.brooklyn.scabbard.annotation.Experiment;

/**
 * Increases disk I/O load by specifying target directories or adjusting read/write block sizes.
 * Default block size is 10M. Uses fixed 100 blocks - default writes consume 1000M disk space,
 * reads use fixed 600M space (pre-allocated file creation may cause write spikes within 3s).
 * Validates system behavior under high disk I/O load, including monitoring alerts and service stability.
 *
 * @author ImBrooklyn
 * @since 09/12/2023
 */
@Experiment
@Builder
public class DiskBurn extends AutowiredChaosExperiment {

    /**
     * Target directory for I/O operations (affects its containing disk), defaults to /
     */
    private final String path;

    /**
     * Enables read I/O load (creates 600M file for reading, automatically cleaned up when experiment ends)
     */
    private final Boolean read;

    /**
     * Enables write I/O load (writes file based on block size, e.g. block size 10 with 100 blocks = 1000M file,
     * automatically cleaned up when experiment ends)
     */
    private final Boolean write;

    /**
     * Block size in megabytes (M), default 10, generally not modified unless higher I/O load is required
     */
    private final String size;

    /**
     * Sets experiment duration in seconds (common parameter)
     */
    private final Integer timeout;
}
