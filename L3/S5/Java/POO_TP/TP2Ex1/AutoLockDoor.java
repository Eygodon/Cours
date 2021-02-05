package TP2Ex1;

public class AutoLockDoor extends DoorWithLock {

	public void close() {
		this.isOpen = false;
		this.isLock = true;
	}

}