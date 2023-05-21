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
import javax.swing.JLabel;



public class GUI
{
    //Declared components
    static JFrame frame;
    static JPanel TotalGUI, northP, southP, eastP, centerP, westP;
    private JLabel timeLabel;





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

        ButtonGroup JbuttonGroup = new ButtonGroup();
        JButton buttons;
        JbuttonGroup.add(buttons = new JButton("AYUDA"));
        left.add(buttons);
        buttons.setFont(buttons.getFont().deriveFont(Font.BOLD, 16)); // Cambia el tamaño de la fuente
        buttons.setBackground(Color.PINK); // Cambia el color de fondo
        left.add(Box.createVerticalStrut(10));

        JbuttonGroup.add(buttons = new JButton("NUEVA PARTIDA"));
        buttons.setFont(buttons.getFont().deriveFont(Font.BOLD, 16)); // Cambia el tamaño de la fuente
        buttons.setBackground(Color.GREEN); // Cambia el color de fondo
        left.add(buttons);
        left.add(Box.createVerticalStrut(10));

        JbuttonGroup.add(buttons = new JButton("SALIR"));
        left.add (left.add(buttons));
        buttons.setFont(buttons.getFont().deriveFont(Font.BOLD, 16)); // Cambia el tamaño de la fuente
        buttons.setBackground(Color.RED); // Cambia el color de fondo
        left.add(Box.createVerticalStrut(10));
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


        /**CENTER PANEL*/

        centerP = new JPanel();
        centerP.setBorder(new TitledBorder(new EtchedBorder(), "TABLERO"));
        TotalGUI.add(centerP, BorderLayout.CENTER);


        TotalGUI.setOpaque(true);
        return(TotalGUI);
    }
    //Main method calling a new object of
    public static void main(String[] args)
    {
        new GUI();
    }
}



//RICH JLABEL CLASS
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


