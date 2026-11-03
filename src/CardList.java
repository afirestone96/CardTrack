import java.util.ArrayList;

/** Contains the cards displayed by the application. */
public class CardList {
    private ArrayList<Card> cards;

    public CardList() {
        cards = new ArrayList<>();
        // Sample data for this assignment, not current market prices.
        cards.add(new Card("C001", "Pikachu", "Pokemon", "Base Set", "58/102",
                "Lightly Played", 2, 5.00, 9.00, "Box A", "Available"));
        cards.add(new Card("C002", "Charizard", "Pokemon", "Obsidian Flames", "223/197",
                "Near Mint", 1, 22.00, 35.00, "Binder A", "Listed"));
        cards.add(new Card("C003", "Eevee", "Pokemon", "Jungle", "51/64",
                "Near Mint", 3, 2.00, 4.00, "Box B", "Available"));
        cards.add(new Card("C004", "Squirtle", "Pokemon", "Base Set", "63/102",
                "Lightly Played", 1, 3.00, 6.00, "Binder B", "Available"));
        cards.add(new Card("C005", "Bulbasaur", "Pokemon", "Base Set", "44/102",
                "Near Mint", 2, 4.00, 8.00, "Box A", "Listed"));
        cards.add(new Card("C006", "Mewtwo", "Pokemon", "Base Set", "10/102",
                "Lightly Played", 1, 12.00, 20.00, "Binder C", "Available"));
    }

    public int size() {
        return cards.size();
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void update(int index, Card card) {
        cards.set(index, card);
    }

    public void remove(int index) {
        cards.remove(index);
    }
}
