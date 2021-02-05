package TP2Ex1;

public class SecretCodeDoor extends DoorWithLock {

	private int code;

	public void SecretCodeDoor(int code) {
		this.code = code;
		this.isLock = true;
	}
	public void open(int code) {
		if (code == this.code)
			this.open();
		else
			System.out.println("CODE WRONG\n");
	}





}