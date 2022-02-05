package com.mercuryred.render.interfaces;

import com.mercuryred.render.interfaces.imageio.ImageReadParam;
import com.mercuryred.render.interfaces.imageio.ImageReader;
import com.mercuryred.render.interfaces.imageio.spi.ImageReaderSpi;
import com.mercuryred.render.interfaces.imageio.stream.ImageInputStream;
import com.mercuryred.render.interfaces.ui.Adjustable;
import com.mercuryred.render.interfaces.ui.BasicStroke;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Dialog;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Event;
import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.FontMetrics;
import com.mercuryred.render.interfaces.ui.Frame;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Graphics2D;
import com.mercuryred.render.interfaces.ui.GraphicsConfiguration;
import com.mercuryred.render.interfaces.ui.GraphicsDevice;
import com.mercuryred.render.interfaces.ui.GraphicsEnvironment;
import com.mercuryred.render.interfaces.ui.Image;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.ui.LayoutManager;
import com.mercuryred.render.interfaces.ui.Point;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.Shape;
import com.mercuryred.render.interfaces.ui.Window;
import com.mercuryred.render.interfaces.ui.color.ColorSpace;
import com.mercuryred.render.interfaces.ui.color.ICC_ColorSpace;
import com.mercuryred.render.interfaces.ui.color.ICC_Profile;
import com.mercuryred.render.interfaces.ui.datatransfer.DataFlavor;
import com.mercuryred.render.interfaces.ui.dnd.DragGestureEvent;
import com.mercuryred.render.interfaces.ui.dnd.DragGestureRecognizer;
import com.mercuryred.render.interfaces.ui.dnd.DragSourceContext;
import com.mercuryred.render.interfaces.ui.dnd.DragSourceDragEvent;
import com.mercuryred.render.interfaces.ui.dnd.DragSourceEvent;
import com.mercuryred.render.interfaces.ui.dnd.DropTargetContext;
import com.mercuryred.render.interfaces.ui.dnd.DropTargetDragEvent;
import com.mercuryred.render.interfaces.ui.dnd.DropTargetDropEvent;
import com.mercuryred.render.interfaces.ui.event.ActionEvent;
import com.mercuryred.render.interfaces.ui.event.ActionListener;
import com.mercuryred.render.interfaces.ui.event.AdjustmentEvent;
import com.mercuryred.render.interfaces.ui.event.ComponentEvent;
import com.mercuryred.render.interfaces.ui.event.ContainerEvent;
import com.mercuryred.render.interfaces.ui.event.FocusEvent;
import com.mercuryred.render.interfaces.ui.event.InputEvent;
import com.mercuryred.render.interfaces.ui.event.KeyEvent;
import com.mercuryred.render.interfaces.ui.event.MouseEvent;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.event.MouseMotionListener;
import com.mercuryred.render.interfaces.ui.event.MouseWheelEvent;
import com.mercuryred.render.interfaces.ui.event.WindowEvent;
import com.mercuryred.render.interfaces.ui.event.WindowListener;
import com.mercuryred.render.interfaces.ui.geom.AffineTransform;
import com.mercuryred.render.interfaces.ui.geom.GeneralPath;
import com.mercuryred.render.interfaces.ui.geom.Point2D;
import com.mercuryred.render.interfaces.ui.geom.Rectangle2D;
import com.mercuryred.render.interfaces.ui.image.BufferedImage;
import com.mercuryred.render.interfaces.ui.image.ColorModel;
import com.mercuryred.render.interfaces.ui.image.DataBuffer;
import com.mercuryred.render.interfaces.ui.image.ImageObserver;
import com.mercuryred.render.interfaces.ui.image.ImageProducer;
import com.mercuryred.render.interfaces.ui.image.IndexColorModel;
import com.mercuryred.render.interfaces.ui.image.Raster;
import com.mercuryred.render.interfaces.ui.image.SampleModel;
import com.mercuryred.render.interfaces.ui.image.WritableRaster;
import com.mercuryred.render.interfaces.ui.print.PageFormat;
import com.mercuryred.render.interfaces.ui.print.PrinterJob;
import com.mercuryred.render.interfaces.uiplus.AbstractButton;
import com.mercuryred.render.interfaces.uiplus.Action;
import com.mercuryred.render.interfaces.uiplus.BoundedRangeModel;
import com.mercuryred.render.interfaces.uiplus.ComboBoxModel;
import com.mercuryred.render.interfaces.uiplus.DefaultListModel;
import com.mercuryred.render.interfaces.uiplus.Icon;
import com.mercuryred.render.interfaces.uiplus.ImageIcon;
import com.mercuryred.render.interfaces.uiplus.InputMap;
import com.mercuryred.render.interfaces.uiplus.JButton;
import com.mercuryred.render.interfaces.uiplus.JCheckBox;
import com.mercuryred.render.interfaces.uiplus.JComboBox;
import com.mercuryred.render.interfaces.uiplus.JComponent;
import com.mercuryred.render.interfaces.uiplus.JDialog;
import com.mercuryred.render.interfaces.uiplus.JFileChooser;
import com.mercuryred.render.interfaces.uiplus.JFrame;
import com.mercuryred.render.interfaces.uiplus.JLabel;
import com.mercuryred.render.interfaces.uiplus.JLayeredPane;
import com.mercuryred.render.interfaces.uiplus.JList;
import com.mercuryred.render.interfaces.uiplus.JMenuBar;
import com.mercuryred.render.interfaces.uiplus.JMenuItem;
import com.mercuryred.render.interfaces.uiplus.JPanel;
import com.mercuryred.render.interfaces.uiplus.JPasswordField;
import com.mercuryred.render.interfaces.uiplus.JPopupMenu;
import com.mercuryred.render.interfaces.uiplus.JProgressBar;
import com.mercuryred.render.interfaces.uiplus.JRadioButton;
import com.mercuryred.render.interfaces.uiplus.JRadioButtonMenuItem;
import com.mercuryred.render.interfaces.uiplus.JRootPane;
import com.mercuryred.render.interfaces.uiplus.JScrollBar;
import com.mercuryred.render.interfaces.uiplus.JScrollPane;
import com.mercuryred.render.interfaces.uiplus.JSplitPane;
import com.mercuryred.render.interfaces.uiplus.JTabbedPane;
import com.mercuryred.render.interfaces.uiplus.JTable;
import com.mercuryred.render.interfaces.uiplus.JTextArea;
import com.mercuryred.render.interfaces.uiplus.JTextField;
import com.mercuryred.render.interfaces.uiplus.ListModel;
import com.mercuryred.render.interfaces.uiplus.ListSelectionModel;
import com.mercuryred.render.interfaces.uiplus.Timer;
import com.mercuryred.render.interfaces.uiplus.UIDefaults;
import com.mercuryred.render.interfaces.uiplus.event.CaretEvent;
import com.mercuryred.render.interfaces.uiplus.event.ChangeEvent;
import com.mercuryred.render.interfaces.uiplus.event.EventListenerList;
import com.mercuryred.render.interfaces.uiplus.event.PopupMenuEvent;
import com.mercuryred.render.interfaces.uiplus.event.TreeSelectionEvent;
import com.mercuryred.render.interfaces.uiplus.plaf.ColorUIResource;
import com.mercuryred.render.interfaces.uiplus.plaf.FontUIResource;
import com.mercuryred.render.interfaces.uiplus.plaf.basic.BasicSplitPaneUI;
import com.mercuryred.render.interfaces.uiplus.table.TableCellRenderer;
import com.mercuryred.render.interfaces.uiplus.table.TableColumnModel;
import com.mercuryred.render.interfaces.uiplus.table.TableModel;
import com.mercuryred.render.interfaces.uiplus.text.Document;
import com.mercuryred.render.interfaces.uiplus.text.JTextComponent;
import com.mercuryred.render.interfaces.uiplus.tree.TreePath;

