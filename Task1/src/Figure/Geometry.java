/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figure;

/**
 *
 * @author Sham-Tze-Wah <shamtzewah@gmail.com>
 */
public class Geometry{
    
    /*Fields*/
    protected double pointX; //starting point in x axis
    protected double pointY; //starting point in y axis
    protected double height; //height of the shape
    protected double width; //width of the shape
    
    /*Constructor*/
    
    Geometry(double pointX, double pointY, double height, double width){
        super();
        this.pointX = pointX;
        this.pointY = pointY;
        this.height = height;
        this.width = width;
    }
    
    Geometry(){
        
    }
    
    /*Setter and getter method*/

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    
    /*Override method*/
    
    /*Object method*/
}

