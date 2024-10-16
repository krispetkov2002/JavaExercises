import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
    2.10 Да се състави Applet или Application на Java, имащ следната функционалност:
	1) дава възможност за поставяне на 2 точки с помощта на мишката (щракване с левия бутон, точката е окръжност
	с радиус 5 пиксела) и изчертава квадрат с диагонал 2-те точки.
	2) при щракване с мишката вътре в квадрата той сменя цвета си, а вън от него - не.
*/

public class SquareChangeColor extends JFrame implements MouseListener{

    boolean flag = true;
    static int[] x = new int[2];
    static int[] y = new int[2];
    int n = 0, r = 5;

    Color[] _colors = new Color[] { Color.RED, Color.BLUE};
    int _currentIndex = 0; //SET COLOR TO RED

    SquareChangeColor() {
        setSize(600, 400);
        setLocation(200, 100);
        setBackground(Color.LIGHT_GRAY);
        addWindowListener(new WindowClosingAdapter(true));
        addMouseListener(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        SquareChangeColor win = new SquareChangeColor();
    }

    private static Boolean MouseIsInCircle(int mouseX, int mouseY){
        return mouseX >= x[0] && mouseX <= x[1] &&
                mouseY >= y[0] && mouseY <= y[1];
    }

    @Override
    public void paint(Graphics g) {
        int[] x_coordinates = new int[2];
        int[] y_coordinates = new int[2];

        if(flag) {
            g.setColor(Color.BLACK);

            for (int i = 0; i < n; i++) {
                //Начертаване на двете точки
                g.fillOval(x[i] - r, y[i] - r, 2*r, 2*r);
                x_coordinates[i] = x[i] - r;
                y_coordinates[i] = y[i] - r;
            }

            //Начертаване на квадрата
            if(n >= 2){
                g.setColor(_colors[_currentIndex]); // RETURN RED
                int d_Width = x_coordinates[1] - x_coordinates[0];
                int d_Height = y_coordinates[1] - y_coordinates[0];

                g.fillRect(x_coordinates[0] + r, y_coordinates[0] + r,
                        d_Width, d_Height);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!MouseIsInCircle(e.getX(), e.getY())){
            return;
        }
        _currentIndex++;
        if(_currentIndex >= _colors.length){
            _currentIndex = 0;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1 && n < 2) {
            x[n] = e.getX();
            y[n] = e.getY();
            n++;}
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
