import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaxAppGUI {
    private TaxManager manager = new TaxManager();

    public TaxAppGUI() {
        JFrame frame = new JFrame("Tax Filing System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField incomeField = new JTextField();
        JTextField statusField = new JTextField();

        String[] types = {"Individual", "Business"};
        JComboBox<String> typeBox = new JComboBox<>(types);

        JTextArea output = new JTextArea();
        JScrollPane scroll = new JScrollPane(output);

        JButton addBtn = new JButton("Add");
        JButton viewBtn = new JButton("View");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(new JLabel("ID"));
        panel.add(idField);
        panel.add(new JLabel("Name"));
        panel.add(nameField);
        panel.add(new JLabel("Email"));
        panel.add(emailField);
        panel.add(new JLabel("Income"));
        panel.add(incomeField);
        panel.add(new JLabel("Type"));
        panel.add(typeBox);
        panel.add(new JLabel("Status"));
        panel.add(statusField);

        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);

        // ADD
        addBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();
                double income = Double.parseDouble(incomeField.getText());

                TaxPayer payer;
                if (typeBox.getSelectedIndex() == 0)
                    payer = new IndividualTaxPayer(name, email);
                else
                    payer = new BusinessTaxPayer(name, email);

                double tax = payer.calculateTax(income);

                manager.addRecord(new TaxRecord(id, name, income, tax, statusField.getText()));
                output.setText("Added!\n");

            } catch (Exception ex) {
                output.setText("Error in input!");
            }
        });

        // VIEW
        viewBtn.addActionListener(e -> {
            output.setText("");
            for (TaxRecord r : manager.getRecords()) {
                output.append(r.toString() + "\n");
            }
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                manager.updateRecord(id, statusField.getText());
                output.setText("Updated!\n");
            } catch (Exception ex) {
                output.setText("Error!");
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                manager.deleteRecord(id);
                output.setText("Deleted!\n");
            } catch (Exception ex) {
                output.setText("Error!");
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TaxAppGUI();
    }
}
