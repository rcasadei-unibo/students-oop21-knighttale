package it.unibo.aknightstale.utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollisionManagerImpl implements CollisionManager {

    private final List<EntityController<? super Character, ? super AnimatedEntityView>> entities;
    private double widthScreen;
    private double heightScreen;

    @SuppressFBWarnings("EI_EXPOSE_REP2") // can be modified later
    public CollisionManagerImpl(final List<EntityController<? super Character, ? super AnimatedEntityView>> entities,
                                final double width, final double height) {
        super();
        this.entities = entities;
        this.widthScreen = width;
        this.heightScreen = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EntityController<? super Character, ? super AnimatedEntityView>> checkCollision(
            final EntityController<? super Character, ? super AnimatedEntityView> ec) {
        final var entity = new BordersImpl(ec.getModel().getPosition().getX() - 1,
                ec.getModel().getPosition().getY() - 1, ec.getModel().getBorders().getWidth() + 1,
                ec.getModel().getBorders().getHeight() + 1);

        return this.entities.stream().filter(e -> e.getModel().isCollidable())
                .filter(e -> entity.intersects(e.getModel().getBorders())).collect(Collectors.toList());
    }

    private boolean rightDirection(final Borders e, final Borders bounds) {
        return equalsDouble(bounds.getX() + 5.0, e.getX() + e.getWidth())
                && (bounds.getY() >= e.getY() && bounds.getY() < e.getY() + e.getHeight()
                || bounds.getY() + bounds.getHeight() > e.getY() && bounds.getY() + bounds.getHeight() <= e.getY() + e.getHeight());
    }

    private boolean leftDirection(final Borders e, final Borders bounds) {
        return equalsDouble(bounds.getX() + bounds.getWidth() - 5.0, e.getX())
                && (bounds.getY() >= e.getY() && bounds.getY() < e.getY() + e.getHeight()
                || bounds.getY() + bounds.getHeight() > e.getY() && bounds.getY() + bounds.getHeight() <= e.getY() + e.getHeight());
    }

    private boolean downDirection(final Borders e, final Borders bounds) {
        return equalsDouble(bounds.getY() + 5.0, e.getY() + e.getHeight())
                && (bounds.getX() >= e.getX() && bounds.getX() < e.getX() + e.getWidth()
                || bounds.getX() + bounds.getWidth() > e.getX() && bounds.getX() + bounds.getWidth() <= e.getX() + e.getWidth());
    }

    private boolean upDirection(final Borders e, final Borders bounds) {
        return equalsDouble(bounds.getY() + bounds.getHeight() - 5.0, e.getY())
                && (bounds.getX() >= e.getX() && bounds.getX() < e.getX() + e.getWidth()
                || bounds.getX() + bounds.getWidth() > e.getX() && bounds.getX() + bounds.getWidth() <= e.getX() + e.getWidth());
    }
    
    private boolean equalsDouble(final double a, final double b) {
        final double delta = 0.0001;
        return Math.abs(a - b) < delta;
    }

    private void entityCollisions(final Borders e, final List<Direction> list) {
        if ((e.getX() + e.getWidth()) < this.widthScreen
                && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                        .filter(entity -> this.rightDirection(e, entity.getModel().getBorders()))
                        .collect(Collectors.toList()).isEmpty()) {
            list.add(Direction.RIGHT);
        }
        if (e.getX() > 0 && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                .filter(entity -> this.leftDirection(e, entity.getModel().getBorders())).collect(Collectors.toList())
                .isEmpty()) {
            list.add(Direction.LEFT);
        }
        if ((e.getY() + e.getHeight()) < this.heightScreen
                && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                        .filter(entity -> this.downDirection(e, entity.getModel().getBorders()))
                        .collect(Collectors.toList()).isEmpty()) {
            list.add(Direction.DOWN);
        }
        if (e.getY() > 0 && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                .filter(entity -> this.upDirection(e, entity.getModel().getBorders())).collect(Collectors.toList())
                .isEmpty()) {
            list.add(Direction.UP);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Direction> checkDirections(
            final EntityController<? extends Character, ? extends AnimatedEntityView> ec) {
        final var list = new ArrayList<Direction>();
        this.entityCollisions(ec.getModel().getBorders(), list);
        return List.copyOf(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<List<EntityController<? super Character, ? super AnimatedEntityView>>> update() {
        final List<List<EntityController<? super Character, ? super AnimatedEntityView>>> list = new ArrayList<>();
        this.entities.stream().filter(e -> e.getModel().isCollidable()).forEach(e -> {
            final var l = this.checkCollision(e);
            if (!l.isEmpty()) {
                l.add(e);
                list.add(l);
            }
        });
        return List.copyOf(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidthScreen(final double widthScreen) {
        this.widthScreen = widthScreen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHeightScreen(final double heightScreen) {
        this.heightScreen = heightScreen;
    }

}
