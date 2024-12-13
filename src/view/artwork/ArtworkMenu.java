package view.artwork;

import javax.swing.*;
import java.awt.*;

public class ArtworkMenu extends JFrame {
    public ArtworkMenu(int id) {
        initComponents(id);
        this.setVisible(true);
    }

    private void initComponents(int id) {
        this.setTitle("Menu Page");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Artwork Menu");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(500, 150, 350, 100);

        JButton addButton = new JButton("Add Artwork");
        addButton.setBounds(470, 100, 200, 40);
        buttonPanel.add(addButton);

        addButton.addActionListener(e -> {
            new AddArtwork(id);
        });

        this.add(title);
        this.add(buttonPanel);
    }
}
