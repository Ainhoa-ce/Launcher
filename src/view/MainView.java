package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainView extends javax.swing.JFrame {
    
    private ImageIcon icon;

    public MainView() {
        initComponents();

    }

    private void initComponents() {

        bgLabel = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jPanelHome = new javax.swing.JPanel();
        jPanelGame = new javax.swing.JPanel();
        
        setUndecorated(true);  //Eliminar barra de título y botones del sistema
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);  //Evitar el cierre
        setExtendedState(JFrame.MAXIMIZED_BOTH);  //Maximizar la ventana a pantalla completa
        setTitle("Launcher");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeader.setOpaque(false);
        jPanelHeader.setLayout(new GridLayout(1, 14, 5, 5));
        getContentPane().add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 1550, 130)); //Añade PanelSuperior al contenedor principal

        //Crear un arreglo de JLabel con las imágenes que quieres mostrar
        String[] imagePaths = {
            "/images/LauncherButton0.png", "/images/LauncherButton1.png",
            "/images/LauncherButton2.png", "/images/LauncherButton3.png",
            "/images/LauncherButton4.png", "/images/LauncherButton5.png",
            "/images/LauncherButton6.png", "/images/LauncherButton7.png",
            "/images/LauncherButton8.png", "/images/LauncherButton9.png",
            "/images/LauncherButton10.png", "/images/LauncherButton11.png",
            "/images/LauncherButton12.png", "/images/LauncherButton13.png"
        };

        //Crea y agrega los JLabel con las imágenes a PanelSuperior
        for (String path : imagePaths) {
            JLabel label = new JLabel();
            icon = new ImageIcon(getClass().getResource(path));
            //Ajusta la imagen al tamaño del JLabel (85x85)
            icon = new ImageIcon(icon.getImage().getScaledInstance(85, 85, java.awt.Image.SCALE_SMOOTH));

            label.setIcon(icon); //Establece la imagen en el JLabel
            label.setPreferredSize(new Dimension(85, 85));  //Establece tamaño fijo para el JLabel
            label.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel

            // Agregar el MouseListener para cambiar el estilo al pasar el mouse
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //Cambia el ícono al pasar el ratón por encima            
                    icon = new ImageIcon(getClass().getResource(path));
                    ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
                    label.setIcon(scaledIcon);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //Restaura ícono original al salir el ratón
                    icon = new ImageIcon(getClass().getResource(path));
                    icon = new ImageIcon(icon.getImage().getScaledInstance(85, 85, java.awt.Image.SCALE_SMOOTH));
                    label.setIcon(icon);
                }
                
                @Override
                public void mouseClicked(MouseEvent e){
                    //Abrir ventana a grado seleccionado. VISTA GAME
                    icon = new ImageIcon(getClass().getResource(path));
                    //showHomeView();
                }
            });

            jPanelHeader.add(label);  //Agregar el JLabel al PanelSuperior
        }

        jPanelHome.setOpaque(false);
        jPanelHome.setLayout(new BorderLayout());
        getContentPane().add(jPanelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 1550, 880));
                
        ViewHome vh = new ViewHome();
        jPanelHome.add(vh, BorderLayout.CENTER);
               
        //Fondo base
        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo base.png")));
        getContentPane().add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
                
        //Agregar jPanelGame y ocultarlo al inicio
        jPanelGame.setOpaque(false);
        getContentPane().add(jPanelGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 1550, 880));
        jPanelGame.setVisible(false); //Oculta la vista de juego al inicio
                        
        revalidate();
        repaint();

    }
    
    
    /*
    //Método para mostrar la vista de juego y ocultar la vista de inicio
    private void showGameView() {
        jPanelHome.setVisible(false);
        jPanelGame.setVisible(true);
    }

    //Método para mostrar la vista de inicio y ocultar la vista de juego
    private void showHomeView() {
        jPanelGame.setVisible(false);
        jPanelHome.setVisible(true);
    }
    */
    public static void main(String[] args) {
        new MainView().setVisible(true);
    }
    
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelGame;
}
