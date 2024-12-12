package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelHome extends javax.swing.JPanel {

    public PanelHome() {
        initComponents();
        
        //Crea un arreglo de JLabel con las imágenes a mostrar
        String[] simulatorPaths = {
            "/images/Grado0.png", "/images/Grado1.png", "/images/Grado2.png", 
            "/images/Grado3.png", "/images/Grado4.png", "/images/Grado5.png",
        };
        
        //Arreglo de labels
        JLabel[] labels = {
            jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6
        };
        
        //Recorre los labels y les asigna las imagenes correspondientes
        for (int i = 0; i < simulatorPaths.length; i++) {
            if (i < labels.length) {
                SetImageLabel(labels[i], simulatorPaths[i], 381, 291);
                
                //Añade MouseListener a cada label
                final int index = i;  //final para que funcione dentro del listener
                labels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // Cambia el ícono al pasar el ratón por encima
                        SetImageLabel(labels[index], simulatorPaths[index], 450, 350);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        //Restaura icono original al salir el ratón
                        SetImageLabel(labels[index], simulatorPaths[index], 381, 291);
                    }

                    @Override
                    public void mouseClicked(MouseEvent e){
                        //Abrir ventana a grado seleccionado. VISTA GAME
                        
                    }
                });
            }
        }
    }
    
    private void SetImageLabel(JLabel label, String path, int sizeWidth, int sizeHeight) {
        ImageIcon image = new ImageIcon(getClass().getResource(path));
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(sizeWidth, sizeHeight, java.awt.Image.SCALE_SMOOTH));
        label.setIcon(icon);
        label.setHorizontalAlignment(JLabel.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(10, 38, 72));
        setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        jLabel1.setPreferredSize(new java.awt.Dimension(381, 291));
        add(jLabel1);

        jLabel2.setPreferredSize(new java.awt.Dimension(381, 291));
        add(jLabel2);

        jLabel3.setPreferredSize(new java.awt.Dimension(381, 291));
        add(jLabel3);

        jLabel4.setPreferredSize(new java.awt.Dimension(381, 291));
        add(jLabel4);

        jLabel5.setPreferredSize(new java.awt.Dimension(381, 291));
        add(jLabel5);

        jLabel6.setPreferredSize(new java.awt.Dimension(381, 291));
        add(jLabel6);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
