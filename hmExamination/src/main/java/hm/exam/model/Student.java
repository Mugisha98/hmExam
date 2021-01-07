package hm.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;

@JsonIgnoreProperties({"supervisor","id"})
@Entity //Map this class to DB via Hibernate
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
    @JsonIgnore //ignore the method when student is serialize & deserialize  TODO: Udkommenter @JsonIgnore med Thymeleaf
    public Long getSupervisorId() {
        return supervisor.getId();
    } //Used for getting Supervisor id in student Tab
    @JsonIgnore //ignore the method when student is serialize & deserialize TODO: Udkommenter @JsonIgnore med Thymeleaf
    public String getSupervisorName(){return supervisor.getFirstName();} //Used for getting name of supervisor in student table
    public Supervisor getSupervisor() {
        return supervisor;
    } //Returns an object for StudentController class to use

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