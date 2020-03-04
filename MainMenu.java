import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainMenu extends JPanel implements ActionListener{
    private JButton floorButton;
    private JButton ticketButton;
    private Prom parent;
    

    public MainMenu(Prom parent) {
        this.floorButton = new JButton("Floor Plan System");
        this.floorButton.addActionListener(this);
        this.floorButton.setVisible(true);
        this.add(floorButton);
        this.ticketButton = new JButton("Ticketing System");
        this.ticketButton.addActionListener(this);
        this.ticketButton.setVisible(true);
        this.add(ticketButton);
        this.parent = parent;
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){
        if (e.getSource() == floorButton){
            parent.setFloorPanel();
            this.setVisible(false);
            parent.revalidate();
            parent.repaint();
        }
        if (e.getSource() == ticketButton){
                setVisible(false);
                parent.setTicketingPanel();
        }

    }
}
