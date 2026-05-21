public class Main {
    public static void main(String[] args) {

        // simulate as an image uploaded without extended metadata.

        String expectedUser = "someone"; // The uploader's username - should be preserved even if metadata is null
        ImageInfo imageInfo = new ImageInfo(
                expectedUser,   // user is known
                null,           // metadata is null
                "http://example.com/image.jpg"
        );

        // the state of ImageInfo
        System.out.println("[ImageInfo State]");
        System.out.println("  imageInfo.getMetadata() = " + imageInfo.getMetadata());
        System.out.println("  imageInfo.getUser()     = " + imageInfo.getUser());
        System.out.println();
        System.out.println(" metadata is null, but user is not null.");

        // the version with bugs
        Media buggyResult = Media.fromBuggy("File:Example.jpg", imageInfo);
        System.out.println("bug");
        System.out.println("  media.user = " + buggyResult.user);
        System.out.println(" the uploader is untracked.\n");

        // the fixed version
        Media fixedResult = Media.fromFixed("File:Example.jpg", imageInfo);
        System.out.println("fixed version");
        System.out.println("  media.user = " + fixedResult.user);
        System.out.println("  user info is preserved correctly.\n");

        // automated assertions
        boolean passed = true;

        if (buggyResult.user != null) {
            System.out.println("ASSERTION FAILED: Buggy version should have null user.");
            passed = false;
        }

        if (!expectedUser.equals(fixedResult.user)) {
            System.out.println("ASSERTION FAILED: Fixed version should preserve user as \"" + expectedUser + "\".");
            passed = false;
        }

        if (passed) {
            System.out.println("All assertions passed.");
        } else {
            System.exit(1);
        }
    }
}
