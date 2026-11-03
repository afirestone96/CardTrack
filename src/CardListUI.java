import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * List-view for CardTrack. Displays the card collection in a scrollable JTable.
 * The controller supplies the table data and handles all button behavior.
 */
public class CardListUI extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable cardTable;
    private final JButton viewDetailsButton = new JButton("View Details");
    private final JButton addButton = new JButton("Add Card");
    private final JButton editButton = new JButton("Edit Selected");
    private final JButton deleteButton = new JButton("Delete Selected");
    private final JButton exitButton = new JButton("Exit");
    private final JLabel statusLabel = new JLabel(" ");

    public CardListUI() {
        super("CardTrack - Card List");

        String[] columns = {
                "Inventory ID", "Name", "Game", "Set", "Condition", "Quantity", "Asking Price"
        };

        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        cardTable = new JTable(tableModel);
        cardTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cardTable.setFillsViewportHeight(true);
        cardTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(cardTable);
        scrollPane.setPreferredSize(new Dimension(900, 330));

        JPanel header = new JPanel(new BorderLayout());
        JLabel title = new JLabel("CardTrack Inventory");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        header.add(title, BorderLayout.WEST);
        header.add(statusLabel, BorderLayout.EAST);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        buttons.add(viewDetailsButton);
        buttons.add(addButton);
        buttons.add(editButton);
        buttons.add(deleteButton);
        buttons.add(exitButton);

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        content.add(header, BorderLayout.NORTH);
        content.add(scrollPane, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);
        setContentPane(content);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        cardTable.getSelectionModel().addListSelectionListener(e -> updateButtons());
        updateButtons();
    }

    public void showWindow() {
        setVisible(true);
    }

    /** Replaces the table contents with current model data. */
    public void setTableData(Object[][] rows) {
        tableModel.setRowCount(0);
        for (Object[] row : rows) {
            tableModel.addRow(row);
        }
        statusLabel.setText(rows.length + (rows.length == 1 ? " card" : " cards"));
        if (rows.length > 0) {
            cardTable.setRowSelectionInterval(0, 0);
        }
        updateButtons();
    }

    /** Returns the model index for the selected row, or -1 if nothing is selected. */
    public int getSelectedModelIndex() {
        int viewIndex = cardTable.getSelectedRow();
        if (viewIndex < 0) {
            return -1;
        }
        return cardTable.convertRowIndexToModel(viewIndex);
    }

    public void selectModelRow(int modelIndex) {
        if (modelIndex < 0 || modelIndex >= tableModel.getRowCount()) {
            cardTable.clearSelection();
            updateButtons();
            return;
        }
        int viewIndex = cardTable.convertRowIndexToView(modelIndex);
        cardTable.setRowSelectionInterval(viewIndex, viewIndex);
        cardTable.scrollRectToVisible(cardTable.getCellRect(viewIndex, 0, true));
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "CardTrack", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "CardTrack", JOptionPane.ERROR_MESSAGE);
    }

    private void updateButtons() {
        boolean hasRows = tableModel.getRowCount() > 0;
        boolean hasSelection = getSelectedModelIndex() >= 0;
        viewDetailsButton.setEnabled(hasSelection);
        editButton.setEnabled(hasSelection);
        deleteButton.setEnabled(hasRows && hasSelection);
    }

    public void onViewDetails(ActionListener listener) {
        viewDetailsButton.addActionListener(listener);
        cardTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && cardTable.getSelectedRow() >= 0) {
                    listener.actionPerformed(null);
                }
            }
        });
    }

    public void onAdd(ActionListener listener) { addButton.addActionListener(listener); }
    public void onEdit(ActionListener listener) { editButton.addActionListener(listener); }
    public void onDelete(ActionListener listener) { deleteButton.addActionListener(listener); }
    public void onExit(ActionListener listener) { exitButton.addActionListener(listener); }
}
