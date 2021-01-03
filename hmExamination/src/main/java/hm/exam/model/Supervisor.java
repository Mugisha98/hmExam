package hm.exam.model;

import javax.persistence.*;
import java.util.List;

@Entity //Map this class to DB
@Table(name = "Supervisors")
public class Supervisor {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AutoGenerates an unique ID
    private Long id;

    //Column names in the DB
    @Column(name = "supervisor_first_name")
    private String firstName;
    @Column(name = "supervisor_last_name")
    private String lastName;
    @Column(name = "supervisor_email")
    private String email;

    //One supervisor to many students
    @OneToMany(cascade = CascadeType.ALL, mappedBy="supervisor")  //mappedBy attribute to define this inverse relation.
    private List<Student> studentList;

    //Getter
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}