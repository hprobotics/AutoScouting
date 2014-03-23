/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.beastiebots.scouting.tournament.MatchData;
import org.beastiebots.scouting.tournament.Team;
import org.beastiebots.scouting.tournament.Tournament;

/**
 *
 * @author Jacob Burroughs
 */
public class Tester extends javax.swing.JFrame {

    Tournament tournament;
    ArrayList<Integer> teams;

    /**
     * Creates new form Tester
     */
    public Tester() {
        tournament = new Tournament();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fieldPanel1 = new org.beastiebots.scouting.autonomousPlotter.FieldPanel();
        fieldPanel2 = new org.beastiebots.scouting.autonomousPlotter.FieldPanel();
        fieldPanel3 = new org.beastiebots.scouting.autonomousPlotter.FieldPanel();
        fieldPanel4 = new org.beastiebots.scouting.autonomousPlotter.FieldPanel();
        teamNumber3 = new javax.swing.JTextField();
        teamNumber4 = new javax.swing.JTextField();
        teamNumber1 = new javax.swing.JTextField();
        teamNumber2 = new javax.swing.JTextField();
        commitButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fieldPanel1.setMult(1.0);

        javax.swing.GroupLayout fieldPanel1Layout = new javax.swing.GroupLayout(fieldPanel1);
        fieldPanel1.setLayout(fieldPanel1Layout);
        fieldPanel1Layout.setHorizontalGroup(
            fieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        fieldPanel1Layout.setVerticalGroup(
            fieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        fieldPanel2.setMult(1.0);

        javax.swing.GroupLayout fieldPanel2Layout = new javax.swing.GroupLayout(fieldPanel2);
        fieldPanel2.setLayout(fieldPanel2Layout);
        fieldPanel2Layout.setHorizontalGroup(
            fieldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        fieldPanel2Layout.setVerticalGroup(
            fieldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        fieldPanel3.setMult(1.0);

        javax.swing.GroupLayout fieldPanel3Layout = new javax.swing.GroupLayout(fieldPanel3);
        fieldPanel3.setLayout(fieldPanel3Layout);
        fieldPanel3Layout.setHorizontalGroup(
            fieldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        fieldPanel3Layout.setVerticalGroup(
            fieldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        fieldPanel4.setMult(1.0);

        javax.swing.GroupLayout fieldPanel4Layout = new javax.swing.GroupLayout(fieldPanel4);
        fieldPanel4.setLayout(fieldPanel4Layout);
        fieldPanel4Layout.setHorizontalGroup(
            fieldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        fieldPanel4Layout.setVerticalGroup(
            fieldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        teamNumber3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        teamNumber3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teamNumber3FocusGained(evt);
            }
        });

        teamNumber4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        teamNumber4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teamNumber4FocusGained(evt);
            }
        });

        teamNumber1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        teamNumber1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teamNumber1FocusGained(evt);
            }
        });

        teamNumber2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        teamNumber2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teamNumber2FocusGained(evt);
            }
        });

        commitButton.setText("Commit");
        commitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Match number:");

        jLabel2.setText("Team number:");

        jLabel3.setText("Team number:");

        jLabel4.setText("Team number:");

        jLabel5.setText("Team number:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(fieldPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teamNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teamNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teamNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teamNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fieldPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(commitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(teamNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(teamNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teamNumber1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teamNumber1FocusGained
        teamNumber1.setSelectionStart(0);
    }//GEN-LAST:event_teamNumber1FocusGained

    private void teamNumber2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teamNumber2FocusGained
        teamNumber2.setSelectionStart(0);
    }//GEN-LAST:event_teamNumber2FocusGained

    private void teamNumber3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teamNumber3FocusGained
        teamNumber3.setSelectionStart(0);
    }//GEN-LAST:event_teamNumber3FocusGained

    private void teamNumber4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teamNumber4FocusGained
        teamNumber4.setSelectionStart(0);
    }//GEN-LAST:event_teamNumber4FocusGained

    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
        Team team1 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber1.getText()));
        Team team2 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber2.getText()));
        Team team3 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber3.getText()));
        Team team4 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber4.getText()));
        team1.addMatchData(new MatchData(jTextField1.getText(), fieldPanel1.getAutonomousRoutine()));
        team2.addMatchData(new MatchData(jTextField1.getText(), fieldPanel2.getAutonomousRoutine()));
        team3.addMatchData(new MatchData(jTextField1.getText(), fieldPanel3.getAutonomousRoutine()));
        team4.addMatchData(new MatchData(jTextField1.getText(), fieldPanel4.getAutonomousRoutine()));
        teamNumber1.setText("");
        teamNumber2.setText("");
        teamNumber3.setText("");
        teamNumber4.setText("");
        fieldPanel1.reset();
        fieldPanel2.reset();
        fieldPanel3.reset();
        fieldPanel4.reset();
        boolean is_number = true;
        int matchNumber = 0;
        try {
            matchNumber = Integer.parseInt(jTextField1.getText());
        } catch (NumberFormatException e) {
            is_number = false;
        }
        if(is_number) {
            jTextField1.setText(Integer.toString(matchNumber+1));
        } else {
            jTextField1.setText("");
        }
        System.out.println(tournament.toJson().toString());
    }//GEN-LAST:event_commitButtonActionPerformed

    private void updateTeamList() {
        for (Team teams : tournament.getTeams()) {
            int data = teams.getNumber();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tester().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commitButton;
    private org.beastiebots.scouting.autonomousPlotter.FieldPanel fieldPanel1;
    private org.beastiebots.scouting.autonomousPlotter.FieldPanel fieldPanel2;
    private org.beastiebots.scouting.autonomousPlotter.FieldPanel fieldPanel3;
    private org.beastiebots.scouting.autonomousPlotter.FieldPanel fieldPanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField teamNumber1;
    private javax.swing.JTextField teamNumber2;
    private javax.swing.JTextField teamNumber3;
    private javax.swing.JTextField teamNumber4;
    // End of variables declaration//GEN-END:variables
}
