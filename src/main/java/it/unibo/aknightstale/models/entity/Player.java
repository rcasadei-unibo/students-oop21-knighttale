package it.unibo.aknightstale.models.entity;

import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.Point2D;

public class Player extends BaseCharacter {

    private static final double WIDTH_BOUNDS = 50.0;
    private static final double HEIGHT_BOUNDS = 50.0;
    private static final double DAMAGE = 25.0;
    private static final double MAX_HEALTH = 100.0;
    private static final double SPEED = 1.0;

    private static final double ATTACK_RANGE = 5.0;

    public Player(final Point2D position) {
        super(new BordersImpl(position.getX(), position.getY(), WIDTH_BOUNDS, HEIGHT_BOUNDS), EntityType.PLAYER, true,
                Direction.RIGHT, DAMAGE, MAX_HEALTH, SPEED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAttackRange() {
        return ATTACK_RANGE;
    }

}
