package view.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ImageCarousel extends JPanel {

    private int contador = 0; //Empieza en imagen 0
    private ArrayList<String> imagePaths; //Lista de rutas de las imágenes
    ImageIcon icon;
    private JLabel rArrow, lArrow, labelImage, labelDerecho, labelIzquierdo;
    private JPanel panelCircle;

    public ImageCarousel() {
        initComponents();
    }

    public ImageCarousel(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
        initComponents();
    }

    public void initComponents() {
        setLayout(null);
        setSize(1550, 600);
        int margenX = 50; //Márgenes entre los botones y la imagen

        lArrow = new JLabel();
        lArrow.setIcon(new ImageIcon(getClass().getResource("/images/Flecha izquierda.png")));
        lArrow.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel
        lArrow.setBounds(150 - margenX - 60, (525/2), 32, 45);
        add(lArrow);

        labelIzquierdo = new JLabel();
        labelIzquierdo.setIcon(new ImageIcon(getClass().getResource("/images/Cuadrado fondo enfocado.png")));
        add(labelIzquierdo);

        //Muestra la imagen
        labelImage = new JLabel();
        labelImage.setHorizontalAlignment(JLabel.CENTER);
        labelImage.setBounds(150, 100, 900, 500);
        add(labelImage);

        labelDerecho = new JLabel();
        labelDerecho.setIcon(new ImageIcon(getClass().getResource("/images/Cuadrado fondo enfocado.png")));
        add(labelDerecho);

        rArrow = new JLabel();
        rArrow.setIcon(new ImageIcon(getClass().getResource("/images/Flecha derecha.png")));
        rArrow.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel
        rArrow.setBounds(150 + 900 + margenX, (525 / 2), 32, 45);
        add(rArrow);

        //Carga la primera imagen
        if (imagePaths != null && !imagePaths.isEmpty()) {
            icon = new ImageIcon(getClass().getResource(imagePaths.get(contador)));
            labelImage.setIcon(icon);
        }
        
        //Panel para los circulos
        panelCircle = new JPanel();
        panelCircle.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelCircle.setBounds(150, 620, 900, 50); //Debajo del carrusel
        add(panelCircle);

        //Actualiza los circulos
        updateCircles();

        lArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //Redimensiona la imagen
                ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/Flecha izquierda.png"));
                Image img = originalIcon.getImage().getScaledInstance(32, 45, Image.SCALE_SMOOTH);
                lArrow.setIcon(new ImageIcon(img));
                lArrow.revalidate();
                lArrow.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Redimensiona la imagen a su tamaño original
                ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/Flecha izquierda.png"));
                Image img = originalIcon.getImage().getScaledInstance(22, 35, Image.SCALE_SMOOTH);
                lArrow.setIcon(new ImageIcon(img));
                lArrow.revalidate();
                lArrow.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                contador--;
                if (contador < 0) {
                    contador = imagePaths.size() - 1; //Si está en la primera, va a la última
                }
                actualizarImagen();
                updateCircles();
            }
        });

        rArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //Redimensiona la imagen
                ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/Flecha derecha.png"));
                Image img = originalIcon.getImage().getScaledInstance(32, 45, Image.SCALE_SMOOTH);
                rArrow.setIcon(new ImageIcon(img));
                rArrow.revalidate();
                rArrow.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Redimensiona la imagen a su tamaño original
                ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/Flecha derecha.png"));
                Image img = originalIcon.getImage().getScaledInstance(22, 35, Image.SCALE_SMOOTH);
                rArrow.setIcon(new ImageIcon(img));
                rArrow.revalidate();
                rArrow.repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                contador++;
                if (contador >= imagePaths.size()) {
                    contador = 0; //En el final vuelve a la primera imagen
                }
                actualizarImagen();
                updateCircles();
            }
        });

    }

    private void actualizarImagen() {
        if (imagePaths != null && !imagePaths.isEmpty()) {
            icon = new ImageIcon(getClass().getResource(imagePaths.get(contador)));
            labelImage.setIcon(icon);  //Actualiza la imagen en el JLabel
        }
    }
    
    //Método para actualizar los circulos
    private void updateCircles() {
        panelCircle.removeAll(); //Elimina los circulos antiguos
        for (int i = 0; i < imagePaths.size(); i++) {
            JLabel indicator = new JLabel();
            indicator.setIcon(new ImageIcon(getClass().getResource("/images/PuntoCarruselEmpty.png")));
            if (i == contador) {
                indicator.setIcon(new ImageIcon(getClass().getResource("/images/PuntoCarruselFilled.png")));
            }
            panelCircle.add(indicator);
        }
        panelCircle.revalidate();
        panelCircle.repaint();
    }

    public static void main(String[] args) {
        ArrayList<String> imagePaths = new ArrayList<>();
        imagePaths.add("/images/Helicoptero0.png");
        imagePaths.add("/images/Helicoptero1.png");
        imagePaths.add("/images/Helicoptero2.png");
        imagePaths.add("/images/Helicoptero3.png");
        imagePaths.add("/images/Helicoptero4.png");

        // Crear el carrusel y agregarlo a una ventana
        JFrame frame = new JFrame("Carrusel de Imágenes");
        ImageCarousel carousel = new ImageCarousel(imagePaths);
        frame.setLayout(new BorderLayout());
        frame.add(carousel, BorderLayout.CENTER);
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
