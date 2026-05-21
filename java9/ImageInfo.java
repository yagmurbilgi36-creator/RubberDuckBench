public class ImageInfo {
    private String user;           // the uploader's username
    private ExtMetadata metadata;  // extra image metadata
    private String originalUrl;

    public ImageInfo(String user, ExtMetadata metadata, String originalUrl) {
        this.user = user;
        this.metadata = metadata;
        this.originalUrl = originalUrl;
    }

    public String getUser() {
        return user;
    }

    public ExtMetadata getMetadata() {
        return metadata;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
