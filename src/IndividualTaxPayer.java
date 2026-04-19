class IndividualTaxPayer extends TaxPayer {

    public IndividualTaxPayer(String name, String email) {
        super(name, email);
    }

    @Override
    public double calculateTax(double income) {
        return income * 0.1;
    }
}
