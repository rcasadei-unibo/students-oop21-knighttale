package it.unibo.aknightstale.utils;

public class Point2D implements Point {

    private double x;
    private double y;

    public Point2D(final double x, final double y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(final double y) {
        this.y = y;
    }

}
