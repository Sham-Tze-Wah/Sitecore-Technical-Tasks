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
public class Aggregation<T> implements GeometryInterface{
    
    /*Fields*/
    private List<GeometryInterface> geometricList;
    
    /*Constructor*/
    Aggregation(){
        geometricList = new ArrayList<>();
    }
    
    /*Getter and setter method*/

    public List<GeometryInterface> getGeometric() {
        return geometricList;
    }

    public void setGeometric(GeometryInterface geometric) {
       geometricList.add(geometric);
    }
    

    /*Override method*/
    @Override
    public void move(double moveX, double moveY) {
         geometricList.forEach((geometry) -> {
                geometry.move(moveX, moveY);
            });
         
    }

    @Override
    public void rotate(double degree, double originX, double originY) {
        geometricList.forEach((geometry) -> {
                geometry.rotate(degree, originX, originY);
            });
    }
    
    @Override
    public void draw() {
        geometricList.forEach((geometry) -> {
            geometry.draw();
        });
    }
    
    /*Object method*/
}
