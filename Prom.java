import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Prom extends JFrame {
    public static void main(String[] args) {
        Prom start = new Prom();
    }

    private ArrayList<Student> students = new ArrayList<>(0);
    private ArrayList<Table> tables = new ArrayList<>(0);
    private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();
    private FloorPlanSystem floorPanel = new FloorPlanSystem(tables, this);
    private TicketingSystem ticketingPanel = new TicketingSystem(this);
    private MainMenu menuPanel = new MainMenu(this);

    Prom() {
        this.getContentPane().add(BorderLayout.CENTER, menuPanel);
        this.menuPanel.setVisible(true);
        this.ticketingPanel.setVisible(false);
        this.floorPanel.setVisible(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setVisible(true);
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public void setFloorPanel(){
        this.getContentPane().add(BorderLayout.CENTER, floorPanel);
        floorPanel.setVisible(true);
    }
    public void setTicketingPanel(){
        this.getContentPane().add(BorderLayout.CENTER, ticketingPanel);
        ticketingPanel.setVisible(true);
    }
    public void setMenuPanel(){
        menuPanel.setVisible(true);

    }
}
