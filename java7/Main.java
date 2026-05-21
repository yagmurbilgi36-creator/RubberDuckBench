public class Main {
    public static void main(String[] args) {

        MessageStore store = new MessageStore();

        System.out.println("What happens when you assign null Long to primitive long?");
        try {
            Long nullableLong = null;           // getStoreTime() returns
            long primitive = nullableLong;      // calls nullableLong.longValue()
            System.out.println("  Result: " + primitive); // never reached
        } catch (NullPointerException e) {
            System.out.println("  NullPointerException, auto-unboxing null is illegal.");
        }

        // the version with bugs
        System.out.println("getMessageStoreTimeStamp() uses long");
        try {
            long result = store.getMessageStoreTimeStampBuggy("TestTopic", 0, 0);
            System.out.println("  Result: " + result); // never reached
        } catch (NullPointerException e) {
            System.out.println("  NullPointerException, the bug is confirmed.");
        }

        // fixed version
        System.out.println("getMessageStoreTimeStamp() uses Long]");
        long result = store.getMessageStoreTimeStampFixed("TestTopic", 0, 0);
        System.out.println("  Result: " + result);
        System.out.println("  no crash is expected.\n");

            // --- Automated assertions ---
        boolean passed = true;

        try {
            store.getMessageStoreTimeStampBuggy("TestTopic", 0, 0);
            System.out.println("assertion failed.");
            passed = false;
        } catch (NullPointerException e) {
            // expected
        }

        // Verify fixed version returns -1 safely
        long fixedResult = store.getMessageStoreTimeStampFixed("TestTopic", 0, 0);
        if (fixedResult != -1) {
            System.out.println("assertion failed.");
            passed = false;
        }

        if (passed) {
            System.out.println("All assertions passed.");
        } else {
            System.exit(1);
        }
    }
}
