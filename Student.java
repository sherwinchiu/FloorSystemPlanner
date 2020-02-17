import java.util.ArrayList;
public class Student{
    private String name;
    private int id;
    private ArrayList<Student> partners = new ArrayList<>(0);
    private boolean paid;
    public Student(String name, int id, ArrayList<Student> partners){
        this.name = name;
        this.id = id;
        this.partners = partners;
    }
    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return id;
    }
    public ArrayList<Student> getPartners(){
        return this.partners;
    }
    public void setPartners(ArrayList<Student> partners){
        this.partners = partners;
    }
    public boolean hasPaid(){
        return this.paid;
    }
    public void setPaid(boolean paid){
        this.paid = paid;
    }
}