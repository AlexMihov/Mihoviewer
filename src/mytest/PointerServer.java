/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class PointerServer extends Thread {

    private final ServerSocket serverSocket;

    public PointerServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        //serverSocket.setSoTimeout();
    }

    @Override
    public void run() {
        while (true) {
            Socket server = null;
            ObjectOutputStream objectStream = null;
            PointerLocator pointerLocator = new PointerLocator();
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                objectStream = new ObjectOutputStream(server.getOutputStream());

                List<RemoteCommand> commands = new ArrayList<>();
                System.out.println("Get ready to record!");
                Thread.sleep(5000);
                System.out.println("Recording...");
                for (int j = 0; j < 100; j++) {
                    commands.add(new RemoteCommand("move", pointerLocator.getLocation()));
                    Thread.sleep(10);
                }
                commands.add(new RemoteCommand("clickRight", pointerLocator.getLocation()));
                System.out.println("Done recording");
                Thread.sleep(100);
                System.out.println("Sending recording...");
                for (int i = 0; i < commands.size(); i++) {
                    objectStream.writeObject(commands.get(i));
                    Thread.sleep(10);
                }
                objectStream.writeObject(null);
                objectStream.flush();

            } catch (Exception ex) {
                Logger.getLogger(MyTest.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    server.close();
                } catch (IOException ex) {
                    Logger.getLogger(PointerServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        int port = 10101;
        try {
            Thread t = new PointerServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
