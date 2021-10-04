package sprites.telas;

import sprites.BaseSprites;

public class GameOver extends BaseSprites {

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
}
