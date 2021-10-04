package sprites.objetos;

import sprites.BaseSprites;

import java.awt.*;
import java.util.Random;

public class Canos extends BaseSprites {

    static int aumentar = 320;

    // Cano superior
    private int sdx1 = aumentar;
    private int sdy1 = -random();
    private int sdx2 = sdx1 + 52;
    private int sdy2 = sdy1 + 400;

    public Canos(){
        // Cano Inferior
        setLargura(52);
        setAltura(400);
        setSx1(0);
        setSy1(169);
        setSx2(52);
        setSy2(569);

        setDx1(aumentar);
        setDy1(getAltura() + 90 + sdy1);
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());

        aumentar += 156;
    }

    @Override
    public void draw(Graphics g) {

        // Desenha o cano inferior
        super.draw(g);

        // Desenha o cano superior
        g.drawImage(getSprite(),
                sdx1, sdy1,
                sdx2, sdy2,
                52, getSy1(),
                104, getSy2(), null);
    }

    public void valorInicial(Canos cano, int posicao){
        aumentar = 320;
        if (posicao > 0){ aumentar+=156 * posicao; }

        cano.setSdx1(aumentar);
        cano.setSdy1(-random());
        cano.setSdx2(cano.getSdx1() + cano.getLargura());
        cano.setSdy2(cano.getSdy1() + cano.getAltura());

        cano.setDx1(aumentar);
        cano.setDy1(cano.getAltura() + 90 + sdy1);
        cano.setDx2(cano.getDx1() + cano.getLargura());
        cano.setDy2(cano.getDy1() + cano.getAltura());
    }


    public int random(){
        Random random = new Random();
        int numeroRandom = random.nextInt(250);
        while (numeroRandom < 145) { numeroRandom  = random.nextInt(350); }
        return numeroRandom;
    }

    public void movimentar(Canos[] canos) {
        for (Canos cano : canos) {
            cano.setDx1(cano.getDx1() - 1);
            cano.setDx2(cano.getDx2() - 1);
            cano.setSdx1(cano.getSdx1() - 1);
            cano.setSdx2(cano.getSdx2() - 1);

            if (cano.getDx2() == 0) {

                int numeroRandom = random();

                cano.setDy1(cano.getAltura() + 90 - numeroRandom);
                cano.setDy2(cano.getDy1() + cano.getAltura());
                cano.setSdy1(-numeroRandom);
                cano.setSdy2(cano.getSdy1() + cano.getAltura());

                cano.setDx1(572);
                cano.setDx2(624);
                cano.setSdx1(572);
                cano.setSdx2(624);
            }
        }
    }

    public int getSdx1() { return sdx1; }
    public int getSdy1() { return sdy1; }
    public int getSdx2() { return sdx2; }
    public int getSdy2() { return sdy2; }

    public void setSdx1(int sdx1) { this.sdx1 = sdx1; }
    public void setSdx2(int sdx2) { this.sdx2 = sdx2; }
    public void setSdy1(int sdy1) { this.sdy1 = sdy1; }
    public void setSdy2(int sdy2) { this.sdy2 = sdy2; }
}
