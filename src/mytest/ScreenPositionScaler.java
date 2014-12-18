/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytest;

/**
 * This class is used to convert the positions on the screen, because the resolutions of the screens
 * can be different and that needs to be accounted for.
 * @author Alex Mihov
 */
public class ScreenPositionScaler {
    private final int sourceWidth;
    private final int sourceHeight;
    private final int destWidth;
    private final int destHeight;
    private final int conversionFactorHeight;
    private final int conversionFactorWidth;
/**
 * The class takes the width and height of the sourcemonitor and destinationmonitor
 * and calculates two conversionfactors for the height and width.
 * @param sourceWidth       width of the sourcemonitor
 * @param sourceHeight      height of the sourcemonitor
 * @param destWidth         width of the destinationmonitor
 * @param destHeight        height of the destinationmonitor
 */
    public ScreenPositionScaler(int sourceWidth, int sourceHeight, int destWidth, int destHeight) {
        this.sourceWidth = sourceWidth;
        this.sourceHeight = sourceHeight;
        this.destWidth = destWidth;
        this.destHeight = destHeight;
        this.conversionFactorHeight = sourceHeight/destHeight;
        this.conversionFactorWidth = sourceHeight/destWidth;
    }

    public int getSourceWidth() {
        return sourceWidth;
    }

    public int getSourceHeight() {
        return sourceHeight;
    }

    public int getDestWidth() {
        return destWidth;
    }

    public int getDestHeight() {
        return destHeight;
    }

    public int getConversionFactorHeight() {
        return conversionFactorHeight;
    }

    public int getConversionFactorWidth() {
        return conversionFactorWidth;
    }
    
}
