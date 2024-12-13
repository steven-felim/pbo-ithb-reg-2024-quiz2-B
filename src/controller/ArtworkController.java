package controller;

import model.classes.Artworks;
import model.classes.DatabaseHandler;
import view.artwork.ArtworkMenu;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.TimeZone;

public class ArtworkController {
    public void insertDataToDB(int id) {
        Artworks tempData = new Artworks();
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        String query = "INSERT INTO artworks (title, description, image_path, user_id) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

            stmt.setString(1, tempData.getTitle());
            stmt.setString(2, tempData.getDescription());
            stmt.setString(3, tempData.getImage_path());
            stmt.setInt(4, id);

            stmt.executeUpdate();
            conn.disconnect();
            JOptionPane.showMessageDialog(null, "Data successfully added!");
            new ArtworkMenu(id);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            JOptionPane.showMessageDialog(null, "Data not added!");
        }
    }
}