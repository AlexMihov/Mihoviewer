/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

import java.awt.Point;

/**
 * Class which represents a command given by the PC which is controlling
 * @author Alex Mihov
 */

public class RemoteCommand {
    private final String command;
    private final Point position;
    /**
     * The constructor takes two arguments which can't be changed afterwards
     * @param command   what action is to be done
     * @param position  what is the position on the screen where the command should be executed.
     */
    public RemoteCommand(String command, Point position){
        this.command = command;
        this.position = position;
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @return the position
     */
    public Point getPosition() {
        return position;
    }
}
