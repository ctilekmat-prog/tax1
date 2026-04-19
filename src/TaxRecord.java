class TaxRecord {
    private int id;
    private String name;
    private double income;
    private double tax;
    private String status;

    public TaxRecord(int id, String name, double income, double tax, String status) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.tax = tax;
        this.status = status;
    }

    public int getId() { return id; }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toFileString() {
        return id + "," + name + "," + income + "," + tax + "," + status;
    }

    public static TaxRecord fromFileString(String line) {
        String[] p = line.split(",");
        return new TaxRecord(
                Integer.parseInt(p[0]),
                p[1],
                Double.parseDouble(p[2]),
                Double.parseDouble(p[3]),
                p[4]
        );
    }

    public String toString() {
        return id + " | " + name + " | " + income + " | " + tax + " | " + status;
    }
}