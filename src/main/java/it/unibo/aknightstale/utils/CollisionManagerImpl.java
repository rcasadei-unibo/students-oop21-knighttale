package it.unibo.aknightstale.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;

public class CollisionManagerImpl implements CollisionManager {

    private final List<EntityController<? super Character, ? super AnimatedEntityView>> entities;
    private double widthScreen;
    private double heightScreen;

    public CollisionManagerImpl(final List<EntityController<? super Character, ? super AnimatedEntityView>> entities,
            final double width, final double height) {
        super();
        this.entities = List.copyOf(entities);
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
        return bounds.getX() == e.getX() + e.getWidth() && (bounds.getY() >= e.getY()
                && bounds.getY() < e.getY() + e.getHeight()
                || bounds.getY() + bounds.getHeight() > e.getY() && bounds.getY() + bounds.getHeight() <= e.getY());
    }

    private boolean leftDirection(final Borders e, final Borders bounds) {
        return bounds.getX() + bounds.getWidth() == e.getX() && (bounds.getY() >= e.getY()
                && bounds.getY() < e.getY() + e.getHeight()
                || bounds.getY() + bounds.getHeight() > e.getY() && bounds.getY() + bounds.getHeight() <= e.getY());
    }

    private boolean downDirection(final Borders e, final Borders bounds) {
        return bounds.getY() == e.getY() + e.getHeight() && (bounds.getX() >= e.getX()
                && bounds.getX() < e.getX() + e.getWidth()
                || bounds.getX() + bounds.getWidth() > e.getX() && bounds.getX() + bounds.getWidth() <= e.getX());
    }

    private boolean upDirection(final Borders e, final Borders bounds) {
        return bounds.getY() + bounds.getHeight() == e.getY() && (bounds.getX() >= e.getX()
                && bounds.getX() < e.getX() + e.getWidth()
                || bounds.getX() + bounds.getWidth() > e.getX() && bounds.getX() + bounds.getWidth() <= e.getX());
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
