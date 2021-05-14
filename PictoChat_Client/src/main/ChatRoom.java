package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoom extends Remote {
	public void sendMessage (String messageText, String userName) throws RemoteException, RemoteException;
	public String getMessage(String messageText) throws RemoteException, RemoteException;
}
