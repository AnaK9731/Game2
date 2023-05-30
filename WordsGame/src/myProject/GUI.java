package myProject;//imported libraries for the GUI
import javax.swing.*;
import javax.swing.border.*;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.Timer;

//Rich JLabel

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLOutput;
import javax.swing.JLabel;



public class GUI
{
    //Declared components
    static JFrame frame;
    static JPanel TotalGUI, northP, southP, centerP, westP;
    private JLabel timeLabel;
    private JButton buttonAyuda;

    //Create listener object and control object
    private Escucha escucha = new Escucha();





    //Frame method
    public GUI()
    {
        frame = new JFrame("JUEGUITO 1.0");
        frame.setExtendedState(frame.NORMAL);

        frame.getContentPane().add(create_Content_Pane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700); //Size of main window
        frame.setVisible(true);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Cambia de tamaño la pantalla

        // gets & sets frame size/location
        int fw = frame.getSize().width;
        int fh = frame.getSize().height;
        int fx = (dim.width-fw)/2;
        int fy = (dim.height-fh)/2;

        //moves the frame
        frame.setLocation(fx, fy);
    }

    public JPanel create_Content_Pane()
    {
        TotalGUI = new JPanel(new GridLayout(2,2));
        TotalGUI.setLayout(new BorderLayout(2,2));  //set layout for the Container Pane
        northP = new JPanel();
        TotalGUI.add(northP, BorderLayout.NORTH);

        RichJLabel label = new RichJLabel("I KNOW THAT WORD");
        label.setLeftShadow(1,1,Color.black);
        label.setRightShadow(1,1,Color.gray);
        label.setForeground(Color.ORANGE);
        label.setFont(label.getFont().deriveFont(68f));

        Box top = Box.createHorizontalBox();
        top.add(Box.createHorizontalStrut(10));
        top.add(Box.createHorizontalStrut(10));
        top.add(label);
        northP.add(top);


        /**WEST Panel*/

        westP = new JPanel();
        westP.setBorder(new TitledBorder(new EtchedBorder(), "PANEL DE JUEGO"));
        TotalGUI.add(westP, BorderLayout.WEST);

        Box left = Box.createVerticalBox();
        left.add(Box.createVerticalStrut(10));
        left.add(Box.createHorizontalStrut(80));

        ButtonGroup buttonGroup = new ButtonGroup();

        JButton buttonAyuda = new JButton("AYUDA");
        buttonAyuda.setFont(buttonAyuda.getFont().deriveFont(Font.BOLD, 16));
        buttonAyuda.setBackground(Color.PINK);
        buttonAyuda.addActionListener(escucha);
        buttonGroup.add(buttonAyuda);
        left.add(buttonAyuda);
        left.add(Box.createVerticalStrut(10));

        JButton buttonNew = new JButton("NUEVA PARTIDA");
        buttonNew.setFont(buttonNew.getFont().deriveFont(Font.BOLD, 16));
        buttonNew.setBackground(Color.GREEN);
        buttonGroup.add(buttonNew);
        left.add(buttonNew);
        left.add(Box.createVerticalStrut(10));

        JButton buttonSalir = new JButton("SALIR");
        buttonSalir.setFont(buttonSalir.getFont().deriveFont(Font.BOLD, 16));
        buttonSalir.setBackground(Color.getHSBColor(250, 14, 52));
        buttonSalir.addActionListener(escucha);
        buttonGroup.add(buttonSalir);
        left.add(buttonSalir);

        westP.add(left);


        /**SOUTH PANEL-CRONOMETRO*/

        southP = new JPanel();
        southP.setBorder(new TitledBorder(new EtchedBorder(), "CRONOMETRO"));
        TotalGUI.add(southP, BorderLayout.SOUTH);

        timeLabel = new JLabel("00:00:00");
        left.add(Box.createVerticalStrut(850));
        timeLabel.setFont(timeLabel.getFont().deriveFont(Font.BOLD, 60));
        timeLabel.setForeground(Color.RED);
        southP.add(timeLabel);


        /**CENTER PANEL-tablero*/

        centerP = new JPanel();
        centerP.setBorder(new TitledBorder(new EtchedBorder(), "TABLERO"));


        TotalGUI.add(centerP, BorderLayout.CENTER);


        TotalGUI.setOpaque(true);
        return(TotalGUI);

    }
    private class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            VentanaAyuda ventanaAyuda = new VentanaAyuda();
            // Muestra la ventana de ayuda
            ventanaAyuda.setVisible(true);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

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

    public class VentanaAyuda extends JFrame {
        public VentanaAyuda() {
            /**Configura la ventana de ayuda
            setTitle("Ventana de Ayuda");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null); // Centra la ventana en la pantalla
            JTextArea textArea = new JTextArea("El juego consiste en presentar al jugador\nuna secuencia de palabras de una en una, es\ndecir, aparece una palabra,\ndura 5 segundos en pantalla, luego se borra y aparece la\nsiguiente.");
            textArea.setLineWrap(true); // Activa el ajuste de línea automático
            textArea.setWrapStyleWord(true); // Ajusta palabras completas en lugar de dividirlas

            getContentPane().add(textArea);*/

        }
    }

    //Main method calling a new object of
    public static void main(String[] args)
    {
        new GUI();
    }
}



//JLABEL CLASS
class RichJLabel extends JLabel {
    private int tracking;

    public RichJLabel(String text) {
        super(text);
        this.tracking = tracking;
    }

    private int left_x, left_y, right_x, right_y;
    private Color left_color, right_color;

    public void setLeftShadow(int x, int y, Color color) {
        left_x = x;
        left_y = y;
        left_color = color;
    }

    public void setRightShadow(int x, int y, Color color) {
        right_x = x;
        right_y = y;
        right_color = color;
    }

    public Dimension getPreferredSize() {
        String text = getText();
        FontMetrics fm = this.getFontMetrics(getFont());

        int w = fm.stringWidth(text);
        w += (text.length()) * tracking;
        w += left_x + right_x;
        int h = fm.getHeight();
        h += left_y + right_y;

        return new Dimension(w, h);
    }

    public void paintComponent(Graphics g) {
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        char[] chars = getText().toCharArray();

        FontMetrics fm = this.getFontMetrics(getFont());

        int h = fm.getAscent();
        int x = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int w = fm.charWidth(ch) + tracking;

            g.setColor(left_color);
            g.drawString("" + chars[i], x - left_x, h - left_y);

            g.setColor(right_color);
            g.drawString("" + chars[i], x + right_x, h + right_y);

            g.setColor(this.getForeground());
            g.drawString("" + chars[i], x, h);

            x += w;
        }
    }
}



