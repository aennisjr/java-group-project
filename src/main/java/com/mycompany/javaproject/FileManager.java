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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ennis
 */
public class FileManager {
    
    // declaration of default directories
    private final String user_directory = "C:/handmedown/users/";
    private final String current_user_directory = "C:/handmedown/activeuser/";
    private final String books_directory = "C:/handmedown/books/";
    private final String supplies_directory = "C:/handmedown/supplies/";
    
    // constructor
    public FileManager() {
        // create directories if they do not already exist        
        new File(user_directory).mkdirs();
        new File(current_user_directory).mkdirs();
        new File(books_directory).mkdirs();
        new File(supplies_directory).mkdirs();
    }
    
    // getter for user directory
    public String get_user_directory() {
        return user_directory;
    }
    
    // getter for current user directory
    public String get_current_user_directory() {
        return current_user_directory;
    }
    
    // getter for books directory
    public String get_books_directory() {
        return books_directory;
    }
    
// getter for books directory
    public String get_supplies_directory() {
        return supplies_directory;
    }
    
    // Get current data and time
    public static String current_date_time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    // gets a list of all files stored in a given directory, returns a File array
    public File[] all_dir_files(String directory) {

        File files = new File(directory);
        File[] file_array = files.listFiles();
        
        return file_array;
        
    }
    
    public ArrayList<String> search_dir_for_files(String directory, String search_for) {
        
        File files = new File(directory);
        File[] file_array = files.listFiles();
        
        ArrayList<String> list = new ArrayList<>(); 
        
        for(File file: file_array) {
            if (file.isFile() && file.getName().endsWith(search_for.toLowerCase() + ".txt")) {
                list.add(file.getName());
                return list;
            }
        }
        return null;
    }
            
            
    // takes a file array, targeted text area (JTextArea), and panel (JPanel) as arguments
    // takes the array, read all files in the array, then append it to the target panel as a string, then revalidates the parent element (JPanel)
    public void render_file_content_in_panel(File[] file_array, JTextArea render_to_panel, JPanel revalidate_panel) {
        String content = ""; // string content to be returned
        int counter = 1; // default value for file numbering
        
        BufferedReader reader;
        
        // iterate through the files
        for(File file: file_array) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    content = counter + ". ";

                    try {
                        reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();
                        while (line != null) {
                                content = content + line + "\n          ";
                                // read next line
                                line = reader.readLine();
                        }
                        // Add space and an icon between the elements
                        content += "\n\t- \u221E - \u221E - \u221E -\n\n";
                        
                        // increment the counter
                        counter++;
                        
                        // close the file
                        reader.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
                    //resource_list.append(line + "\n\n");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // Output file data string that was found inside the folder
            render_to_panel.append(content);
        }
        //repaints the panel after update
        revalidate_panel.revalidate();
    }
    
