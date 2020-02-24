import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
class Prom extends JFrame{
    public static void main(String[] args) {
        Prom start = new Prom();
    }
    private ArrayList<Student> students = new ArrayList<>(0);
    private ArrayList<Table> tables = new ArrayList<>(0);
   // private FloorPlanSystem floorPlanSystem = new FloorPlanSystem(tables);
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    Prom(){
        FloorPlanSystem panel = new FloorPlanSystem(tables);
        panel.addMouseListener(new MyMouseListener()); 
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setVisible(true);
    }
    private static class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            System.out.println("hi");
        }
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }
        @Override
        public void mouseExited(MouseEvent mouseEvent) {
        }
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        }
        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
        }
    }
}
