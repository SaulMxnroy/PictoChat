package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoom extends Remote {
	public void retrieveMessage (String messageText, String userName) throws RemoteException, RemoteException;
}
