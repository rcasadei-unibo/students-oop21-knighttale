package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.EntityType;
import it.unibo.aknightstale.utils.BordersImpl;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;

public class PlayerController<M extends Character, V extends AnimatedEntityView> extends AbstractController<M, V> {

    public PlayerController(final M model, final V view, final EntityManager manager) {
        super(model, view, manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void move(final Direction dir) {
        super.getModel().setDirection(dir);
        super.getView().setStatus(Status.WALK);
        super.getView().update(super.getModel().getDirection());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attack() {
        final var playerModel = super.getModel();
        final double attackRange = playerModel.getAttackRange();
        final var playerBounds = new BordersImpl(playerModel.getPosition().getX() - attackRange,
                playerModel.getPosition().getY() - attackRange, playerModel.getBorders().getWidth() + attackRange,
                playerModel.getBorders().getHeight() + attackRange);

        this.getManager().getEntities().stream().filter(ec -> playerBounds.intersects(ec.getModel().getBorders()))
                .filter(ec -> ec.getModel() instanceof Character).forEach(ec -> {
                    if (!ec.getModel().getType().equals(EntityType.PLAYER)) {
                        final var model = (Character) ec.getModel();
                        super.getModel().attack(model);
                    }
                });
        super.getView().setStatus(Status.ATTACK);
        super.getView().update(super.getModel().getDirection());
    }

}
