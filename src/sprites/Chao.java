package sprites;

import java.awt.*;

public class Chao extends BaseSprites{

    // Construtor
    public Chao(){
        setLargura(224);
        setAltura(112);

        setSx1(0);
        setSy1(610);
        setSx2(224);
        setSy2(722);

        setDx1(0);
        setDy1(480 - getAltura());
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());
    }

    // Refazer um novo chão
    @Override
    public void draw(Graphics g) {
        super.draw(g);

        g.drawImage(getSprite(),
                getDx1(), getDy1(),
                (getDx2() + getLargura()), getDy2(),
                getSx1(), getSy1(),
                getSx2(), getSy2(), null);
    }

    // Movimentação do chão
    public void movimentar(){
        setDx1(getDx1() - 2);
        setDx2(getDx2() - 2);

        if (getDx2() == 112){
            setDx1(0);
            setDx2(getLargura());
        }
    }
}
