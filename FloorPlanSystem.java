import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class FloorPlanSystem extends JPanel{

    private ArrayList<Table> tables = new ArrayList<>(0);
    
    public FloorPlanSystem(ArrayList<Table> tables){
        this.tables = tables;
    }
      //  DrawingPanel panel = new DrawingPanel();
       // this.getContentPane().add(BorderLayout.CENTER, panel);
       // this.addMouseListener(new MyMouseListener());
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        */

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