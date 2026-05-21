/**
 * stub for org.wikipedia.gallery.ExtMetadata
 * It is a SEPARATE object from the uploader's user info.
 */
public class ExtMetadata {
    private String description;

    public ExtMetadata(String description) {
        this.description = description;
    }

    public String imageDescription() {
        return description;
    }
}
