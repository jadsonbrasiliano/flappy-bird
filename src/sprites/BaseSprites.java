package sprites;

import javax.swing.*;
import java.awt.*;

public class BaseSprites {

    private int dx1;
    private int dx2;
    private int dy1;
    private int dy2;

    private int sx1;
    private int sx2;
    private int sy1;
    private int sy2;

    private int largura;
    private int altura;

    private final ImageIcon imageIcon = new ImageIcon("/sprites/sprites.png");
    private final Image sprite = imageIcon.getImage();

    // Getters
    public int getDx1() { return dx1; }
    public int getDx2() { return dx2; }
    public int getDy1() { return dy1; }
    public int getDy2() { return dy2; }

    public int getSx1() { return sx1; }
    public int getSx2() { return sx2; }
    public int getSy1() { return sy1; }
    public int getSy2() { return sy2; }

    public int getLargura() { return largura; }
    public int getAltura() { return altura; }

    // Setters
    public void setDx1(int dx1) { this.dx1 = dx1; }
    public void setDx2(int dx2) { this.dx2 = dx2; }
    public void setDy1(int dy1) { this.dy1 = dy1; }
    public void setDy2(int dy2) { this.dy2 = dy2; }

    public void setSx1(int sx1) { this.sx1 = sx1; }
    public void setSx2(int sx2) { this.sx2 = sx2; }
    public void setSy1(int sy1) { this.sy1 = sy1; }
    public void setSy2(int sy2) { this.sy2 = sy2; }

    public void setLargura(int largura) { this.largura = largura; }
    public void setAltura(int altura) { this.altura = altura; }

    public void draw(Graphics g){
        g.drawImage(sprite,
                dx1, dy1,
                dx2, dy2,
                sx1, sy1,
                sx2, sy2, null);
    }
}