import java.io.File;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public interface IRenderEngine {

  JScrollPane createJScrollPane(Component view, int vsbPolicy, int hsbPolicy);

  JScrollPane createJScrollPane(Component view);

  JScrollPane createJScrollPane(int vsbPolicy, int hsbPolicy);

  JScrollPane createJScrollPane();

  KeyEvent createKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation, boolean isProxyActive);

  KeyEvent createKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation);

  KeyEvent createKeyEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar);

  KeyEvent createKeyEvent(Component source, int id, long when, int modifiers, int keyCode);

  <E> JComboBox createJComboBox(ComboBoxModel<E> aModel);

  <E> JComboBox createJComboBox(E[] items);

  <E> JComboBox createJComboBox(Vector<E> items);

  JComboBox createJComboBox();

  JTextField createJTextField();

  JTextField createJTextField(String text);

  JTextField createJTextField(int columns);

  JTextField createJTextField(String text, int columns);

  JTextField createJTextField(Document doc, String text, int columns);

  Icon createIcon();

  Component createComponent();

  Color createColor(int r, int g, int b);

  Color createColor(int r, int g, int b, int a);

  Color createColor(int rgb);

  Color createColor(int rgba, boolean hasalpha);

  Color createColor(float r, float g, float b);

  Color createColor(float r, float g, float b, float a);

  Color createColor(ColorSpace cspace, float[] components, float alpha);

  JPanel createJPanel(LayoutManager layout, boolean isDoubleBuffered);

  JPanel createJPanel(LayoutManager layout);

  JPanel createJPanel(boolean isDoubleBuffered);

  JPanel createJPanel();

  BasicStroke createBasicStroke(float width, int cap, int join, float miterlimit, float[] dash, float dash_phase);

  BasicStroke createBasicStroke(float width, int cap, int join, float miterlimit);

  BasicStroke createBasicStroke(float width, int cap, int join);

  BasicStroke createBasicStroke(float width);

  BasicStroke createBasicStroke();

  Frame createFrame();

  Frame createFrame(GraphicsConfiguration gc);

  Frame createFrame(String title);

  Frame createFrame(String title, GraphicsConfiguration gc);

  Graphics createGraphics();

  Graphics2D createGraphics2D();

  Container createContainer();

  Insets createInsets(int top, int left, int bottom, int right);

  FontMetrics createFontMetrics(Font font);

  Font createFont(String name, int style, int size);

  Font createFont(String name, int style, float sizePts);

