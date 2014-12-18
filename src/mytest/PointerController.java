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
import java.awt.event.InputEvent;


/**
 *
 * @author alex
 */
public class PointerController {
    private Point currentPosition;
    private final Robot ROBOT;
    
    PointerController() throws AWTException{
        this.ROBOT = new Robot();
    }
    public void movePointer(){
        ROBOT.mouseMove(currentPosition.x, currentPosition.y);     
    }
    public void clickLeft(){
        ROBOT.mousePress(InputEvent.BUTTON1_MASK);
        ROBOT.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    public void setCurrentPosition(Point newPosition){
        this.currentPosition = newPosition;
    }
}
