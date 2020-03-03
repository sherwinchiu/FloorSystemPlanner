import javax.swing.*;
import java.awt.*;
<<<<<<< Updated upstream
import java.util.ArrayList;

public class Prom extends JFrame{
=======
import java.awt.event.*;

import java.util.ArrayList;

class Prom extends JFrame {
>>>>>>> Stashed changes
    public static void main(String[] args) {
        Prom start = new Prom();
    }

    private ArrayList<Student> students = new ArrayList<>(0);
    private ArrayList<Table> tables = new ArrayList<>(0);
<<<<<<< Updated upstream
   // private FloorPlanSystem floorPlanSystem = new FloorPlanSystem(tables);
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    Prom(){
        TicketingSystem s = new TicketingSystem();
        FloorPlanSystem panel = new FloorPlanSystem(tables);
        this.getContentPane().add(BorderLayout.CENTER, panel);
=======
    // private FloorPlanSystem floorPlanSystem = new FloorPlanSystem(tables);
    private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();
    private FloorPlanSystem floorPanel = new FloorPlanSystem(tables);
    private TicketingSystem ticketingPanel = new TicketingSystem(this);
    private JButton floorButton;
    private JButton ticketButton;

    Prom() {
        this.floorButton = new JButton("Floor Plan System");
        this.floorButton.setBounds(MAX_X / 2 - (MAX_X / 12), MAX_Y / 2, 140, 50);
        this.floorButton.addActionListener(new FloorActionListener());
        this.floorButton.setVisible(true);
        this.ticketButton = new JButton("Ticketing System");
        this.ticketButton.setBounds(MAX_X / 2 - (MAX_X / 12), MAX_Y / 2 + 60, 140, 50);
        this.ticketButton.addActionListener(new TicketActionListener());
        this.ticketButton.setVisible(true);
        this.getContentPane().add(this.floorButton);
        this.getContentPane().add(this.ticketButton);
        this.getContentPane().add(BorderLayout.CENTER, floorPanel);
        this.getContentPane().add(BorderLayout.CENTER, ticketingPanel);
>>>>>>> Stashed changes
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setVisible(true);
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }

    private class FloorActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            floorPanel.setVisible(true);
        }
    }

    private class TicketActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            ticketingPanel.setVisible(true);
        }
    }
}
