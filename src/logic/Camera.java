package logic;

import gui.CameraPanel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import objects.Line2D;
import objects.Line3D;
import objects.Point2D;
import objects.Point3D;
import objects.Wall;
import objects.Wall2D;

/**
 *
 * @author Magda
 */
public class Camera {
    private CameraPanel panel;
    private Scene scene;
    private List<Wall2D> walls;
    private int d = 200;
    private Transformation transformation;

    public Camera(CameraPanel panel) throws IOException{
        this.panel = panel;
        scene = new Scene();
        scene.divideWalls(1);
        walls = new ArrayList<Wall2D>();
        transformation = new Transformation(this, scene, d, panel.getWidth(), panel.getHeight());
        update();
    }

    public void update(){
        walls.clear();
        for (Wall wall : scene.getWalls()){
            wall.countCenter();
            wall.solvePlaneEquation();
        }
        Collections.sort(scene.getWalls());
        for (Wall wall : scene.getWalls()){
            if (isVisible(wall) && !isHidden(wall))
                walls.add(transformWall(wall));
        }
        panel.repaint();
    }

    public Transformation setTransformation(){
        return transformation;
    }

    public Wall2D transformWall(Wall wall){
        Point3D a = wall.getPoints().get(0);
        Point3D b = wall.getPoints().get(1);
        Point3D c = wall.getPoints().get(2);
        Point3D d = wall.getPoints().get(3);
        return new Wall2D(new Line2D(transformPoint(a), transformPoint(b),wall.getLines().get(0).isInner()),
                new Line2D(transformPoint(b), transformPoint(c),wall.getLines().get(1).isInner()),
                new Line2D(transformPoint(c), transformPoint(d),wall.getLines().get(2).isInner()),
                new Line2D(transformPoint(d), transformPoint(a),wall.getLines().get(3).isInner()));
    }

    private Point2D transformPoint(Point3D p){
        double k = d/p.getY();
        int x = (int) (k*p.getX()+panel.getWidth()/2);
        int y = (int) (panel.getHeight()/2 - k*p.getZ());
        return new Point2D(x,y);
    }

    public void setD(int d){
        this.d = d;
    }

    public List<Wall2D> getWalls(){
        return walls;
    }

    private boolean isVisible(Wall wall){
        boolean check = true;
        for (Line3D line : wall.getLines())
            check = isVisible(line) && check;
        return check;
    }

    public boolean isVisible(Line3D line) {
        return isVisible(line.getA()) && isVisible(line.getB());
    }

    public boolean isVisible(Point3D p){
        if (p.getY() >= d)
            return true;
        return false;
    }

    private boolean isHidden(Wall wall) {
        double value = (wall.getA()*(0-wall.getXcenter())) + (wall.getB()*(-d-wall.getYcenter())) + (wall.getC()*(0-wall.getZcenter()));
        return value > 0;
    }

}