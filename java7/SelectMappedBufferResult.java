/**
 * Stub for org.apache.rocketmq.store.SelectMappedBufferResult
 *
 * Can be null when no data is found at the requested offset.
 */
public class SelectMappedBufferResult {

    private boolean valid;

    public SelectMappedBufferResult(boolean valid) {
        this.valid = valid;
    }

    public long getLong() {
        if (!valid) throw new RuntimeException("Buffer read error");
        return 12345L;
    }

    public int getInt() {
        if (!valid) throw new RuntimeException("Buffer read error");
        return 100;
    }

    public void release() {
        // cleanup
    }
}
