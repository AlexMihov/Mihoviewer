/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class MyTest {

    /**
     * @param args the command line arguments
     * @throws java.awt.AWTException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws AWTException, InterruptedException {
        Socket client = null;
        RemoteCommand remoteCommand = new RemoteCommand("move", new Point(0,0));
        PointerController pointerController = new PointerController();
                  
        try {
            String serverName = "localhost";
            int port = 10101;

            System.out.println("Connecting to " + serverName + " on port " + port);

            client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());

            InputStream inFromServer = client.getInputStream();
            ObjectInputStream objectStream = new ObjectInputStream(inFromServer);

            while (true) {
                remoteCommand = (RemoteCommand)objectStream.readObject();
                if(remoteCommand != null){
                    Point currentPosition = remoteCommand.getPosition();
                    switch(remoteCommand.getCommand()){
                        case "move":
                            pointerController.setCurrentPosition(currentPosition);
                            pointerController.movePointer();
                            break;
                        case "clickLeft":
                            pointerController.setCurrentPosition(currentPosition);
                            pointerController.movePointer();
                            pointerController.clickLeft();
                            break;
                        case "clickRight":
                            pointerController.setCurrentPosition(currentPosition);
                            pointerController.movePointer();
                            pointerController.clickRight();
                            break;
                        case "clickMiddle":
                            pointerController.setCurrentPosition(currentPosition);
                            pointerController.movePointer();
                            pointerController.clickMiddle();
                            break;
                        default:
                            break;
                        }
                }else{
                    System.out.println("I fucked up");
                    return;
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MyTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MyTest.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                client.close();
            } catch (IOException ex) {
                Logger.getLogger(MyTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
