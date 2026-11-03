import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Detail-view for one card. It can be used for read-only viewing or as the
 * input form for adding and updating cards.
 */
public class CardDetailUI extends JDialog {
    private final JTextField[] fields = new JTextField[11];
    private final JButton saveButton = new JButton("Save");
    private final JButton closeButton = new JButton("Close");

    public CardDetailUI(JFrame owner, String title, boolean editable, String saveText) {
        super(owner, title, true);

        String[] labels = {
                "Inventory ID", "Name", "Game", "Set", "Card number",
                "Condition", "Quantity", "Purchase cost", "Asking price",
                "Location", "Status"
        };

        JPanel form = new JPanel(new GridLayout(labels.length, 2, 8, 8));
        for (int i = 0; i < labels.length; i++) {
            fields[i] = new JTextField(22);
            fields[i].setEditable(editable);
            JLabel label = new JLabel(labels[i]);
            label.setLabelFor(fields[i]);
            form.add(label);
            form.add(fields[i]);
        }

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        if (editable) {
            saveButton.setText(saveText);
            buttons.add(saveButton);
        }
        buttons.add(closeButton);

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        content.add(form, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);
        setContentPane(content);

        // Closing a detail view never exits the application.
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        closeButton.addActionListener(e -> dispose());
        pack();
        setResizable(false);
        setLocationRelativeTo(owner);
    }

    public void displayValues(String[] values) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText(values[i]);
        }
    }

    public String[] getValues() {
        String[] values = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            values[i] = fields[i].getText().trim();
        }
        return values;
    }

    public void onSave(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Check input", JOptionPane.ERROR_MESSAGE);
    }

    public void showDialog() {
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }
}
