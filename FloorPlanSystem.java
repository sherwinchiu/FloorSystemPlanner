
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
    private ArrayList<Table> tables = new ArrayList<Table>(0);
    private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();
    private int mx, my;

    public FloorPlanSystem(final ArrayList<Table> t) {
        this.tables = t;
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseListener());
        // till we buy the thing to test
        for (int i = 0; i < 6; i++) {
            Table newTab = new Table(10);
            this.tables.add(newTab);
        }
        setTable();
        Student s1 = new Student("sherwin", "073726689");
        Student s2 = new Student("Kyro", "235123");
        tables.get(0).addStudent(s1);
        for (int i = 0; i < 6; i++) {
            tables.get(0).addStudent(s2);
            tables.get(1).addStudent(s1);
            tables.get(1).addStudent(s2);
        }

    }

    public void setTable() {
        int incrementX = 0;
        int incrementY = 0;
        for (int i = 0; i < tables.size(); i++) {
            if (incrementX * tables.get(i).getRadius() >= MAX_X) {
                incrementX = 0;
                incrementY++;
            }
            this.tables.get(i).setX(MAX_X / 2 + incrementX * tables.get(i).getRadius() * 2);
            this.tables.get(i).setY(MAX_Y / 2 + incrementY * tables.get(i).getRadius() * 2);
            incrementX++;
            this.tables.get(i).setX(incrementX * tables.get(i).getRadius());
            this.tables.get(i).setY(incrementY * tables.get(i).getRadius());
            incrementX++;
        }
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
            tables.get(i).drawTable(g);
            tables.get(i).drawChair(g);
        }
        // Updates and redraws the panel
        this.repaint();
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {
            elapsedTime = System.currentTimeMillis() - startTime;
            mouseCounter++;
            if (elapsedTime > 1000) {
                mouseCounter = 0;
                startTime = System.currentTimeMillis();
            } else if (elapsedTime < 1000 && mouseCounter >= 2) {
                mouseCounter = 0;
                startTime = System.currentTimeMillis();
                mx = mouseEvent.getX();
                my = mouseEvent.getY();
                Rectangle mouseRect = new Rectangle(mx, my, 1, 1);
                for (int i = 0; i < tables.size(); i++) {
                    for (int j = 0; j < tables.get(i).getStudents().size(); j++) {
                        if (mouseRect.intersects(tables.get(i).getNameRect(j))) {
                            System.out.println(tables.get(i).getStudents().get(j).getId());
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
            mx = mouseEvent.getX() - tables.get(0).getRadius() / 2;
            my = mouseEvent.getY() - tables.get(0).getRadius() / 2;
            Rectangle mouseRect = new Rectangle(mx, my, 1, 1);
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
            System.out.println(mx + ":" + my);
            Rectangle mouseRect = new Rectangle(mouseEvent.getX(), mouseEvent.getY(), 1, 1);
            for (int i = 0; i < tables.size(); i++) {
                if (mouseRect.intersects(tables.get(i).getTableRect())) {
                    somethingDragging = false;
                    tables.get(i).setDragged(false);
                }
            }
            mouseEvent.consume();
        }
    }
}
