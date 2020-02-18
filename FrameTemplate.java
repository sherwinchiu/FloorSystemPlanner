import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class FrameTemplate extends JFrame {

    private final int MAX_X = (int)getToolkit().getScreenSize().getWidth();
    private final int MAX_Y = (int)getToolkit().getScreenSize().getHeight();

    FrameTemplate () {
        //Creates our panel
        DrawingPanel panel = new DrawingPanel();
        //Add Panel to frame
        this.getContentPane().add(BorderLayout.CENTER, panel);

        //Add key listener to frame
        this.addKeyListener(new MyKeyListener());
        //Add mouse listener to frame
        this.addMouseListener(new MyMouseListener());

        //Set frame to close when you press the x
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set size of the frame
        this.setSize(MAX_X, MAX_Y);
        //Sets visibility to true
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

    private static class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

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
