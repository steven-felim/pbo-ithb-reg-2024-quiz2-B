package view.artwork;

import model.classes.Artworks;

import javax.swing.*;
import java.awt.*;

public class AddArtwork extends JFrame {
    private Artworks artworks;
    public AddArtwork(int id) {
        artworks = new Artworks();
        initComponents(id);
        this.setVisible(true);
    }

    private void initComponents(int id) {
        this.setTitle("Add Artwork");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("AddArtwork");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        titleLabel.setBounds(200, 110, 220, 30);
        panel.add(titleLabel);

        JTextField titleField = new JTextField(255);
        titleField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        titleField.setBounds(510, 110, 220, 30);
        panel.add(titleField);

        JLabel desc = new JLabel("Description");
        desc.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        desc.setBounds(200, 160, 220, 30);
        panel.add(desc);

        JTextArea descField = new JTextArea();
        descField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        descField.setBounds(510, 160, 270, 80);
        panel.add(descField);

        JFileChooser fcFoto = new JFileChooser();
        JButton browseButton = new JButton("Browse...");
        browseButton.setBounds(440, 260, 440, 40);
        browseButton.addActionListener(e -> {
            int returnValue = fcFoto.showOpenDialog(panel);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                artworks.setImage_path(fcFoto.getSelectedFile().getAbsolutePath());
                browseButton.setText(artworks.getImage_path());
            }
        });
        panel.add(browseButton);

        JButton submit = new JButton("Add Artwork");
        submit.setBounds(440, 310, 440, 40);
        panel.add(submit);

        submit.addActionListener(e ->  {
            // Sambungin ke DB, ada controller
        });

        this.add(title);
        this.add(panel);
    }
}
