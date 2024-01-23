package birdgame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 * Custom button component for the Bird Game application.
 * This class extends JComponent and implements MouseListener to provide a customizable button
 * that can display text and/or images and respond to mouse events.
 */
public class CButton extends JComponent implements MouseListener {

    private int WIDTH = 120;
    private int HEIGHT = 60;
    private int MAX_WIDTH = 300;
    private int MAX_HEIGHT = 300;
    private int MIN_WIDTH = 40;
    private int MIN_HEIGHT = 40;
    private Font font = new Font("TimesRoman", Font.BOLD, 20);

    private boolean mouseEntered = false;
    private boolean hasImage = false;
    private boolean hasText = false;

    private Image img;

    private String text = "";
    
    /**
     * Default constructor for CButton.
     */
    public CButton(){
        super();
        enableInputMethods(true);
        addMouseListener(this);
    }

    /**
     * Constructor for CButton with text and specific dimensions.
     *
     * @param text The text to be displayed on the button.
     * @param width The width of the button.
     * @param height The height of the button.
     */
    public CButton(String text, int width, int height){
        super();
        this.text = text;
        enableInputMethods(true);
        addMouseListener(this);
        hasText = true;
        WIDTH = width;
        HEIGHT = height;
    }
    
    /**
     * Constructor for CButton with text.
     *
     * @param text The text to be displayed on the button.
     */
    public CButton(String text){
        super();
        this.text = text;
        enableInputMethods(true);
        addMouseListener(this);
        hasText = true;
    }

    /**
     * Constructor for CButton with an image.
     *
     * @param img The BufferedImage to be displayed on the button.
     */
    public CButton(BufferedImage img){
        super();
        enableInputMethods(true);
        addMouseListener(this);
        int imgWIDTH = img.getWidth();
        int imgHEIGHT = img.getHeight();
        this.img = img.getScaledInstance(imgWIDTH,imgHEIGHT, Image.SCALE_SMOOTH);
        hasImage = true;
        WIDTH = imgWIDTH;
        HEIGHT = imgHEIGHT;
    }
    
    /**
     * Constructor for CButton with an image and specific dimensions.
     *
     * @param img The BufferedImage to be displayed on the button.
     * @param width The width of the button.
     * @param height The height of the button.
     */
    public CButton(BufferedImage img, int width, int height){
        super();
        enableInputMethods(true);
        addMouseListener(this);
        this.img = img.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        hasImage = true;
        WIDTH = width;
        HEIGHT = height;
    }

    /**
     * Gets the preferred size for the button.
     * @return A Dimension object representing the preferred size.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.WIDTH, this.HEIGHT);
    }

    /**
     * Gets the minimum size for the button.
     * @return A Dimension object representing the minimum size.
     */
    @Override
    public Dimension getMinimumSize() {
        return new Dimension(this.MIN_WIDTH, this.MIN_HEIGHT);
    }

    /**
     * Gets the maximum size for the button.
     * @return A Dimension object representing the maximum size.
     */
    @Override
    public Dimension getMaximumSize() {
        return new Dimension(this.MAX_WIDTH, this.MAX_HEIGHT);
    }

    /**
     * Paints the component with its current state.
     * @param g The Graphics object to paint on.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D antiAlias = (Graphics2D)g;
        antiAlias.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

        if(hasText){
            //draw outer part (trick: fill full button and draw inner parte above)
            if(mouseEntered){
                g.setColor(new Color(00,00,00,00));
            }else{
                g.setColor(Color.GRAY);
            }
            g.fillRoundRect(0,0, WIDTH, HEIGHT, 50,100);
            if(mouseEntered){
                g.setColor(Color.GREEN.darker().darker());
            }else{
                g.setColor(Color.GREEN.darker());
            }
            g.fillRoundRect(0,0, this.WIDTH-1, this.HEIGHT-5, 50, 100);
            g.setColor(Color.GREEN.darker());
            //inner part
            g.fillRoundRect(1,5, WIDTH-1, HEIGHT-10, 50, 100);
            g.setColor(Color.BLACK);
            //Border
            g.drawRoundRect(0,0, this.WIDTH-1, this.HEIGHT-5, 50, 100);
            //Text
            g.setFont(font);
            g.drawString(this.text, 
                    WIDTH/2 - g.getFontMetrics(font).stringWidth(this.text)/2, 
                    HEIGHT/2 + g.getFontMetrics(font).getHeight()/4);
        }else if(hasImage){
            if(mouseEntered){
                g.setColor(Color.RED);
                g.fillRect(0,0,WIDTH, HEIGHT);
                g.drawImage(img, 0,0, null);
                
            }else{
                g.drawImage(img, 0,0, null);
            }
        }
    }

    /**
     * Invoked when the mouse exits the component.
     * @param e The MouseEvent associated with the mouse exit.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        mouseEntered = false;
        repaint();
    }

    /**
     * Invoked when the mouse clicks on the component.
     * @param e The MouseEvent associated with the mouse click.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseEntered = false;
        repaint();
        performeAction(e);
    }

    /**
     * Invoked when the mouse enters the component.
     * @param e The MouseEvent associated with the mouse entry.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEntered = true;
        repaint();
    }

    /**
     * Invoked when a mouse button has been pressed on the component.
     * @param e The MouseEvent associated with the mouse press.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * Invoked when a mouse button has been released on the component.
     * @param e The MouseEvent associated with the mouse release.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * Adds an ActionListener to this button.
     * 
     * @param listener The ActionListener to be added.
     */
    public void addActionListener(ActionListener listener){
        listenerList.add(ActionListener.class, listener);
    }

    /**
     * Performs an action on mouse click by notifying all registered listeners.
     * 
     * @param e The MouseEvent that triggered the action.
     */
    private void performeAction(MouseEvent e){
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners != null) {
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, new String()); 
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        } 
    }
}
