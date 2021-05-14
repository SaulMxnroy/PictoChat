package main;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class RMIPictoChatServer extends UnicastRemoteObject implements ChatRoom {

    public RMIPictoChatServer() throws RemoteException {
        super();
    }
    
    @Override
    public void sendMessage (String messageText, String userName) throws RemoteException, RemoteException{
    	if (messageText.isEmpty())
    		messageText = ""; 
    	else
    	System.out.println(userName + ": " + messageText);
    }
    @Override
    public String getMessage(String text) throws RemoteException {
        return "You: " + text;
    }
    
    public static void main(String[] args){
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemoteServer", new RMIPictoChatServer());
            System.out.println("Welcome to the chat!");
            
        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }
    
}