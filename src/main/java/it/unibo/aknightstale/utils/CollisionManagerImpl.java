package it.unibo.aknightstale.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.aknightstale.controllers.entity.EntityController;
import it.unibo.aknightstale.models.entity.Direction;
import it.unibo.aknightstale.models.entity.Character;
import it.unibo.aknightstale.views.entity.AnimatedEntityView;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;

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
        final var entity = new BoundingBox(ec.getModel().getPosition().getX() - 1,
                ec.getModel().getPosition().getY() - 1, ec.getModel().getBounds().getWidth() + 1,
                ec.getModel().getBounds().getHeight() + 1);
        return this.entities.stream().filter(e -> e.getModel().isCollidable())
                .filter(e -> entity.intersects(e.getModel().getBounds())).collect(Collectors.toList());
    }

    private boolean rightDirection(final Bounds e, final Bounds bounds) {
        return bounds.getMinX() == e.getMinX() + e.getWidth()
                && (bounds.getMinY() >= e.getMinY() && bounds.getMinY() < e.getMinY() + e.getHeight()
                        || bounds.getMinY() + bounds.getHeight() > e.getMinY()
                                && bounds.getMinY() + bounds.getHeight() <= e.getMinY());
    }

    private boolean leftDirection(final Bounds e, final Bounds bounds) {
        return bounds.getMinX() + bounds.getWidth() == e.getMinX()
                && (bounds.getMinY() >= e.getMinY() && bounds.getMinY() < e.getMinY() + e.getHeight()
                        || bounds.getMinY() + bounds.getHeight() > e.getMinY()
                                && bounds.getMinY() + bounds.getHeight() <= e.getMinY());
    }

    private boolean downDirection(final Bounds e, final Bounds bounds) {
        return bounds.getMinY() == e.getMinY() + e.getHeight()
                && (bounds.getMinX() >= e.getMinX() && bounds.getMinX() < e.getMinX() + e.getWidth()
                        || bounds.getMinX() + bounds.getWidth() > e.getMinX()
                                && bounds.getMinX() + bounds.getWidth() <= e.getMinX());
    }

    private boolean upDirection(final Bounds e, final Bounds bounds) {
        return bounds.getMinY() + bounds.getHeight() == e.getMinY()
                && (bounds.getMinX() >= e.getMinX() && bounds.getMinX() < e.getMinX() + e.getWidth()
                        || bounds.getMinX() + bounds.getWidth() > e.getMinX()
                                && bounds.getMinX() + bounds.getWidth() <= e.getMinX());
    }

    private void entityCollisions(final Bounds e, final List<Direction> list) {
        if ((e.getMinX() + e.getWidth()) < this.widthScreen
                && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                        .filter(entity -> this.rightDirection(e, entity.getModel().getBounds()))
                        .collect(Collectors.toList()).isEmpty()) {
            list.add(Direction.RIGHT);
        }
        if (e.getMinX() > 0 && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                .filter(entity -> this.leftDirection(e, entity.getModel().getBounds())).collect(Collectors.toList())
                .isEmpty()) {
            list.add(Direction.LEFT);
        }
        if ((e.getMinY() + e.getHeight()) < this.heightScreen
                && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                        .filter(entity -> this.downDirection(e, entity.getModel().getBounds()))
                        .collect(Collectors.toList()).isEmpty()) {
            list.add(Direction.DOWN);
        }
        if (e.getMinY() > 0 && this.entities.stream().filter(entity -> entity.getModel().isCollidable())
                .filter(entity -> this.upDirection(e, entity.getModel().getBounds())).collect(Collectors.toList())
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
        this.entityCollisions(ec.getModel().getBounds(), list);
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
