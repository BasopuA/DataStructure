/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ManageMessage implements MessageManagerInterface,FileManagerInterface{

    @Override
    public String encryptedMessage(Message message) 
    {
        return  message.getText();
    }

    @Override
    public String decryptedMessage(Message message)
    {
        String text = message.getText();
        String newMessage = "";
        char myChar;
        int shift = 3;
        for (int i = 0; i < text.length(); i++) 
        {
            
            myChar = text.charAt(i);
            if(Character.isLetter(myChar))
            {
                if(myChar >='a' && myChar <='z')
                {
                    char newChar = (char)(myChar-3);
                    if(newChar  < 'a')
                    {
                        newChar += 26;
                    }
                    newMessage += newChar;
                }
                
                else
                {
                    if(myChar >='A' && myChar<='Z')
                    {
                        char newChar = (char)(myChar-3);
                        if(newChar < 'A')
                        {
                            newChar +=26;
                        }
                        newMessage += newChar;
                    }
                }
            }
            else
            {
                newMessage += myChar;
            }
            
        }
        
        return newMessage;
    }

    @Override
    public Map<String, Integer> keyWordsFrequency(List<String> words) 
    {
        for (String word : words)
        {
            System.out.println(word);
        }
        Map<String,Integer> wordMap = new HashMap<>();
        int count =0;
        
        for (String word : words) 
        {
            if(wordMap.containsKey(word))
            {
                count = wordMap.get(word);
                count++;
                wordMap.put(word, count);
            }
            else
            {
                wordMap.put(word, 1);
            }
        }
        
        return wordMap;
    }

    @Override
    public String classifyingMessage(Map<String, Integer> frequencyWords) 
    {
        String results = "The text is normal";
        int countPercentage =0;
        String[] dangerWordsList = {"burn","protest","ziyakhala","president","state"};
        for (String dangerWord : dangerWordsList) 
        {
            if(frequencyWords.containsKey(dangerWord))
            {
                countPercentage +=frequencyWords.get(dangerWord);
            }
        }
        if(countPercentage>2)
        {
           results = "The Message is Dangerours"; 
        }
       
        
        return results;
    }

    @Override
    public Message readTheMessageFromFile(File file) throws IOException 
    {
       Message message = null;

        BufferedReader br;
       String data,record = "";

           file = new File("./Message.txt");
            try
            {
               // file = fc.getSelectedFile();
                br = new BufferedReader(new FileReader(file));
                while((data=br.readLine())!=null)
                {
                    record +=data+"\n";
                }
                br.close();
                message = new Message(record) ;
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, "you did not select the file");
            }
       
        
        
        
        
        return message;
    }

    @Override
    public void storeToNewFile(Message message, File file, String decryptMessage, Map<String, Integer> words, String classifyedMessage) throws IOException
    {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        
        bw.write(message.toString());
        bw.newLine();
            
        bw.write("========================Decrypted Message\n" +decryptMessage );
        bw.newLine(); 
        
        bw.write("============================Text Type:" +classifyedMessage );
        bw.newLine(); 
        
        bw.write("==================The list or words in Map\n");
        
        for (Map.Entry<String, Integer> entry : words.entrySet()) 
        {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
            bw.write(key+"===>" +val);    
        }
        bw.newLine();
        
        bw.close();
    }
     public List<String> getWords(Message message) {
        Message cleanMessage = removeSpecialCharacters(message);
        String[] messageTokens = cleanMessage.getText().split(" ");
        List<String> words = new ArrayList<>();

        for(String word:messageTokens){
        words.add(word);
        }

        return words;
        }
          private Message removeSpecialCharacters(Message message) {
            char charAtIndex;
            String newText = "";
            String text = message.getText();

            for(int i = 0; i < text.length(); i++){
            charAtIndex = text.charAt(i);

            if(Character.isLetterOrDigit(charAtIndex)){
            newText = newText + Character.toString(charAtIndex);
            } else {
            if(Character.isWhitespace(charAtIndex)){
            newText = newText + " ";
            }
            }
            }


     Message newMessage = new Message(newText); 
     return newMessage;
     }
}
    

