package com.softserveinc.edu.ita.taskmanager.view;


import com.softserveinc.edu.ita.taskmanager.controller.XMLInitializeContext;
import com.softserveinc.edu.ita.taskmanager.factory.TaskFactory;
import com.softserveinc.edu.ita.taskmanager.model.AbstractTask;
import com.softserveinc.edu.ita.taskmanager.runner.TaskRunner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class WindowApplication extends JFrame implements ActionListener, Application {

    private String[] comboBoxMsgs;

    /**
     * @param args
     * the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JTextField descrField;
    private javax.swing.JLabel descrLabel;
    private javax.swing.JTextField outputField;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JButton startTaskBtn;
    private javax.swing.JLabel taskNameLabel;
    private javax.swing.JComboBox taskNamesBox;
    // End of variables declaration

    private String switchedTaskItem;

    /**
     * Creates new form WindowApplication
     */
    public WindowApplication() {

        try {
            XMLInitializeContext.init(XMLInitializeContext.XML_TASKS_FILE)
                    .parseTag(XMLInitializeContext.TAG_ATTR).loadIntoCache();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        List<String> allKeys = TaskFactory.getAllKeys();

        comboBoxMsgs = allKeys.toArray(new String[allKeys.size()]);

        System.out.println("combo box items: " + Arrays.toString(comboBoxMsgs));

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        taskNamesBox = new javax.swing.JComboBox<>();
        taskNameLabel = new javax.swing.JLabel();
        descrField = new javax.swing.JTextField();
        startTaskBtn = new javax.swing.JButton();
        outputField = new javax.swing.JTextField();
        descrLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        taskNamesBox = new JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taskNamesBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                comboBoxMsgs));

        taskNamesBox.addActionListener(this);

        taskNameLabel.setText("Task Name:");

        descrField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descrFieldActionPerformed(evt);
            }
        });

        startTaskBtn.setText("Run");
        startTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startTaskBtnActionPerformed(evt);
            }
        });

        descrLabel.setText("Description:");

        outputLabel.setText("Output:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(40, 40,
                                                                        40)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        startTaskBtn)
                                                                                .addGroup(
                                                                                        layout.createSequentialGroup()
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(
                                                                                                                        taskNamesBox,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(
                                                                                                                        taskNameLabel))
                                                                                                .addGap(55,
                                                                                                        55,
                                                                                                        55)
                                                                                                .addGroup(
                                                                                                        layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(
                                                                                                                        descrLabel)
                                                                                                                .addComponent(
                                                                                                                        descrField,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        250,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(74, 74,
                                                                        74)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        outputLabel)
                                                                                .addComponent(
                                                                                        outputField,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        214,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(112, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(taskNameLabel)
                                                .addComponent(descrLabel))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(
                                                        taskNamesBox,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        descrField,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        44,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(startTaskBtn)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        35, Short.MAX_VALUE)
                                .addComponent(outputLabel)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outputField,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)));

        pack();
    }// </editor-fold>

    private void descrFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void startTaskBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        Class<?> objClass = TaskFactory.getTaskById(switchedTaskItem);

        AbstractTask obj = null;
        try {
            obj = (AbstractTask) objClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        outputField.setText("" + TaskRunner.run(obj));
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(
                    WindowApplication.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(
                    WindowApplication.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(
                    WindowApplication.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(
                    WindowApplication.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowApplication().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == taskNamesBox) {

            JComboBox cb = (JComboBox) e.getSource();

            switchedTaskItem = (String) cb.getSelectedItem();

            descrField.setText(TaskFactory.getExistingTaskDescription(
                    switchedTaskItem,
                    TaskFactory.getTaskById(switchedTaskItem)));

        }

    }

}