//  Font createFont(String name, int style, float sizePts, boolean created, Font2DHandle handle);

//  Font createFont(File fontFile, int fontFormat, boolean isCopy, CreatedFontTracker tracker);

//  Font createFont(AttributeValues values, String oldName, int oldStyle, boolean created, Font2DHandle handle);

  Font createFont(Map<? extends AttributedCharacterIterator.Attribute, ?> attributes);

  Font createFont(Font font);

//  Font createFont(Font2D font2D);

  GraphicsEnvironment createGraphicsEnvironment();

  ImageIcon createImageIcon(String filename, String description);

  ImageIcon createImageIcon(String filename);

  ImageIcon createImageIcon(URL location, String description);

  ImageIcon createImageIcon(URL location);

  ImageIcon createImageIcon(Image image, String description);

  ImageIcon createImageIcon(Image image);

  ImageIcon createImageIcon(byte[] imageData, String description);

  ImageIcon createImageIcon(byte[] imageData);

  ImageIcon createImageIcon();

  Image createImage();

  BufferedImage createBufferedImage(int width, int height, int imageType);

  BufferedImage createBufferedImage(int width, int height, int imageType, IndexColorModel cm);

  BufferedImage createBufferedImage(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties);

  ActionEvent createActionEvent(Object source, int id, String command);

  ActionEvent createActionEvent(Object source, int id, String command, int modifiers);

  ActionEvent createActionEvent(Object source, int id, String command, long when, int modifiers);

  Rectangle createRectangle();

  Rectangle createRectangle(Rectangle r);

  Rectangle createRectangle(int x, int y, int width, int height);

  Rectangle createRectangle(int width, int height);

  Rectangle createRectangle(Point p, Dimension d);

  Rectangle createRectangle(Point p);

  Rectangle createRectangle(Dimension d);

  ComponentEvent createComponentEvent(Component source, int id);

  WindowEvent createWindowEvent(Window source, int id, Window opposite, int oldState, int newState);

  WindowEvent createWindowEvent(Window source, int id, Window opposite);

  WindowEvent createWindowEvent(Window source, int id, int oldState, int newState);

  WindowEvent createWindowEvent(Window source, int id);

  JFrame createJFrame();

  JFrame createJFrame(GraphicsConfiguration gc);

  JFrame createJFrame(String title);

  JFrame createJFrame(String title, GraphicsConfiguration gc);

  DataFlavor createDataFlavor();

