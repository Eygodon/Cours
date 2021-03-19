package zen_pong_no_fxml;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * ZenPong example
 * Adapted from "Pro JavaFX 8"
 *
 * @author xskapin
 */
public class PongComponents extends Group {
    /*----------------------- Private members --------------------------------*/
    
    /** The moving ball */
    private Circle ball;
 
    //@{
    /** Game paddles */
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    //@}

    //@{
    /** Paddles can be dragged using the mouse, we need members 
     to remember the previous position and compute the new one. */
     /** Initial translateY property for the left and right paddles */
    private double initLeftPaddleTranslateY;
    private double initRightPaddleTranslateY;
    private double leftPaddleDragAnchorY;
    private double rightPaddleDragAnchorY;
    //@}
    
    //@{
    /** Walls enclosing the game **/
    private Rectangle bottomWall;
    private Rectangle leftWall;
    private Rectangle rightWall;
    private Rectangle topWall;
    //@}

    /** Button to (re)start the game */
    private Button startButton;


    /*----------------------- Public methods --------------------------------*/

    /**
     * Constructor
     */
    public PongComponents() {
	super();

	initBall();
	initWalls();
	initPaddles();
	initStartButton();
	
	getChildren().addAll(this.ball, this.topWall, this.leftWall, this.rightWall,
			     this.bottomWall, this.leftPaddle, this.rightPaddle,
			     this.startButton);

	// Specifies whether this Node should be a part of focus traversal cycle.
        setFocusTraversable(true);

	initKeyEvents();
	requestFocus();
    }

    //@{
    /** Getters / Setters */

    public Circle getBall() {
	return this.ball;
    }

    public Rectangle getBottomWall() {
	return this.bottomWall;
    }
    public Rectangle getLeftWall() {
	return this.leftWall;
    }
    public Rectangle getRightWall() {
	return this.rightWall;
    }
    public Rectangle getTopWall() {
	return this.topWall;
    }

    public Rectangle getLeftPaddle() {
	return this.leftPaddle;
    }
    public Rectangle getRightPaddle() {
	return this.rightPaddle;
    }

    public Button getStartButton() {
	return this.startButton;
    }
    //@}


    /**
     * Reset components location
     */
    public void reset() {
	double centerX = 250.0, centerY = 250.0;
	double paddleY = 0.0;
	
	this.ball.centerXProperty().setValue(centerX);
	this.ball.centerYProperty().setValue(centerY);

	this.leftPaddle.translateYProperty().setValue(paddleY);
	this.rightPaddle.translateYProperty().setValue(paddleY);

	this.startButton.visibleProperty().setValue(true);

	requestFocus();
    }
    

    /*----------------------- Private methods --------------------------------*/

    /**
     * Initialize ball's parameters
     */
    private void initBall() {
	double centerX = 250.0, centerY = 250.0;
	double radius = 10.0;

	this.ball = new Circle(centerX, centerY, radius, Color.RED);
    }

    /**
     * Associate events with keyboard
     * @see PongComponents()
     */
    private void initKeyEvents() {
	double step = 6.0;

        setOnKeyPressed(k -> {
		switch(k.getCode()) {
		case UP:
		    movePaddle(this.rightPaddle, this.topWall, -1.0*step);
		    break;

		case DOWN:
		    movePaddle(this.rightPaddle, this.bottomWall, step);
		    break;

		case A:
		    movePaddle(this.leftPaddle, this.topWall, -1.0*step);
		    break;

		case Q:
		    movePaddle(this.leftPaddle, this.bottomWall, step);
		    break;

		default:
		    break;
		}
	    });
    }

    /**
     * Moves a Paddle alog the Y axis until unless it hits a wall
     * @param paddle Paddle to translate
     * @param wall Wall for testing collision
     * @param step paddle's displacement
     * @see initKeyEvents()
     */
    private void movePaddle(Paddle paddle,
			    Rectangle wall,
			    double step) {
	if (! paddle.getBoundsInParent().intersects(wall.getBoundsInLocal())) {
	    paddle.translateYProperty().setValue(paddle.translateYProperty().getValue() + step);
	}
    }


    /**
     * Initialize paddles parameters
     * @see PongComponents()
     */
    private void initPaddles() {
	double xPos = 20.0, yPos = 235.0;

	this.leftPaddle = new Paddle(xPos, yPos,
				     this.topWall.getY(), this.bottomWall.getY() );

	xPos = 470.0; 
	this.rightPaddle = new Paddle(xPos, yPos,
				     this.topWall.getY(), this.bottomWall.getY() );

    }


    /**
     * Initialize startButton parameters
     * @see PongComponents()
     */
    private void initStartButton() {
	double xPos = 225.0;
	double yPos = 470.0;

	this.startButton = new Button("Start");
	this.startButton.setLayoutX(xPos);
        this.startButton.setLayoutY(yPos);
    }


    /**
     * Initialize walls parameters
     * @see PongComponents()
     */
    private void initWalls() {
	double coord1 = 0;
	double coord2 = 500;
	double size1 = 500;
	double size2 = 1;

	// Parameters: X position, Y position, width, height
        this.bottomWall = new Rectangle(coord1, coord2, size1, size2);
        this.leftWall   = new Rectangle(coord1, coord1, size2, size1);
        this.rightWall  = new Rectangle(coord2, coord1, size2, size1);
	this.topWall    = new Rectangle(coord1, coord1, size1, size2);
    }
}
