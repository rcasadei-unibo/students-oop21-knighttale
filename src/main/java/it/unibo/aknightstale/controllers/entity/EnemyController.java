package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.Enemy;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.EnemyView;
import it.unibo.aknightstale.views.entity.Status;

public class EnemyController extends AbstractController<Enemy, EnemyView> {


    public EnemyController(final Enemy model, final EnemyView view, final EntityManager manager) {
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
        /*final var playerModel = super.getModel();
        final double attackRange = playerModel.getAttackRange();
        final var playerBounds = new BoundingBox(playerModel.getPosition().getX() - attackRange,
                playerModel.getPosition().getY() - attackRange, playerModel.getBounds().getWidth() + attackRange,
                playerModel.getBounds().getHeight() + attackRange);
        this.getManager().getEntities().stream()
                .filter(ec -> playerBounds.intersects(ec.getModel().getBounds()))
                .filter(ec -> ec.getModel() instanceof Character)
                .forEach(ec -> {
                    if (!ec.getModel().getType().equals(EntityType.PLAYER)) {
                        final var model = (Character) ec.getModel();
                        super.getModel().attack(model);
                    }
                });
        super.getView().setStatus(Status.ATTACK);
        super.getView().update(super.getModel().getDirection());*/
    }

}