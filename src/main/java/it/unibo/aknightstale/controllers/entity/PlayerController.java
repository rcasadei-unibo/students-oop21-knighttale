package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;

public class PlayerController<M extends Character, V extends AnimatedEntityView> extends AbstractController<M, V> {

    public PlayerController(final M model, final V view, final EntityManager manager) {
        super(model, view, manager);
    }

    /**
     * {@inheritDoc}i
     */
    @Override
    protected void move(final Direction dir) {
        super.getModel().setDirection(dir);
        super.getView().setStatus(Status.WALK);
        super.getView().update(super.getModel().getDirection());
    }

    /**
     * {@inheritDoc}i
     */
    @Override
    public void attack() {
        this.getManager().getEntities().stream().filter(ec -> {
            final var e = ec.getModel();
            switch (this.getModel().getDirection()) {
            case RIGHT:
                return e.getPosition().getX() <= super.getModel().getPosition().getX() + super.getModel().getAttackRange()
                        && e.getPosition().getX() >= super.getModel().getPosition().getX();
            case LEFT:
                return e.getPosition().getX() >= super.getModel().getPosition().getX() - super.getModel().getAttackRange()
                        && e.getPosition().getX() <= super.getModel().getPosition().getX();
            case UP:
                return e.getPosition().getY() >= super.getModel().getPosition().getY() - super.getModel().getAttackRange()
                        && e.getPosition().getY() <= super.getModel().getPosition().getY();
            case DOWN:
                return e.getPosition().getY() <= super.getModel().getPosition().getY() + super.getModel().getAttackRange()
                        && e.getPosition().getY() >= super.getModel().getPosition().getY();
            default:
            }
            return true;
        }).filter(ec -> ec.getModel() instanceof Character).forEach(e -> {
            final var model = (Character) e.getModel();
            super.getModel().attack(model);
        });
        super.getView().setStatus(Status.ATTACK);
        super.getView().update(super.getModel().getDirection());
    }

}
