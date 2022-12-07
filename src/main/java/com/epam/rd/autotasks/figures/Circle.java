package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private double x;
    private double y;
    private double r;


    public Circle(Point mid, double r){
        if (r <= 0 || mid == null) throw new IllegalArgumentException();
        x = mid.getX();
        y = mid.getY();
        this.r = r;
    }
    @Override
    public Point centroid(){
        return new Point(x,y);
    }
    @Override
    public boolean isTheSame(Figure figure){
        if (this == figure) {
            return true;
        }
        if (figure == null || getClass() != figure.getClass()) {
            return false;
        }
        Circle fig = (Circle) figure;
        if (Math.abs(x - fig.x) < 1e-15) x = fig.x;
        if (Math.abs(y - fig.y) < 1e-15) y = fig.y;
        if (Math.abs(r - fig.r) < 1e-15) r = fig.r;
        return x == fig.x &&
                y == fig.y &&
                r == fig.r;
    }
}
