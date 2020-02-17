import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
class Prom implements JFrame{
    private ArrayList<Student> students = new ArrayList<>(0);
    private ArrayList<Table> tables = new ArrayList<>(0);
    private TicketingSystem menu = new TicketingSystem(students, tables);
    private FloorPlanSystem floorPlanSystem = new FloorPlanSystem(students);
    private final int MAX_X = 800;
    private final int MAX_Y = 600;
    
     Prom(){
        DrawingPanel panel = new DrawingPanel();
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.addMouseListener(new MyMouseListener());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MAX_X, MAX_Y);
        this.setVisible(true);
        /*
        //Sets to fullscreen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        */
    }
    private static class DrawingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Draw Stuff Here

            //Updates and redraws the panel
            this.repaint();
        }
    }
    private static class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
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
   