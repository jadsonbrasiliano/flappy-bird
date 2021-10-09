package sprites.telas;

import sprites.BaseSprites;

import java.awt.*;

public class GameOver extends BaseSprites {

    // Prpriedades das medalhas
    private int msx1;
    private int msy1;
    private int msx2;
    private int msy2;

    public GameOver(){
        setLargura(226);
        setAltura(200);

        setSx1(134);
        setSy1(153);
        setSx2(360);
        setSy2(353);

        setDx1(47);
        setDy1(40);
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());
    }

    private void bronze(){
         msx1 = 48;
         msy1 = 124;
         msx2 = 92;
         msy2 = 168;
    }

    private void ouro(){
        msx1 = 0;
        msy1 = 124;
        msx2 = 44;
        msy2 = 168;
    }

    private void platina(){
        msx1 = 0;
        msy1 = 78;
        msx2 = 44;
        msy2 = 122;
    }

    private void prata(){
        msx1 = 48;
        msy1 = 78;
        msx2 = 92;
        msy2 = 122;
    }

    public void medalhaValorInicial(){
        msx1 = 0;
        msy1 = 0;
        msx2 = 0;
        msy2 = 0;
    }

    public void medalha(int score){
        if (score >= 10 && score < 20){ bronze(); }
        else if (score >= 20 && score < 50){ prata(); }
        else if (score >= 50 && score < 100){ ouro(); }
        else if (score > 100){ platina(); }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        g.drawImage(getSprite(),
                73, 126,
                117, 170,
                getMsx1(), getMsy1(),
                getMsx2(), getMsy2(), null);
    }

    public int getMsx1() { return msx1; }
    public int getMsy1() { return msy1; }
    public int getMsx2() { return msx2; }
    public int getMsy2() { return msy2; }
}
