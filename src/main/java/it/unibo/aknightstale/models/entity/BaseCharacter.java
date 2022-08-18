package it.unibo.aknightstale.models.entity;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;

public abstract class BaseCharacter extends EntityImpl implements Character {
    /**
     * The entity damage.
     */
    private double damage;
    /**
     * The entity health.
     */
    private double health;
    /**
     * The entity speed.
     */
    private double speed;
    /**
     * The entity direction.
     */
    private Direction direction;

    public BaseCharacter(final Bounds bounds, final EntityType type, final boolean collidable, final Direction dir,
            final double dmg, final double health, final double speed) {
        super(bounds, type, collidable);
        this.damage = dmg;
        this.health = health;
        this.speed = speed;
        this.direction = dir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getDamage() {
        return this.damage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDamage(final double dmg) {
        this.damage = dmg;
    }

    @Override
    public abstract double getAttackRange();

    @Override
    public abstract void attack(LifeEntity e);

    /**
     * {@inheritDoc}i
     */
    @Override
    public void setHealth(final double health) {
        this.health = health;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHealth() {
        return this.health;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getSpeed() {
        return this.speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeed(final double speed) {
        this.speed = speed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDirection(final Direction dir) {
        this.direction = dir;
    }

    private void updatePosition(final double x, final double y) {
        final var pos = super.getPosition();
        super.setPosition(new Point2D(pos.getX() + x, pos.getY() + y));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goUp() {
        this.updatePosition(0, -speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goDown() {
        this.updatePosition(0, speed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goLeft() {
        this.updatePosition(-speed, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goRight() {
        this.updatePosition(speed, 0);
    }

}
