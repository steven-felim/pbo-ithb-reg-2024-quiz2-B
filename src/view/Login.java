package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private final LoginController c;
    public Login() {
        c = new LoginController();
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Login");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        title.setBounds(143, 22, 200, 51);
        JPanel formLogin = new JPanel();
        formLogin.setLayout(null);
        formLogin.setBounds(44, 111, 300, 150);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        email.setBounds(0, 0, 130, 30);
        formLogin.add(email);

        JTextField emailField = new JTextField(255);
        emailField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        emailField.setBounds(0, 33, 298, 30);
        formLogin.add(emailField);

        JLabel passwordUser = new JLabel("Password:");
        passwordUser.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        passwordUser.setBounds(0, 77, 130, 30);
        formLogin.add(passwordUser);

        JPasswordField passwordField = new JPasswordField(255);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        passwordField.setBounds(0, 110, 298, 30);
        passwordField.setEchoChar('*');
        formLogin.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(43, 300, 350, 100);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 0, 100, 40);
        buttonPanel.add(loginButton);

        loginButton.addActionListener(e -> {
            if (c.checkLogin(emailField.getText(), passwordField.getText())) {
                this.dispose();
            }
        });

        add(title);
        add(formLogin);
        add(buttonPanel);
    }
}
