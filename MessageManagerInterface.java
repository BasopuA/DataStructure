/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.ab;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public interface MessageManagerInterface 
{
    public String encryptedMessage(Message message);
    public String decryptedMessage(Message message);
    public Map<String,Integer> keyWordsFrequency(List<String> words);
    public String classifyingMessage(Map<String,Integer> dangersWords);
    
}
