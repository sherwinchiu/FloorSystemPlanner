
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

class FloorPlanSystem extends JPanel {
    private int mouseCounter = 0;
    private long startTime = System.currentTimeMillis();
    private long elapsedTime = System.currentTimeMillis() - startTime;
    private boolean somethingDragging = false;
    private ArrayList<Student> sideStudents = new ArrayList<Student>(0);
    private ArrayList<Table> tables = new ArrayList<Table>(0);
    private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();
    private int mx, my;
    private Rectangle mouseRect = new Rectangle(mx, my, 1, 1);
    Font diameterFont = new Font("Serif", Font.PLAIN, 30);

    public FloorPlanSystem(final ArrayList<Table> t) {
        this.tables = t;
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseListener());
        // Testing for tables
        for (int i = 0; i < 15; i++) {
            Table newTab = new Table(10);
            this.tables.add(newTab);
        }
        setTable();
        Student s1 = new Student("sherwin", "073726689");
        Student s2 = new Student("Kyro", "235123");
        Student s3 = new Student("sherwin", "1234567");
        tables.get(0).addStudent(s1);
        tables.get(0).addStudent(s3);
        for (int i = 0; i < 6; i++) {
            tables.get(0).addStudent(s2);
            tables.get(1).addStudent(s1);
            tables.get(1).addStudent(s2);
        }

    }
    public void setTable() {
        int incrementX = 0;
        int incrementY = 0;
        int tableSetX = 0;
        int tableSetY = 0;
        for (int i = 0; i < tables.size(); i++) {
            if (tableSetX >= MAX_X) {
                incrementX = 0;
                incrementY++;
            }
            tableSetX = (int)(375+incrementX * tables.get(i).getRadius()*1.5);
            tableSetY = (int)(100+incrementY * tables.get(i).getRadius()*1.5);
            this.tables.get(i).setX(tableSetX);
            this.tables.get(i).setY(tableSetY);
            incrementX++;
        }
    }
    private void displaySidePanel(final Graphics g){
        g.setColor(new Color(212,235,242));
        g.fillRect(0,0,300, MAX_Y);
        g.setColor(Color.BLACK);
    }
    private void displaySideNames(final Graphics g){
        int incrementY = 20;
        int sideNameY = 0;
        
        for(int i = 0; i < this.sideStudents.size(); i++){
            sideNameY = 20+incrementY*((i)*5);
            g.setFont(new Font("Times New Roman", Font.BOLD, 25));
            g.drawString(sideStudents.get(i).getName(), 2, sideNameY);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            g.drawString("Student ID: " +sideStudents.get(i).getId(), 15, sideNameY+20);
        }
    }
    private void processSideNames(int tIndex, int sIndex){
        sideStudents.add(this.tables.get(tIndex).getStudents().get(sIndex));
    }
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        // Draw Stuff Here
        g.setColor(Color.BLACK);
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getDragged()) {
                tables.get(i).setX(mx-tables.get(i).getDiameter()/2);
                tables.get(i).setY(my-tables.get(i).getDiameter()/2);
            }
            tables.get(i).drawTable(g);
            tables.get(i).drawChair(g);
        }
        displaySidePanel(g);
        displaySideNames(g);
        
        // Updates and redraws the panel
        this.repaint();
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {
            elapsedTime = System.currentTimeMillis() - startTime;
            mouseCounter++;
            if (mx >= 50 && mx <= 150 && my >= 500 && my <= 540){
                for (int i = 0; i < tables.size(); i++){
                    tables.get(i).setDiameter(tables.get(i).getDiameter()+10);
                    setTable();
                }
            }
            else if (mx >= 50 && mx <= 150 && my >= 600 && my <= 640){
                for (int i = 0; i < tables.size(); i++){
                    tables.get(i).setDiameter(tables.get(i).getDiameter()-10);
                    setTable();
                }
        }
            else if (elapsedTime > 1000) {
                mouseCounter = 0;
                startTime = System.currentTimeMillis();
            } else if (elapsedTime < 1000 && mouseCounter >= 2) {
                mouseCounter = 0;
                startTime = System.currentTimeMillis();
                mx = mouseEvent.getX();
                my = mouseEvent.getY();
                mouseRect.x = mx;
                mouseRect.y = my;
                for (int i = 0; i < tables.size(); i++) {
                    for (int j = 0; j < tables.get(i).getStudents().size(); j++) {
                        if (mouseRect.intersects(tables.get(i).getNameRect(j))) {
                            processSideNames(i, j);
                        }
                    }
                }
            }
    }
        @Override
        public void mouseEntered(final MouseEvent mouseEvent) {
        }

        public void mouseExited(final MouseEvent mouseEvent) {
        }
        @Override
        public void mousePressed(final MouseEvent mouseEvent) {
        }
        @Override
        public void mouseReleased(final MouseEvent mouseEvent) {
            for (int i = 0; i < tables.size(); i++) {
                somethingDragging = false;
                tables.get(i).setDragged(false);
            }
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            mx = mouseEvent.getX();
            my = mouseEvent.getY();
            mouseRect.x = mx;
            mouseRect.y = my;
            for (int i = 0; i < tables.size(); i++) {
                if (mouseRect.intersects(tables.get(i).getTableRect()) && !somethingDragging) {
                    tables.get(i).setDragged(true);
                    somethingDragging = true;
                    mouseEvent.consume();
                }
            }
        }
        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            mx = mouseEvent.getX();
            my = mouseEvent.getY();
            mouseRect.x = mx;
            mouseRect.y = my;
            for (int i = 0; i < tables.size(); i++) {
                if (mouseRect.intersects(tables.get(i).getTableRect())) {
                    somethingDragging = false;
                    tables.get(i).setDragged(false);
                    mouseEvent.consume();   
                }
            }
        }
    }
}
