import java.io.*;
import java.awt.*;
import java.util.*;

/*
    1.10 В текстов файл са зададени данни за 6 намиращи се един в друг квадрата, чиито долен ляв връх съвпада.
    В първия ред са данните X и Y за всеки един от 4-те върха (като разделител служи интервал). В следващите редове,
    подредени в намаляващ ред по размера на фигурата, са X и Y координатите на различаващите се 3 върха. Да се състави
    Application на Java за прочитане на този файл и за графично представяне на квадратите, всеки с различен цвят.
*/

public class SquaresFromTextCoordinates extends Frame {

    private static ArrayList<Coordinates> _coordinates = new ArrayList<Coordinates>();

    public static void main(String[] args) throws IOException {
        SquaresFromTextCoordinates frame = new SquaresFromTextCoordinates();
        frame.setLocation(600, 100);
        frame.setSize(800, 600);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.addWindowListener(new WindowClosingAdapter(false));
        frame.setVisible(true);
        frame.setTitle("Squares Application");
        readCoordinates();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);

        Color[] _colors = new Color[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                Color.ORANGE, Color.PINK };

        for (int i = 0; i < _coordinates.size(); i++) {
            g.setColor(_colors[i]);
            int[] x_coordinates = {_coordinates.get(i).X0, _coordinates.get(i).X1,
                    _coordinates.get(i).X2, _coordinates.get(0).X3};

            int[] y_coordinates = {_coordinates.get(i).Y0, _coordinates.get(i).Y1,
                    _coordinates.get(i).Y2, _coordinates.get(0).Y3};

            g.fillPolygon(x_coordinates, y_coordinates, 4);
        }
    }

    private static void readCoordinates() throws IOException {
        FileReader fileReader = new FileReader("src\\SquaresCoordinates.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = bufferedReader.readLine();

        boolean flag = true;
        while (textLine != null)
        {
            String[] textCoordinates = textLine.split(" ");
            if(flag){
                Coordinates coordinates = new Coordinates(Integer.parseInt(textCoordinates[0]),
                        Integer.parseInt(textCoordinates[1]),
                        Integer.parseInt(textCoordinates[2]),
                        Integer.parseInt(textCoordinates[3]),
                        Integer.parseInt(textCoordinates[4]),
                        Integer.parseInt(textCoordinates[5]),
                        Integer.parseInt(textCoordinates[6]),
                        Integer.parseInt(textCoordinates[7]));
                _coordinates.add(coordinates);
                flag = false;
            }
            else{
                Coordinates coordinates = new Coordinates(Integer.parseInt(textCoordinates[0]),
                        Integer.parseInt(textCoordinates[1]),
                        Integer.parseInt(textCoordinates[2]),
                        Integer.parseInt(textCoordinates[3]),
                        Integer.parseInt(textCoordinates[4]),
                        Integer.parseInt(textCoordinates[5]));
                _coordinates.add(coordinates);
            }


            textLine = bufferedReader.readLine();
        }
    }
}

class Coordinates {
    public int X0, Y0, X1, Y1, X2, Y2, X3, Y3;
    //public int Wo;
    //public int Ho;

    public Coordinates(int X0, int Y0, int X1, int Y1, int X2, int Y2, int X3, int Y3) {
        this.X0 = X0;
        this.Y0 = Y0;
        this.X1 = X1;
        this.Y1 = Y1;
        this.X2 = X2;
        this.Y2 = Y2;
        this.X3 = X3;
        this.Y3 = Y3;
    }
    public Coordinates(int X0, int Y0, int X1, int Y1, int X2, int Y2) {
        this.X0 = X0;
        this.Y0 = Y0;
        this.X1 = X1;
        this.Y1 = Y1;
        this.X2 = X2;
        this.Y2 = Y2;
    }
}