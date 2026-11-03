import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** Displays fields and buttons. The controller handles their behavior. */
public class CardView extends JPanel {
    private JTextField[] fields = new JTextField[11];
    private JButton previous = new JButton("Previous");
    private JButton next = new JButton("Next");
    private JButton newCard = new JButton("New");
    private JButton update = new JButton("Update");
    private JButton clear = new JButton("Clear");
    private JButton delete = new JButton("Delete");
    private JButton exit = new JButton("Exit");
    private JLabel position = new JLabel();

    public CardView() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        String[] labels = {"Inventory ID", "Name", "Game", "Set", "Card number",
                "Condition", "Quantity", "Purchase cost", "Asking price", "Location", "Status"};
        JPanel form = new JPanel(new GridLayout(labels.length, 2, 8, 8));
        for (int i = 0; i < labels.length; i++) {
            fields[i] = new JTextField(20);
            JLabel label = new JLabel(labels[i]);
            label.setLabelFor(fields[i]);
            form.add(label);
            form.add(fields[i]);
        }
        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(previous);
        buttons.add(next);
        buttons.add(newCard);
        buttons.add(update);
        buttons.add(clear);
        buttons.add(delete);
        buttons.add(exit);
        add(position, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    public void showWindow() {
        JFrame window = new JFrame("CardTrack");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public String[] getValues() {
        String[] values = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            values[i] = fields[i].getText().trim();
        }
        return values;
    }

    public void displayValues(String[] values) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText(values[i]);
        }
    }

    public void clearFields() {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public void setNavigation(int index, int count) {
        position.setText(count == 0 ? "No cards" : "Card " + (index + 1) + " of " + count);
        previous.setEnabled(index > 0);
        next.setEnabled(index >= 0 && index < count - 1);
        update.setEnabled(count > 0);
        delete.setEnabled(count > 0);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Check input", JOptionPane.ERROR_MESSAGE);
    }

    public void onPrevious(ActionListener listener) { previous.addActionListener(listener); }
    public void onNext(ActionListener listener) { next.addActionListener(listener); }
    public void onNew(ActionListener listener) { newCard.addActionListener(listener); }
    public void onUpdate(ActionListener listener) { update.addActionListener(listener); }
    public void onClear(ActionListener listener) { clear.addActionListener(listener); }
    public void onDelete(ActionListener listener) { delete.addActionListener(listener); }
    public void onExit(ActionListener listener) { exit.addActionListener(listener); }
}