//  DataFlavor createDataFlavor(String primaryType, String subType, MimeTypeParameterList params, Class<?> representationClass, String humanPresentableName);

  DataFlavor createDataFlavor(Class<?> representationClass, String humanPresentableName);

  DataFlavor createDataFlavor(String mimeType, String humanPresentableName);

  DataFlavor createDataFlavor(String mimeType, String humanPresentableName, ClassLoader classLoader);

  DataFlavor createDataFlavor(String mimeType);

  DropTargetDragEvent createDropTargetDragEvent(DropTargetContext dtc, Point cursorLocn, int dropAction, int srcActions);

  DropTargetDropEvent createDropTargetDropEvent(DropTargetContext dtc, Point cursorLocn, int dropAction, int srcActions);

  DropTargetDropEvent createDropTargetDropEvent(DropTargetContext dtc, Point cursorLocn, int dropAction, int srcActions, boolean isLocal);

  Shape createShape();

  Rectangle2D createRectangle2D();

  JButton createJButton();

  JButton createJButton(Icon icon);

  JButton createJButton(String text);

  JButton createJButton(Action a);

  JButton createJButton(String text, Icon icon);

  JFileChooser createJFileChooser();

  JFileChooser createJFileChooser(String currentDirectoryPath);

  JFileChooser createJFileChooser(File currentDirectory);

