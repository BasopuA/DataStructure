/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.ab;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Alex
 */
public interface FileManagerInterface 
{
    public Message readTheMessageFromFile(File file) throws IOException;
    public void storeToNewFile(Message message, File file,String decryptMessage,Map<String,Integer> words,String classifyedMessage) throws IOException;
}
