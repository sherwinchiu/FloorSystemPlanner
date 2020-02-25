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
    static boolean somethingDragging = false;
    static ArrayList<Table> tables = new ArrayList<Table>(10);
    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();
    private int mx, my;  
    public FloorPlanSystem(final ArrayList<Table> t){
        this.tables = t;
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseListener());
        // till we buy the thing to test
        for(int i = 0; i < 6; i++){
            Table newTab = new Table(10);
            this.tables.add(newTab);
        }
        Student s1 = new Student("sherwin", "073726689");
        Student s2 = new Student("Kyro", "235123");
        for(int i = 0; i < 6; i++){
            tables.get(0).addStudent(s1);
            tables.get(0).addStudent(s2);
            tables.get(1).addStudent(s1);
            tables.get(1).addStudent(s2);
        }
        
        setTable();
        
    }
    public void setTable() {
        int incrementX = 0;
        int incrementY = 0;
        for (int i = 0; i < tables.size(); i++) {
            if (incrementX * tables.get(i).getRadius() >= MAX_X) {
                incrementX = 0;
                incrementY++;
            }
            this.tables.get(i).setX(incrementX * tables.get(i).getRadius());
            this.tables.get(i).setY(incrementY * tables.get(i).getRadius());
            incrementX++;
        }
        this.tables.get(i).setX(incrementX*tables.get(i).getRadius());
        this.tables.get(i).setY(incrementY*tables.get(i).getRadius());
        incrementX++;        
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        // Draw Stuff Here
        g.setColor(Color.BLACK);
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getDragged()) {
                tables.get(i).setX(mx);
                tables.get(i).setY(my);
            }
            tables.get(i).drawChair(g);
            tables.get(i).drawTable(g);
        }
        // Updates and redraws the panel
        this.repaint();
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener {
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

        public void mouseDragged(MouseEvent mouseEvent) {
            mx = mouseEvent.getX();
            my = mouseEvent.getY();
            Rectangle mouseRect = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 1, 1);
            for (int i = 0; i < 50; i++) {
                if (mouseRect.intersects(tables.get(i).getBoundingBox())) {
                    tables.get(i).setDragged(true);
                    mouseEvent.consume();

    @Override
    public void mouseExited(final MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(final MouseEvent mouseEvent) {

    }
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        for (int i = 0; i < tables.size(); i++){
                somethingDragging = false;
                tables.get(i).setDragged(false);
            }
        }   
    public void mouseDragged(MouseEvent mouseEvent){
    mx = mouseEvent.getX();
    my = mouseEvent.getY();
    Rectangle mouseRect = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 1, 1);
    for (int i = 0; i < tables.size(); i++){
        if (mouseRect.intersects(tables.get(i).getBoundingBox()) && !somethingDragging){
            tables.get(i).setDragged(true);
            somethingDragging = true;
            mouseEvent.consume();

        }

    }
    }
    public void mouseMoved(MouseEvent mouseEvent){
    mx = mouseEvent.getX();
    my = mouseEvent.getY();
    System.out.println(mx + ":" + my);
    Rectangle mouseRect = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 1, 1);
    for (int i = 0; i < tables.size(); i++){
        if (mouseRect.intersects(tables.get(i).getBoundingBox())){
            somethingDragging = false;
            tables.get(i).setDragged(false);
        }
    }   
    mouseEvent.consume();
    }
    }
    }