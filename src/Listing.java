/** Stores information about one listing in CardTrack. */
public class Listing {
    private String listingId;
    private String cardId;
    private String platform;
    private double askingPrice;
    private int quantity;
    private String status;

    // The constructor gives every field its starting value.
    public Listing(String listingId, String cardId, String platform, double askingPrice, int quantity, String status) {
        this.listingId = listingId;
        this.cardId = cardId;
        this.platform = platform;
        this.askingPrice = askingPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getAskingPrice() {
        return askingPrice;
    }

    public void setAskingPrice(double askingPrice) {
        this.askingPrice = askingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Listing{"
                + "listingId=" + listingId
                + ", cardId=" + cardId
                + ", platform=" + platform
                + ", askingPrice=" + askingPrice
                + ", quantity=" + quantity
                + ", status=" + status
                + "}";
    }
}
