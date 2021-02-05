package TP2Ex2;

import java.awt.*;

public class Cart {

	private Color color;
	private int level;

	public Cart()
	{
		this.level = 100;
		this.color = Color.BLACK;
	}

	public Cart(Color color, int n) {
		this.color = color;
		this.level = 100;
	}


	public void use() {
		this.level-= 1;
	}

	public Color getColor() {
		return this.color;
	}

	public Boolean isEmpty() {
		if (this.level == 0)
			return true;
		else
			return false;
	}

	@Override
	public String toString()
	{
		return String.format("%s - Ink level : %d", this.color.toString(), this.level);
	}
}