/** Stores information about one card in CardTrack. */
public class Card {
    private String inventoryId;
    private String name;
    private String game;
    private String setName;
    private String cardNumber;
    private String condition;
    private int quantity;
    private double purchaseCost;
    private double askingPrice;
    private String inventoryLocation;
    private String status;

    // The constructor gives every field its starting value.
    public Card(String inventoryId, String name, String game, String setName, String cardNumber, String condition, int quantity, double purchaseCost, double askingPrice, String inventoryLocation, String status) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.game = game;
        this.setName = setName;
        this.cardNumber = cardNumber;
        this.condition = condition;
        this.quantity = quantity;
        this.purchaseCost = purchaseCost;
        this.askingPrice = askingPrice;
        this.inventoryLocation = inventoryLocation;
        this.status = status;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public double getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    public String getInventoryLocation() {
        return inventoryLocation;
    }

    public void setInventoryLocation(String inventoryLocation) {
        this.inventoryLocation = inventoryLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Displays general card information. Subclasses override this method
     * to show information that is unique to their card type.
     */
    public void displayCardDetails() {
        System.out.println("Class: Card | Method: displayCardDetails()");
        System.out.println("Standard card: " + name + " | " + game + " | "
                + setName + " #" + cardNumber);
    }

    /**
     * Displays general storage information. Subclasses override this method
     * to show storage information that is unique to their card type.
     */
    public void displayStorageInfo() {
        System.out.println("Class: Card | Method: displayStorageInfo()");
        System.out.println("Standard card storage location: " + inventoryLocation);
    }

    @Override
    public String toString() {
        return "Card{"
                + "inventoryId=" + inventoryId
                + ", name=" + name
                + ", game=" + game
                + ", setName=" + setName
                + ", cardNumber=" + cardNumber
                + ", condition=" + condition
                + ", quantity=" + quantity
                + ", purchaseCost=" + purchaseCost
                + ", askingPrice=" + askingPrice
                + ", inventoryLocation=" + inventoryLocation
                + ", status=" + status
                + "}";
    }
}
