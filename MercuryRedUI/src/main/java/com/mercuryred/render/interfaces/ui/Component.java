package com.mercuryred.render.interfaces.ui;



public interface Component {

    Container getParent();

    boolean isVisible();

    boolean isShowing();

    void setVisible(boolean b);

    Color getBackground();

    Font getFont();

    Point getLocationOnScreen();

    void setBounds(int x, int y, int width, int height);

    void setBounds(Rectangle r);

    int getWidth();

    int getHeight();

    Dimension getPreferredSize();

    void paint(Graphics g);

    Image createImage(ImageProducer producer);

    Image createImage(int width, int height);

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);

    PropertyChangeListener[] getPropertyChangeListeners();

    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

    PropertyChangeListener[] getPropertyChangeListeners(String propertyName);

    ComponentOrientation getComponentOrientation();
}
