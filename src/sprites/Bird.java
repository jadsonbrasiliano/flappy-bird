package sprites;

public class Bird extends BaseSprites{

    // Construtor
    public Bird(){
        setLargura(34);
        setAltura(24);

        setSx1(0);
        setSy1(0);
        setSx2(34);
        setSy2(24);

        setDx1(10);
        setDy1(50);
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());
    }

    // Movimentação do bird
    public void gravidade(){
        setDy1(getDy1() + 3);
        setDy2(getDy2() + 3);
    }

    public void pular(){
        setDy1(getDy1() - 30);
        setDy2(getDy1() + getAltura());
    }
}
