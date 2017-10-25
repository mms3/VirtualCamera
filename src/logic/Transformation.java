package logic;

import objects.Wall;

/**
 *
 * @author Magda
 */
public class Transformation {
    private Scene scene;
    private Camera camera;
    private int d;
    private final int step = 50;
    private final int zoom = 10;
    private final double degree = Math.PI*5/180;;
    private int width;
    private int height;

    public Transformation (Camera camera, Scene scene, int d, int width, int height){
        this.camera = camera;
        this.scene = scene;
        this.d = d;
        this.width = width;
        this.height = height;
    }

    public void goUp(){
        for (Wall wall : scene.getWalls()){
            wall.getPoints().get(0).setZ(wall.getPoints().get(0).getZ()-step);
            wall.getPoints().get(1).setZ(wall.getPoints().get(1).getZ()-step);
            wall.getPoints().get(2).setZ(wall.getPoints().get(2).getZ()-step);
            wall.getPoints().get(3).setZ(wall.getPoints().get(3).getZ()-step);
        }
        camera.update();
    }

    public void goDown(){
        for (Wall wall : scene.getWalls()){
            wall.getPoints().get(0).setZ(wall.getPoints().get(0).getZ()+step);
            wall.getPoints().get(1).setZ(wall.getPoints().get(1).getZ()+step);
            wall.getPoints().get(2).setZ(wall.getPoints().get(2).getZ()+step);
            wall.getPoints().get(3).setZ(wall.getPoints().get(3).getZ()+step);
        }
        camera.update();
    }

    public void goLeft(){
        for (Wall wall : scene.getWalls()){
            wall.getPoints().get(0).setX(wall.getPoints().get(0).getX()+step);
            wall.getPoints().get(1).setX(wall.getPoints().get(1).getX()+step);
            wall.getPoints().get(2).setX(wall.getPoints().get(2).getX()+step);
            wall.getPoints().get(3).setX(wall.getPoints().get(3).getX()+step);
        }
        camera.update();
    }

    public void goRight(){
        for (Wall wall : scene.getWalls()){
            wall.getPoints().get(0).setX(wall.getPoints().get(0).getX()-step);
            wall.getPoints().get(1).setX(wall.getPoints().get(1).getX()-step);
            wall.getPoints().get(2).setX(wall.getPoints().get(2).getX()-step);
            wall.getPoints().get(3).setX(wall.getPoints().get(3).getX()-step);
        }
        camera.update();
    }

    public void goForward(){
        for (Wall wall : scene.getWalls()){
            wall.getPoints().get(0).setY(wall.getPoints().get(0).getY()-step);
            wall.getPoints().get(1).setY(wall.getPoints().get(1).getY()-step);
            wall.getPoints().get(2).setY(wall.getPoints().get(2).getY()-step);
            wall.getPoints().get(3).setY(wall.getPoints().get(3).getY()-step);
        }
        camera.update();
    }

    public void goBackward(){
        for (Wall wall : scene.getWalls()){
            wall.getPoints().get(0).setY(wall.getPoints().get(0).getY()+step);
            wall.getPoints().get(1).setY(wall.getPoints().get(1).getY()+step);
            wall.getPoints().get(2).setY(wall.getPoints().get(2).getY()+step);
            wall.getPoints().get(3).setY(wall.getPoints().get(3).getY()+step);
        }
        camera.update();
    }

    public void turnUp(){
        for (Wall wall : scene.getWalls()){
            double ay = wall.getPoints().get(0).getY()*Math.cos(-degree)-wall.getPoints().get(0).getZ()*Math.sin(-degree);
            double az = wall.getPoints().get(0).getY()*Math.sin(-degree)+wall.getPoints().get(0).getZ()*Math.cos(-degree);
            double by = wall.getPoints().get(1).getY()*Math.cos(-degree)-wall.getPoints().get(1).getZ()*Math.sin(-degree);
            double bz = wall.getPoints().get(1).getY()*Math.sin(-degree)+wall.getPoints().get(1).getZ()*Math.cos(-degree);
            double cy = wall.getPoints().get(2).getY()*Math.cos(-degree)-wall.getPoints().get(2).getZ()*Math.sin(-degree);
            double cz = wall.getPoints().get(2).getY()*Math.sin(-degree)+wall.getPoints().get(2).getZ()*Math.cos(-degree);
            double dy = wall.getPoints().get(3).getY()*Math.cos(-degree)-wall.getPoints().get(3).getZ()*Math.sin(-degree);
            double dz = wall.getPoints().get(3).getY()*Math.sin(-degree)+wall.getPoints().get(3).getZ()*Math.cos(-degree);
            wall.getPoints().get(0).setY(ay);
            wall.getPoints().get(0).setZ(az);
            wall.getPoints().get(1).setY(by);
            wall.getPoints().get(1).setZ(bz);
            wall.getPoints().get(2).setY(cy);
            wall.getPoints().get(2).setZ(cz);
            wall.getPoints().get(3).setY(dy);
            wall.getPoints().get(3).setZ(dz);
        }
        camera.update();
    }

