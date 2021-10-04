package sprites.telas;

import sprites.BaseSprites;

public class GetReady extends BaseSprites {

    public GetReady(){
        setLargura(174);
        setAltura(152);

        setSx1(134);
        setSy1(0);
        setSx2(308);
        setSy2(152);

        setDx1(73);
        setDy1(40);
        setDx2(getDx1() + getLargura());
        setDy2(getDy1() + getAltura());
    }
}
