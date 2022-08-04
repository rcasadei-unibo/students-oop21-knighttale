package it.unibo.aknightstale.models.entity;

public enum Direction {
    /**
     * Up direction.
     */
    UP,
    /**
     * Left direction.
     */
    LEFT,
    /**
     * Right direction.
     */
    RIGHT,
    /**
     * West direction.
     */
    DOWN;
    
    @Override
    public String toString() {
    	return this.name().toLowerCase();
    }
}
