/** Handles interaction between the CardList model and both GUI views. */
public class CardController {
    private final CardList model;
    private final CardListUI listView;

    public CardController() {
        this.model = new CardList();
        this.listView = new CardListUI();

        listView.onViewDetails(e -> viewSelectedCard());
        listView.onAdd(e -> openAddCard());
        listView.onEdit(e -> openEditCard());
        listView.onDelete(e -> deleteSelectedCard());
        listView.onExit(e -> System.exit(0));

        refreshList();
        listView.showWindow();
    }

    /** Refreshes the JTable so it always matches the current model list. */
    private void refreshList() {
        Object[][] rows = new Object[model.size()][7];
        for (int i = 0; i < model.size(); i++) {
            Card card = model.get(i);
            rows[i][0] = card.getInventoryId();
            rows[i][1] = card.getName();
            rows[i][2] = card.getGame();
            rows[i][3] = card.getSetName();
            rows[i][4] = card.getCondition();
            rows[i][5] = card.getQuantity();
            rows[i][6] = String.format("$%.2f", card.getAskingPrice());
        }
        listView.setTableData(rows);
    }

    private void viewSelectedCard() {
        int index = selectedIndexOrError();
        if (index < 0) {
            return;
        }

        CardDetailUI detailView = new CardDetailUI(
                listView, "Card Details", false, "Save");
        detailView.displayValues(cardToValues(model.get(index)));
        detailView.showDialog();
    }

    private void openAddCard() {
        CardDetailUI detailView = new CardDetailUI(
                listView, "Add Card", true, "Add Card");

        detailView.onSave(e -> {
            Card card = readCard(detailView);
            if (card != null) {
                model.add(card);
                refreshList();
                listView.selectModelRow(model.size() - 1);
                detailView.dispose();
            }
        });

        detailView.showDialog();
    }

    private void openEditCard() {
        int index = selectedIndexOrError();
        if (index < 0) {
            return;
        }

        CardDetailUI detailView = new CardDetailUI(
                listView, "Edit Card", true, "Save Changes");
        detailView.displayValues(cardToValues(model.get(index)));

        detailView.onSave(e -> {
            Card updatedCard = readCard(detailView);
            if (updatedCard != null) {
                model.update(index, updatedCard);
                refreshList();
                listView.selectModelRow(index);
                detailView.dispose();
            }
        });

        detailView.showDialog();
    }

    private void deleteSelectedCard() {
        if (model.size() == 0) {
            listView.showError("There are no cards to delete.");
            return;
        }

        int index = selectedIndexOrError();
        if (index < 0) {
            return;
        }

        model.remove(index);
        refreshList();
        if (model.size() > 0) {
            listView.selectModelRow(Math.min(index, model.size() - 1));
        }
    }

    private int selectedIndexOrError() {
        int index = listView.getSelectedModelIndex();
        if (index < 0 || index >= model.size()) {
            listView.showError("Select a card from the table first.");
            return -1;
        }
        return index;
    }

    private Card readCard(CardDetailUI detailView) {
        String[] values = detailView.getValues();
        for (String value : values) {
            if (value.isEmpty()) {
                detailView.showError("Please fill in every field.");
                return null;
            }
        }

        try {
            int quantity = Integer.parseInt(values[6]);
            double cost = Double.parseDouble(values[7]);
            double price = Double.parseDouble(values[8]);

            if (quantity < 0 || cost < 0 || price < 0
                    || !Double.isFinite(cost) || !Double.isFinite(price)) {
                detailView.showError("Quantity and prices must be zero or greater and finite.");
                return null;
            }

            return new Card(values[0], values[1], values[2], values[3], values[4], values[5],
                    quantity, cost, price, values[9], values[10]);
        } catch (NumberFormatException exception) {
            detailView.showError("Enter a whole number for quantity and numbers for prices.");
            return null;
        }
    }

    private String[] cardToValues(Card card) {
        return new String[] {
                card.getInventoryId(),
                card.getName(),
                card.getGame(),
                card.getSetName(),
                card.getCardNumber(),
                card.getCondition(),
                Integer.toString(card.getQuantity()),
                Double.toString(card.getPurchaseCost()),
                Double.toString(card.getAskingPrice()),
                card.getInventoryLocation(),
                card.getStatus()
        };
    }
}
