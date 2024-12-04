package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainView extends javax.swing.JFrame {
    
    private ImageIcon icon, iconHome;

    public MainView() {
        initComponents();

    }

    private void initComponents() {

        bgLabel = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jPanelHome = new javax.swing.JPanel();
        jPanelGame = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setUndecorated(true);  //Eliminar barra de título y botones del sistema
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);  //Evitar el cierre
        setExtendedState(JFrame.MAXIMIZED_BOTH);  //Maximizar la ventana a pantalla completa
        setTitle("Launcher");
        setSize(1920, 1080);
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
                    ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
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
        jPanelHome.setLayout(new GridLayout(2, 3, 10, 10));
        getContentPane().add(jPanelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 1550, 880));
        
        //Agregar miniaturas de los simuladores al JPanelHome
        String[] simulatorPaths = {
            "/images/Grado0.png", "/images/Grado1.png", "/images/Grado2.png", 
            "/images/Grado3.png", "/images/Grado4.png", "/images/Grado5.png",
        };
        
        //Crea y agrega los JLabel con las imágenes a JPanelHome
        for (String path : simulatorPaths) {
            JLabel labelHome = new JLabel();
            iconHome = new ImageIcon(getClass().getResource(path));
                
            //Ajusta la imagen al tamaño del JLabel
            iconHome = new ImageIcon(iconHome.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));

            labelHome.setIcon(iconHome); //Establece la imagen en el JLabel
            labelHome.setPreferredSize(new Dimension(120, 120));  //Establece tamaño fijo para el JLabel
            labelHome.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel

            // Agregar el MouseListener para cambiar el estilo al pasar el mouse
            labelHome.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //Cambia el ícono al pasar el ratón por encima            
                    iconHome = new ImageIcon(getClass().getResource(path));
                    ImageIcon scaledIcon = new ImageIcon(iconHome.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
                    labelHome.setIcon(scaledIcon);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //Restaura ícono original al salir el ratón
                    iconHome = new ImageIcon(getClass().getResource(path));
                    iconHome = new ImageIcon(iconHome.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));
                    labelHome.setIcon(iconHome);
                }
                
                @Override
                public void mouseClicked(MouseEvent e){
                    //Abrir ventana a grado seleccionado. VISTA GAME
                    iconHome = new ImageIcon(getClass().getResource(path));
                    //showGameView();
                }
            });
            jPanelHome.add(labelHome);
            System.out.println("Miniatura añadida: " + path);
            jPanelHome.setBorder(BorderFactory.createLineBorder(Color.RED)); //Temporal
            labelHome.setBorder(BorderFactory.createLineBorder(Color.RED)); //Temporal 
        }
        
        
        //Fondo base
        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo base.png")));
        getContentPane().add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
                
        //Agregar jPanelGame y ocultarlo al inicio
        jPanelGame.setOpaque(false);
        getContentPane().add(jPanelGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 1550, 880));
        jPanelGame.setVisible(false); //Al principio, la vista de juego está oculta

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1550, Short.MAX_VALUE)
        );
        jPanelHomeLayout.setVerticalGroup(
                jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 880, Short.MAX_VALUE)
        );

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
}
