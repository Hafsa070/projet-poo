package PP.src.view;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PP.src.controleur.AdminController;
import PP.src.controleur.ClientController;

public class LoginView {
    public LoginView() {
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Champs de texte pour le nom d'utilisateur et le mot de passe
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour gérer la connexion
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Code de validation des utilisateurs
                if (username.equals("admin") && password.equals("admin")) {
                    // Ouvrir l'interface admin
                    new AdminView(new AdminController());
                } else if (username.equals("client") && password.equals("client")) {
                    // Ouvrir l'interface client
                    new ClientView(new ClientController());
                } else {
                    JOptionPane.showMessageDialog(frame, "Identifiants incorrects");
                }
            }
        });

        // Ajouter les composants au frame
        frame.getContentPane().add(usernameField);
        frame.getContentPane().add(passwordField);
        frame.getContentPane().add(loginBtn);

        frame.setVisible(true);
    }
}






