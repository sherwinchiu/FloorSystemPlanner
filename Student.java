import java.util.ArrayList;
import java.util.Comparator;
class Student implements Comparator<Student>{
    private String name;
    private String id;
    private ArrayList<Student> partners = new ArrayList<>(0);
    private boolean paid;
    private ArrayList<Student> unDesired = new ArrayList<Student>();
    public Student(String name, String id, ArrayList<Student> partners){
        this.name = name;
        this.id = id;
        this.partners = partners;
    }
    public Student(String name, String id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public String getId(){
        return id;
    }
    public ArrayList<Student> getPartners(){
        return this.partners;
    }
    public void setPartners(ArrayList<Student> partners){
        this.partners = partners;
    }
    public ArrayList<Student> getUndesired(){
        return this.unDesired;
    }
    public void setUndesired(ArrayList<Student> u){
        this.unDesired = u;
    }
    public boolean hasPaid(){
        return this.paid;
    }
    public void setPaid(boolean paid){
        this.paid = paid;
    }
    public boolean equals(Student s){
        if (compare(this, s) == 0)
            return true; 
        else   
            return false;
    }
    @Override
    public int compare(Student s1, Student s2) {
        if (Integer.parseInt(s1.getId()) > Integer.parseInt(s2.getId()))
            return 1;
        else if (s1.getId().equals(s2.getId()))
            return 0;
        else 
            return -1;
    }
}