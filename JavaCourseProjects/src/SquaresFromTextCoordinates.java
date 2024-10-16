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
            g.fillRect(_coordinates.get(i).Xo,
                    _coordinates.get(i).Yo,
                    _coordinates.get(i).Wo,
                    _coordinates.get(i).Ho);
        }
    }

    private static void readCoordinates() throws IOException {
        FileReader fileReader = new FileReader("src\\SquaresCoordinates.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = bufferedReader.readLine();
        while (textLine != null)
        {
            String[] textCoordinates = textLine.split(" ");
            Coordinates coordinates = new Coordinates(Integer.parseInt(textCoordinates[0]),
                    Integer.parseInt(textCoordinates[1]),
                    Integer.parseInt(textCoordinates[2]),
                    Integer.parseInt(textCoordinates[3]));
            _coordinates.add(coordinates);
            textLine = bufferedReader.readLine();
        }
    }
}

class Coordinates {
    public int Xo, Yo;
    public int Wo;
    public int Ho;

    public Coordinates(int X, int Y, int W, int H) {
        this.Xo = X;
        this.Yo = Y;

        this.Wo = W;
        this.Ho = H;
    }
}