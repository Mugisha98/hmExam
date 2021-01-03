package hm.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@JsonIgnoreProperties({"supervisor","id"})
@Entity //Map this class to DB
@Table(name = "Students")
public class Student {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AutoGenerates an unique ID
    private Long id;

    //Column names in the DB
    @Column(name = "student_first_name")
    private String firstName;
    @Column(name = "student_last_name")
    private String lastName;
    @Column(name = "student_email")
    private String email;


    @ManyToOne //Many supervisors to one student
    @JoinColumn(name = "supervisor_id") //Which column to join the entities(Students & Supervisors)
    private Supervisor supervisor;

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
    public Long getSupervisorId() {
        return supervisor.getId();
    }  //Used for getting Supervisor id in student Table
    public String getSupervisorName(){return supervisor.getFirstName();} //Used for getting name of supervisor in student table
    public Supervisor getSupervisor() {
        return supervisor;
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
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

}