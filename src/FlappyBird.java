import sprites.objetos.Background;
import sprites.objetos.Bird;
import sprites.objetos.Canos;
import sprites.objetos.Chao;
import sprites.telas.GameOver;
import sprites.telas.GetReady;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class FlappyBird extends Canvas implements Runnable, MouseListener {

    // Atributos
    private final Bird bird = new Bird();
    private final Chao chao = new Chao();
    private final Background background = new Background();
    private final Canos[] canos = { new Canos(), new Canos(), new Canos(), new Canos() };

    private final GetReady getReady = new GetReady();
    private final GameOver gameOver = new GameOver();

    private int frames;
    private final boolean gameLoop;
    private boolean telaGetReady;
    private boolean telaGameOver;

    // Construtor
    public FlappyBird(){
        gameLoop = true;
        telaGetReady = true;
        frame();
        this.addMouseListener(this);
    }

    // Métodos

    public static void main(String[] args) {
        new Thread(new FlappyBird()).start();
    }

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
        // Animação do bird
        bird.animar(frames);
        if (frames == 20){ frames = 0; }
        frames++;

        // Movimentação dos objetos
        chao.movimentar();
        if(!telaGetReady){
            if (!telaGameOver){
                bird.gravidade();
                for (Canos cano : canos){ cano.movimentar(canos); }
            }
        }

        // Após a colisão volta pro início
        if (telaGameOver){
            int posicao = 0;
            bird.valorInicial();
            for (Canos cano : canos){
                cano.valorInicial(cano, posicao);
                posicao++;
            }
        }

        colisao();
    }

    public void render() {

        // Criando o Buffer
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        // Pegando os gráficos do buffer para desenhar
        Graphics g = bs.getDrawGraphics();

        // Desenhando no Buffer
        background.draw(g);
        for(Canos cano : canos){ cano.draw(g); }
        chao.draw(g);
        bird.draw(g);
        if (telaGetReady){ getReady.draw(g); }
        if (telaGameOver){ gameOver.draw(g); }
        g.dispose();
        bs.show();
    }

    public void colisao(){

        // Colisão com o chão
        if (bird.getDy2() == chao.getDy1()){ telaGameOver = true; }

        // Colisão com o cano
        for(Canos cano : canos){

            // Colisão com o cano de cima
            if (bird.getDx1() > cano.getSdx1() && bird.getDx1() <= cano.getSdx2()
                    || bird.getDx2() > cano.getSdx1() && bird.getDx2() <= cano.getSdx2()) {

                if (bird.getDy1() < cano.getSdy2()){ telaGameOver = true; }
            }

            // Colisão com o cano de baixo
            if (bird.getDx1() > cano.getDx1() && bird.getDx1() <= cano.getDx2()
                    || bird.getDx2() > cano.getDx1() && bird.getDx2() <= cano.getDx2()) {

                if (bird.getDy2() > cano.getDy1()){ telaGameOver = true; }
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

    @Override
    public void mouseReleased(MouseEvent e) {
        int keyCode = e.getButton();
        if (keyCode == MouseEvent.BUTTON1){
            if (telaGetReady) { telaGetReady = false; }
            else if (telaGameOver) { telaGameOver = false; }
            else{ bird.pular(); }
        }
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