    // Searches the specified directory for a file
    public void search_render_file_content_in_panel(String search_for, File[] file_array, JTextArea render_to_panel, JPanel revalidate_panel) {
         // Stores the content to be output to the user
        String content = "";
        // variable to store the outcome
        boolean outcome = false;
        int counter = 1;
        int file_count = 0;
        BufferedReader reader;
        
        // Check if the string is too short
        if(search_for.length() < 3){
            JOptionPane.showMessageDialog(render_to_panel, "Your query is too short. Please enter at least 3 characters to search for.");
        } else {
            for(File file: file_array) {
                // checks for the following
                // 1. that the file is actually a file and not a directory (folder)
                // 2. that the file name ends with the title of the book that the user searched for

                // Split the filename into two parts for better searching
                // Searches the title portion (second part) of the filename
                String[] arrOfStr = file.getName().split(" - "); 

                if (file.isFile() && arrOfStr[1].toLowerCase().contains(search_for.toLowerCase())) {
                    try {
                        try {
                            content = content + counter + ". ";

                            try {
                                reader = new BufferedReader(new FileReader(file));
                                String line = reader.readLine();
                                while (line != null) {
                                        content = content + line + "\n          ";
                                        // read next line
                                        line = reader.readLine();
                                }
                                // Add space and an icon between the elements
                                content += "\n\t- \u221E - \u221E - \u221E -\n\n";

                                // increment the counter
                                counter++;
                                file_count++;
                                outcome = true;

                                // close the file
                                reader.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                            //resource_list.append(line + "\n\n");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                            e.printStackTrace();
                    }
                }
            }

            // output the results to the user
            if(outcome == true) {
                JOptionPane.showMessageDialog(null, "Your search for \""+ search_for +"\" returned " + file_count + " result(s).");
                render_to_panel.setText(null); //clear out old text
                render_to_panel.append("Showing " + file_count + " result(s).\n\n"); // display number of results
                render_to_panel.append(content); /// add the new text
            } else if (outcome == false) {
                JOptionPane.showMessageDialog(null, "We didn't find any results for \""+ search_for +"\". Please try searching again");
            } else {
                JOptionPane.showMessageDialog(null, "An error occured while processing your request.");
            }
        }
    }
    
    // takes a directory (String) and filename (String). Searches the directory for the filename given then deletes it
    public boolean delete_file_by_name(String directory, String filename) {

        FileManager getFiles = new FileManager();
        // get information about the current user
        File[] temp_files = getFiles.all_dir_files(getFiles.get_current_user_directory());
        // extract the user's email address for use
        String current_user_email = temp_files[0].getName().replaceFirst("[.][^.]+$", "");

        // variable to store the outcome
        boolean outcome = false;

        // get a list of books in the folder
        File[] files_array = getFiles.all_dir_files(directory);

        for(File file: files_array) {
            // checks for the following
            // 1. that the file is actually a file and not a directory (folder)
            // 2. that the file name starts with the current user's email address 
            // 3. that the file name ends with the title of the book that the user entered
            if (file.isFile() && file.getName().startsWith(current_user_email) && file.getName().toLowerCase().endsWith(filename + ".txt")) {
                try {
                    // delete
                    if(file.delete()){
                        // if the file was found and successfully deleted
                        outcome = true;
                        break;
                    }
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        }

        // output the results to the user
        if(outcome == true) {
            // book successfully removed
            JOptionPane.showMessageDialog(null, "Your item has been removed from our database.");
            return true;
        } else if (outcome == false) {
            // if the filename does not match any of the files returned, or if the file was not added by current user
            JOptionPane.showMessageDialog(null, "The item you're attempting to delete was not added by you, \n"
                                              + "or you may have typed the title incorrectly. Please try again.");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "An error occured while processing your request.");
            return false;
        }
        
    }
    
    // returns a String containing information about the currently active user
    public String current_user() {

        // get information about the current user
        File temp_storage = new File(get_current_user_directory());
        File[] temp_files = temp_storage.listFiles();
        // extract the user's email address for use in the filename
        String current_user_email = temp_files[0].getName().replaceFirst("[.][^.]+$", "");

        String userdata = "";
        int increment_count = 0;
        
        BufferedReader reader;

        // get additional information about the current user from the /user/ directory
        File user = new File(get_user_directory());
        File[] user_array = user.listFiles();
        for(File info: user_array) {
            if (info.isFile() && info.getName().endsWith(current_user_email + ".txt")) {
                try {
                    try {
                        reader = new BufferedReader(new FileReader(info));
                        String line = reader.readLine();
                        while (increment_count < 3) {
                                userdata = userdata + line + " | ";
                                // read next line
                                line = reader.readLine();
                                increment_count++;
                        }
                        // close the file
                        reader.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        return userdata;
    }
    
    // returns a String containing the currently active user's email address (filename)
    public String current_user_email(){
        // get information about the current user
        File temp_storage = new File(get_current_user_directory());
        File[] temp_files = temp_storage.listFiles();
        // extract the user's email address from the filename
        String current_user_email = temp_files[0].getName().replaceFirst("[.][^.]+$", "");
        
        return current_user_email;
    }
    
}
