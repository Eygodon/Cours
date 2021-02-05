package TP2Ex1;

import  java.util.List;

public class Door {

	protected Boolean isOpen;

	public Door ()
	{
		this.isOpen = false;
	}

	public void open()
	{
		this.isOpen = true;
	}

	public void close()
	{
		this.isOpen = false;
	}

	public boolean getStatus()
	{
		return this.isOpen;
	}

	@Override
	public String toString()
	{
		return String.format("%s - isOpen : %b", this.getClass().getSimpleName(), this.getStatus());
	}

	public void openSwitch() {
		// TODO - implement Door.openSwitch
		throw new UnsupportedOperationException();
	}
}