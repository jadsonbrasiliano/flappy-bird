import javax.swing.*;
import java.awt.*;

public class FlappyBird extends Canvas {

    // Atributos
    private final int WIDTH = 320;
    private final int HEIGHT = 480;

    // Construtor
    public FlappyBird(){
        frame();
    }

    // Métodos
    public void frame(){

        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(dimension);

        JFrame tela = new JFrame("Flappy Bird");
        tela.add(this);
        tela.pack();
        tela.setVisible(true);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(tela.EXIT_ON_CLOSE);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public static void main(String[] args) {
        new FlappyBird();
    }
}
