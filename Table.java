import java.awt.*;

class Table{
    private int size;
    private Student[] students;
    private int x;
    private int y;
    private final int RADIUS = 25;
    
    public Table(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void addStudent(Student s){
        for (int i = 0; i < this.size; i++){
            if (this.students[i] == null){
                this.students[i] = s;
                i = this.size; //lol idk if he lets us do this
            }
        }
    }
    public void removeStudent(Student s){
        for(int i = 0; i < this.size; i++){
            if (s.getId() == students[i].getId())
                this.students[i] = null;
        }
    } 
    public Student[] getStudents(){
        return this.students;
    }
    public void setStudents(ArrayList<Student> s){
        for(int i = 0; i < this.size; i++)
            this.students[i] = s;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }


    
    public boolean isFull(){
        if (students[size-1] != null){
            return true;
        } else{
            return false;
        }
    }
    public void drawTable(Graphics g){
        g.drawOval(this.x, this.y, this.RADIUS, this.RADIUS);
      }
}
    
