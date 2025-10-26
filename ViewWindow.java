package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ViewWindow extends JFrame {
    public ViewWindow() {
        setTitle("View Students");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Column names for the table
        String[] columns = {"ID", "Name", "Age", "GPA"};

        // Read data from file
        Object[][] data = readStudentsFromFile("students.txt");

        // Create JTable with the data
        JTable table = new JTable(data, columns);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Make the table scrollable
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add title label
        JLabel title = new JLabel("Student Details", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Add everything to frame
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Helper method to read students from a file
    private Object[][] readStudentsFromFile(String fileName) {
        ArrayList<Object[]> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Object[] row = {parts[0], parts[1], parts[2], parts[3]};
                    list.add(row);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }

        // Convert ArrayList to 2D array
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i] = list.get(i);
        }

        return data;
    }
}
