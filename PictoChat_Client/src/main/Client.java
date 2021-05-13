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

    private void connectServer() {
        try {
        	
            String textBody = " has joined the chat!", name;

            Registry registro = LocateRegistry.getRegistry("localhost", 7777);
            ChatRoom interfaz = (ChatRoom) registro.lookup("RemoteServer");
            System.out.print("Please, enter your name: ");
            name = input.next();
            do {
            	textBody = input.nextLine();
                interfaz.retrieveMessage(textBody, name);	
            } while (!textBody.equals("END"));
   
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}