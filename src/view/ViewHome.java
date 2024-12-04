package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewHome extends javax.swing.JFrame {
    
    public MainView vistaPrincipal;
    public ImageIcon iconHome;

    public ViewHome() {
        initComponents();
    }
                          
    private void initComponents() {

        panelHome = new JPanel();
        jLabel1 = new JLabel();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home");
        setUndecorated(true);
        setSize(1550, 880);

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
            iconHome = new ImageIcon(iconHome.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH));

            labelHome.setIcon(iconHome); //Establece la imagen en el JLabel
            labelHome.setPreferredSize(new Dimension(120, 120));  //Establece tamaño fijo para el JLabel
            labelHome.setHorizontalAlignment(JLabel.CENTER); //Centra la imagen dentro del JLabel
            panelHome.add(labelHome);
        }
        // Agregar el JPanel al JFrame
        getContentPane().add(panelHome);
        
        // Hacer visible la ventana
        setVisible(true);
       
        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1550, Short.MAX_VALUE)
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );

        getContentPane().add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 880));

        //pack();
    }

    public static void main(String args[]) {
       new ViewHome().setVisible(true);
    }
                       
    private javax.swing.JPanel panelHome;
    private javax.swing.JLabel jLabel1;
                           
}

