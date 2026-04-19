import java.util.ArrayList;

class TaxManager {
    private ArrayList<TaxRecord> records = new ArrayList<>();

    public void addRecord(TaxRecord r) {
        records.add(r);
    }

    public void viewRecords() {
        for (TaxRecord r : records) {
            System.out.println(r);
        }
    }

    public void updateRecord(int id, String status) {
        for (TaxRecord r : records) {
            if (r.getId() == id) {
                r.setStatus(status);
            }
        }
    }

    public void deleteRecord(int id) {
        records.removeIf(r -> r.getId() == id);
    }

    public ArrayList<TaxRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<TaxRecord> records) {
        this.records = records;
    }
}