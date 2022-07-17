/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sham-Tze-Wah <shamtzewah@gmail.com>
 * @param <T>
 */
public class Aggregation<T> implements ShapeInterface{
    
    /*Fields*/
    private List<T> geometricList;
    
    /*Constructor*/
    Aggregation(){
        geometricList = new ArrayList<>();
    }
    
    /*Getter and setter method*/

    public List<T> getGeometric() {
        return geometricList;
    }

    public void setGeometric(T geometric) {
       geometricList.add(geometric);
    }
    

    /*Override method*/
    @Override
    public void move(double moveX, double moveY) {
         geometricList.forEach((shape) -> {
                if(shape instanceof Point){
                    ((Point) shape).move(moveX, moveY);
                }
                else if(shape instanceof Line){
                    ((Line) shape).move(moveX, moveY);
                }
                else if(shape instanceof Circle){
                    ((Circle) shape).move(moveX, moveY);
                }
            });
    }

    @Override
    public void rotate(double degree, double originX, double originY) {
        geometricList.forEach((shape) -> {
                if(shape instanceof Point){
                    ((Point) shape).rotate(degree, originX, originY);
                }
                else if(shape instanceof Line){
                    ((Line) shape).rotate(degree, originX, originY);

                }
                else if(shape instanceof Circle){
                    ((Circle) shape).rotate(degree, originX, originY);

                }
            });
    }
    
    /*Object method*/
    
}