    public void turnDown(){
        for (Wall wall : scene.getWalls()){
            double ay = wall.getPoints().get(0).getY()*Math.cos(degree)-wall.getPoints().get(0).getZ()*Math.sin(degree);
            double az = wall.getPoints().get(0).getY()*Math.sin(degree)+wall.getPoints().get(0).getZ()*Math.cos(degree);
            double by = wall.getPoints().get(1).getY()*Math.cos(degree)-wall.getPoints().get(1).getZ()*Math.sin(degree);
            double bz = wall.getPoints().get(1).getY()*Math.sin(degree)+wall.getPoints().get(1).getZ()*Math.cos(degree);
            double cy = wall.getPoints().get(2).getY()*Math.cos(degree)-wall.getPoints().get(2).getZ()*Math.sin(degree);
            double cz = wall.getPoints().get(2).getY()*Math.sin(degree)+wall.getPoints().get(2).getZ()*Math.cos(degree);
            double dy = wall.getPoints().get(3).getY()*Math.cos(degree)-wall.getPoints().get(3).getZ()*Math.sin(degree);
            double dz = wall.getPoints().get(3).getY()*Math.sin(degree)+wall.getPoints().get(3).getZ()*Math.cos(degree);
            wall.getPoints().get(0).setY(ay);
            wall.getPoints().get(0).setZ(az);
            wall.getPoints().get(1).setY(by);
            wall.getPoints().get(1).setZ(bz);
            wall.getPoints().get(2).setY(cy);
            wall.getPoints().get(2).setZ(cz);
            wall.getPoints().get(3).setY(dy);
            wall.getPoints().get(3).setZ(dz);
        }
        camera.update();
    }

    public void turnLeft(){
        for (Wall wall : scene.getWalls()){
            double ax = wall.getPoints().get(0).getX()*Math.cos(-degree)-wall.getPoints().get(0).getY()*Math.sin(-degree);
            double ay = wall.getPoints().get(0).getX()*Math.sin(-degree)+wall.getPoints().get(0).getY()*Math.cos(-degree);
            double bx = wall.getPoints().get(1).getX()*Math.cos(-degree)-wall.getPoints().get(1).getY()*Math.sin(-degree);
            double by = wall.getPoints().get(1).getX()*Math.sin(-degree)+wall.getPoints().get(1).getY()*Math.cos(-degree);
            double cx = wall.getPoints().get(2).getX()*Math.cos(-degree)-wall.getPoints().get(2).getY()*Math.sin(-degree);
            double cy = wall.getPoints().get(2).getX()*Math.sin(-degree)+wall.getPoints().get(2).getY()*Math.cos(-degree);
            double dx = wall.getPoints().get(3).getX()*Math.cos(-degree)-wall.getPoints().get(3).getY()*Math.sin(-degree);
            double dy = wall.getPoints().get(3).getX()*Math.sin(-degree)+wall.getPoints().get(3).getY()*Math.cos(-degree);
            wall.getPoints().get(0).setX(ax);
            wall.getPoints().get(0).setY(ay);
            wall.getPoints().get(1).setX(bx);
            wall.getPoints().get(1).setY(by);
            wall.getPoints().get(2).setX(cx);
            wall.getPoints().get(2).setY(cy);
            wall.getPoints().get(3).setX(dx);
            wall.getPoints().get(3).setY(dy);
        }
        camera.update();
    }

