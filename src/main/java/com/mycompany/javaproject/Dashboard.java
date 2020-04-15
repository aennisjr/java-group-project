/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author ennis
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        render_book_content();
        new FileManager();
    }
       
    // renders the content of the page (books)
    public void render_book_content(){
        FileManager getFiles = new FileManager();
        File[] books_array = getFiles.all_dir_files(getFiles.get_books_directory());
        int current_book_count = books_array.length;
        
        resource_list.setText(null); //clear out old text
        
        resource_list.append("Our system currently has " + String.valueOf(current_book_count) + " book(s).\n\n");
        FileManager render = new FileManager();
        render.render_file_content_in_panel(books_array, resource_list, container_panel);
    }
    
    // renders the content of the page (supplies)
    public void render_supplies_content(){
        FileManager getFiles = new FileManager();
        File[] supplies_array = getFiles.all_dir_files(getFiles.get_supplies_directory());
        int current_supplies_count = supplies_array.length;
        
        resource_list.setText(null); //clear out old text
        
        resource_list.append("Our system currently has " + String.valueOf(current_supplies_count) + " item(s).\n\n");
        FileManager render = new FileManager();
        render.render_file_content_in_panel(supplies_array, resource_list, container_panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resource_list = new javax.swing.JTextArea();
        refresh_books_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        add_new_book_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        refresh_supplies = new javax.swing.JButton();
        add_new_supplies_button = new javax.swing.JButton();
        delete_book_button = new javax.swing.JButton();
        search_field = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        signout_button = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        delete_supplies_button = new javax.swing.JButton();
        supplies_search_field = new javax.swing.JTextField();
        supplies_search_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashbaord");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/h.png")).getImage());
        setPreferredSize(new java.awt.Dimension(930, 540));
        setResizable(false);

        container_panel.setBackground(new java.awt.Color(255, 255, 255));

        resource_list.setEditable(false);
        resource_list.setColumns(20);
        resource_list.setRows(5);
        jScrollPane1.setViewportView(resource_list);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        refresh_books_button.setText("Refresh");
        refresh_books_button.setToolTipText("See all books");
        refresh_books_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh_books_buttonMouseClicked(evt);
            }
        });

        jLabel1.setText("Books");

        add_new_book_button.setText("Add New");
        add_new_book_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_new_book_buttonMouseClicked(evt);
            }
        });

        jLabel2.setText("School Supplies");

        refresh_supplies.setText("Refresh");
        refresh_supplies.setToolTipText("See all school supplies");
        refresh_supplies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh_suppliesMouseClicked(evt);
            }
        });

        add_new_supplies_button.setText("Add New");
        add_new_supplies_button.setToolTipText("Add new school supplies");
        add_new_supplies_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_new_supplies_buttonMouseClicked(evt);
            }
        });

        delete_book_button.setText("Del Book");
        delete_book_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_book_buttonMouseClicked(evt);
            }
        });

        search_button.setText("Search");
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_buttonMouseClicked(evt);
            }
        });

        signout_button.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        signout_button.setText("Sign Out");
        signout_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signout_buttonMouseClicked(evt);
            }
        });

        delete_supplies_button.setText("Delete");
        delete_supplies_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_supplies_buttonMouseClicked(evt);
            }
        });

        supplies_search_button.setText("Search");
        supplies_search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplies_search_buttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout container_panelLayout = new javax.swing.GroupLayout(container_panel);
        container_panel.setLayout(container_panelLayout);
        container_panelLayout.setHorizontalGroup(
            container_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refresh_books_button, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_new_book_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(refresh_supplies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_new_supplies_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_book_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search_field)
                    .addComponent(search_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signout_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(delete_supplies_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplies_search_field)
                    .addComponent(supplies_search_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        container_panelLayout.setVerticalGroup(
            container_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(container_panelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(container_panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh_books_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_new_book_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_book_button)
                        .addGap(18, 18, 18)
                        .addComponent(search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button)
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh_supplies)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_new_supplies_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_supplies_button)
                        .addGap(23, 23, 23)
                        .addComponent(supplies_search_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplies_search_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signout_button)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh_books_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_books_buttonMouseClicked
        // handle click event for the view books button

        // use the method to get the list of files
        FileManager getFiles = new FileManager();
        File[] books_array = getFiles.all_dir_files(getFiles.get_books_directory());
        
        render_book_content();
        
    }//GEN-LAST:event_refresh_books_buttonMouseClicked

    private void add_new_book_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_new_book_buttonMouseClicked
        //Show the add book panel when the dashboard's Add New button is clicked
        new AddBook().setVisible(true);
    }//GEN-LAST:event_add_new_book_buttonMouseClicked

    private void delete_book_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_book_buttonMouseClicked
        // Handle even for Delete Book Button
        String input = JOptionPane.showInputDialog(this, "Please enter the title of the book you wish to delete.").trim().toLowerCase();
        
        // check if a value is entered
        if(input != null) {
            FileManager getFiles = new FileManager();
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this file?");
            
            if(confirm == 0) {
                // confirmation is true
                boolean delete = getFiles.delete_file_by_name(getFiles.get_books_directory(), input);
                render_book_content();
            }
        }
    }//GEN-LAST:event_delete_book_buttonMouseClicked

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseClicked
        // handle click event for the search button
        String search = search_field.getText().trim();
        
        if(search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a book title to search for.");
        } else {
            //get a list of books in the folder
            FileManager getFiles = new FileManager();
            
            // get information about the current user
            File[] books_array = getFiles.all_dir_files(getFiles.get_books_directory());
            
            // search for the file and render the results (if any)
            getFiles.search_render_file_content_in_panel(search, books_array, resource_list, container_panel);
        }
    }//GEN-LAST:event_search_buttonMouseClicked

    private void signout_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signout_buttonMouseClicked
        // Click event for the sign out button
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to sign out?");
        
        if(confirm == 0) {
            // confirmation is true
            this.setVisible(false);
            System.exit(0);
        }
    }//GEN-LAST:event_signout_buttonMouseClicked

    private void refresh_suppliesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_suppliesMouseClicked
        // use the method to get the list of files
        FileManager getFiles = new FileManager();
        File[] supplies_array = getFiles.all_dir_files(getFiles.get_supplies_directory());

        render_supplies_content();
    }//GEN-LAST:event_refresh_suppliesMouseClicked

    private void add_new_supplies_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_new_supplies_buttonMouseClicked
        // Handle click event for Add Supplies button        
        new AddSupplies().setVisible(true);
    }//GEN-LAST:event_add_new_supplies_buttonMouseClicked

    private void supplies_search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplies_search_buttonMouseClicked
        // handle click event for the supplies search button
        String search = supplies_search_field.getText().trim();
        
        if(search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a value to search for.");
        } else {

            //get a list of books in the folder
            FileManager getFiles = new FileManager();
            
            // get information about the current user
            File[] supplies_array = getFiles.all_dir_files(getFiles.get_supplies_directory());
            
            // search for the file and render the results (if any)
            getFiles.search_render_file_content_in_panel(search, supplies_array, resource_list, container_panel);
        }
    }//GEN-LAST:event_supplies_search_buttonMouseClicked

    private void delete_supplies_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_supplies_buttonMouseClicked
        // Handle click even for delete supplies button
        String input = JOptionPane.showInputDialog(this, "Please enter the name of the item you wish to delete.").trim().toLowerCase();
        
        // check if a value is entered
        if(input != null) {
            FileManager getFiles = new FileManager();
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this file?");
            
            if(confirm == 0) {
                // confirmation is true
                boolean delete = getFiles.delete_file_by_name(getFiles.get_supplies_directory(), input);
                render_supplies_content();
            }
        }
    }//GEN-LAST:event_delete_supplies_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_new_book_button;
    private javax.swing.JButton add_new_supplies_button;
    private javax.swing.JPanel container_panel;
    private javax.swing.JButton delete_book_button;
    private javax.swing.JButton delete_supplies_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton refresh_books_button;
    private javax.swing.JButton refresh_supplies;
    private javax.swing.JTextArea resource_list;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_field;
    private javax.swing.JButton signout_button;
    private javax.swing.JButton supplies_search_button;
    private javax.swing.JTextField supplies_search_field;
    // End of variables declaration//GEN-END:variables
}
