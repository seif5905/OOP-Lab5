package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        Font btnFont = new Font("Arial", Font.BOLD, 16);
        addButton.setFont(btnFont);
        viewButton.setFont(btnFont);
        updateButton.setFont(btnFont);
        deleteButton.setFont(btnFont);

        addButton.addActionListener(e -> new AddWindow());
        viewButton.addActionListener(e -> new ViewWindow());
        updateButton.addActionListener(e -> new UpdateWindow());
        deleteButton.addActionListener(e -> new DeleteWindow());

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard());
    }
}



