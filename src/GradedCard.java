/**
 * A graded trading card. GradedCard IS-A Card, so it inherits the
 * common Card data and adds information specific to professional grading.
 */
public class GradedCard extends Card {
    private String gradingCompany;
    private double grade;
    private String certificationNumber;

    public GradedCard(String inventoryId, String name, String game, String setName,
                      String cardNumber, String condition, int quantity,
                      double purchaseCost, double askingPrice,
                      String inventoryLocation, String status,
                      String gradingCompany, double grade,
                      String certificationNumber) {
        super(inventoryId, name, game, setName, cardNumber, condition, quantity,
                purchaseCost, askingPrice, inventoryLocation, status);
        this.gradingCompany = gradingCompany;
        this.grade = grade;
        this.certificationNumber = certificationNumber;
    }

    public String getGradingCompany() {
        return gradingCompany;
    }

    public void setGradingCompany(String gradingCompany) {
        this.gradingCompany = gradingCompany;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(String certificationNumber) {
        this.certificationNumber = certificationNumber;
    }

    @Override
    public void displayCardDetails() {
        System.out.println("Class: GradedCard | Method: displayCardDetails()");
        System.out.println(getName() + " is graded " + grade + " by "
                + gradingCompany + " | Certification: " + certificationNumber);
    }

    @Override
    public void displayStorageInfo() {
        System.out.println("Class: GradedCard | Method: displayStorageInfo()");
        System.out.println("Graded slab storage: " + getInventoryLocation()
                + " | Keep the slab protected from scratches.");
    }
}
