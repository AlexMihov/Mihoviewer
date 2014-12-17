/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;


/**
 *
 * @author alex
 */
public class PointerMover {
    private Point currentPosition = MouseInfo.getPointerInfo().getLocation();
    private final Robot ROBOT;
    
    PointerMover() throws AWTException{
        this.ROBOT = new Robot();
    }
    public void movePointer(Point newPosition){
        currentPosition = newPosition;
        ROBOT.mouseMove(currentPosition.x, currentPosition.y);
        
    }
}
