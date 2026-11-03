import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** JUnit tests for the Inventory model class. */
public class InventoryTest {
    @Test
    void constructorAndGettersStoreInventoryInformation() {
        Inventory inventory = new Inventory("I001", "U001", "Show Inventory", "Home Office", "2026-09-20");
        assertEquals("I001", inventory.getInventoryId());
        assertEquals("U001", inventory.getSellerId());
        assertEquals("Show Inventory", inventory.getName());
        assertEquals("Home Office", inventory.getStorageLocation());
        assertEquals("2026-09-20", inventory.getLastUpdated());
    }

    @Test
    void settersUpdateInventoryInformation() {
        Inventory inventory = new Inventory("I001", "U001", "Old Name", "Old Location", "2026-01-01");
        inventory.setInventoryId("I002"); inventory.setSellerId("U002");
        inventory.setName("Online Inventory"); inventory.setStorageLocation("Storage Shelf");
        inventory.setLastUpdated("2026-09-21");
        assertEquals("I002", inventory.getInventoryId());
        assertEquals("U002", inventory.getSellerId());
        assertEquals("Online Inventory", inventory.getName());
        assertEquals("Storage Shelf", inventory.getStorageLocation());
        assertEquals("2026-09-21", inventory.getLastUpdated());
    }

    @Test
    void toStringIncludesUpdatedInventoryValues() {
        Inventory inventory = new Inventory("I003", "U003", "Card Show", "Bin 4", "2026-09-20");
        String result = inventory.toString();
        assertTrue(result.contains("inventoryId=I003"));
        assertTrue(result.contains("name=Card Show"));
        assertTrue(result.contains("storageLocation=Bin 4"));
    }
}
