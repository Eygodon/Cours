package Ex2;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

public class SliderBetter extends HBox {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Label l;
    private TextField tfValue;
    private Slider slider;

    /******************* CONSTRUCTORS *******************/
    public SliderBetter(String sLabel, double min, double max, double value){
        super();
        this.l = new Label(sLabel);
        this.slider = new Slider(min, max, value);
        this.tfValue = new TextField("");


        Bindings.bindBidirectional(
                this.tfValue.textProperty(),
                this.slider.valueProperty(),
                new NumberStringConverter()
        );

        this.getChildren().addAll(l, slider, tfValue);
    }

    /********************* GETTERS **********************/
    public double getMin (){
        return this.slider.getMin();
    }

    public double getMax(){
        return this.slider.getMax();
    }

    public double getValue(){
        return this.slider.getValue();
    }

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    DoubleProperty valueProp (){
        return this.slider.valueProperty();
    }
}
