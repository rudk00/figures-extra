package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;
    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    double x4;
    double y4;
    public Quadrilateral(Point a, Point b, Point c, Point d){
        if (a == null || b == null || c == null || d == null) throw new IllegalArgumentException();
        if (intersect(a,b,c,d) || intersect(a,d,b,c)) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        x1 = a.getX();
        y1 = a.getY();
        x2 = b.getX();
        y2 = b.getY();
        x3 = c.getX();
        y3 = c.getY();
        x4 = d.getX();
        y4 = d.getY();
        if ((x1/y1 == x2/y2 && x2/y2 == x3/y3) || (x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) {
            throw new IllegalArgumentException();
        }
        double t1 = ((x4 - x1)*(y2-y1)-(y4-y1)*(x2-x1));
        double t2 = ((x4 - x2)*(y3-y2)-(y4-y2)*(x3-x2));
        double t3 = ((x4 - x3)*(y1-y3)-(y4-y3)*(x1-x3));
        double t4 =((x1 - x3)*(y2-y3)-(y1-y3)*(x2-x3));
        if ((t1*t2*t3*t4)<0) throw new IllegalArgumentException();
    }
    public static int orientation(Point p, Point q, Point r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX())
                - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0.0)
            return 0;
        return (val > 0) ? 1 : 2;
    }

    public static boolean intersect(Point p1, Point q1, Point p2, Point q2) {

        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) return true;

        return false;
    }
    @Override
    public Point centroid(){
        Figure triangle1 = new Triangle(a,b,d);
        Figure triangle2 = new Triangle(b,c,d);
        Figure triangle3 = new Triangle(a,b,c);
        Figure triangle4 = new Triangle(a,c,d);
        Point centroid1 = triangle1.centroid();
        Point centroid2 = triangle2.centroid();
        Point centroid3 = triangle3.centroid();
        Point centroid4 = triangle4.centroid();
        double x1 = centroid1.getX();
        double y1 = centroid1.getY();
        double x2 = centroid2.getX();
        double y2 = centroid2.getY();
        double x3 = centroid3.getX();
        double y3 = centroid3.getY();
        double x4 = centroid4.getX();
        double y4 = centroid4.getY();
        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3-x4))/((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);
        return new Point(x,y);
    }
    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null) return false;
        if (figure == this) return true;
        if (figure instanceof Quadrilateral) {
            if (a.isTheSame(((Quadrilateral)figure).a) || a.isTheSame(((Quadrilateral)figure).b) || a.isTheSame(((Quadrilateral)figure).c) || a.isTheSame(((Quadrilateral)figure).d)){
                if (b.isTheSame(((Quadrilateral)figure).a) || b.isTheSame(((Quadrilateral)figure).b) || b.isTheSame(((Quadrilateral)figure).c) || b.isTheSame(((Quadrilateral)figure).d)){
                    if (c.isTheSame(((Quadrilateral)figure).a) || c.isTheSame(((Quadrilateral)figure).b) || c.isTheSame(((Quadrilateral)figure).c) || c.isTheSame(((Quadrilateral)figure).d)){
                        if (d.isTheSame(((Quadrilateral)figure).a) || d.isTheSame(((Quadrilateral)figure).b) || d.isTheSame(((Quadrilateral)figure).c) || d.isTheSame(((Quadrilateral)figure).d)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }
}



