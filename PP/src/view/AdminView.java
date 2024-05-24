package PP.src.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import PP.src.model.Chambre;
import PP.src.controleur.AdminController;
import PP.src.model.Chambre;
import  PP.src.model.Reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  AdminView {
 private AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Boutons et autres composants pour l'interface admin
        JButton ajouterChambreBtn = new JButton("Ajouter Chambre");
        ajouterChambreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code pour ajouter une chambre
                    Chambre chambre = new Chambre(1, "Simple", 100.0);
                    adminController.ajouterChambre(chambre);
                    JOptionPane.showMessageDialog(frame, "Chambre ajoutée avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        JButton modifierChambreBtn = new JButton("Modifier Chambre");
        modifierChambreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code pour modifier une chambre
                    Chambre chambre = new Chambre(1, "Double", 150.0);
                    adminController.modifierChambre(1, chambre);
                    JOptionPane.showMessageDialog(frame, "Chambre modifiée avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        JButton supprimerChambreBtn = new JButton("Supprimer Chambre");
        supprimerChambreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code pour supprimer une chambre
                    adminController.supprimerChambre(1);
                    JOptionPane.showMessageDialog(frame, "Chambre supprimée avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        JButton accepterReservationBtn = new JButton("Accepter Réservation");
        accepterReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code pour accepter une réservation
                    adminController.accepterReservation(1);
                    JOptionPane.showMessageDialog(frame, "Réservation acceptée!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        JButton declinerReservationBtn = new JButton("Décliner Réservation");
        declinerReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Code pour décliner une réservation
                    adminController.declinerReservation(1);
                    JOptionPane.showMessageDialog(frame, "Réservation déclinée!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        // Ajout des composants au frame
        frame.getContentPane().add(ajouterChambreBtn);
        frame.getContentPane().add(modifierChambreBtn);
        frame.getContentPane().add(supprimerChambreBtn);
        frame.getContentPane().add(accepterReservationBtn);
        frame.getContentPane().add(declinerReservationBtn);

        frame.setVisible(true);
    }
    
} 
    

