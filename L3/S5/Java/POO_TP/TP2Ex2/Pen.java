package TP2Ex2;

import java.awt.*;

public class Pen {

	protected Cart cart;
	public Pen()
	{
		this.cart = new Cart();
	}


	public Pen(Color color) {
		this.cart = new Cart(color, 100);
	}


	public void write(String str) {
		if (this.cart.isEmpty())
		{
			System.err.println("Cartouche vide\n");
		}
		System.out.println(str);
		this.cart.use();
	}


	public void changeCart(Cart cart) {
		this.cart = cart;
	}

	public Cart getCart() {
		return this.cart;
	}

	@Override
	public String toString()
	{
		return String.format("%s - %s", this.getClass().getSimpleName(), this.cart.toString());
	}

	public void print()
	{
		System.out.println(this.toString());
	}

}