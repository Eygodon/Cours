package zen_pong_no_fxml;

import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.shape.Rectangle;

/**
 * ZenPong example
 * Adapted from "Pro JavaFX 8"
 *
 * @author xskapin
 */
public class Paddle extends Rectangle {

    /*----------------------- Private members -------------------------------*/

    //@{
    /** The Paddle can be dragged using the mouse, we need 
     to remember the previous position and compute the new one. */
    private double initTranslateY;
    private double dragAnchorY;
    //@}

    //@{
    /** Bounds for moving the paddle */
    private double minLimit, maxLimit;
    //@}
    /*----------------------- Public methods --------------------------------*/

    /**
     * Constructor
     * @param posX top-left position of the Paddle on the X axis
     * @param posY top-left position of the Paddle on the Y axis
     * @param minLimit Minimum limit for the Paddle position on the Y axis 
     * @param maxLimit Maximum limit for the Paddle position on the Y axis 
     */
    public Paddle(double posX, double posY,
		  double minLimit, double maxLimit) {
	// width = 10.0, height = 30.0
	super(posX, posY, 10.0, 30.0);

	this.minLimit = minLimit;
	this.maxLimit = maxLimit;
	setFill(Color.BLUE);
	setCursor(Cursor.HAND);

	initMouseEvents();
    }

    
    /*----------------------- Private methods -------------------------------*/

    /**
     * Manage the Paddle's moves, depending on mouse dragging
     * @see Paddle()
     */
    private void initMouseEvents() {
	setOnMousePressed(me -> {
		this.initTranslateY = getTranslateY();
		this.dragAnchorY = me.getSceneY();
        });

        setOnMouseDragged(me -> {
		double dragY = me.getSceneY() - this.dragAnchorY;

		// Stop the paddle if it hits either bottom or top wall
		double distanceFromCenter = getY() + translateYProperty().getValue() + dragY;
		
		if (((distanceFromCenter + getHeight())  < this.maxLimit)
		    && (distanceFromCenter  > this.minLimit)) {
		    translateYProperty().setValue(this.initTranslateY + dragY);
		}
	    });
    }
}
