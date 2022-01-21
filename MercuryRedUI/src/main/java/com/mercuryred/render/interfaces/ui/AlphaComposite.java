package com.mercuryred.render.interfaces.ui;



public interface AlphaComposite {

    AlphaComposite getInstance(int rule);

    AlphaComposite getInstance(int rule, float alpha);
}
