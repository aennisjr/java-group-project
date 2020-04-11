/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaproject;

/**
 *
 * @author ennis
 */
public class Main {
    
    public Main(){
        new FileManager();
    }
    
    public static void main(String[] args) {
        
        // Set the main window to be visible after launching the application
        new MainWindow().setVisible(true);
        //new Dashboard().setVisible(true);
        //new Test().setVisible(true);
        
    }
    
}
