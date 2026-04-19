abstract class TaxPayer {
    protected String name;
    protected String email;

    public TaxPayer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract double calculateTax(double income);
}
