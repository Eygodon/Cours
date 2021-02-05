package TP2Ex1;

public abstract class DoorWithLock extends Door implements Lockable {

	protected Boolean isLock;

	public DoorWithLock()
	{
		this.isLock = true;
		this.isOpen = true;
	}

	public void lockSwitch() {
		if (this.isLock)
			this.isLock = false;
		else
			this.isLock = true;
	}

	public void open() {

		if (!(this.isLock))
			super.open();
		else
			System.out.println("UNLOCK THE DOOR BEFORE OPENING\n");
	}

	public void close()
	{
		this.isLock = true;
		this.isOpen = true;
	}

	public boolean isLocked()
	{
		return this.isLock;
	}
}