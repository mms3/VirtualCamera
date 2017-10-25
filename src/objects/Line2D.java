package objects;

/**
 *
 * @author Magda
 */
public class Line2D {
    private Point2D a, b;
    private boolean inner;

    public Line2D (Point2D a, Point2D b, boolean inner){
        this.a = a;
        this.b = b;
        this.inner = inner;
    }

    public Point2D getA (){
        return a;
    }

    public Point2D getB (){
        return b;
    }

    public boolean isInner(){
        return inner;
    }
}