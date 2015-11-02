import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo  
{
    private Canvas myCanvas;
    private final int width = 600;
    private final int height = 500;

    

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    */
    
   
    public void boxBounce(int balls, int off)
    {
        myCanvas.erase(); 
        myCanvas.setVisible(true); //Show the canvas
        final int offset=off;
        int maxX= width-offset;
        int maxY= height-offset;
        
        myCanvas= new Canvas("BoxBallDemo", width, height);
        
        BoxBall[] test = new BoxBall[balls];
        for (int i=0; i<test.length; i++)
        {
            test[i] = new BoxBall(maxX, maxY, offset, myCanvas );
        }
        
        int tick=0;
        while(tick<200)
        {
            myCanvas.wait(30); 
            
            myCanvas.drawLine(offset, offset, maxX, offset);   //top boundary
            myCanvas.drawLine(offset, maxY, maxX, maxY);     //bottom boundary
            myCanvas.drawLine(maxX, offset, maxX, maxY);     //right boundary
            myCanvas.drawLine(offset, offset, offset, maxY);   //left boundary
        
        
            for (int i=0; i< test.length; i++)
            {
                test[i].move();
            }
        }
        }
    }
