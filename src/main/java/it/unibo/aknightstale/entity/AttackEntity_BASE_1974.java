package it.unibo.aknightstale.entity;

public interface AttackEntity {
    double getDamage();

    void setDamage(double dmg);

    double getAttackRange();

    void attack();
}
