import java.awt.*;
import java.util.ArrayList;

class Table{
    private int size;
    private ArrayList<Student> students = new ArrayList<>(0);
    private int x;
    private int y;
    private final int MAX_SIZE = 10;
    private final int RADIUS = 25;
    
    public Table(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void addStudent(Student s){
        this.students.add(s);
    }
    public void removeStudent(Student s){
        for(int i = 0; i < this.size; i++){
            if (s.getId() == this.students.get(i).getId())
                this.students.set(i, null);
        }
    } 
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public void setStudents(ArrayList<Student> s){
        this.students = s;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getRadius() {
    	return this.RADIUS;
    }
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    public boolean isFull(){
        if(this.size == this.MAX_SIZE)
            return true;
        else 
            return false;
    }
    public void drawTable(Graphics g){
        g.drawOval(this.x, this.y, this.RADIUS, this.RADIUS);
      }
}
    
