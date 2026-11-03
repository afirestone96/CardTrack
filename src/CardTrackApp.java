import javax.swing.SwingUtilities;

/** Starts the CardTrack application. */
public class CardTrackApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CardController());
    }
}
