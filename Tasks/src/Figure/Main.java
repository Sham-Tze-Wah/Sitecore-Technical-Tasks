/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Figure;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sham-Tze-Wah <shamtzewah@gmail.com>
 */
public class Main extends JFrame{    //draw point
    /*Fields*/
    static JFrame f;    
    CustomPaintComponent p;
    Container c;
    static JLabel lblPoint, lblLine, lblCircle;  
    static Graphics2D g2d;
    JPanel aggregationPane;
    
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    int screenSizeX = size.width;
    int screenSizeY = size.height;
    
     int pointAmount;
     int lineAmount;
     int circleAmount;
     
     static Aggregation geometricList;
    
    static double translateX = 0;
    static double translateY = 0;
    static double degree = 0;
    
    final int panelX = 150;
    final int panelY = 150;
    final static double translateValue = 50; //50 pixels
    final static double rotateValue = 0.5; //in radian
    
    /*Constructor*/
    public Main(){
        
        //create new frame (window)
        f = new JFrame();    
        
        // sets close behavior; EXIT_ON_CLOSE invokes System.exit(0) on closing the JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // get the content area of Panel.    
        c = f.getContentPane();
        
        //assign the geometry into the aggregation list
        initAggregation();
        
        //get the draw geometry panel
        p = new CustomPaintComponent();
        Dimension drawShapePanel = new Dimension(screenSizeX - panelX, screenSizeY - panelY);
        p.setPreferredSize(drawShapePanel);
        p.setMinimumSize(drawShapePanel);
        p.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        
        // add draw geometry panel into container    
        c.add(p,BorderLayout.PAGE_START);
        c.add(p,BorderLayout.PAGE_END);
        
        //pack all the content in the frame so that it is at or above preferred size
        f.pack();
        f.setVisible(true);
    }
    
    /*methods*/
    public static void main(String[] args) {

         //initialise timer and UI
         Main main = new Main();
    }
    
    private void initAggregation(){
        randomGenerateNumber();
        addGeometryIntoList();
        displayAggregationDetails();
    }
    
    private void displayAggregationDetails(){ 
        //create a jpanel to group them
        aggregationPane = new JPanel();
        
        //style the panel
        aggregationPane.setPreferredSize(new Dimension(panelX, panelY));
        aggregationPane.setMinimumSize(new Dimension(panelX, panelY));
        aggregationPane.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        aggregationPane.setLayout(new BoxLayout(aggregationPane, BoxLayout.Y_AXIS));
        
        //create JLabel to check the number of point, line and circle
         lblPoint = new JLabel("Number of point: "+pointAmount);
         //lblPoint.setBounds(50,500,200,30);
         lblPoint.setAlignmentX(LEFT_ALIGNMENT);
         lblLine = new JLabel("Number of line: " + lineAmount);
         //lblLine.setBounds(50,550, 200, 30);
         lblLine.setAlignmentX(LEFT_ALIGNMENT);
         lblCircle = new JLabel("Number of circle: " + circleAmount);
         //lblCircle.setBounds(50, 600, 200, 30);
         lblCircle.setAlignmentX(LEFT_ALIGNMENT);
         
        //assign the label into the jpanel
         aggregationPane.add(lblPoint);
         aggregationPane.add(lblLine);
         aggregationPane.add(lblCircle);
         
         aggregationPane.setAlignmentX(LEFT_ALIGNMENT);
         
         //add the jpanel into the master frame
         c.add(aggregationPane);
    }
    
    private void addGeometryIntoList(){
        Point point;
        Line line;
        Circle circle;
        double posX;
        double posY;
        
        geometricList = new Aggregation();
        //assign the point, line and circle into aggregation
        for(int i=0; i<pointAmount; i++){
            posX = Math.random() * ((screenSizeX - panelX) - panelX + 1) +panelX;
            posY = Math.random() * ((screenSizeY - panelY) - panelY + 1) +panelY;
            point = new Point(posX, posY, 5,5);
            geometricList.setGeometric(point);
        }

        for(int i=0; i<lineAmount; i++){
            posX = Math.random() * ((screenSizeX - panelX) - panelX + 1) +panelX;
            posY = Math.random() * ((screenSizeY - panelY) - panelY + 1) +panelY;
            line = new Line(posX, posY, 200, 200);
            geometricList.setGeometric(line);
         }

        for(int i=0; i<circleAmount; i++){
            posX = Math.random() * ((screenSizeX - panelX) - panelX + 1) +panelX;
            posY = Math.random() * ((screenSizeY - panelY) - panelY + 1) +panelY;
            circle = new Circle(posX, posY, 200, 200);
            geometricList.setGeometric(circle);
        }
    }
    
