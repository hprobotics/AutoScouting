/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beastiebots.scouting.gui;

import java.nio.file.Files;
import net.samuelcampos.usbdrivedectector.USBStorageDevice;
import org.beastiebots.scouting.tournament.MatchData;
import org.beastiebots.scouting.tournament.SubjectiveComments;
import org.beastiebots.scouting.tournament.Team;
import org.beastiebots.scouting.tournament.TeleopPerformance;
import org.beastiebots.scouting.tournament.Tournament;
import org.beastiebots.scouting.tournament.uploader.ScoutingClient;

/**
 *
 * @author Jacob
 */
public class ScoutingSubjectiveClientUI extends javax.swing.JFrame {

    Tournament tournament;
    USBStorageDevice flashDrive;

    /**
     * Creates new form ScoutingClientUI
     */
    public ScoutingSubjectiveClientUI() {
        initComponents();
        tournament = new Tournament();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        teleopPerformance1 = new org.beastiebots.scouting.tournament.TeleopPerformance();
        teleopPerformance2 = new org.beastiebots.scouting.tournament.TeleopPerformance();
        jLabel1 = new javax.swing.JLabel();
        commitButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        teamNumber1 = new javax.swing.JTextField();
        teamNumber2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamComments1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        teamComments2 = new javax.swing.JTextArea();
        teamNumber3 = new javax.swing.JTextField();
        teamNumber4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        teamComments3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        teamComments4 = new javax.swing.JTextArea();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), teleopPerformance1, org.jdesktop.beansbinding.BeanProperty.create("doubleHang"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), teleopPerformance1, org.jdesktop.beansbinding.BeanProperty.create("flag"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), teleopPerformance1, org.jdesktop.beansbinding.BeanProperty.create("hang"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JSpinner(), org.jdesktop.beansbinding.ELProperty.create("${value}"), teleopPerformance1, org.jdesktop.beansbinding.BeanProperty.create("numCubes"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), teleopPerformance2, org.jdesktop.beansbinding.BeanProperty.create("doubleHang"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), teleopPerformance2, org.jdesktop.beansbinding.BeanProperty.create("flag"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JCheckBox(), org.jdesktop.beansbinding.ELProperty.create("${selected}"), teleopPerformance2, org.jdesktop.beansbinding.BeanProperty.create("hang"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JSpinner(), org.jdesktop.beansbinding.ELProperty.create("${value}"), teleopPerformance2, org.jdesktop.beansbinding.BeanProperty.create("numCubes"));
        bindingGroup.addBinding(binding);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Match number:");

        commitButton.setText("Commit");
        commitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitButtonActionPerformed(evt);
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

        jLabel3.setText("Team number:");

        jLabel2.setText("Team number:");

        teamComments1.setColumns(20);
        teamComments1.setRows(5);
        jScrollPane1.setViewportView(teamComments1);

        teamComments2.setColumns(20);
        teamComments2.setRows(5);
        jScrollPane2.setViewportView(teamComments2);

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

        jLabel4.setText("Team number:");

        jLabel5.setText("Team number:");

        teamComments3.setColumns(20);
        teamComments3.setRows(5);
        jScrollPane3.setViewportView(teamComments3);

        teamComments4.setColumns(20);
        teamComments4.setRows(5);
        jScrollPane4.setViewportView(teamComments4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teamNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(commitButton))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
        FlashDriveChooser selector = new FlashDriveChooser(this, true, flashDrive);
        selector.setVisible(true);
        if (flashDrive == null || Files.notExists(flashDrive.getRootDirectory().toPath())) {
            flashDrive = null;
        }
        flashDrive = selector.getChosenDevice();
        if (!teamNumber1.getText().isEmpty()) {
            Team team1 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber1.getText()));
            team1.addMatchData(new MatchData(jTextField1.getText(), new SubjectiveComments(teamComments1.getText())));
        }
        if (!teamNumber2.getText().isEmpty()) {
            Team team2 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber2.getText()));
            team2.addMatchData(new MatchData(jTextField1.getText(), new SubjectiveComments(teamComments2.getText())));
        }
        if (!teamNumber3.getText().isEmpty()) {
            Team team3 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber3.getText()));
            team3.addMatchData(new MatchData(jTextField1.getText(), new SubjectiveComments(teamComments3.getText())));
        }
        if (!teamNumber4.getText().isEmpty()) {
            Team team4 = tournament.getOrCreateTeamByNumber(Integer.parseInt(teamNumber4.getText()));
            team4.addMatchData(new MatchData(jTextField1.getText(), new SubjectiveComments(teamComments4.getText())));
        }
        teamNumber1.setText("");
        teamNumber2.setText("");
        teamNumber3.setText("");
        teamNumber4.setText("");
        teamComments1.setText("");
        teamComments2.setText("");
        teamComments3.setText("");
        teamComments4.setText("");
        
        boolean is_number = true;
        int matchNumber = 0;
        try {
            matchNumber = Integer.parseInt(jTextField1.getText());
        } catch (NumberFormatException e) {
            is_number = false;
        }
        if (is_number) {
            jTextField1.setText(Integer.toString(matchNumber + 1));
        } else {
            jTextField1.setText("");
        }
        System.out.println(tournament.toJson().toString());
        (new ScoutingClient(tournament.toJson().toString(), (flashDrive != null) ? flashDrive.getRootDirectory().toPath() : null)).execute();
    }//GEN-LAST:event_commitButtonActionPerformed

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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScoutingSubjectiveClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoutingSubjectiveClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoutingSubjectiveClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoutingSubjectiveClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoutingSubjectiveClientUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea teamComments1;
    private javax.swing.JTextArea teamComments2;
    private javax.swing.JTextArea teamComments3;
    private javax.swing.JTextArea teamComments4;
    private javax.swing.JTextField teamNumber1;
    private javax.swing.JTextField teamNumber2;
    private javax.swing.JTextField teamNumber3;
    private javax.swing.JTextField teamNumber4;
    private org.beastiebots.scouting.tournament.TeleopPerformance teleopPerformance1;
    private org.beastiebots.scouting.tournament.TeleopPerformance teleopPerformance2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
