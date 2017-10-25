package objects;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Magda
 */
public class Wall2D {
    private Point2D a, b, c, d;
    private List<Line2D> lines = new ArrayList<Line2D>();

    public Wall2D(Point2D a, Point2D b, Point2D c, Point2D d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Wall2D (Line2D ab, Line2D bc, Line2D cd, Line2D da){
        lines.add(ab);
        lines.add(bc);
        lines.add(cd);
        lines.add(da);
        this.a = ab.getA();
        this.b = bc.getA();
        this.c = cd.getA();
        this.d = da.getA();
    }

    public Point2D getA(){
        return a;
    }

    public Point2D getB(){
        return b;
    }

    public Point2D getC(){
        return c;
    }

    public Point2D getD(){
        return d;
    }

    public int[] getXs(){
        int[] x = {a.getX(),b.getX(),c.getX(),d.getX()};
        return x;
    }

    public int[] getYs(){
        int[] y = {a.getY(),b.getY(),c.getY(),d.getY()};
        return y;
    }

    public ArrayList<Line2D> getLines(){
        return (ArrayList<Line2D>) lines;
    }
}