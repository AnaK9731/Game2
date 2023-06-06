package myProject;//imported libraries for the GUI
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;
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
import javax.swing.JLabel;

public class GUI {
    //Declared components
    private int estado= 0;
    private Timer timer, timerPalabras;
    private String wordJtexArea;
    private int contadorAGanar=0;
    static JFrame frame;
    static JPanel TotalGUI, northP, southP, centerP, westP;
    private JLabel timeLabel;
    private JButton buttonNew, buttonYes,  buttonNo;
    private JButton buttonAyuda, buttonSalir;

    //Create listener object and control object
    private Escucha escucha;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private int option;
    private String alias;

    private int counter, segundos;
    private modelGame modelGame;
    private List<String> wordToWin, ShowWords;
    private int stopTimer=0, stopTimerAganar=0;
    private int i = 0;
    private int nivel = 1;

    //Frame method
    public GUI() {
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
        int fx = (dim.width - fw) / 2;
        int fy = (dim.height - fh) / 2;

        //moves the frame
        frame.setLocation(fx, fy);
    }

    public JPanel create_Content_Pane() {

        //Create listener object and control object

        escucha = new Escucha();

        //Falta el objeto de modelGame.
        modelGame = new modelGame();

        //Inicia el timer
        timerPalabras = new Timer(1000,escucha);
        timerPalabras.setInitialDelay(0);
        timer = new Timer(10, escucha);
        timer.setInitialDelay(0);

        //Creando un JtextArea
        textArea = new JTextArea();
        textArea.setRows(5); // Establece el número de filas visibles
        textArea.setColumns(20); // Establece el número de columnas visibles

        scrollPane = new JScrollPane(textArea);

        TotalGUI = new JPanel(new GridLayout(2, 2));
        TotalGUI.setLayout(new BorderLayout(2, 2));  //set layout for the Container Pane
        northP = new JPanel();
        TotalGUI.add(northP, BorderLayout.NORTH);

        RichJLabel label = new RichJLabel("I KNOW THAT WORD");
        label.setLeftShadow(1, 1, Color.black);
        label.setRightShadow(1, 1, Color.gray);
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

        buttonAyuda = new JButton("AYUDA");
        buttonAyuda.setFont(buttonAyuda.getFont().deriveFont(Font.BOLD, 16));
        buttonAyuda.setBackground(Color.PINK);
        buttonAyuda.addActionListener(escucha);
        buttonGroup.add(buttonAyuda);
        left.add(buttonAyuda);
        left.add(Box.createVerticalStrut(10));

        buttonNew = new JButton("NUEVA PARTIDA");
        buttonNew.setFont(buttonNew.getFont().deriveFont(Font.BOLD, 16));
        buttonNew.setBackground(Color.GREEN);
        buttonNew.addActionListener(escucha);
        buttonGroup.add(buttonNew);
        left.add(buttonNew);
        left.add(Box.createVerticalStrut(10));

        buttonSalir = new JButton("SALIR");
        buttonSalir.addActionListener(escucha);
        buttonSalir.setFont(buttonSalir.getFont().deriveFont(Font.BOLD, 16));
        buttonSalir.setBackground(Color.red);
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

        //TABLERO
        centerP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerP.setBorder(new TitledBorder(new EtchedBorder(), "TABLERO"));



        buttonYes = new JButton("SI");
        buttonYes.setFont(buttonNew.getFont().deriveFont(Font.BOLD, 66));
        buttonYes.setBackground(Color.GREEN);
        buttonYes.addActionListener(escucha);
        centerP.add(buttonYes); // Agregar el botón "SI"

        buttonNo = new JButton("NO"); // Corregir el nombre del botón a "buttonNo"
        buttonNo.setFont(buttonNew.getFont().deriveFont(Font.BOLD, 63));
        buttonNo.setBackground(Color.RED);
        buttonNo.addActionListener(escucha);
        centerP.add(buttonNo); // Agregar el botón "NO"

       TotalGUI.add(centerP, BorderLayout.CENTER);



        TotalGUI.setOpaque(true);
        return (TotalGUI);
    }
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==buttonYes){
                wordJtexArea = textArea.getText();
                if (wordToWin.contains(wordJtexArea)) {
                    System.out.println("La palabra '" + wordJtexArea + "' está en la lista de palabras elegidas.");

                }
            }
            if (e.getSource()==buttonNo){
                    wordJtexArea = textArea.getText();
                    if (wordToWin.contains(wordJtexArea)){
                        JOptionPane.showMessageDialog(null,"La palabra '" + wordJtexArea + "' Si está en la lista de palabras elegidas.");
                        // Realiza la acción que deseas cuando la palabra NO está en la lista
                    }
            }
            if (e.getSource() == buttonAyuda) {
                VentanaAyuda ventanaAyuda = new VentanaAyuda();
                // Muestra la ventana de ayuda
                ventanaAyuda.setVisible(true);
            }
            if (e.getSource() == timer) {
                if (counter < 5) {
                    counter++;// Incrementa el contador cada segundo
                    //updateTimerLabel(); // Actualiza la etiqueta del cronómetro
                    timeLabel.setText("00:00:0" + Integer.toString(counter));
                    wordToWin = modelGame.getPalabrasElegidas();
                    if (counter==1){
                        while ( i < wordToWin.size() ) {
                            String palabra = wordToWin.get(i);
                            /**System.out.println("Palabra en la posición " + i + ": " + palabra);
                             // Realiza cualquier acción adicional que necesites con la palabra en esta posición*/
                            textArea.setText(palabra.toString());
                            textArea.setForeground(Color.BLACK);
                            textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
                            textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
                            textArea.setBackground(null); // Establecer el fondo como transparente
                            textArea.setEditable(false); // Deshabilitar la edición del JTextArea
                            textArea.setPreferredSize(new Dimension(200, 100)); // Establecer un tamaño preferido para el JTextArea
                            centerP.add(textArea); // Agregar el área de texto

                            stopTimer++;

                            i++;
                            break;
                        }
                    }
                    if (stopTimer== wordToWin.size()){
                        if (counter==5){
                            estado=1;
                            timer.stop();
                            i = 0;
                            JOptionPane.showMessageDialog(null,"PREPARATE PARA SELECCIONAR SI O NO.");
                            timerPalabras.start();
                        }
                    }
                    if (counter >4){
                        //revalidar y pintar ocn el counter pasado los 5
                        centerP.revalidate(); // Actualizar el diseño del panel
                        centerP.repaint();
                    }
                }
                else if (counter==5) {
                    counter=0;
                }
            }
            //Iniciando a mostrar las palabras aleatorias para que seleccione las correctas.
            if (estado==1){
                if (e.getSource() == timerPalabras) {
                    if (segundos < 5) {
                        segundos++;// Incrementa el contador cada segundo
                        timeLabel.setText("00:00:0" + Integer.toString(segundos));
                        ShowWords = modelGame.getPalabrasAleatorias();
                        if (segundos==1){
                            while ( i < ShowWords.size() ) {
                                String palabra = ShowWords.get(i);
                                /**System.out.println("Palabra en la posición " + i + ": " + palabra);
                                 // Realiza cualquier acción adicional que necesites con la palabra en esta posición*/
                                textArea.setText(palabra.toString());
                                textArea.setForeground(Color.BLACK);
                                textArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
                                textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
                                centerP.add(textArea); // Agregar el área de texto
                                stopTimerAganar++;
                                i++;
                                break;
                            }
                        }
                        if (stopTimerAganar== ShowWords.size()){
                            if (counter==5){
                                estado=0;
                                timerPalabras.stop();
                            }
                        }
                        if (counter >4){
                            //revalidar y pintar ocn el counter pasado los 5
                            centerP.revalidate(); // Actualizar el diseño del panel
                            centerP.repaint();
                        }
                    } else if (segundos==5) {
                        segundos=0;
                    }
                }
            }
            else if (e.getSource() == buttonNew) {
                option = JOptionPane.showOptionDialog(null, scrollPane, "Introduce Un Alias", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (option == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null, "Memoriza las palabras");
                    alias = textArea.getText();
                    centerP.setBorder(new TitledBorder(new EtchedBorder(), alias + ". Nivel " + nivel));
                    buttonNew.removeActionListener(escucha);
                    timer.start(); // Inicia el cronómetro cuando se presiona OK
                    System.out.println(modelGame.leerTxt("C:\\Users\\Usuario\\Desktop\\Game2\\WordsGame\\src\\recursos\\palabras.txt"));
                    modelGame.niveles();
                    wordToWin = modelGame.getPalabrasElegidas();
                }
            }
            if (e.getSource() == buttonSalir) {
                System.exit(0);
                buttonNew.addActionListener(escucha);
            }
        }
    }
    public class VentanaAyuda extends JFrame {
        public VentanaAyuda() {
            // Configura la ventana de ayuda
            setTitle("Ventana de Ayuda");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null); // Centra la ventana en la pantalla
            JTextArea textArea = new JTextArea("El juego consiste en presentar al jugador\nuna secuencia de palabras de una en una, es\ndecir, aparece una palabra,\ndura 5 segundos en pantalla, luego se borra y aparece la\nsiguiente.");
            textArea.setLineWrap(true); // Activa el ajuste de línea automático
            textArea.setWrapStyleWord(true); // Ajusta palabras completas en lugar de dividirlas
            textArea.setEditable(false);
            getContentPane().add(textArea);
        }
    }



    //Main method calling a new object of
    public static void main(String[] args) {
        new GUI();
    }


    //JLABEL CLASSs
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
}

