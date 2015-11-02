import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes. Edited by Chris Boardman
 * @version 2015.11.12
 */

public class BallDemo  
{
    private Canvas myCanvas;               //To create a canvas object
    private final int width = 600;         // To set width of the initial box
    private final int height = 500;        // To set hieght of the initial box

    

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

     /**
     * The boxBounce method creates a box using methods of the Canvas class to create a box using
     * the offset value given. It then populates the box with the number of balls the user enters.
     * @param balls The number of balls in the box
     * @param off The offset of the box's boundaries.
     */
    public void boxBounce(int balls, int off)
    {
        myCanvas.erase(); //Reset the canvas
        myCanvas.setVisible(true); //Show the canvas
        final int offset=off;
        int maxX= width-offset;
        int maxY= height-offset; //Set va;ies for the box.
        
        myCanvas= new Canvas("BoxBallDemo", width, height);
        
        BoxBall[] test = new BoxBall[balls]; //Create array
        for (int i=0; i<test.length; i++) //Populate array with balls
        {
            test[i] = new BoxBall(maxX, maxY, offset, myCanvas );
        }
        
        int tick=0;
        while(tick<200) //Use tick for a value in a while loop to move the balls.
        {
            myCanvas.wait(30); 
               
            myCanvas.drawLine(offset, offset, maxX, offset); //Draw wall boundaries  
            myCanvas.drawLine(offset, maxY, maxX, maxY);     
            myCanvas.drawLine(maxX, offset, maxX, maxY);   
            myCanvas.drawLine(offset, offset, offset, maxY);   
        
        
            for (int i=0; i< test.length; i++)
            {
                test[i].move(); //Draw the balls on a cycle 
            }
            tick++;
        }
        }
    }
