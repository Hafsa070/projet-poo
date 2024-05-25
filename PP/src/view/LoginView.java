package PP.src.view;

import javax.swing.*;
import java.awt.*;
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
        frame.setSize(400, 250); // Augmenter la hauteur pour mieux espacer les composants
        frame.setLocationRelativeTo(null); // Centrer la fenêtre

        // Panel principal avec layout BorderLayout et fond bleu clair
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230)); // Couleur bleu clair

        // Panel pour les champs de texte et le bouton
        JPanel inputPanel = new JPanel(new GridLayout(4, 1, 5, 10)); // 4 lignes, 1 colonne, espacement de 5 pixels horizontalement et 10 pixels verticalement
        inputPanel.setBackground(new Color(240, 248, 255)); // Couleur blanc cassé
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Marge intérieure de 20 pixels

        // Champs de texte pour l'ID et le mot de passe
        JTextField zondeid = new JTextField();
        JPasswordField zonemdp = new JPasswordField();

        // Bouton "Entrer" avec fond bleu foncé et texte blanc
        JButton enterButton = new JButton("Entrer");
        enterButton.setBackground(new Color(25, 25, 112)); // Couleur bleu foncé
        enterButton.setForeground(Color.WHITE); // Texte blanc
        enterButton.setFocusPainted(false); // Supprimer le contour de mise au point

        // Ajouter un écouteur d'événements au bouton "Entrer"
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour gérer la connexion
                String username = zondeid.getText();
                String password = new String(zonemdp.getPassword());

                // Code de validation des utilisateurs
                if (username.equals("ad") && password.equals("ad")) {
                    // Ouvrir l'interface admin
                    new AdminView(new AdminController());
                } else if (username.equals("cl") && password.equals("cl")) {
                    // Ouvrir l'interface client
                    new ClientView(new ClientController());
                } else {
                    JOptionPane.showMessageDialog(frame, "Identifiants incorrects");
                }
            }
        });

        // Ajouter les composants au panel des champs de texte et du bouton
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(zondeid);
        inputPanel.add(new JLabel("Mot de passe:"));
        inputPanel.add(zonemdp);
        inputPanel.add(enterButton);

        // Ajout du panel des champs de texte et du bouton au panel principal
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Ajout du panel principal au frame
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }
}