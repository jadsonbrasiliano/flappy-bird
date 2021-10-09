package sprites.objetos;

import sprites.BaseSprites;

public class Bird extends BaseSprites {

    // Construtor
    public Bird(){ valorInicial(); }

    // Movimentação do bird
    public void gravidade(){
        setDy1(getDy1() + 4);
        setDy2(getDy2() + 4);
    }

    public void pular(){
        setDy1(getDy1() - 36);
        setDy2(getDy1() + getAltura());
    }

    public void asaCima(){
        setSx1(0);
        setSy1(0);
        setSx2(34);
        setSy2(24);
    }

    public void asaReta(){
        setSx1(0);
        setSy1(26);
        setSx2(34);
        setSy2(50);
    }

    public void asaBaixo(){
        setSx1(0);
        setSy1(52);
        setSx2(34);
        setSy2(76);
    }

    public void valorInicial(){
        setLargura(34);
        setAltura(24);
        asaCima();
        setDx1(10);
        setDy1(50);
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());
    }

    public void animar(int frames){
        if (frames > 5 && frames <= 10){ asaReta(); }
        else if (frames > 10 && frames <= 15){ asaBaixo(); }
        else if (frames > 15 && frames <= 20){ asaReta(); }
        else{ asaCima(); }
    }
}