    public void turnRight(){
        for (Wall wall : scene.getWalls()){
            double ax = wall.getPoints().get(0).getX()*Math.cos(degree)-wall.getPoints().get(0).getY()*Math.sin(degree);
            double ay = wall.getPoints().get(0).getX()*Math.sin(degree)+wall.getPoints().get(0).getY()*Math.cos(degree);
            double bx = wall.getPoints().get(1).getX()*Math.cos(degree)-wall.getPoints().get(1).getY()*Math.sin(degree);
            double by = wall.getPoints().get(1).getX()*Math.sin(degree)+wall.getPoints().get(1).getY()*Math.cos(degree);
            double cx = wall.getPoints().get(2).getX()*Math.cos(degree)-wall.getPoints().get(2).getY()*Math.sin(degree);
            double cy = wall.getPoints().get(2).getX()*Math.sin(degree)+wall.getPoints().get(2).getY()*Math.cos(degree);
            double dx = wall.getPoints().get(3).getX()*Math.cos(degree)-wall.getPoints().get(3).getY()*Math.sin(degree);
            double dy = wall.getPoints().get(3).getX()*Math.sin(degree)+wall.getPoints().get(3).getY()*Math.cos(degree);
            wall.getPoints().get(0).setX(ax);
            wall.getPoints().get(0).setY(ay);
            wall.getPoints().get(1).setX(bx);
            wall.getPoints().get(1).setY(by);
            wall.getPoints().get(2).setX(cx);
            wall.getPoints().get(2).setY(cy);
            wall.getPoints().get(3).setX(dx);
            wall.getPoints().get(3).setY(dy);
        }
        camera.update();
    }

    public void rotateLeft(){
        for (Wall wall : scene.getWalls()){
            double ax = wall.getPoints().get(0).getX()*Math.cos(-degree)+wall.getPoints().get(0).getZ()*Math.sin(-degree);
            double az = -wall.getPoints().get(0).getX()*Math.sin(-degree)+wall.getPoints().get(0).getZ()*Math.cos(-degree);
            double bx = wall.getPoints().get(1).getX()*Math.cos(-degree)+wall.getPoints().get(1).getZ()*Math.sin(-degree);
            double bz = -wall.getPoints().get(1).getX()*Math.sin(-degree)+wall.getPoints().get(1).getZ()*Math.cos(-degree);
            double cx = wall.getPoints().get(2).getX()*Math.cos(-degree)+wall.getPoints().get(2).getZ()*Math.sin(-degree);
            double cz = -wall.getPoints().get(2).getX()*Math.sin(-degree)+wall.getPoints().get(2).getZ()*Math.cos(-degree);
            double dx = wall.getPoints().get(3).getX()*Math.cos(-degree)+wall.getPoints().get(3).getZ()*Math.sin(-degree);
            double dz = -wall.getPoints().get(3).getX()*Math.sin(-degree)+wall.getPoints().get(3).getZ()*Math.cos(-degree);
            wall.getPoints().get(0).setX(ax);
            wall.getPoints().get(0).setZ(az);
            wall.getPoints().get(1).setX(bx);
            wall.getPoints().get(1).setZ(bz);
            wall.getPoints().get(2).setX(cx);
            wall.getPoints().get(2).setZ(cz);
            wall.getPoints().get(3).setX(dx);
            wall.getPoints().get(3).setZ(dz);
        }
        camera.update();
    }

    public void rotateRight(){
        for (Wall wall : scene.getWalls()){
            double ax = wall.getPoints().get(0).getX()*Math.cos(degree)+wall.getPoints().get(0).getZ()*Math.sin(degree);
            double az = -wall.getPoints().get(0).getX()*Math.sin(degree)+wall.getPoints().get(0).getZ()*Math.cos(degree);
            double bx = wall.getPoints().get(1).getX()*Math.cos(degree)+wall.getPoints().get(1).getZ()*Math.sin(degree);
            double bz = -wall.getPoints().get(1).getX()*Math.sin(degree)+wall.getPoints().get(1).getZ()*Math.cos(degree);
            double cx = wall.getPoints().get(2).getX()*Math.cos(degree)+wall.getPoints().get(2).getZ()*Math.sin(degree);
            double cz = -wall.getPoints().get(2).getX()*Math.sin(degree)+wall.getPoints().get(2).getZ()*Math.cos(degree);
            double dx = wall.getPoints().get(3).getX()*Math.cos(degree)+wall.getPoints().get(3).getZ()*Math.sin(degree);
            double dz = -wall.getPoints().get(3).getX()*Math.sin(degree)+wall.getPoints().get(3).getZ()*Math.cos(degree);
            wall.getPoints().get(0).setX(ax);
            wall.getPoints().get(0).setZ(az);
            wall.getPoints().get(1).setX(bx);
            wall.getPoints().get(1).setZ(bz);
            wall.getPoints().get(2).setX(cx);
            wall.getPoints().get(2).setZ(cz);
            wall.getPoints().get(3).setX(dx);
            wall.getPoints().get(3).setZ(dz);
        }
        camera.update();
    }

    public void zoomIn(){
        d += zoom;
        camera.setD(d);
        camera.update();
    }

    public void zoomOut(){
        d -= zoom;
        camera.setD(d);
        camera.update();
    }
}
