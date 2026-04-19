import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaxManager manager = new TaxManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TAX FILING SYSTEM ===");
            System.out.println("1. Add Record");
            System.out.println("2. View Records");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Record");
            System.out.println("5. Save to File");
            System.out.println("6. Load from File");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Income: ");
                    double income = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Type (1=Individual, 2=Business): ");
                    int type = sc.nextInt();

                    TaxPayer payer;
                    if (type == 1)
                        payer = new IndividualTaxPayer(name, email);
                    else
                        payer = new BusinessTaxPayer(name, email);

                    double tax = payer.calculateTax(income);

                    manager.addRecord(new TaxRecord(id, name, income, tax, "Pending"));
                    break;

                case 2:
                    manager.viewRecords();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Status: ");
                    String status = sc.nextLine();
                    manager.updateRecord(uid, status);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    manager.deleteRecord(did);
                    break;

                case 5:
                    FileManager.save(manager.getRecords());
                    break;

                case 6:
                    manager.setRecords(FileManager.load());
                    break;

                case 0:
                    return;
            }
        }
    }
}
