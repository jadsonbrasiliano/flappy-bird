import sprites.Background;
import sprites.Bird;
import sprites.Canos;
import sprites.Chao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class FlappyBird extends Canvas implements Runnable, MouseListener {

    // Atributos
    private final Bird bird = new Bird();
    private final Chao chao = new Chao();
    private final Background background = new Background();
    private final Canos[] canos = { new Canos(), new Canos(), new Canos(), new Canos() };
    private boolean gameLoop;

    // Construtor
    public FlappyBird(){
        gameLoop = true;
        frame();
        this.addMouseListener(this);
    }

    // Métodos
    public void frame(){

        this.setPreferredSize(new Dimension(320, 480));

        JFrame frame = new JFrame("Flappy Bird");
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void update() {
        chao.movimentar();
        bird.gravidade();
        for (Canos cano : canos){ cano.movimentar(canos); }
        colisao();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        background.draw(g);
        for(Canos cano : canos){ cano.draw(g); }
        chao.draw(g);
        bird.draw(g);

        g.dispose();
        bs.show();
    }

    public void colisao(){

        // Colisão com o chão
        if (bird.getDy2() == chao.getDy1()){
            gameLoop = false;
        }

        // Colisão com o cano
        for(Canos cano : canos){

            // Colisão com o cano de cima
            if (bird.getDx1() > cano.getSdx1() && bird.getDx1() <= cano.getSdx2()
                    || bird.getDx2()-4 > cano.getSdx1() && bird.getDx2() <= cano.getSdx2()) {

                if (bird.getDy1() < cano.getSdy2()){
                    System.out.println("O bird colidiu com a parte de cima");
                    gameLoop = false;
                }
            }

            // Colisão com o cano de baixo
            if (bird.getDx1() > cano.getDx1() && bird.getDx1() <= cano.getDx2()
                    || bird.getDx2() > cano.getDx1() && bird.getDx2() <= cano.getDx2()) {

                if (bird.getDy2() > cano.getDy1()+2){
                    System.out.println("O bird colidiu com a parte de baixo");
                    gameLoop = false;
                }
            }
        }
    }

    @Override
    public void run() {
        while(gameLoop){
            update();
            render();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new FlappyBird()).start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int keyCode = e.getButton();
        if (keyCode == MouseEvent.BUTTON1){ bird.pular(); }
    }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
