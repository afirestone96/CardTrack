/**
 * Contract for CardTrack model objects that can prepare and print
 * a text-based report.
 */
public interface Printable {
    void printSetup();
    void print();
}
