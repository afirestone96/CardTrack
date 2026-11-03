/** Stores information about one seller in CardTrack. */
public class Seller {
    private String sellerId;
    private String name;
    private String businessName;
    private String preferredPlatform;
    private String defaultStorageLocation;

    // The constructor gives every field its starting value.
    public Seller(String sellerId, String name, String businessName, String preferredPlatform, String defaultStorageLocation) {
        this.sellerId = sellerId;
        this.name = name;
        this.businessName = businessName;
        this.preferredPlatform = preferredPlatform;
        this.defaultStorageLocation = defaultStorageLocation;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPreferredPlatform() {
        return preferredPlatform;
    }

    public void setPreferredPlatform(String preferredPlatform) {
        this.preferredPlatform = preferredPlatform;
    }

    public String getDefaultStorageLocation() {
        return defaultStorageLocation;
    }

    public void setDefaultStorageLocation(String defaultStorageLocation) {
        this.defaultStorageLocation = defaultStorageLocation;
    }

    @Override
    public String toString() {
        return "Seller{"
                + "sellerId=" + sellerId
                + ", name=" + name
                + ", businessName=" + businessName
                + ", preferredPlatform=" + preferredPlatform
                + ", defaultStorageLocation=" + defaultStorageLocation
                + "}";
    }
}
