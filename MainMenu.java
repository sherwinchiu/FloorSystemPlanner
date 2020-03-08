/**  MainMenu class 
 *  Sherwin Chiu and Kyro Nassif
 *  Visual display of the menu for prom   
 *  2/13/2020
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


class MainMenu extends JPanel implements ActionListener{
    private JButton floorButton;
    private JButton ticketButton;
    private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();
    private Prom parent;
    private  final BufferedImage menuImage;


    // constructor
    public MainMenu(Prom parent) throws Exception{
        menuImage = ImageIO.read(new File("menuScreen.jpg"));
        this.floorButton = new JButton("Floor Plan System");
        this.floorButton.addActionListener(this);
        this.floorButton.setVisible(true);
        this.floorButton.setBounds(MAX_X/2 - 100, MAX_Y, 100, 40);
        this.add(floorButton);  
        this.ticketButton = new JButton("Ticketing System");
        this.ticketButton.addActionListener(this);
        this.ticketButton.setVisible(true);
        this.add(ticketButton);
        this.parent = parent;
        this.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(menuImage, 0, 0, MAX_X, MAX_Y, this); //draw image
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == floorButton) { // if they click floor button
            parent.remove(this);
            parent.setFloorPanel();
            this.setVisible(false);

        }
        if (e.getSource() == ticketButton) { // if they click ticket button
            setVisible(false);
            parent.remove(this);
            parent.setTicketingPanel();
        }

    }
}
