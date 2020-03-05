import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Prom extends JFrame {
  public static void main(String[] args) {
    Prom start = new Prom();
  }
  
  private ArrayList<Student> students;
  private ArrayList<Table> tables;
  private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
  private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();
  private FloorPlanSystem floorPanel;
  private TicketingSystem ticketingPanel;
  private MainMenu menuPanel;
  
  Prom() {
    students = new ArrayList<>();
    tables = new ArrayList<>();
    floorPanel = new FloorPlanSystem(tables, this);
    ticketingPanel = new TicketingSystem(this);
    menuPanel = new MainMenu(this);
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
    floorPanel.setTable();
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
