package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import objects.Point3D;
import objects.Wall;

/**
 *
 * @author Magda
 */
public class Scene {
    private List<Wall> walls;

    public Scene() throws IOException{
        walls = readObjects();
    }

    private ArrayList<Wall> readObjects() throws FileNotFoundException, IOException{
        List<Wall> walls = new ArrayList<Wall>();
        FileReader fileReader = new FileReader("walls.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.length() == 0 || line.charAt(0)=='*')
                continue;

            String[] coordinates = line.split(" ");
            Point3D a = new Point3D(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[2]));
            Point3D b = new Point3D(Integer.parseInt(coordinates[3]), Integer.parseInt(coordinates[4]), Integer.parseInt(coordinates[5]));
            Point3D c = new Point3D(Integer.parseInt(coordinates[6]), Integer.parseInt(coordinates[7]), Integer.parseInt(coordinates[8]));
            Point3D d = new Point3D(Integer.parseInt(coordinates[9]), Integer.parseInt(coordinates[10]), Integer.parseInt(coordinates[11]));
            walls.add(new Wall(a, b, c, d));
        }
        br.close();
        return (ArrayList<Wall>) walls;
    }

    public ArrayList<Wall> getWalls(){
        return (ArrayList<Wall>) walls;
    }

    public void divideWalls(int n) {
        for (int i=0; i<n; i++)
            walls = walls.stream().flatMap(wall -> wall.divide().stream()).collect(Collectors.toList());
    }
}