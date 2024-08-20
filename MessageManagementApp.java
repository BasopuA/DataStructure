/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package messagemanagementapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.ab.ManageMessage;
import za.ac.tut.ab.Message;

/**
 *
 * @author Alex
 */
public class MessageManagementApp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        File file = new File("./Message.txt");
        File file1 = new File("./newMessage.txt");
        
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ManageMessage  mm = new ManageMessage();
            Message message = mm.readTheMessageFromFile(file);
            List<String> words = new ArrayList<>();
            Map<String,Integer> wornMessage = new HashMap<>();
            
            String encryptedMessage = mm.encryptedMessage(message);
            String decryptedeMessage = mm.decryptedMessage(message);
            words = mm.getWords(message);
            wornMessage = mm.keyWordsFrequency(words);
            
            for (Map.Entry<String, Integer> entry : wornMessage.entrySet()) {
                Object key = entry.getKey();
                Object val = entry.getValue();
               System.out.println(key+"===>"+val);
            }
            String messageType = mm.classifyingMessage(wornMessage);
            
            mm.storeToNewFile(message, file1, decryptedeMessage, wornMessage, encryptedMessage);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(MessageManagementApp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
