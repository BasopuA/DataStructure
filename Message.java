/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.ab;

/**
 *
 * @author Alex
 */
public class Message 
{
    private String text;

    public Message(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }

    public void setText(String text) 
    {
        this.text = text;
    }

    @Override
    public String toString() 
    {
        return  text ;
    }
    
    
    
}
