package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import view.components.ImageCarousel;

public class PanelGame extends javax.swing.JPanel {
    
    private int contador = 0; //Empieza en imagen 0
    private ArrayList<String> imagePaths; //Lista de rutas de las imágenes
    private ImageIcon icon;
    

    public PanelGame(ArrayList<String> imagePaths) {
        initComponents();
        this.imagePaths = imagePaths;
                
        lArrow.setIcon(new ImageIcon(getClass().getResource("/images/Flecha izquierda.png")));
        lArrow.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel
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
        
        rArrow.setIcon(new ImageIcon(getClass().getResource("/images/Flecha derecha.png")));
        rArrow.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel
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
        
        labelImage.setHorizontalAlignment(JLabel.CENTER);
        labelIzquierdo.setIcon(new ImageIcon(getClass().getResource("/images/Cuadrado fondo enfocado.png")));
        labelIzquierdo.setHorizontalAlignment(JLabel.LEFT);
        labelDerecho.setIcon(new ImageIcon(getClass().getResource("/images/Cuadrado fondo enfocado.png")));
        labelDerecho.setHorizontalAlignment(JLabel.RIGHT);
        
        panelCircles.setBackground(new Color(10, 38, 72));
        panelCircles.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        //Actualiza los circulos
        updateCircles();
        
        //Carga la primera imagen
        if (imagePaths != null && !imagePaths.isEmpty()) {
            icon = new ImageIcon(getClass().getResource(imagePaths.get(contador)));
            labelImage.setIcon(icon);
        }
    }
    
    private void actualizarImagen() {
        if (imagePaths != null && !imagePaths.isEmpty()) {
            icon = new ImageIcon(getClass().getResource(imagePaths.get(contador)));
            
            //Escala la imagen para que se ajuste al tamaño del label
            Image img = icon.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
            labelImage.setIcon(icon);  //Actualiza la imagen en el JLabel
        }
    }
    
    //Método para actualizar los circulos
    private void updateCircles() {
        panelCircles.removeAll(); //Elimina los circulos antiguos
        for (int i = 0; i < imagePaths.size(); i++) {
            JLabel indicator = new JLabel();
            indicator.setIcon(new ImageIcon(getClass().getResource("/images/PuntoCarruselEmpty.png")));
            if (i == contador) {
                indicator.setIcon(new ImageIcon(getClass().getResource("/images/PuntoCarruselFilled.png")));
            }
            panelCircles.add(indicator);
        }
        panelCircles.revalidate();
        panelCircles.repaint();
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCarousel = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        panelCircles = new javax.swing.JPanel();
        lArrow = new javax.swing.JLabel();
        rArrow = new javax.swing.JLabel();
        labelDerecho = new javax.swing.JLabel();
        labelIzquierdo = new javax.swing.JLabel();
        panelDescription = new javax.swing.JPanel();

        setBackground(new java.awt.Color(10, 38, 72));

        panelCarousel.setOpaque(false);
        panelCarousel.setPreferredSize(new java.awt.Dimension(1550, 600));

        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelCirclesLayout = new javax.swing.GroupLayout(panelCircles);
        panelCircles.setLayout(panelCirclesLayout);
        panelCirclesLayout.setHorizontalGroup(
            panelCirclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        panelCirclesLayout.setVerticalGroup(
            panelCirclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        lArrow.setText("jLabel1");
        lArrow.setPreferredSize(new java.awt.Dimension(32, 45));

        rArrow.setText("jLabel2");
        rArrow.setPreferredSize(new java.awt.Dimension(32, 45));

        labelDerecho.setText("jLabel1");
        labelDerecho.setPreferredSize(new java.awt.Dimension(50, 400));

        labelIzquierdo.setText("jLabel1");
        labelIzquierdo.setPreferredSize(new java.awt.Dimension(50, 400));

        javax.swing.GroupLayout panelCarouselLayout = new javax.swing.GroupLayout(panelCarousel);
        panelCarousel.setLayout(panelCarouselLayout);
        panelCarouselLayout.setHorizontalGroup(
            panelCarouselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarouselLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCarouselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCarouselLayout.createSequentialGroup()
                        .addComponent(lArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(labelIzquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(rArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCarouselLayout.createSequentialGroup()
                        .addComponent(panelCircles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(709, 709, 709))))
        );
        panelCarouselLayout.setVerticalGroup(
            panelCarouselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarouselLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelCarouselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lArrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rArrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDerecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelIzquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCircles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        panelDescription.setPreferredSize(new java.awt.Dimension(1550, 380));

        javax.swing.GroupLayout panelDescriptionLayout = new javax.swing.GroupLayout(panelDescription);
        panelDescription.setLayout(panelDescriptionLayout);
        panelDescriptionLayout.setHorizontalGroup(
            panelDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1633, Short.MAX_VALUE)
        );
        panelDescriptionLayout.setVerticalGroup(
            panelDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCarousel, javax.swing.GroupLayout.DEFAULT_SIZE, 1633, Short.MAX_VALUE)
            .addComponent(panelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 1633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCarousel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public static void main(String[] args) {
        // Crear una lista de rutas de imágenes
        ArrayList<String> imagePaths = new ArrayList<>();
        imagePaths.add("/images/ascensor0.png");
        imagePaths.add("/images/ascensor1.png");
        imagePaths.add("/images/ascensor2.png");
        imagePaths.add("/images/ascensor3.png");
        imagePaths.add("/images/ascensor4.png");
        
        // Crear el JFrame y agregar el PanelGame
        JFrame frame = new JFrame("Panel Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.add(new PanelGame(imagePaths)); // Agregar el PanelGame
        frame.setVisible(true); // Mostrar el JFrame
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lArrow;
    private javax.swing.JLabel labelDerecho;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelIzquierdo;
    private javax.swing.JPanel panelCarousel;
    private javax.swing.JPanel panelCircles;
    private javax.swing.JPanel panelDescription;
    private javax.swing.JLabel rArrow;
    // End of variables declaration//GEN-END:variables
}
