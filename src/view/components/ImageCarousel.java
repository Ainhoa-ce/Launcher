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
        lArrow.setBounds(150 - margenX - 60, (525/2), 60, 30);
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
        rArrow.setBounds(150 + 891 + margenX, (525/2), 60, 30);
        // Establecer las imágenes para los botones de navegación
        rArrow.setIcon(new ImageIcon(getClass().getResource("/images/Flecha derecha.png")));
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

        // Agregar círculos para los indicadores
        updateCircles();

        // Añadir los listeners de los botones de navegación
        lArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lArrow.setPreferredSize(new Dimension(100, 100)); // Agrandar el botón
                lArrow.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lArrow.setPreferredSize(new Dimension(80, 80)); // Restaurar tamaño original
                lArrow.revalidate();
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
                rArrow.setPreferredSize(new Dimension(100, 100)); // Agrandar el botón
                rArrow.revalidate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rArrow.setPreferredSize(new Dimension(80, 80)); // Restaurar tamaño original
                rArrow.revalidate();
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
