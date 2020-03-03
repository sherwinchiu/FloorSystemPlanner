import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Prom extends JFrame{
    public static void main(String[] args) {
        Prom start = new Prom();
    }
    private ArrayList<Student> students = new ArrayList<>(0);
    private ArrayList<Table> tables = new ArrayList<>(0);
   // private FloorPlanSystem floorPlanSystem = new FloorPlanSystem(tables);
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    Prom(){
        TicketingSystem s = new TicketingSystem();
        FloorPlanSystem panel = new FloorPlanSystem(tables);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setVisible(true);
    }
}
