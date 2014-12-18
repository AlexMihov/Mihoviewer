/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

import java.util.List;
import java.awt.Point;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                objectStream = new ObjectOutputStream(server.getOutputStream());

                List<Point> points = new ArrayList<>();
                System.out.println("Get ready to record!");
                Thread.sleep(5000);
                System.out.println("Recording...");
                for (int j = 0; j < 10000; j++) {
                    PointerLocator pointerLocator = new PointerLocator();
                    points.add(pointerLocator.getLocation());
                    Thread.sleep(10);
                }
                System.out.println("Done recording");
                Thread.sleep(1000);
                System.out.println("Sending recording...");
                for (int i = 0; i < 10000; i++) {
                    objectStream.writeObject(points.get(i));
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
