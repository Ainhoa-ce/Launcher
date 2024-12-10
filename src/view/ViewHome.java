package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewHome extends JPanel {
    
    private JPanel panelHome;
    private ImageIcon iconHome;

    public ViewHome() {
        initComponents();
    }
                              
    private void initComponents() {

        panelHome = new JPanel();
        
        setPreferredSize(new Dimension(1550, 880));

        panelHome.setBackground(new java.awt.Color(10, 38, 72));
        panelHome.setLayout(new GridLayout(2, 3, 10, 10));
        
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
            iconHome = new ImageIcon(iconHome.getImage().getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH));

            labelHome.setIcon(iconHome); //Establece la imagen en el JLabel
            labelHome.setPreferredSize(new Dimension(400, 300));  //Establece tamaño fijo para el JLabel
            labelHome.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel
            panelHome.add(labelHome);
            
            // Agregar el MouseListener para cambiar el estilo al pasar el mouse
            labelHome.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    //Cambia el ícono al pasar el ratón por encima            
                    iconHome = new ImageIcon(getClass().getResource(path));
                    ImageIcon scaledIcon = new ImageIcon(iconHome.getImage().getScaledInstance(450, 350, java.awt.Image.SCALE_SMOOTH));
                    labelHome.setIcon(scaledIcon);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //Restaura ícono original al salir el ratón
                    iconHome = new ImageIcon(getClass().getResource(path));
                    iconHome = new ImageIcon(iconHome.getImage().getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH));
                    labelHome.setIcon(iconHome);
                }
                
                @Override
                public void mouseClicked(MouseEvent e){
                    //Abrir ventana con un indice. VISTA GAME
                    iconHome = new ImageIcon(getClass().getResource(path));
                    //showGameView(index);
                }
            });
        }
        
        //Añadir panelHome a ViewHome
        setLayout(new BorderLayout());  //Usar un layout adecuado
        add(panelHome, BorderLayout.CENTER);  //Añadir panelHome en el centro de ViewHome
                       
    }
    
    /*
    //Método para mostrar la vista de juego y ocultar la vista de inicio
        private void showGameView(index) {
            //Crea la vista Game
            ViewGame vg = new ViewGame(int index);
            jPanelHome.setVisible(false);
            jPanelGame.setVisible(true);
        }
    }
    */
    
    public static void main(String args[]) {
      new ViewHome().setVisible(true);
    }
     
                           
}

