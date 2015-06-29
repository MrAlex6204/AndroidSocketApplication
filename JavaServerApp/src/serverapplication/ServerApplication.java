/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapplication;
import java.net.*;
import java.io.*;

/**
 *
 * @author MrAlex6204
 */
public class ServerApplication {

    
    
    private static String getRandomMsg(){
        String[] messages = {"Hello client",
                            "How are you",
                            "Hello XD",
                            "Let's get fun",
                            "Hi Oscar",
                            "Hi Team", 
                            "mmmm",
                            "XD yes!",
                            "Lets eat something @:p"};
        int idx = (int) (Math.random() * messages.length);
        String msg = messages[idx];
        System.out.println("Respond Message:"+ msg);
        
       return msg;
    }
    
    private static void writeToClient(String text,OutputStream outStream){
        PrintWriter writer = new PrintWriter(outStream);
        writer.println(text);
        writer.close();
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        ServerSocket srv = new ServerSocket(5000);
        
        while(true){
            System.out.println("Awaiting for a connection>");
            Socket client = srv.accept();            
                        
            System.out.println("\n Client IP:"+client.getInetAddress().toString());
            
            writeToClient(getRandomMsg(),client.getOutputStream());
                        
            client.close();
            System.out.println("\n");
        }
        
        }catch(IOException ex){
            System.out.println("Error:\n"+ex.getMessage());
        }
        
        
    }
    
}
