package PP.src.view;

import PP.src.controleur.ClientController;
import PP.src.model.Date;
import PP.src.model.Reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView {
    private ClientController clientController;

    public ClientView(ClientController clientController) {
        this.clientController = clientController;
        initUI();
    }



    private void initUI() {
        JFrame frame = new JFrame("Client Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JButton demanderReservationBtn = new JButton("Demander Réservation");
        demanderReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Reservation reservation = new Reservation(1, 1, 1, new Date(2024, 5, 1), new Date(2024, 5, 10), "En attente");
                    clientController.demanderReservation(reservation);
                    JOptionPane.showMessageDialog(frame, "Réservation demandée avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        JButton modifierReservationBtn = new JButton("Modifier Réservation");
        modifierReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Reservation reservation = new Reservation(1, 1, 1, new Date(2024, 5, 5), new Date(2024, 5, 15), "En attente");
                    clientController.modifierReservation(1, reservation);
                    JOptionPane.showMessageDialog(frame, "Réservation modifiée avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        JButton annulerReservationBtn = new JButton("Annuler Réservation");
        annulerReservationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clientController.annulerReservation(1);
                    JOptionPane.showMessageDialog(frame, "Réservation annulée avec succès!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
                }
            }
        });

        frame.getContentPane().add(demanderReservationBtn);
        frame.getContentPane().add(modifierReservationBtn);
        frame.getContentPane().add(annulerReservationBtn);

        frame.setVisible(true);
    }
}
