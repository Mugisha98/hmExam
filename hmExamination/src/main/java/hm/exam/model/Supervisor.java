package hm.exam.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supervisors")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supervisor_first_name")
    private String firstName;
    @Column(name = "supervisor_last_name")
    private String lastName;
    @Column(name = "supervisor_email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="supervisor")
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