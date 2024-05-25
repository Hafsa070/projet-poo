package PP.src.view;

import PP.src.model.Chambre;
import PP.src.controleur.AdminController;
import PP.src.model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  AdminView {
  private AdminController adminController;
    private JFrame frame;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Admin Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre

        // Définir la couleur de fond
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        // Créer un JPanel pour organiser les composants
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 lignes, 1 colonne, espacements horizontal et vertical
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Marge intérieure

        // Bouton "Ajouter Chambre"
        JButton ajouterChambreBtn = new JButton("Ajouter Chambre");
        ajouterChambreBtn.setBackground(new Color(51, 153, 255));
        ajouterChambreBtn.setForeground(Color.WHITE);
        ajouterChambreBtn.setFocusPainted(false);
        ajouterChambreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Chambre chambre = new Chambre(1, "Simple", 100.0);
                    adminController.ajouterChambre(chambre);
                    JOptionPane.showMessageDialog(frame, "Chambre ajoutée avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(ajouterChambreBtn);

        // Bouton "Modifier Chambre"
        JButton modifierChambreBtn = new JButton("Modifier Chambre");
        modifierChambreBtn.setBackground(new Color(51, 153, 255));
        modifierChambreBtn.setForeground(Color.WHITE);
        modifierChambreBtn.setFocusPainted(false);
        modifierChambreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Chambre chambre = new Chambre(1, "Double", 150.0);
                    adminController.modifierChambre(1, chambre);
                    JOptionPane.showMessageDialog(frame, "Chambre modifiée avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(modifierChambreBtn);

        // Bouton "Supprimer Chambre"
        JButton supprimerChambreBtn = new JButton("Supprimer Chambre");
        supprimerChambreBtn.setBackground(new Color(51, 153, 255));
        supprimerChambreBtn.setForeground(Color.WHITE);
        supprimerChambreBtn.setFocusPainted(false);
        supprimerChambreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adminController.supprimerChambre(1);
                    JOptionPane.showMessageDialog(frame, "Chambre supprimée avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(supprimerChambreBtn);

        // Bouton "Accepter Réservation"
        JButton accepterReservationBtn = new JButton("Accepter Réservation");
        accepterReservationBtn.setBackground(new Color(51, 153, 255));
        accepterReservationBtn.setForeground(Color.WHITE);
        accepterReservationBtn.setFocusPainted(false);
        accepterReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adminController.accepterReservation(1);
                    JOptionPane.showMessageDialog(frame, "Réservation acceptée!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(accepterReservationBtn);

        // Bouton "Décliner Réservation"
        JButton declinerReservationBtn = new JButton("Décliner Réservation");
        declinerReservationBtn.setBackground(new Color(51, 153, 255));
        declinerReservationBtn.setForeground(Color.WHITE);
        declinerReservationBtn.setFocusPainted(false);
        declinerReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adminController.declinerReservation(1);
                    JOptionPane.showMessageDialog(frame, "Réservation déclinée!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(declinerReservationBtn);

        // Ajouter le JPanel au frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

    

