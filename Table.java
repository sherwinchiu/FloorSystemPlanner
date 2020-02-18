import javax.swing.*;
import java.awt.*;

class Table{
    private int size;
    private Student[] students;
    private int x;
    private int y;
    private int radius;
    
    public Table(size){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public void draw(Graphics g){
      g.drawOval(this.x, this.y, this.radius, this.radius);
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setSize(int size){
        this.size = size;
        students = new Student[size];
    }
    
    public void addStudent(Student s){
        for (int i = 0; i < this.size; i++){
            if (students[i] == null);
            students[i] = s;
            i = this.size; //lol idk if he lets us do this
        }
    }
    public int getX(){
        return this.x;
    }
    public Student[] getStudents(){
        return this.students;
    }
    public int getY(){
        return this.y;
    }
    public boolean isFull(){
        if (students[size-1] != null){
            return true;
        } else{
            return false;
        }
    }
}
    