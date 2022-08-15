package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.CharacterModel;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public abstract class AbstractController<M extends CharacterModel, V extends AnimatedEntityView>
        extends EntityControllerImpl<M, V> implements CharacterController<M, V> {

    /**
     * The entity manager.
     */
    private final EntityManager manager;


    public AbstractController(final M model, final V view, final EntityManager manager) {
        super(model, view);
        this.manager = manager;
    }

    /**
     * Updates the direction and the view of entity.
     * 
     * @param dir the entity direction.
     */
    protected abstract void move(Direction dir);

    private boolean canMove(final Direction d) {
        return this.manager.getCollisionManager().checkDirections(this).contains(d);
    }

    /**
     * {@inheritDoc}i
     */
    @Override
    public void moveRight() {
        if (canMove(Direction.RIGHT)) {
            super.getModel().goRight();
            move(Direction.RIGHT);
        }
    }

    /**
     * {@inheritDoc}i
     */
    @Override
    public void moveLeft() {
        if (canMove(Direction.LEFT)) {
            super.getModel().goLeft();
            move(Direction.LEFT);
        }
    }

    /**
     * {@inheritDoc}i
     */
    @Override
    public void moveUp() {
        if (canMove(Direction.UP)) {
            super.getModel().goUp();
            move(Direction.UP);
        }
    }

    /**
     * {@inheritDoc}i
     */
    @Override
    public void moveDown() {
        if (canMove(Direction.DOWN)) {
            super.getModel().goDown();
            move(Direction.DOWN);
        }
    }

    @Override
    public abstract void attack();

    /**
     * Get the entity manager.
     * 
     * @return  The entity manager.
     */
    public EntityManager getManager() {
        return manager;
    }
}
