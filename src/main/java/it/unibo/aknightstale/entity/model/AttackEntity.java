package it.unibo.aknightstale.entity.model;

public interface AttackEntity {

	/**
	 * Get entity's damage
	 * 
	 * @return The entity's damage
	 */
	double getDamage();

	/**
	 * Set entity's damage
	 * @param dmg	The new entity's damage
	 */
    void setDamage(double dmg);

    /**
     * Get entity's range of attack
     * 
     * @return	The range of attack
     */
    double getAttackRange();

    /**
     * Entity attacks other entities that are in the range of attack
     */
    void attack();
}
