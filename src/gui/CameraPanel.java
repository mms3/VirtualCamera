package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import logic.Camera;
import objects.Line2D;
import objects.Wall2D;

/**
 *
 * @author Magda
 */
public class CameraPanel extends javax.swing.JPanel{
    private int width;
    private int height;
    private Camera camera;

    public CameraPanel() throws IOException{
        width = 600;
        height = 500;
        camera = new Camera(this);
    }

    public Camera getCamera(){
        return camera;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for (Wall2D wall: camera.getWalls()){
            g2D.setColor(Color.lightGray);
            g2D.fillPolygon(wall.getXs(), wall.getYs(), 4);
            g2D.setColor(Color.black);
            //g2D.drawPolygon(wall.getXs(), wall.getYs(), 4);
            for (Line2D line : wall.getLines()){
                if(!line.isInner())
                    g2D.drawLine(line.getA().getX(), line.getA().getY(), line.getB().getX(), line.getB().getY());
            }
        }
    }
}