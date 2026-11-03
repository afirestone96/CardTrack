/** Stores information about one inventory in CardTrack. */
public class Inventory implements Printable {
    private String inventoryId;
    private String sellerId;
    private String name;
    private String storageLocation;
    private String lastUpdated;

    // The constructor gives every field its starting value.
    public Inventory(String inventoryId, String sellerId, String name, String storageLocation, String lastUpdated) {
        this.inventoryId = inventoryId;
        this.sellerId = sellerId;
        this.name = name;
        this.storageLocation = storageLocation;
        this.lastUpdated = lastUpdated;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
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

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public void printSetup() {
        System.out.println("Class: Inventory | Method: printSetup()");
        System.out.println("Preparing an inventory summary for " + name + ".");
    }

    @Override
    public void print() {
        System.out.println("Class: Inventory | Method: print()");
        System.out.println("Inventory " + inventoryId + " | " + name
                + " | Storage: " + storageLocation
                + " | Last Updated: " + lastUpdated);
    }

    @Override
    public String toString() {
        return "Inventory{"
                + "inventoryId=" + inventoryId
                + ", sellerId=" + sellerId
                + ", name=" + name
                + ", storageLocation=" + storageLocation
                + ", lastUpdated=" + lastUpdated
                + "}";
    }
}
