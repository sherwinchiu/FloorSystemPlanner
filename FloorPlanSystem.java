/**  FloorPlanSystem class 
  *  Sherwin Chiu and Kyro Nassif
  *  Visual Display of floor for Prom   
  *  2/13/2020
  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class FloorPlanSystem extends JPanel{
    private final int NUM_TABLES = 50;
    private ArrayList<Table> tables = new ArrayList<Table>(10);
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    public FloorPlanSystem(final ArrayList<Table> t){
        this.tables = t;
        // till we buy the thing to test
        for(int i = 0; i < NUM_TABLES; i++){
            Table newTab = new Table(50, 50, 10);
            this.tables.add(newTab);
        }
        Student s1 = new Student("sherwin", "073726689");
        Student s2 = new Student("Kyro", "235123");
        tables.get(0).addStudent(s1);
        tables.get(0).addStudent(s2);
        tables.get(1).addStudent(s1);
        tables.get(1).addStudent(s2);
        
    }
    public void setTable(){
        int incrementX = 0;
        int incrementY = 0;
    	for(int i = 0; i < NUM_TABLES; i++){
            if(incrementX*200 >= MAX_X){
                incrementX = 0;
                incrementY++;
            }
            this.tables.get(i).setX(incrementX*200);
            this.tables.get(i).setY(incrementY*200);
            incrementX++;        
        }
    }
    public void paintComponent(final Graphics g){
        super.paintComponent(g);
        //Draw Stuff Here
        g.setColor(Color.BLACK);
        setTable();
        System.out.println(tables.get(0).getSize());
        for(int i = 0; i < tables.size(); i++){
            tables.get(i).drawChair(g);
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