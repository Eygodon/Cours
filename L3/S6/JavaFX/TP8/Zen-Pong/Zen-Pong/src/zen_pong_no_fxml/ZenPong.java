package zen_pong_no_fxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * ZenPong example
 * Adapted from "Pro JavaFX 8"
 *
 * @author xskapin
 */
public class ZenPong extends Application {

    /*----------------------- Private members --------------------------------*/

    /** Game field */
    private PongComponents pongComponents;

    /** Ball animation */
    private PongAnimation pongAnimation;

    //@{
    /** Controls whether the ball is moving right or down */
    private boolean movingRight = true;
    private boolean movingDown = true;
    //@}


    /*----------------------- Public methods --------------------------------*/

    @Override
    public void start(Stage primaryStage) {
        this.pongComponents = new PongComponents();
	this.pongAnimation = new PongAnimation(this.pongComponents);
 	initGame();
    
	double width = 500.0;
	double height = 500.0;
        Scene scene = new Scene(this.pongComponents, width, height);
        scene.setFill(Color.LIGHTGRAY);        
        
        primaryStage.setTitle("ZenPong");
        primaryStage.setScene(scene);        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    


    /*----------------------- Private methods --------------------------------*/
  
     /**
     * Initialize game
     * @see start()
     */
    private void initGame() {
	Button startButton = this.pongComponents.getStartButton();
        
        startButton.setOnAction(e -> {
		startButton.visibleProperty().setValue(false);	
		this.pongAnimation.getTimeline().playFromStart();
		this.pongComponents.requestFocus();
	    });
    } 
}
