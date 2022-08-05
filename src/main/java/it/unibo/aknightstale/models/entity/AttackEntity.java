package it.unibo.aknightstale.models.entity;

public interface AttackEntity {
    double getDamage();

    void setDamage(double dmg);

    double getAttackRange();

    void attack(LifeEntity e);
}
