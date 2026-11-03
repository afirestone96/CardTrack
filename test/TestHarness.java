/**
 * Manual unit tests for the Card and Sale model classes.
 * Run this class from IntelliJ to see each test result in the console.
 */
public class TestHarness {
    private int testsRun;
    private int testsPassed;

    public TestHarness() {
        testCard();
        testSale();
        System.out.println("\nManual test results: " + testsPassed + " of " + testsRun + " tests passed.");
    }

    public static void main(String[] args) {
        new TestHarness();
    }

    private void check(String testName, boolean passed) {
        testsRun++;
        if (passed) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
        }
    }

    private void testCard() {
        System.out.println("Testing Card");
        Card card = new Card("C001", "Pikachu", "Pokemon", "Base Set", "58/102",
                "Near Mint", 2, 5.00, 12.50, "Show Case", "Available");

        check("Card constructor and getters", card.getInventoryId().equals("C001")
                && card.getName().equals("Pikachu") && card.getGame().equals("Pokemon")
                && card.getSetName().equals("Base Set") && card.getCardNumber().equals("58/102")
                && card.getCondition().equals("Near Mint") && card.getQuantity() == 2
                && card.getPurchaseCost() == 5.00 && card.getAskingPrice() == 12.50
                && card.getInventoryLocation().equals("Show Case") && card.getStatus().equals("Available"));

        card.setInventoryId("C002"); card.setName("Charizard"); card.setGame("Pokemon TCG");
        card.setSetName("Obsidian Flames"); card.setCardNumber("223/197");
        card.setCondition("Lightly Played"); card.setQuantity(1); card.setPurchaseCost(22.00);
        card.setAskingPrice(35.00); card.setInventoryLocation("Binder A"); card.setStatus("Listed");

        check("Card setters", card.getInventoryId().equals("C002") && card.getName().equals("Charizard")
                && card.getGame().equals("Pokemon TCG") && card.getSetName().equals("Obsidian Flames")
                && card.getCardNumber().equals("223/197") && card.getCondition().equals("Lightly Played")
                && card.getQuantity() == 1 && card.getPurchaseCost() == 22.00
                && card.getAskingPrice() == 35.00 && card.getInventoryLocation().equals("Binder A")
                && card.getStatus().equals("Listed"));
        check("Card toString", card.toString().contains("inventoryId=C002")
                && card.toString().contains("name=Charizard") && card.toString().contains("status=Listed"));
    }

    private void testSale() {
        System.out.println("Testing Sale");
        Sale sale = new Sale("S001", "C002", "2026-09-20", "eBay", 1,
                35.00, 22.00, 4.50, 1.00, 7.50);

        check("Sale constructor and getters", sale.getSaleId().equals("S001")
                && sale.getCardId().equals("C002") && sale.getSaleDate().equals("2026-09-20")
                && sale.getPlatform().equals("eBay") && sale.getQuantitySold() == 1
                && sale.getSalePrice() == 35.00 && sale.getPurchaseCost() == 22.00
                && sale.getFees() == 4.50 && sale.getShippingCost() == 1.00 && sale.getProfit() == 7.50);

        sale.setSaleId("S002"); sale.setCardId("C003"); sale.setSaleDate("2026-09-21");
        sale.setPlatform("Whatnot"); sale.setQuantitySold(2); sale.setSalePrice(60.00);
        sale.setPurchaseCost(30.00); sale.setFees(5.00); sale.setShippingCost(3.00); sale.setProfit(22.00);

        check("Sale setters", sale.getSaleId().equals("S002") && sale.getCardId().equals("C003")
                && sale.getSaleDate().equals("2026-09-21") && sale.getPlatform().equals("Whatnot")
                && sale.getQuantitySold() == 2 && sale.getSalePrice() == 60.00
                && sale.getPurchaseCost() == 30.00 && sale.getFees() == 5.00
                && sale.getShippingCost() == 3.00 && sale.getProfit() == 22.00);
        check("Sale toString", sale.toString().contains("saleId=S002")
                && sale.toString().contains("platform=Whatnot") && sale.toString().contains("profit=22.0"));
    }
}
