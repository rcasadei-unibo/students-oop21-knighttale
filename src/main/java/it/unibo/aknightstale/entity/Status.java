package it.unibo.aknightstale.entity;

public enum Status {
	
	IDLE, WALK, ATTACK;
	
	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
	
}
