package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Crea un arreglo de JLabel con las imágenes a mostrar
        String[] imagePaths = {
            "/images/LauncherButton0.png", "/images/LauncherButton1.png",
            "/images/LauncherButton2.png", "/images/LauncherButton3.png",
            "/images/LauncherButton4.png", "/images/LauncherButton5.png",
            "/images/LauncherButton6.png", "/images/LauncherButton7.png",
            "/images/LauncherButton8.png", "/images/LauncherButton9.png",
            "/images/LauncherButton10.png", "/images/LauncherButton11.png",
            "/images/LauncherButton12.png", "/images/LauncherButton13.png"
        };
        
        //Arreglo de labels
        JLabel[] labels = {
            jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7,
            jLabel8, jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14
        };
        
        //Recorre los labels y les asigna las imagenes correspondientes
        for (int i = 0; i < imagePaths.length; i++) {
            if (i < labels.length) {
                SetImageLabel(labels[i], imagePaths[i], 85);
                
                //Añade MouseListener a cada label
                final int index = i;  //final para que funcione dentro del listener
                labels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // Cambia el ícono al pasar el ratón por encima
                        SetImageLabel(labels[index], imagePaths[index], 100);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        //Restaura icono original al salir el ratón
                        SetImageLabel(labels[index], imagePaths[index], 85);
                    }

                    @Override
                    public void mouseClicked(MouseEvent e){
                        //Abrir ventana a grado seleccionado. VISTA HOME
                        
                    }
                });
            }
        }
        
        PanelHome ph = new PanelHome();
        panelHome.add(ph, BorderLayout.CENTER);
        //panelHome.setVisible(false);
        
        //PanelGame pg = new PanelGame();
        //panelGame.add(pg, BorderLayout.CENTER);
        //panelGame.setVisible(false); //Oculta la vista de juego al inicio
        
    }

    @SuppressWarnings("unchecked")

    private void SetImageLabel(JLabel label, String path, int size) {
        ImageIcon image = new ImageIcon(getClass().getResource(path));
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
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
        panelHome = new javax.swing.JPanel();
        panelGame = new javax.swing.JPanel();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setMaximumSize(new java.awt.Dimension(1550, 128));
        headerPanel.setMinimumSize(new java.awt.Dimension(1550, 128));
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new java.awt.GridLayout(1, 14, 5, 5));

        jLabel1.setMaximumSize(new java.awt.Dimension(85, 85));
        jLabel1.setMinimumSize(new java.awt.Dimension(85, 85));
        jLabel1.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel1);

        jLabel2.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel2);

        jLabel3.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel3);

        jLabel4.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel4);

        jLabel5.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel5);

        jLabel6.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel6);

        jLabel7.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel7);

        jLabel8.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel8);

        jLabel9.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel9);

        jLabel10.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel10);

        jLabel11.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel11);

        jLabel12.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel12);

        jLabel13.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel13);

        jLabel14.setPreferredSize(new java.awt.Dimension(85, 85));
        headerPanel.add(jLabel14);

        getContentPane().add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 1550, 128));

        panelHome.setOpaque(false);
        panelHome.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 1550, 880));

        panelGame.setOpaque(false);
        panelGame.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 1550, 880));

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Fondo base.png"))); // NOI18N
        getContentPane().add(bgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelHome;
    // End of variables declaration//GEN-END:variables
}
