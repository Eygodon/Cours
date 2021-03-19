package FirstSteps;

/**
 * This class only represents a double value
 * This is useful to declare values in FXML files, inside <fx:define> tags
 * @author xaviator
 */
public class Scalar1D {
    /*------------------------ Private members --------------------------------*/

    /** Field used in FXML file to represent a numeric value */
    double value1;

    /*------------------------ Public methods ---------------------------------*/

    /**
     * Constructor
     */
    public Scalar1D() {
    }

    //@{

    /** Getters / Setters (required to be accessed in FXML files)
     */
    public double getValue1() {
        return this.value1;
    }
    public void setValue1(double value1) {
        this.value1 = value1;
    }
}
