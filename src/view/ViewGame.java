package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import view.components.ImageCarousel;

public class ViewGame extends JPanel {
    
    private JPanel panelGame, panelDescription;
    private JTextArea title, description; 
    private JButton btnStart;
    private ImageCarousel carousel;
    
    public ViewGame(){
        initComponents();
    }
    
    private void initComponents() {

        panelGame = new JPanel();
        setPreferredSize(new Dimension(1550, 880));
        panelGame.setBackground(new java.awt.Color(10, 38, 72));
        panelGame.setLayout(new BorderLayout());
        
        //Inicializa el carrusel y lo agrega al panelGame
        carousel = new ImageCarousel();
        panelGame.add(carousel, BorderLayout.CENTER); //Lo añadimos en la parte superior
                   
        panelDescription = new JPanel();
        panelDescription.setLayout(new BorderLayout());
        panelDescription.setPreferredSize(new Dimension(1550, 200));
        panelDescription.setBackground(new java.awt.Color(10, 38, 72));
        
        //Definir el título y descripción según el índice (simulador seleccionado), CAMBIAR FUENTE
        title = new JTextArea("Mantenimiento de los equipos y herramientas de extinción de incendios"); 
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBackground(new java.awt.Color(10, 38, 72)); //Fondo transparente
        title.setEditable(false);
        title.setBorder(BorderFactory.createEmptyBorder());
        panelDescription.add(title, BorderLayout.NORTH);
        
        description = new JTextArea("En un campo de prácticas sumido en el desorden y la confusión tienes que encontrar y colocar las partes de los EPIs utilizados en la extinción de incendios forestales");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setForeground(Color.WHITE);
        description.setBackground(new java.awt.Color(10, 38, 72)); //Fondo transparente
        description.setEditable(false);
        description.setBorder(BorderFactory.createEmptyBorder());
        panelDescription.add(description, BorderLayout.CENTER); 
        
        //Botón de inicio
        btnStart = new JButton("Comenzar");
        btnStart.setFont(new Font("Arial", Font.BOLD, 20));
        btnStart.setBackground(new Color(20, 60, 120));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFocusPainted(false);
        panelDescription.add(btnStart, BorderLayout.SOUTH);
        
        panelGame.add(panelDescription, BorderLayout.SOUTH);
        
        this.setLayout(new BorderLayout());
        this.add(panelGame, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        //new ViewGame().setVisible(true);
        // Crear la ventana y añadir ViewGame
        JFrame frame = new JFrame("Game Simulator");
        ViewGame viewGame = new ViewGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1550, 880);
        frame.setVisible(true);
        frame.add(viewGame);
    }
    
}
