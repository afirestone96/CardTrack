/** Stores information about one sale in CardTrack. */
public class Sale implements Printable {
    private String saleId;
    private String cardId;
    private String saleDate;
    private String platform;
    private int quantitySold;
    private double salePrice;
    private double purchaseCost;
    private double fees;
    private double shippingCost;
    private double profit;

    // The constructor gives every field its starting value.
    public Sale(String saleId, String cardId, String saleDate, String platform, int quantitySold, double salePrice, double purchaseCost, double fees, double shippingCost, double profit) {
        this.saleId = saleId;
        this.cardId = cardId;
        this.saleDate = saleDate;
        this.platform = platform;
        this.quantitySold = quantitySold;
        this.salePrice = salePrice;
        this.purchaseCost = purchaseCost;
        this.fees = fees;
        this.shippingCost = shippingCost;
        this.profit = profit;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public void printSetup() {
        System.out.println("Class: Sale | Method: printSetup()");
        System.out.println("Preparing a sale receipt for sale " + saleId + ".");
    }

    @Override
    public void print() {
        System.out.println("Class: Sale | Method: print()");
        System.out.println("Sale " + saleId + " on " + platform
                + " | Card ID: " + cardId
                + " | Sale Price: $" + salePrice
                + " | Profit: $" + profit);
    }

    @Override
    public String toString() {
        return "Sale{"
                + "saleId=" + saleId
                + ", cardId=" + cardId
                + ", saleDate=" + saleDate
                + ", platform=" + platform
                + ", quantitySold=" + quantitySold
                + ", salePrice=" + salePrice
                + ", purchaseCost=" + purchaseCost
                + ", fees=" + fees
                + ", shippingCost=" + shippingCost
                + ", profit=" + profit
                + "}";
    }
}
