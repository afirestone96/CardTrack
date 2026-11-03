/**
 * An ungraded trading card. RawCard IS-A Card, so it inherits the
 * common Card data and adds information specific to raw-card protection.
 */
public class RawCard extends Card {
    private boolean inTopLoader;
    private String sleeveType;
    private String binderSection;

    public RawCard(String inventoryId, String name, String game, String setName,
                   String cardNumber, String condition, int quantity,
                   double purchaseCost, double askingPrice,
                   String inventoryLocation, String status,
                   boolean inTopLoader, String sleeveType,
                   String binderSection) {
        super(inventoryId, name, game, setName, cardNumber, condition, quantity,
                purchaseCost, askingPrice, inventoryLocation, status);
        this.inTopLoader = inTopLoader;
        this.sleeveType = sleeveType;
        this.binderSection = binderSection;
    }

    public boolean isInTopLoader() {
        return inTopLoader;
    }

    public void setInTopLoader(boolean inTopLoader) {
        this.inTopLoader = inTopLoader;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public String getBinderSection() {
        return binderSection;
    }

    public void setBinderSection(String binderSection) {
        this.binderSection = binderSection;
    }

    @Override
    public void displayCardDetails() {
        System.out.println("Class: RawCard | Method: displayCardDetails()");
        System.out.println(getName() + " is an ungraded card in "
                + getCondition() + " condition | Sleeve: " + sleeveType);
    }

    @Override
    public void displayStorageInfo() {
        System.out.println("Class: RawCard | Method: displayStorageInfo()");
        String protection = inTopLoader ? "top loader" : "sleeve only";
        System.out.println("Raw card storage: " + getInventoryLocation()
                + " | " + binderSection + " | Protection: " + protection);
    }
}
