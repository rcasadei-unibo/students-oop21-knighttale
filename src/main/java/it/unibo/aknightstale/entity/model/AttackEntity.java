package it.unibo.aknightstale.entity.model;

public interface AttackEntity {
    double getDamage();

    void setDamage(double dmg);

    double getAttackRange();

    void attack(LifeEntity e);
}