    private void randomGenerateNumber(){
        //random generate a number
        Random rndm = new Random();
        
        //assign random number into respective var
        pointAmount = rndm.nextInt(5);
        lineAmount = rndm.nextInt(5);
        circleAmount = rndm.nextInt(5);
    }
    
    
    
   static class CustomPaintComponent extends JPanel implements KeyListener {

       /*Fields*/
       
       /*Constructor*/
       CustomPaintComponent(){
            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addKeyListener(this);
       }
       
       /*method*/
        @Override
        protected void paintComponent(Graphics g) {
            
            super.paintComponent(g);    
            g2d = (Graphics2D)g;
             
            //get the origin before transformation
            AffineTransform origin = g2d.getTransform();
            
             //set colour for the geometry
             g2d.setColor(Color.blue);

             //translate the geometry (all)
            geometricList.move(translateX, translateY);
            
            //rotate the geometry (all)
            g2d.rotate(degree, 0, 0);
            
            //draw the geometry
            drawShape();
        }   
        
        void drawShape(){
            //create a container to store geometry
            List<Object> list = new ArrayList<>();
            
            //assign the geometry to the container
            list = geometricList.getGeometric();
            
             //draw the geometry
            list.forEach((shape) -> {
                if(shape instanceof Point){
                    //g2d.setPaint(Color.blue);
                    g2d.fillRect((int)((Point) shape).getPointX(), (int)((Point) shape).getPointY(), (int)((Point) shape).getHeight(), (int)((Point) shape).getWidth());
                    g2d.drawRect((int)((Point) shape).getPointX(), (int)((Point) shape).getPointY(), (int)((Point) shape).getHeight(), (int)((Point) shape).getWidth());
                    //g2d.drawOval((int)((Point) shape).getPointX(), (int)((Point) shape).getPointY(), (int)((Point) shape).getHeight(), (int)((Point) shape).getWidth());
                }
                else if(shape instanceof Line){
                    g2d.drawLine((int)((Line) shape).getPointX(),(int)((Line) shape).getPointY(), (int)((Line) shape).getHeight(), (int)((Line) shape).getWidth());
                }
                else if(shape instanceof Circle){
                    g2d.drawOval((int)((Circle) shape).getPointX(), (int)((Circle) shape).getPointY(), (int)((Circle) shape).getHeight(), (int)((Circle) shape).getWidth());
                }
            });
        }

        @Override
        public void keyTyped(KeyEvent ke) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                //press 'up arrow' key to move upwards
                case KeyEvent.VK_UP:
                    translateY = translateY - translateValue;
                    f.repaint();
                    break;
                //press 'down arrow' key to move downwards
                case KeyEvent.VK_DOWN:
                     translateY = translateY + translateValue;
                     f.repaint();
                    break;
                //press 'left arrow' key to move left
                case KeyEvent.VK_LEFT:
                    translateX = translateX - translateValue;
                    f.repaint();
                    break;
                 //press 'right arrow' key to move right
                case KeyEvent.VK_RIGHT:
                    translateX = translateX + translateValue;
                    f.repaint();
                    break;
                 //press 'E' key to move clockwise
                case KeyEvent.VK_E:
                    degree = degree + rotateValue;
                    f.repaint();
                    break;
                //press 'Q' key to move anti-clockwise
                case KeyEvent.VK_Q:
                    degree = degree - rotateValue;
                    f.repaint();
                    break;
                //return to the original position
                case KeyEvent.VK_SPACE:
                    translateX = 0;
                    translateY = 0;
                    degree = 0;
                    f.repaint();
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            
        }

    }
}

