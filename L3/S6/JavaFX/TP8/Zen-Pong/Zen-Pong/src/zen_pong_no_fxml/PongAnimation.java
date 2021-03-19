package zen_pong_no_fxml;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


/**
 * ZenPong example - Pong Animation
 * Adapted from "Pro JavaFX 8"
 *
 * @author xskapin
 */

public class PongAnimation {

    /*----------------------- Private members --------------------------------*/
    
    /** Animation */
    Timeline timeline;

    /** Container of elements used in the animation */
    private PongComponents pongComponents;

    //@{
    /** Controls whether the ball is moving right or down */
    private boolean movingRight = true;
    private boolean movingDown = true;
    //@}
    

    /*----------------------- Public methods --------------------------------*/
    
    /**
     * Constructor
     * @param pongComponents Contains the elements used to define this animation
     */
    public PongAnimation(PongComponents pongComponents) {
	this.pongComponents = pongComponents;

	double duration = 10.0; // ms
	Circle ball = this.pongComponents.getBall();

	this.timeline = new Timeline(new KeyFrame(new Duration(duration), t -> {
		    // onFinished() code
		    checkForCollision();
		    
		    // compute the displacement in pixels between 2 time intervals.
		    int horzPixels = this.movingRight ? 1 : -1;
		    int vertPixels = this.movingDown ? 1 : -1;
		    ball.centerXProperty().setValue(ball.centerXProperty().getValue() + horzPixels);
		    ball.centerYProperty().setValue(ball.centerYProperty().getValue() + vertPixels);
	}));
	this.timeline.setCycleCount(Timeline.INDEFINITE);
    }


    //@{
    /** Getters / Setters */
    
    public Timeline getTimeline() {
	return this.timeline;
    }
    
    //@}


    /*----------------------- Private methods --------------------------------*/
 
    /**
     * Checks whether the ball has collided with either the paddles,
     * topWall, or bottomWall. If the ball hits the wall behind the paddles,
     * the game is over.
     */
    
    private void checkForCollision() {
	Circle ball = this.pongComponents.getBall();

	Rectangle bottomWall = this.pongComponents.getBottomWall();
	Rectangle leftWall   = this.pongComponents.getLeftWall();
	Rectangle rightWall  = this.pongComponents.getRightWall();
	Rectangle topWall    = this.pongComponents.getTopWall();

	Rectangle leftPaddle  = this.pongComponents.getLeftPaddle();
	Rectangle rightPaddle = this.pongComponents.getRightPaddle();

	// 1. End of game if either left wall or right wall are hit
        // The intersects() methods tests whether the node shape (here, a circle)
        // touches the bounding box of another node.
        // The getBoundsInLocal() method returns the rectangular bounds of a
        // Node in the node's untransformed local coordinate space
        if (ball.intersects(rightWall.getBoundsInLocal())
            || ball.intersects(leftWall.getBoundsInLocal())) {

            this.timeline.stop();
            this.pongComponents.reset();
        }

        // 2. The ball movement goes in the opposite direction if the ball hits 
        // either the top wall or the bottom wall 
        else if (ball.intersects(bottomWall.getBoundsInLocal())
            || ball.intersects(topWall.getBoundsInLocal())) {

            this.movingDown = ! this.movingDown;
        }
        // 3. If the ball touches one paddle, it "bounces" over
        // and moves in the opposite direction
        // The getBoundsInParent() method returns the rectangular bounds of a 
        // node which include its transforms
        else if (ball.intersects(leftPaddle.getBoundsInParent())
            && ! this.movingRight) {
            this.movingRight = ! this.movingRight;
        }
        else if (ball.intersects(rightPaddle.getBoundsInParent())
            && this.movingRight) {
            this.movingRight = ! this.movingRight;
        }        
    }
}
