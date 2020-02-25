/**  FloorPlanSystem class 
  *  Sherwin Chiu and Kyro Nassif
  *  Visual Display of floor for Prom   
  *  2/13/2020
  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

class FloorPlanSystem extends JPanel{
    private final int NUM_TABLES = 50;
    static ArrayList<Table> tables = new ArrayList<Table>(10);
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    static int mx, my;  
    static ArrayList dragged = new ArrayList(50);
    public FloorPlanSystem(final ArrayList<Table> t){
        this.tables = t;
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseListener());
        // till we buy the thing to test
        for(int i = 0; i < NUM_TABLES; i++){
            Table newTab = new Table(10);
            this.tables.add(newTab);
        }


        int incrementX = 0;
        int incrementY = 0;
    	for(int i = 0; i < NUM_TABLES; i++){
            if(incrementX*tables.get(i).getRadius() >= MAX_X){
                incrementX = 0;
                incrementY++;
            }
            this.tables.get(i).setX(incrementX*tables.get(i).getRadius());
            this.tables.get(i).setY(incrementY*tables.get(i).getRadius());
            incrementX++;        
        }
    }
    public void paintComponent(final Graphics g){
        super.paintComponent(g);
        //Draw Stuff Here
        g.setColor(Color.BLACK);
        for(int i = 0; i < tables.size(); i++){
            if (tables.get(i).getDragged()){
                tables.get(i).setX(mx);
                tables.get(i).setY(my);
            }
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
    private static class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {
      
         } @Override
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
    public void mouseDragged(MouseEvent mouseEvent){
        mx = mouseEvent.getX();
        my = mouseEvent.getY();
        Rectangle mouseRect = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 1, 1);
        for (int i = 0; i < 50; i++){
            if (mouseRect.intersects(tables.get(i).getBoundingBox())){
                tables.get(i).setDragged(true);
                mouseEvent.consume();

            }
    
    }
}
    public void mouseMoved(MouseEvent mouseEvent){
        mx = mouseEvent.getX();
        my = mouseEvent.getY();
        System.out.println(mx + ":" + my);
        Rectangle mouseRect = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 1, 1);
        for (int i = 0; i < 50; i++){
            if (mouseRect.intersects(tables.get(i).getBoundingBox())){
                tables.get(i).setDragged(false);

            }
    }
    mouseEvent.consume();
    }
}
}