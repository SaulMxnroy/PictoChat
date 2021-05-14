package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	
	Scanner input = new Scanner(System.in);
	
    public static void main(String[] arg){
        Client client = new Client();
        client.connectServer();
        
    }
    
    public void sendMessage (String messageText, String userName) throws RemoteException, RemoteException{
    	if (messageText.isEmpty())
    		messageText = ""; 
    	else
    	System.out.println(userName + ": " + messageText);
    }

    private void connectServer() {
        try {
        	
            String textBody = " has joined the chat!", name;

            Registry registro = LocateRegistry.getRegistry("localhost", 7777);
            ChatRoom interfaz = (ChatRoom) registro.lookup("RemoteServer");
            System.out.print("Please, enter your name: ");
            name = input.next();
            do {
            	
            	textBody = input.nextLine();
                interfaz.sendMessage(textBody, name);	
                System.out.println(interfaz.getMessage(textBody));
            } while (!textBody.equals("END"));
   
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}