import java.util.ArrayList;

/**
 * Demonstrates inheritance, method overriding, interfaces, and polymorphism.
 */
public class TestInheritInterface {

    public static void main(String[] args) {
        System.out.println("===== M04-A01 PART 1: CLASS HIERARCHY =====");
        testClassHierarchy();

        System.out.println();
        System.out.println("===== M04-A01 PART 2: INTERFACE =====");
        testInterface();
    }

    public static void testClassHierarchy() {
        // The ArrayList uses the super-class as its data type.
        ArrayList<Card> cards = new ArrayList<>();

        // Two objects from the first subclass.
        cards.add(new GradedCard(
                "G001", "Charizard", "Pokemon", "Base Set", "4/102",
                "Graded", 1, 200.00, 450.00, "Slab Case A", "Available",
                "PSA", 9, "12345678"));

        cards.add(new GradedCard(
                "G002", "Pikachu", "Pokemon", "Crown Zenith", "160/159",
                "Graded", 1, 70.00, 125.00, "Slab Case B", "Available",
                "PSA", 10, "87654321"));

        // Two objects from the second subclass.
        cards.add(new RawCard(
                "R001", "Umbreon VMAX", "Pokemon", "Evolving Skies", "215/203",
                "Near Mint", 1, 500.00, 900.00, "Binder A", "Available",
                true, "Penny Sleeve", "Page 1"));

        cards.add(new RawCard(
                "R002", "Lugia V", "Pokemon", "Silver Tempest", "186/195",
                "Lightly Played", 1, 90.00, 150.00, "Binder B", "Listed",
                false, "Perfect Fit Sleeve", "Page 3"));

        // A regular super-class object is also included to demonstrate that
        // the same ArrayList can contain Card and its subclasses.
        cards.add(new Card(
                "C100", "Mew", "Pokemon", "Promo", "8",
                "Near Mint", 1, 10.00, 20.00, "Box A", "Available"));

        for (Card card : cards) {
            card.displayCardDetails();
            card.displayStorageInfo();
            System.out.println("--------------------------------------------");
        }
    }

    public static void testInterface() {
        // The ArrayList uses the interface as its data type.
        ArrayList<Printable> printableItems = new ArrayList<>();

        Sale sale = new Sale(
                "S100", "G001", "2026-09-25", "eBay",
                1, 450.00, 200.00, 55.00, 8.00, 187.00);

        Inventory inventory = new Inventory(
                "I100", "U001", "CardTrack Main Inventory",
                "Home Office", "2026-09-25");

        printableItems.add(sale);
        printableItems.add(inventory);

        for (Printable item : printableItems) {
            item.printSetup();
            item.print();
            System.out.println("--------------------------------------------");
        }
    }
}
