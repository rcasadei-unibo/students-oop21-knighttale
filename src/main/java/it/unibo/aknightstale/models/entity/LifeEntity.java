package it.unibo.aknightstale.models.entity;

public interface LifeEntity {
    /**
     * Sets the entity health.
     * 
     * @param health the new entity health.
     */
    void setHealth(double health);

    /**
     * Gets the entity health.
     * 
     * @return the entity health.
     */
    double getHealth();

    /**
     * Checks if the entity is died or not.
     * 
     * @return true if it's died, false if it's alive.
     */
    boolean isDead();
}
