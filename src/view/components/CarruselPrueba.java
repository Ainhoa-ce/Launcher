package view.components;

import java.awt.event.*;
import javax.swing.*;

public class CarruselPrueba extends JPanel implements ActionListener{
    
    JButton prev, next;
    JLabel image;
    ImageIcon icon;
    int contador = 0;//Empieza en imagen 0
    
    String[] images = {
        "/images/Embarque0.png",
        "/images/Embarque1.png",
        "/images/Embarque2.png",
        "/images/Embarque3.png",
        "/images/Embarque4.png"
    };
    
    public CarruselPrueba(){
        
        setLayout(null);
        // Calcular la coordenada Y para centrar los botones en el medio de la imagen
        int botonY = (525 / 2); // (altura de la imagen / 2 )
        // Configurar los márgenes entre los botones y la imagen
        int margenX = 50; // Márgenes entre los botones y la imagen
        
        
        
        
        prev = new JButton("<");
        prev.setBounds(150 - margenX - 60, botonY, 60, 30);
        prev.addActionListener(this);
        
        image =new JLabel();
        icon = new ImageIcon(getClass().getResource(images[contador])); // Inicializa con la imagen 0
        image.setIcon(icon);
        image.setBounds(150, 50, 891, 525);
        
        next = new JButton(">");
        next.setBounds(150 + 891 + margenX, botonY, 60, 30);
        next.addActionListener(this);
        
        
        add(prev);
        add(image);
        add(next);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == next){
            contador++;
            if (contador >= images.length) {
                contador = 0; // Si alcanza el final, vuelve a la primera imagen
            }
            
        }else if (e.getSource() == prev) {
            contador--;
            if (contador < 0) {
                contador = images.length - 1; // Si está en la primera, va a la última
            }
        }
        
        icon = new ImageIcon(getClass().getResource(images[contador]));
        image.setIcon(icon);
        
    }
    
    public static void main(String[] args) {
        
        CarruselPrueba cv = new CarruselPrueba();
        
        JFrame frame = new JFrame("Carrusel de Imagenes");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Permite cerrar la ventana
        frame.setSize(1200, 700);
        frame.add(cv);
        frame.setVisible(true);
        
    }
}
