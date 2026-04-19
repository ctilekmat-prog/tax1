import java.io.*;
import java.util.ArrayList;

class FileManager {

    public static void save(ArrayList<TaxRecord> records) {
        try (PrintWriter pw = new PrintWriter("data.txt")) {
            for (TaxRecord r : records) {
                pw.println(r.toFileString());
            }
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public static ArrayList<TaxRecord> load() {
        ArrayList<TaxRecord> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(TaxRecord.fromFileString(line));
            }
            System.out.println("Loaded!");
        } catch (Exception e) {
            System.out.println("Error loading file");
        }
        return list;
    }
}