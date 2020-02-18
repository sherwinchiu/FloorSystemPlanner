/**  FloorPlanSystem class 
  *  Sherwin Chiu and Kyro Nassif
  *  Visual Display of floor for Prom   
  *  2/13/2020
  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class FloorPlanSystem extends JPanel{

    private ArrayList<Table> tables = new ArrayList<>(0);
    public FloorPlanSystem(ArrayList<Table> tables){
        this.tables = tables;  
    }
    public void placeTable(ArrayList<Table> tables){


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw Stuff Here
        g.setColor(Color.BLACK);
        for(int i = 0; i < tables.size(); i++){
            tables.get(i).drawTable(g);
        }
        //Updates and redraws the panel
        this.repaint();
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