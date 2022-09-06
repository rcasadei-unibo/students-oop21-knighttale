package it.unibo.aknightstale.models;

import it.unibo.aknightstale.models.entity.BaseCharacter;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.utils.Borders;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends BaseCharacter {


    static final double WIDTH_BOUNDS = 50.0;
    static final double HEIGHT_BOUNDS = 50.0;
    static final double DAMAGE = 25.0;
    static final double MAX_HEALTH = 100.0;
    static final double SPEED = 0.6;
    static final double ATTACK_RANGE = 5.0;

    static final double CHASING_RANGE = 100;

    private final List<Direction> listDirection = new ArrayList<>();

    public Status getStatus() {
        return status;
    }

    private Status status = Status.WALK;

    private boolean checkAxisX = (new Random().nextInt() % 2 == 0);

    public Enemy(final Point2D position) {
        super(new BordersImpl(position.getX(), position.getY(), WIDTH_BOUNDS, HEIGHT_BOUNDS), EntityType.ENEMY, true,
                Direction.RIGHT, DAMAGE, MAX_HEALTH, SPEED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAttackRange() {
        return ATTACK_RANGE;
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }

    /*cambiare parametro Point2D con classe Point che non usa javafx*/
    public void update(final Point2D playerPosition) {
        Direction dir = null;

        double distanceX = this.getPosition().getX() - playerPosition.getX();
        double distanceY = this.getPosition().getY() - playerPosition.getY();

        if(playerPosition.equals(this.getPosition())){
            this.status = Status.IDLE;
        } else {
            if (Math.abs(distanceX) < CHASING_RANGE && Math.abs(distanceY) < CHASING_RANGE) {
                this.status = Status.WALK;

                if (this.checkAxisX) {
                    this.checkAxisX = false;
                    if (distanceX <= CHASING_RANGE && distanceX >= 20) {
                        dir = Direction.LEFT;
                    } else if (distanceX >= -CHASING_RANGE && distanceX <= 20) {
                        dir = Direction.RIGHT;
                    }
                } else {
                    this.checkAxisX = true;
                    if (distanceY <= CHASING_RANGE && distanceY >= 20) {
                        dir = Direction.UP;
                    } else if (distanceY >= -CHASING_RANGE && distanceY <= 20) {
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

    private Direction getRandomDirection(){
        int randomDirection = new Random().nextInt(4);

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
