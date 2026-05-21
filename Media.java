public class Media {

    public String imageUrl;
    public String filename;
    public String creator;
    public String user;

    public Media(String localUri, String imageUrl, String filename, String description,
                 int dataLength, Object dateCreated, Object dateUploaded,
                 String creator, String user) {
        this.imageUrl = imageUrl;
        this.filename = filename;
        this.creator = creator;
        this.user = user;
    }

    /**
     * old version with bugs "if metadata is null, user must also be null"
     * with hardcoded null as the user argument when metadata == null.
     *
     * Original buggy line:
     *   page.title(), "", 0, null, null, null);     
     * new version with the bug fixed:
     *   page.title(), "", 0, null, null, null, null);
     */
    public static Media fromBuggy(String pageTitle, ImageInfo imageInfo) {
        ExtMetadata metadata = imageInfo.getMetadata();
        if (metadata == null) {
            // BUG: hardcodes null for user, assuming that if metadata is null, user info must also be null.
            return new Media(null, imageInfo.getOriginalUrl(),
                    pageTitle, "", 0, null, null, null, null);
        }
        return new Media(null, imageInfo.getOriginalUrl(),
                pageTitle, "", 0, null, null, null, imageInfo.getUser());
    }

    /**
     * fixed version
     *
     * imageInfo.getUser() is called in both branches because
     * user info is independent of metadata.
     *
     * This matches the final state of Media.java after the bug was corrected:
     *   page.title(), "", 0, null, null, null, imageInfo.getUser());
     */
    public static Media fromFixed(String pageTitle, ImageInfo imageInfo) {
        ExtMetadata metadata = imageInfo.getMetadata();
        if (metadata == null) {
            // FIX: user is independent of metadata
            return new Media(null, imageInfo.getOriginalUrl(),
                    pageTitle, "", 0, null, null, null, imageInfo.getUser());
        }
        return new Media(null, imageInfo.getOriginalUrl(),
                pageTitle, "", 0, null, null, null, imageInfo.getUser());
    }
}
