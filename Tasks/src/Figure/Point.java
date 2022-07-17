/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figure;

import static Figure.Main.g2d;

/**
 *
 * @author Sham-Tze-Wah <shamtzewah@gmail.com>
 */
public class Point extends Shape implements ShapeInterface{
    /*Fields*/

    /*Constructor*/
    Point(double pointX, double pointY, double width, double height){
        super(pointX, pointY, width, height);
    }
    
    /*Getter and setter method*/

    /*Override method*/
    @Override
    public void move(double moveX, double moveY) {
        g2d.translate(moveX, moveY);
    }

    @Override
    public void rotate(double degree, double originX, double originY) {
        g2d.rotate(degree, originX, originY);
    }
    
     /*Object method*/

    
    
}
