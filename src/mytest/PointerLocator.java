/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

import java.awt.MouseInfo;
import java.awt.Point;

/**
 *
 * @author alex
 */
public class PointerLocator {
    private Point location;
    
    public Point getLocation(){
        return MouseInfo.getPointerInfo().getLocation();
    }
    
}
