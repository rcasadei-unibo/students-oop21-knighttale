package it.unibo.aknightstale.entity.model;

public interface LifeEntity {

	/**
	 * Set entity's health
	 * 
	 * @param health	The new entity's health
	 */
	void setHealth(double health);

	/**
	 * Get entity's health
	 * 
	 * @return	The entity's health
	 */
    double getHealth();

    /**
     * Check if entity is alive or dead
     * 
     * @return	True if entity is dead, false if he's alive
     */
    boolean isDead();
}
