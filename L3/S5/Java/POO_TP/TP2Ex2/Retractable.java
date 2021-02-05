package TP2Ex2;

import java.awt.*;

public class Retractable extends Pen {

	private Boolean lead;

	public Boolean getLead() {
		return this.lead;
	}

	public Retractable()
	{
		super();
	}


	public Retractable(Color color) {
		super(color);
	}

	public void leadIn() {
		if (isLeadOut())
			this.lead = false;
		else
			System.out.println("La mine est déjà rentrée");
	}

	public void leadOut() {
		if (isLeadOut())
			System.out.println("La mine est déjà sortie");
		else
			this.lead = true;
	}


	public void write(String str) {
		if (!isLeadOut())
			System.err.println("La mine est rentrée");
		else
			super.write(str);
	}

	public Boolean isLeadOut() {
		return this.lead;
	}

}