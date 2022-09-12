package it.unibo.aknightstale.models;

import it.unibo.aknightstale.models.entity.BaseCharacter;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.Point;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.entity.Status;

import java.util.Random;

public class Enemy extends BaseCharacter {


    static final double WIDTH_BOUNDS = 20.0;
    static final double HEIGHT_BOUNDS = 24.0;
    static final double DAMAGE = 25.0;
    static final double MAX_HEALTH = 100.0;
    static final double SPEED = 0.8;
    static final double DEFENSE = 10.0;
    static final double ATTACK_RANGE = 5.0;

    private static final int MIN_DISTANCE = 20;
    static final double CHASING_RANGE = 100;

    //private final List<Direction> listDirection = new ArrayList<>();

    private Status status = Status.WALK;

    private final Random random = new Random();
    private boolean checkAxisX = random.nextInt() % 2 == 0;

    public Enemy(final Point position) {
        super(new BordersImpl(position.getX(), position.getY(), WIDTH_BOUNDS, HEIGHT_BOUNDS), EntityType.ENEMY, true,
                Direction.RIGHT, DAMAGE, MAX_HEALTH, SPEED, DEFENSE);
    }

    /**
     * {@inheritDoc}
     */
    public Status getStatus() {
        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAttackRange() {
        return ATTACK_RANGE;
    }


    /**
     * This method set the new enemy's direction.
     * @param playerPosition is the player's position in the game world. */
    public void update(final Point2D playerPosition) {
        Direction dir = null;

        final double distanceX = this.getPosition().getX() - playerPosition.getX();
        final double distanceY = this.getPosition().getY() - playerPosition.getY();

        if (playerPosition.equals(this.getPosition())) {
            this.status = Status.IDLE;
        } else {
            if (Math.abs(distanceX) < CHASING_RANGE && Math.abs(distanceY) < CHASING_RANGE) {
                this.status = Status.WALK;

                if (this.checkAxisX) {
                    this.checkAxisX = false;
                    if (distanceX <= CHASING_RANGE && distanceX >= MIN_DISTANCE) {
                        dir = Direction.LEFT;
                    } else if (distanceX >= -CHASING_RANGE && distanceX <= MIN_DISTANCE) {
                        dir = Direction.RIGHT;
                    }
                } else {
                    this.checkAxisX = true;
                    if (distanceY <= CHASING_RANGE && distanceY >= MIN_DISTANCE) {
                        dir = Direction.UP;
                    } else if (distanceY >= -CHASING_RANGE && distanceY <= MIN_DISTANCE) {
                        dir = Direction.DOWN;
                    }
                }
            }
            if (dir == null) {
                dir = this.getRandomDirection();
            }

            setDirection(dir);
        }
    }

    private Direction getRandomDirection() {
        final int randomDirection = random.nextInt(4);

        switch (randomDirection) {
            case 1:
                goLeft();
                return Direction.LEFT;
            case 2:
                goRight();
                return Direction.RIGHT;
            case 3:
                goUp();
                return Direction.UP;
            default:
                goDown();
                return Direction.DOWN;
        }
    }
}
