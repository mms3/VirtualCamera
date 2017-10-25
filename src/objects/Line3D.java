package objects;


/**
 *
 * @author Magda
 */
public class Line3D {
    private Point3D a;
    private Point3D b;
    private boolean inner;

    public Line3D (Point3D a, Point3D b, boolean inner){
        this.a = a;
        this.b = b;
        this.inner = inner;
    }

    public Point3D getA (){
        return a;
    }

    public Point3D getB (){
        return b;
    }

    public boolean isInner(){
        return inner;
    }
}