//  JFileChooser createJFileChooser(FileSystemView fsv);
//
//  JFileChooser createJFileChooser(File currentDirectory, FileSystemView fsv);
//
//  JFileChooser createJFileChooser(String currentDirectoryPath, FileSystemView fsv);

  JProgressBar createJProgressBar();

  JProgressBar createJProgressBar(int orient);

  JProgressBar createJProgressBar(int min, int max);

  JProgressBar createJProgressBar(int orient, int min, int max);

  JProgressBar createJProgressBar(BoundedRangeModel newModel);

  JComponent createJComponent();

  <E> JList createJList(ListModel<E> dataModel);

  <E> JList createJList(E[] listData);

  <E> JList createJList(Vector<? extends E> listData);

  JList createJList();

  JLabel createJLabel(String text, Icon icon, int horizontalAlignment);

  JLabel createJLabel(String text, int horizontalAlignment);

  JLabel createJLabel(String text);

  JLabel createJLabel(Icon image, int horizontalAlignment);

  JLabel createJLabel(Icon image);

  JLabel createJLabel();

  JTextComponent createJTextComponent();

  JTextArea createJTextArea();

  JTextArea createJTextArea(String text);

  JTextArea createJTextArea(int rows, int columns);

  JTextArea createJTextArea(String text, int rows, int columns);

  JTextArea createJTextArea(Document doc);

  JTextArea createJTextArea(Document doc, String text, int rows, int columns);

  Action createAction();

  JMenuBar createJMenuBar();

  JMenuItem createJMenuItem();

  JMenuItem createJMenuItem(Icon icon);

  JMenuItem createJMenuItem(String text);

  JMenuItem createJMenuItem(Action a);

  JMenuItem createJMenuItem(String text, Icon icon);

  JMenuItem createJMenuItem(String text, int mnemonic);

  InputEvent createInputEvent(Component source, int id, long when, int modifiers);

  TreeSelectionEvent createTreeSelectionEvent(Object source, TreePath[] paths, boolean[] areNew, TreePath oldLeadSelectionPath, TreePath newLeadSelectionPath);

  TreeSelectionEvent createTreeSelectionEvent(Object source, TreePath path, boolean isNew, TreePath oldLeadSelectionPath, TreePath newLeadSelectionPath);

  Point createPoint();

  Point createPoint(Point p);

  Point createPoint(int x, int y);

  MouseEvent createMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int button);

  MouseEvent createMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger);

  MouseEvent createMouseEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int button);

  GraphicsDevice createGraphicsDevice();

  JTable createJTable();

  JTable createJTable(TableModel dm);

  JTable createJTable(TableModel dm, TableColumnModel cm);

  JTable createJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm);

  JTable createJTable(int numRows, int numColumns);

  JTable createJTable(Vector<? extends Vector> rowData, Vector<?> columnNames);

  JTable createJTable(Object[][] rowData, Object[] columnNames);

  JTabbedPane createJTabbedPane();

  JTabbedPane createJTabbedPane(int tabPlacement);

  JTabbedPane createJTabbedPane(int tabPlacement, int tabLayoutPolicy);

  Document createDocument();

  AbstractButton createAbstractButton();

  DragGestureEvent createDragGestureEvent(DragGestureRecognizer dgr, int act, Point ori, List<? extends InputEvent> evs);

  DragSourceDragEvent createDragSourceDragEvent(DragSourceContext dsc, int dropAction, int action, int modifiers);

  DragSourceDragEvent createDragSourceDragEvent(DragSourceContext dsc, int dropAction, int action, int modifiers, int x, int y);

  DragSourceEvent createDragSourceEvent(DragSourceContext dsc);

  DragSourceEvent createDragSourceEvent(DragSourceContext dsc, int x, int y);

  JPopupMenu createJPopupMenu();

  JPopupMenu createJPopupMenu(String label);

  FocusEvent createFocusEvent(Component source, int id, boolean temporary, Component opposite);

  FocusEvent createFocusEvent(Component source, int id, boolean temporary, Component opposite, FocusEvent.Cause cause);

  FocusEvent createFocusEvent(Component source, int id, boolean temporary);

  FocusEvent createFocusEvent(Component source, int id);

  AffineTransform createAffineTransform(double m00, double m10, double m01, double m11, double m02, double m12, int state);

  AffineTransform createAffineTransform();

  AffineTransform createAffineTransform(AffineTransform Tx);

  AffineTransform createAffineTransform(float m00, float m10, float m01, float m11, float m02, float m12);

  AffineTransform createAffineTransform(float[] flatmatrix);

  AffineTransform createAffineTransform(double m00, double m10, double m01, double m11, double m02, double m12);

  AffineTransform createAffineTransform(double[] flatmatrix);

  GeneralPath createGeneralPath();

  GeneralPath createGeneralPath(int rule);

  GeneralPath createGeneralPath(int rule, int initialCapacity);

  GeneralPath createGeneralPath(Shape s);

  GeneralPath createGeneralPath(int windingRule, byte[] pointTypes, int numTypes, float[] pointCoords, int numCoords);

  Point2D createPoint2D();

  Point2D createPoint2D(double x, double y);

  JScrollBar createJScrollBar(int orientation, int value, int extent, int min, int max);

  JScrollBar createJScrollBar(int orientation);

  JScrollBar createJScrollBar();

  CaretEvent createCaretEvent(Object source);

  MouseListener createMouseListener();

  JCheckBox createJCheckBox();

  JCheckBox createJCheckBox(Icon icon);

  JCheckBox createJCheckBox(Icon icon, boolean selected);

  JCheckBox createJCheckBox(String text);

  JCheckBox createJCheckBox(Action a);

  JCheckBox createJCheckBox(String text, boolean selected);

  JCheckBox createJCheckBox(String text, Icon icon);

  JCheckBox createJCheckBox(String text, Icon icon, boolean selected);

  ColorModel createColorModel(int bits);

  ColorModel createColorModel(int pixel_bits, int[] bits, ColorSpace cspace, boolean hasAlpha, boolean isAlphaPremultiplied, int transparency, int transferType);

  JPasswordField createJPasswordField();

  JPasswordField createJPasswordField(String text);

  JPasswordField createJPasswordField(int columns);

  JPasswordField createJPasswordField(String text, int columns);

  JPasswordField createJPasswordField(Document doc, String txt, int columns);

  JRadioButton createJRadioButton();

  JRadioButton createJRadioButton(Icon icon);

  JRadioButton createJRadioButton(Action a);

  JRadioButton createJRadioButton(Icon icon, boolean selected);

  JRadioButton createJRadioButton(String text);

  JRadioButton createJRadioButton(String text, boolean selected);

  JRadioButton createJRadioButton(String text, Icon icon);

  JRadioButton createJRadioButton(String text, Icon icon, boolean selected);

  DefaultListModel createDefaultListModel();

  Timer createTimer(int delay, ActionListener listener);

  MouseMotionListener createMouseMotionListener();

  MouseWheelEvent createMouseWheelEvent(Component source, int id, long when, int modifiers, int x, int y, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation);

  MouseWheelEvent createMouseWheelEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation);

  MouseWheelEvent createMouseWheelEvent(Component source, int id, long when, int modifiers, int x, int y, int xAbs, int yAbs, int clickCount, boolean popupTrigger, int scrollType, int scrollAmount, int wheelRotation, double preciseWheelRotation);

  ImageObserver createImageObserver();

  ChangeEvent createChangeEvent(Object source);

  AdjustmentEvent createAdjustmentEvent(Adjustable source, int id, int type, int value);

  AdjustmentEvent createAdjustmentEvent(Adjustable source, int id, int type, int value, boolean isAdjusting);

  Window createWindow(GraphicsConfiguration gc);

  Window createWindow();

  Window createWindow(Frame owner);

  Window createWindow(Window owner);

  Window createWindow(Window owner, GraphicsConfiguration gc);

  JRadioButtonMenuItem createJRadioButtonMenuItem();

  JRadioButtonMenuItem createJRadioButtonMenuItem(Icon icon);

  JRadioButtonMenuItem createJRadioButtonMenuItem(String text);

  JRadioButtonMenuItem createJRadioButtonMenuItem(Action a);

  JRadioButtonMenuItem createJRadioButtonMenuItem(String text, Icon icon);

  JRadioButtonMenuItem createJRadioButtonMenuItem(String text, boolean selected);

  JRadioButtonMenuItem createJRadioButtonMenuItem(Icon icon, boolean selected);

  JRadioButtonMenuItem createJRadioButtonMenuItem(String text, Icon icon, boolean selected);

  JLayeredPane createJLayeredPane();

  EventListenerList createEventListenerList();

  JDialog createJDialog();

  JDialog createJDialog(Frame owner);

  JDialog createJDialog(Frame owner, boolean modal);

  JDialog createJDialog(Frame owner, String title);

  JDialog createJDialog(Frame owner, String title, boolean modal);

  JDialog createJDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc);

  JDialog createJDialog(Dialog owner);

  JDialog createJDialog(Dialog owner, boolean modal);

  JDialog createJDialog(Dialog owner, String title);

  JDialog createJDialog(Dialog owner, String title, boolean modal);

  JDialog createJDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc);

  JDialog createJDialog(Window owner);

  JDialog createJDialog(Window owner, Dialog.ModalityType modalityType);

  JDialog createJDialog(Window owner, String title);

  JDialog createJDialog(Window owner, String title, Dialog.ModalityType modalityType);

  JDialog createJDialog(Window owner, String title, Dialog.ModalityType modalityType, GraphicsConfiguration gc);

  UIDefaults createUIDefaults();

  UIDefaults createUIDefaults(int initialCapacity, float loadFactor);

  UIDefaults createUIDefaults(Object[] keyValueList);

  ColorUIResource createColorUIResource(int r, int g, int b);

  ColorUIResource createColorUIResource(int rgb);

  ColorUIResource createColorUIResource(float r, float g, float b);

  ColorUIResource createColorUIResource(Color c);

  FontUIResource createFontUIResource(String name, int style, int size);

  FontUIResource createFontUIResource(Font font);

  ContainerEvent createContainerEvent(Component source, int id, Component child);

  JRootPane createJRootPane();

  InputMap createInputMap();

  WindowListener createWindowListener();

  PopupMenuEvent createPopupMenuEvent(Object source);

  JSplitPane createJSplitPane();

  JSplitPane createJSplitPane(int newOrientation);

  JSplitPane createJSplitPane(int newOrientation, boolean newContinuousLayout);

  JSplitPane createJSplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent);

  JSplitPane createJSplitPane(int newOrientation, boolean newContinuousLayout, Component newLeftComponent, Component newRightComponent);

  BasicSplitPaneUI createBasicSplitPaneUI();

  Event createEvent(Object target, long when, int id, int x, int y, int key, int modifiers, Object arg);

  Event createEvent(Object target, long when, int id, int x, int y, int key, int modifiers);

  Event createEvent(Object target, int id, Object arg);

  TableCellRenderer createTableCellRenderer();

  DataBuffer createDataBuffer(int dataType, int size);

  DataBuffer createDataBuffer(DataBuffer.State initialState, int dataType, int size);

  DataBuffer createDataBuffer(int dataType, int size, int numBanks);

  DataBuffer createDataBuffer(DataBuffer.State initialState, int dataType, int size, int numBanks);

  DataBuffer createDataBuffer(int dataType, int size, int numBanks, int offset);

  DataBuffer createDataBuffer(DataBuffer.State initialState, int dataType, int size, int numBanks, int offset);

  DataBuffer createDataBuffer(int dataType, int size, int numBanks, int[] offsets);

  DataBuffer createDataBuffer(DataBuffer.State initialState, int dataType, int size, int numBanks, int[] offsets);

  Raster createRaster(SampleModel sampleModel, Point origin);

  Raster createRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point origin);

  Raster createRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle aRegion, Point sampleModelTranslate, Raster parent);

  WritableRaster createWritableRaster(SampleModel sampleModel, Point origin);

  WritableRaster createWritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Point origin);

  WritableRaster createWritableRaster(SampleModel sampleModel, DataBuffer dataBuffer, Rectangle aRegion, Point sampleModelTranslate, WritableRaster parent);

  ImageReadParam createImageReadParam();

  ImageReader createImageReader(ImageReaderSpi originatingProvider);

  ImageInputStream createImageInputStream();

  PageFormat createPageFormat();

  PrinterJob createPrinterJob();

  ColorSpace createColorSpace(int type, int numcomponents);

  ICC_ColorSpace createICC_ColorSpace(ICC_Profile profile);

  GraphicsEnvironment getLocalGraphicsEnvironment();

  Image createImage(ImageProducer source);

  void invokeLater(Runnable runnable);

  Rectangle2D createRectangle2D(float x, float y, float w, float h);
}

