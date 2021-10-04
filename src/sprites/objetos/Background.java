package sprites.objetos;

import sprites.BaseSprites;

import java.awt.*;

public class Background extends BaseSprites {

    // Construtor
    public Background(){
        setLargura(276);
        setAltura(204);

        setSx1(390);
        setSy1(0);
        setSx2(666);
        setSy2(204);

        setDx1(0);
        setDy1(480 - getAltura());
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());
    }

    // Refazer um novo background
    @Override
    public void draw(Graphics g) {

        Color LIGTH_BLUE = new Color(112, 197, 206);
        g.setColor(LIGTH_BLUE);
        g.fillRect(0, 0, 320, 480);

        super.draw(g);

        g.drawImage(getSprite(),
                getLargura(), getDy1(),
                (getDx2() + getLargura()), getDy2(),
                getSx1(), getSy1(),
                getSx2(), getSy2(), null);
    }
}
