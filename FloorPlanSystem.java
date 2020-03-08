
/**  FloorPlanSystem class 
 *  Sherwin Chiu and Kyro Nassif
 *  Visual display of floor for Prom   
 *  2/13/2020
 */
// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class FloorPlanSystem extends JPanel {
    private static final long serialVersionUID = 1L;
    // Adding panel variables
    private final int MAX_X = (int) getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int) getToolkit().getScreenSize().getHeight();

    // Adding Mouse Variables
    private int mx, my;
    private int mouseCounter = 0;
    private long startTime = System.currentTimeMillis();
    private long elapsedTime = System.currentTimeMillis() - startTime;
    private boolean somethingDragging = false;
    // Adding variables used for displaying
    private ArrayList<Student> sideStudents = new ArrayList<Student>(0);
    private ArrayList<Table> tables = new ArrayList<Table>(0);
    // Adding rectangles for button interaction
    private Rectangle mouseRect = new Rectangle(mx, my, 1, 1);
    private Rectangle sizeUpRect = new Rectangle(25, MAX_Y - (MAX_Y / 5) + 100, 100, 40);
    private Rectangle sizeDownRect = new Rectangle(175, MAX_Y - (MAX_Y / 5) + 100, 100, 40);
    private ArrayList<Rectangle> removeStudentRect = new ArrayList<Rectangle>(0);
    private Rectangle backRect = new Rectangle(0, 0, 100, 40);
    // Adding fonts used in the planner
    private final Font diameterFont = new Font("Times New Roman", Font.PLAIN, 30);
    private final Font studentFont = new Font("Times New Roman", Font.PLAIN, 14);
    private final Font sidePanelFont = new Font("Times New Roman", Font.BOLD, 25);
    private Prom parent;

    public FloorPlanSystem(final ArrayList<Table> t, Prom parent){ //constructor{
        this.tables = t;
        this.parent = parent;
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseListener());
        this.setVisible(false);
        this.tables.add(new Table(2));
    }
    // -----------------------------------------------------------------------------------------------------
    // Setup and Logistical Methods -
    // -----------------------------------------------------------------------------------------------------
    public void setTable() {
        int incrementX = 0;
        int incrementY = 0;
        int tableSetX = 375;
        int tableSetY = 100;
        for (int i = 0; i < tables.size(); i++) {
          this.tables.get(i).refreshChairs();
            if (tableSetX + tables.get(0).getDiameter() * 3 >= MAX_X) {
                incrementX = 0;
                incrementY++;
            }
            tableSetX = (int) (375 + incrementX * tables.get(i).getDiameter() * 1.5);
            tableSetY = (int) (100 + incrementY * tables.get(i).getDiameter() * 1.5);
            this.tables.get(i).setX(tableSetX);
            this.tables.get(i).setY(tableSetY);
            incrementX++;
        }
    }

    /**
     * @param tIndex
     * @param sIndex
     */
    // -----------------------------------------------------------------------------------------------------
    private void addSideNames(int tIndex, int sIndex) { // displays names on side 
        if (sideStudents.size() < MAX_Y / 135) {
            sideStudents.add(this.tables.get(tIndex).getStudents().get(sIndex));
            removeStudentRect.add(new Rectangle(270, 0, 20, 20));
        }
    }

    /**
     * @param num
     */
    // -----------------------------------------------------------------------------------------------------
    private void removeSideName(int num) {// removes names on side
        sideStudents.remove(num);
        removeStudentRect.remove(num);
    }

    /**
     * @param g
     */
    // -----------------------------------------------------------------------------------------------------
    // Drawing Methods -
    // -----------------------------------------------------------------------------------------------------
    private void drawSidePanel(final Graphics g) {// draws side panel
        g.setColor(new Color(212, 235, 242));
        g.fillRect(0, 0, 300, MAX_Y);
        g.setColor(Color.BLACK);
    }

    /**
     * @param g
     */
    // ----------------------------------------------------------------------------------------------------
    private void drawSideNames(final Graphics g) { // draws names on side
        int incrementY = 20;
        int sideNameY = 0;
        for (int i = 0; i < this.sideStudents.size(); i++) {
            sideNameY = 100 + incrementY * ((i) * 5);
            removeStudentRect.get(i).setRect(270, sideNameY - 10, 20, 20);
            g.setFont(sidePanelFont);
            g.drawString(sideStudents.get(i).getName(), 2, sideNameY);
            g.drawRect(270, sideNameY - 10, 20, 20);
            g.setColor(Color.RED);
            g.drawLine(270, sideNameY - 10, 290, sideNameY + 10);
            g.drawLine(270, sideNameY + 10, 290, sideNameY - 10);
            g.setColor(Color.BLACK);
            g.setFont(studentFont);
            g.drawString("Student ID: " + sideStudents.get(i).getId(), 15, sideNameY + 20);
        }
    }

    /**
     * @param g
     */
    // ----------------------------------------------------------------------------------------------------
    private void drawTableNum(final Graphics g) {//draw table numbers
        g.setFont(sidePanelFont);
        for (int i = 0; i < tables.size(); i++) {
            g.drawString("" + (i + 1), tables.get(i).getX() + tables.get(0).getDiameter() / 2 - 5,
                    tables.get(i).getY() + tables.get(0).getDiameter() / 2 + 5);
        }
    }

    /**
     * @param g
     */
    // ----------------------------------------------------------------------------------------------------
    private void drawInfo(final Graphics g) { //draw student info
        g.setFont(sidePanelFont);
        g.drawString("Additional Info", 10, MAX_Y - MAX_Y / 6 - 10);
        g.setFont(studentFont);
        g.drawString("Double-click names for more info.", 10, MAX_Y - MAX_Y / 6 + 5);
        g.drawString("Drag the tables to move them.", 10, MAX_Y - MAX_Y / 6 + 20);
        g.drawString("Press size buttons to change size.", 10, MAX_Y - MAX_Y / 6 + 35);
        g.drawString("Press the back button to go back to main menu.", 10, MAX_Y - MAX_Y / 6 + 50);
    }

    /**
     * @param g
     */
    private void drawSizeButtons(final Graphics g) { //draw buttons for size
        g.drawRect(25, MAX_Y - (MAX_Y / 5) + 100, 100, 40);
        g.drawRect(175, MAX_Y - (MAX_Y / 5) + 100, 100, 40);
        g.setFont(diameterFont);
        g.drawString("Size +", 30, MAX_Y - (MAX_Y / 5) + 132);
        g.drawString("Size -", 180, MAX_Y - (MAX_Y / 5) + 132);
    }

    /**
     * @param g
     */
    // ----------------------------------------------------------------------------------------------------
    private void drawBackButton(final Graphics g) { //draw back button
        g.drawRect(0, 0, 100, 40);
        g.setFont(diameterFont);
        g.drawString("Back", 15, 30);
    }

    /**
     * @param g
     */
    // ----------------------------------------------------------------------------------------------------
    public void paintComponent(final Graphics g) { //paints the screen
        super.paintComponent(g);
        // Draw Stuff Here
        g.setColor(Color.BLACK);
        g.setFont(studentFont);
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getDragged()) {
                tables.get(i).setX(mx - tables.get(i).getDiameter() / 2);
                tables.get(i).setY(my - tables.get(i).getDiameter() / 2);
            }
            tables.get(i).drawTable(g);
            tables.get(i).drawChair(g);
        }
        drawTableNum(g);
        drawSidePanel(g);
        drawSideNames(g);
        drawInfo(g);
        drawSizeButtons(g);
        drawBackButton(g);
        // Updates and redraws the panel
        this.repaint();
    }

    // -----------------------------------------------------------------------------------------------------
    // Clicking Methods -
    // -----------------------------------------------------------------------------------------------------
    private void sizeButtonPushed() { // if size button is pushed
        if (tables.size() != 0) {
            if (mouseRect.intersects(sizeUpRect) && tables.get(0).getDiameter() < 200) {
                for (int i = 0; i < tables.size(); i++) {
                    if (tables.get(i) != null) {
                        tables.get(i).setDiameter(tables.get(i).getDiameter() + 10);
                        tables.get(i).refreshChairs();
                    }
                }
            } else if (mouseRect.intersects(sizeDownRect) && tables.get(0).getDiameter() > 130) {
                for (int i = 0; i < tables.size(); i++) {
                    if (tables.get(i) != null) {
                        tables.get(i).setDiameter(tables.get(i).getDiameter() - 10);
                        tables.get(i).refreshChairs();
                    }
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------
    private void doubleClick() { //checks if they double clicked
        elapsedTime = System.currentTimeMillis() - startTime;
        mouseCounter++;
        if (elapsedTime > 1000) {
            mouseCounter = 0;
            startTime = System.currentTimeMillis();
        } else if (elapsedTime < 1000 && mouseCounter >= 2) {
            mouseCounter = 0;
            startTime = System.currentTimeMillis();
            for (int i = 0; i < tables.size(); i++) {
                for (int j = 0; j < tables.get(i).getStudents().size(); j++) {
                    if (mouseRect.intersects(tables.get(i).getNameRect(j))) {
                        addSideNames(i, j);
                    }
                }
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------
    private void backButtonPushed() { // if back button pushed
        if (mouseRect.intersects(backRect)) {
            parent.remove(this);
            parent.setMenuPanel();
            setVisible(false);
            parent.revalidate();
            parent.repaint();
        }
    }

    // -----------------------------------------------------------------------------------------------------
    private void clearStudentButtonPushed() { //if clear student button is pushed
        for (int i = 0; i < removeStudentRect.size(); i++) {
            if (mouseRect.intersects(removeStudentRect.get(i))) {
                removeSideName(i);
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------
    private class MyMouseListener implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {
            doubleClick(); // Check if mouse has been double clicked
            sizeButtonPushed(); // Check if either size up or size down button is pushed
            backButtonPushed(); // Check if back button has been pushed
            clearStudentButtonPushed(); // Check if clear students button has been pushed
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
                tables.get(i).refreshChairs();
            }
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            mx = mouseEvent.getX();
            my = mouseEvent.getY();
            mouseRect.x = mx;
            mouseRect.y = my;
            for (int i = 0; i < tables.size(); i++) {
                if (mouseRect.intersects(tables.get(i).getTableRect()) && !somethingDragging) { // if they click a table
                    tables.get(i).setDragged(true);
                    somethingDragging = true;
                    mouseEvent.consume();
                    tables.get(i).refreshChairs();
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
                if (mouseRect.intersects(tables.get(i).getTableRect())) { // if they click a table
                    somethingDragging = false;
                    tables.get(i).setDragged(false);
                    mouseEvent.consume();
                    tables.get(i).refreshChairs();
                }
            }
        }
    }
}
