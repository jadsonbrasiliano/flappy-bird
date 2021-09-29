import sprites.Background;
import sprites.Bird;
import sprites.Chao;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class FlappyBird extends Canvas implements Runnable{

    // Atributos
    private final Bird bird = new Bird();
    private final Chao chao = new Chao();
    private final Background background = new Background();
    private boolean gameLoop;

    // Construtor
    public FlappyBird(){
        gameLoop = true;
        frame();
    }

    // Métodos
    public void frame(){

        this.setPreferredSize(new Dimension(320, 480));

        JFrame tela = new JFrame("Flappy Bird");
        tela.add(this);
        tela.pack();
        tela.setVisible(true);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(tela.EXIT_ON_CLOSE);
    }

    public void update() {
        chao.movimentar();
        bird.movimentar();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        background.draw(g);
        chao.draw(g);
        bird.draw(g);

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        while(gameLoop){
            update();
            render();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new FlappyBird()).start();
    }
}
