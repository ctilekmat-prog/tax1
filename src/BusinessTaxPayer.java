class BusinessTaxPayer extends TaxPayer {

    public BusinessTaxPayer(String name, String email) {
        super(name, email);
    }

    @Override
    public double calculateTax(double income) {
        return income * 0.2;
    }
}