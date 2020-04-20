package com.mycompany.javaproject;

public class Main {
    
    public Main(){
        new FileManager();
    }
    
    public static void main(String[] args) {
        
        // Set the main window to be visible after launching the application
        new MainWindow().setVisible(true);
        
    }
    
}
