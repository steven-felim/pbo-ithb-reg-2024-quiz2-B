package controller;

import model.classes.DatabaseHandler;
import view.artwork.ArtworkMenu;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    public boolean checkLogin(String email, String password) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, email, password FROM users " +
                    "WHERE email = '" + email + "' AND password = '" + password + "'")) {

            while (rs.next()) {
                int checkID = rs.getInt("id");
                String name = rs.getString("name");
                String checkEmail = rs.getString("email");
                String checkPassword = rs.getString("password");

                if (checkEmail.equals(email) && checkPassword.equals(password)) {
                    new ArtworkMenu(checkID);
                    JOptionPane.showMessageDialog(null, "Hello, " + name + ", you are logged in!");
                    return true;
                }
            }
        } catch (
                SQLException e2) {
            e2.printStackTrace();
            conn.disconnect();
        }
        JOptionPane.showMessageDialog(null, "Login Failed");
        return false;
    }
}
