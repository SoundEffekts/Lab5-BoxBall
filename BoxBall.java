import java.awt.*;
import java.awt.geom.*;
import java.util.Random; //Import statements for the RNG/canvas inputs

/**
 * Class BouncingBall - a graphical ball that works in conjuction withh the BallDemo class to create a
 * simulation of balls bouncing around a user defined box. 
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Edited by Chris Boardman
 *
 * @version 2015.11.2
 */

public class BoxBall
{ 
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Canvas canvas;
    private int ySpeed ;
    private int xSpeed;
    private int maxX;
    private int maxY;
    private int offset;
    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPosition  the horizontal coordinate of the ball
     * @param yPosition  the vertical coordinate of the ball
     * @param diameter  the diameter (in pixels) of the ball
     * @param color  the color of the ball
     * @param canvas  the canvas to draw this ball on
     * @param ySpeed The Y speed of the ball.
     * @param xSpeed The X speed of the ball.
     * @param maxX The maximum pos that X can be in the box
     * @param maxY The maximum pos that X can be in the box
     * @param offset The offset value for the box.
    */
   
    public BoxBall(int max_X, int max_Y ,int off ,Canvas box)
    {
        maxX = max_X;      
        maxY = max_Y;
        off=offset;
        box = canvas;
        
        final int xSpeed=7;
        final int ySpeed=7;
        
        Random rand = new Random();
        
        xPosition = rand.nextInt(maxX);
        yPosition = rand.nextInt(maxY);
        color = new Color(0, 0, 0);
        diameter = rand.nextInt(15)+5;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     * 
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        erase();
        
        xPosition+=xSpeed;
        yPosition+=ySpeed; 
        
        if((xPosition)>(maxX-diameter))
            {   
               xPosition= maxX-diameter;
               xSpeed=-xSpeed;
            }
            
        if((yPosition)>(maxY-diameter))
            {   
               yPosition = maxY-diameter;
               ySpeed=-ySpeed;
            }
            
        if(xPosition < offset)
            {
                xPosition= (diameter + offset);
                xSpeed=-xSpeed;
            }
        
        if(yPosition < offset)
            {
                yPosition= (diameter + offset);
                ySpeed=-ySpeed;
            }
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     * @return xPosition
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     * @return yPosition
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
