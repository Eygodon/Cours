package TP2Ex2;

import java.awt.*;

public class SingleUse extends Pen {


	public SingleUse(Color color) {
		super(color);
	}

	public void changeCart(Cart cart) {
		super.changeCart(null);
	}

}