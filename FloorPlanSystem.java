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
	int screenX = 1920;
	int screenY = 1080;
    Table table = new Table(10);
    Table[] tabless = new Table[10];
    private ArrayList<Table> tables = new ArrayList<Table>(10);
    public FloorPlanSystem(){
        for (int i = 0; i < tabless.length; i++){
            tabless[i] = table;
            tables.add(tabless[i]);
            
        }
    }
    public void setTable(final ArrayList<Table> tables){
        int yFactor = 1;
        int xFactor = 0;
    	for (int i = 0; i < tables.size(); i++) {
            if (xFactor*(2*tables.get(0).getRadius()+10) >= screenX){
                xFactor = 0;
                yFactor++;
        }    
        tables.get(i).setX(xFactor*(2*tables.get(0).getRadius())+tables.get(i).getRadius()+5);
        tables.get(i).setY(yFactor*(2*tables.get(0).getRadius())+tables.get(i).getRadius()+5);   
        xFactor++;
        }
    }
    public void paintComponent(final Graphics g){
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
        public void mouseClicked(final MouseEvent mouseEvent) {
        }
        @Override
        public void mouseEntered(final MouseEvent mouseEvent) {
        }
        @Override
        public void mouseExited(final MouseEvent mouseEvent) {
        }
        @Override
        public void mousePressed(final MouseEvent mouseEvent) {
        }
        @Override
        public void mouseReleased(final MouseEvent mouseEvent) {
        }
    }
}