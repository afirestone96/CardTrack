import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** JUnit tests for the Listing model class. */
public class ListingTest {
    @Test
    void constructorAndGettersStoreListingInformation() {
        Listing listing = new Listing("L001", "C001", "eBay", 14.99, 2, "Active");
        assertEquals("L001", listing.getListingId());
        assertEquals("C001", listing.getCardId());
        assertEquals("eBay", listing.getPlatform());
        assertEquals(14.99, listing.getAskingPrice());
        assertEquals(2, listing.getQuantity());
        assertEquals("Active", listing.getStatus());
    }

    @Test
    void settersUpdateListingInformation() {
        Listing listing = new Listing("L001", "C001", "eBay", 14.99, 2, "Active");
        listing.setListingId("L002"); listing.setCardId("C002"); listing.setPlatform("TCGplayer");
        listing.setAskingPrice(18.50); listing.setQuantity(1); listing.setStatus("Sold");
        assertEquals("L002", listing.getListingId());
        assertEquals("C002", listing.getCardId());
        assertEquals("TCGplayer", listing.getPlatform());
        assertEquals(18.50, listing.getAskingPrice());
        assertEquals(1, listing.getQuantity());
        assertEquals("Sold", listing.getStatus());
    }

    @Test
    void toStringIncludesUpdatedListingValues() {
        Listing listing = new Listing("L003", "C003", "Whatnot", 25.00, 1, "Active");
        String result = listing.toString();
        assertTrue(result.contains("listingId=L003"));
        assertTrue(result.contains("platform=Whatnot"));
        assertTrue(result.contains("askingPrice=25.0"));
    }
}
