package it.unibo.aknightstale.controllers.entity;


import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.utils.EntityManager;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import it.unibo.aknightstale.views.entity.Status;

public class EnemyController<M extends Character, V extends AnimatedEntityView> extends AbstractController<M, V> {

    private boolean canAttack = true;

    private final Runnable waitForAttack = () -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        canAttack = true;
    };
    private final Thread wait = new Thread(waitForAttack);

    public EnemyController(final M model, final V view, final EntityManager manager) {
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
        if (this.canAttack) {
            super.attack();
            this.canAttack = false;
            try {
                wait.start();
            } catch (final IllegalThreadStateException ignored) {
            }
        }
    }
}
