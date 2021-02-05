package TP2Ex2;

import java.lang.reflect.Array;
import java.util.*;

public class MultiColorPen extends Retractable {

	private ArrayList<Cart> allCarts = new ArrayList<>();

	public void changeCart(int pos) {
		if (!(this.cart == this.allCarts.get(pos)))
		this.cart = this.allCarts.get(pos);
		else
			System.err.println("La mine est déjà séléctionnée\n");
	}

}