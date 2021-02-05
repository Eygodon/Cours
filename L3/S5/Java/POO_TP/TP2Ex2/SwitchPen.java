package TP2Ex2;

import java.awt.*;

public class SwitchPen extends Pen {

	private static final Color DEFAULT_COLOR = Color.green;
	private int attribute;

	public SwitchPen() {
		super(SwitchPen.DEFAULT_COLOR);
	}



	public void write(String str, char oldChar, char newChar) {
		char[] charArr = str.toCharArray();
		for (int i = 0; i < charArr.length; i++)
		{
			if (charArr[i] == oldChar)
				charArr[i] = newChar;
		}
		str = String.valueOf(charArr);
		super.write(str);
	}


	public void write( String str) {
		this.write(str,'a', '*');
	}

}