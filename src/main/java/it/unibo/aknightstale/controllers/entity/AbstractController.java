package it.unibo.aknightstale.controllers.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.utils.Point2D;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;

public abstract class AbstractController<M extends Character, V extends AnimatedEntityView>
        extends EntityControllerImpl<M, V> implements CharacterController<M, V> {

    /**
     * The entity manager.
     */
    private final EntityManager manager;

    @SuppressFBWarnings("EI_EXPOSE_REP2")       //must return a reference because it can be modified later
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
     * {@inheritDoc}
     */
    @Override
    public void moveRight() {
        if (canMove(Direction.RIGHT)) {
            super.getModel().goRight();
            move(Direction.RIGHT);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveLeft() {
        if (canMove(Direction.LEFT)) {
            super.getModel().goLeft();
            move(Direction.LEFT);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveUp() {
        if (canMove(Direction.UP)) {
            super.getModel().goUp();
            move(Direction.UP);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveDown() {
        if (canMove(Direction.DOWN)) {
            super.getModel().goDown();
            move(Direction.DOWN);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attack() {
        final var entityModel = super.getModel();
        final double attackRange = entityModel.getAttackRange();
        final var entityBounds = new BordersImpl(entityModel.getPosition().getX() - attackRange,
                entityModel.getPosition().getY() - attackRange, entityModel.getBorders().getWidth() + attackRange,
                entityModel.getBorders().getHeight() + attackRange);

        this.getManager().getEntities().stream()
                .filter(ec -> entityBounds.intersects(ec.getModel().getBorders()))
                .filter(ec -> ec.getModel() instanceof Character)
                .forEach(ec -> {
                    if (!ec.getModel().getType().equals(super.getModel().getType())) {
                        final var model = (Character) ec.getModel();
                        super.getModel().attack(model);
                    }
                });
        super.getView().setStatus(Status.ATTACK);
        super.getView().update(super.getModel().getDirection());
    }

    /**
     * Get the entity manager.
     * 
     * @return  The entity manager.
     */
    @SuppressFBWarnings("EI_EXPOSE_REP")        //must return a reference because it will be modified
    public EntityManager getManager() {
        return manager;
    }

    @Override
    public void adaptPositionToScreenSize(final double traslX, final double traslY) {
        final double newX = getModel().getPosition().getX() * traslX;
        final double newY = getModel().getPosition().getY() * traslY;
        getModel().setPosition(new Point2D(newX, newY));
    }

}


