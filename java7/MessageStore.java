public class MessageStore {

    private Long getStoreTime(SelectMappedBufferResult result) {
        if (result != null) {
            try {
                final long phyOffset = result.getLong();
                final int size = result.getInt();
                long storeTime = phyOffset + size; 
                return storeTime;
            } catch (Exception e) {
                // returns null
            } finally {
                result.release();
            }
        }
        return null; 
    }

    public long getMessageStoreTimeStampBuggy(String topic, int queueId, long consumeQueueOffset) {
        SelectMappedBufferResult result = null;

        long storeTime = getStoreTime(result);
        return storeTime;
    }


    public long getMessageStoreTimeStampFixed(String topic, int queueId, long consumeQueueOffset) {
        SelectMappedBufferResult result = null;

        Long storeTime = getStoreTime(result);
        if (storeTime != null) return storeTime;

        return -1; // safe fallback
    }
}
