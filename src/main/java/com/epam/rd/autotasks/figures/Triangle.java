package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(Point A, Point B, Point C) {
        if (A == null || B == null || C == null) throw new IllegalArgumentException();
        x1 = A.getX();
        y1 = A.getY();
        x2 = B.getX();
        y2 = B.getY();
        x3 = C.getX();
        y3 = C.getY();
        if ((x1/y1 == x2/y2 && x2/y2 == x3/y3) || (x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public Point centroid(){
        return new Point((x1+x2+x3)/3, (y1+y2+y3)/3);
    }
    @Override
    public boolean isTheSame(Figure figure){
        if (this == figure) {
            return true;
        }
        if (figure == null || getClass() != figure.getClass()) {
            return false;
        }
        Triangle fig = (Triangle) figure;
        if (Math.abs(x1 - fig.x1) < 1e-15) x1 = fig.x1;
        if (Math.abs(x2 - fig.x2) < 1e-15) x2 = fig.x2;
        if (Math.abs(x3 - fig.x3) < 1e-15) x3 = fig.x3;
        if (Math.abs(y1 - fig.y1) < 1e-15) y1 = fig.y1;
        if (Math.abs(y2 - fig.y2) < 1e-15) y2 = fig.y2;
        if (Math.abs(y3 - fig.y3) < 1e-15) y3 = fig.y3;
        return x1 == fig.x1 && y1 == fig.y1 && x2 == fig.x2 && y2 == fig.y2
                && x3 == fig.x3 && y3 == fig.y3;
    }
}
