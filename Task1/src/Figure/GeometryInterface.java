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
public interface GeometryInterface {
        void move(double moveX, double moveY);
        void rotate(double degree, double originX, double originY);
        void draw();
}