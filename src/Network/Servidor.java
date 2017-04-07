package Network;

import Model.UsersManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edgarprieto on 3/4/17.
 */
public class Servidor extends Thread {
    private static final int PORT = 11111;

    private final UsersManager Model;
    private ServerSocket serverSocket;
    private final List<DedicatedServer> dedicatedServers;
    public boolean running;

    public Servidor (UsersManager Model){
        this.Model = Model;
        dedicatedServers = new ArrayList<>();
    }

    public void startServer() throws IOException{
        serverSocket = new ServerSocket(PORT);
        running = true;
        start();
    }

    public void stopServer() {
        running = false;
        for (DedicatedServer d : dedicatedServers){
            d.stopRunning;
        }
    }

    public void run() {
        while (running)
            try {
            Socket socket = serverSocket.accept();
            DedicatedServer dServer = new DedicatedServer(socket, dedicatedServers, Model);
            dedicatedServers.add(dServer);
            dServer.start();
            } catch (IOException e){
            e.printStackTrace();
            }
    }


}
