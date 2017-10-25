package objects;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magda
 */
public class Wall implements Comparable<Wall>{
    List<Line3D> lines = new ArrayList<>();
    List<Point3D> points = new ArrayList<>();
    int div = 2;
    private double ycenter, xcenter, zcenter;
    private double A, B, C, D;

    public Wall(Point3D a, Point3D b, Point3D c, Point3D d){
        lines.add(new Line3D(a, b, false));
        lines.add(new Line3D(b, c, false));
        lines.add(new Line3D(c, d, false));
        lines.add(new Line3D(d, a, false));
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        solvePlaneEquation();
    }

    public Wall(Line3D ab, Line3D bc, Line3D cd, Line3D da){
        lines.add(ab);
        lines.add(bc);
        lines.add(cd);
        lines.add(da);
        setPoints();
        solvePlaneEquation();
    }

    public Wall (List<Point3D> points){
        this.points = points;
        solvePlaneEquation();
    }

    public final void solvePlaneEquation(){
        double x1 = points.get(0).getX();
        double y1 = points.get(0).getY();
        double z1 = points.get(0).getZ();
        double x2 = points.get(1).getX();
        double y2 = points.get(1).getY();
        double z2 = points.get(1).getZ();
        double x3 = points.get(3).getX();
        double y3 = points.get(3).getY();
        double z3 = points.get(3).getZ();
        A = (y2-y1)*(z3-z1)-(y3-y1)*(z2-z1);
        B = (z2-z1)*(x3-x1)-(z3-z1)*(x2-x1);
        C = (x2-x1)*(y3-y1)-(x3-x1)*(y2-y1);
        D = -(A*x1+B*y1+C*z1);
    }

    public double getA(){
        return A;
    }

    public double getB(){
        return B;
    }

    public double getC(){
        return C;
    }

    public double getD(){
        return D;
    }

    public void setPoints(ArrayList<Point3D> points){
        this.points = points;
    }

    public void countCenter(){
        ycenter = (points.get(0).getY()+points.get(1).getY()+points.get(2).getY()+points.get(3).getY())/4;
        xcenter = (points.get(0).getX()+points.get(1).getX()+points.get(2).getX()+points.get(3).getX())/4;
        zcenter = (points.get(0).getZ()+points.get(1).getZ()+points.get(2).getZ()+points.get(3).getZ())/4;
    }

    public double getXcenter(){
        return xcenter;
    }

    public double getYcenter(){
        return ycenter;
    }

    public double getZcenter(){
        return zcenter;
    }

    public ArrayList<Line3D> getLines(){
        return (ArrayList<Line3D>) lines;
    }

    public ArrayList<Point3D> getPoints(){
        return (ArrayList<Point3D>) points;
    }

    private void setPoints(){
        for (int i=0; i<4; i++)
            points.add(lines.get(i).getA());
    }

    public void printWall(){
        System.out.println("("+points.get(0).getX()+", "+points.get(0).getY()+", "+points.get(0).getZ()+") x " +
                "("+points.get(1).getX()+", "+points.get(1).getY()+", "+points.get(1).getZ()+") x " +
                "("+points.get(2).getX()+", "+points.get(2).getY()+", "+points.get(2).getZ()+") x " +
                "("+points.get(3).getX()+", "+points.get(3).getY()+", "+points.get(3).getZ()+")");
    }

    public List<Wall> divide() {
        List<Wall> walls = new ArrayList<>();
        double x1 = (points.get(0).getX()+points.get(1).getX())/2;
        double y1 = (points.get(0).getY()+points.get(1).getY())/2;
        double z1 = (points.get(0).getZ()+points.get(1).getZ())/2;
        double x2 = (points.get(2).getX()+points.get(1).getX())/2;
        double y2 = (points.get(2).getY()+points.get(1).getY())/2;
        double z2 = (points.get(2).getZ()+points.get(1).getZ())/2;
        double x3 = (points.get(2).getX()+points.get(3).getX())/2;
        double y3 = (points.get(2).getY()+points.get(3).getY())/2;
        double z3 = (points.get(2).getZ()+points.get(3).getZ())/2;
        double x4 = (points.get(0).getX()+points.get(3).getX())/2;
        double y4 = (points.get(0).getY()+points.get(3).getY())/2;
        double z4 = (points.get(0).getZ()+points.get(3).getZ())/2;
        double x5 = (x1+x3)/2;
        double y5 = (y2+y4)/2;
        double z5 = (z2+z4)/2;

        walls.add(new Wall(new Line3D(points.get(0),new Point3D(x1,y1,z1),false),
                new Line3D(new Point3D(x1,y1,z1),new Point3D(x5,y5,z5),true),
                new Line3D(new Point3D(x5,y5,z5),new Point3D(x4,y4,z4),true),
                new Line3D(new Point3D(x4,y4,z4),points.get(0),false)));
        walls.add(new Wall(new Line3D(new Point3D(x1,y1,z1),points.get(1),false),
                new Line3D(points.get(1),new Point3D(x2,y2,z2),false),
                new Line3D(new Point3D(x2,y2,z2),new Point3D(x5,y5,z5),true),
                new Line3D(new Point3D(x5,y5,z5),new Point3D(x1,y1,z1),true)));
        walls.add(new Wall(new Line3D(new Point3D(x5,y5,z5),new Point3D(x2,y2,z2),true),
                new Line3D(new Point3D(x2,y2,z2),points.get(2),false),
                new Line3D(points.get(2),new Point3D(x3,y3,z3),false),
                new Line3D(new Point3D(x3,y3,z3),new Point3D(x5,y5,z5),true)));
        walls.add(new Wall(new Line3D(new Point3D(x4,y4,z4),new Point3D(x5,y5,z5),true),
                new Line3D(new Point3D(x5,y5,z5),new Point3D(x3,y3,z3),true),
                new Line3D(new Point3D(x3,y3,z3),points.get(3),false),
                new Line3D(points.get(3),new Point3D(x4,y4,z4),false)));

        return walls;
    }

    @Override
    public int compareTo(Wall o) {
        if (ycenter < o.ycenter) {
            return 1;
        } else if (ycenter > o.ycenter) {
            return -1;
        } else {
            if (abs(xcenter) < abs(o.xcenter)){
                return 1;
            } else if (abs(xcenter) > abs(o.xcenter)){
                return -1;
            } else {
                if (abs(zcenter) < abs(o.zcenter)){
                    return 1;
                } else if (abs(zcenter) > abs(o.zcenter)){
                    return -1;
                } else
                    return 0;
            }
        }
    }
}