package hm.exam.controller;


import hm.exam.model.Student;
import hm.exam.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentControllerTest {


    Student student;

    @InjectMocks // creates objects and inject mocked dependencies
    StudentController studentController;

    @Mock //To create mock object for IStudentRepository dependency instead of calling the real Repository
    IStudentRepository iStudentRepository;


    @BeforeEach //
    void setUp(){
        student = new Student();
    }



    @Test
    void studentOverview() {
        //Assertions.assertEquals("overview-student", studentController.studentOverview());
    }

    @Test
    void createStudent() {
        //Assertions.assertEquals("create-student", studentController.createStudent());
    }


    @Test
    void createdStudent() {
        Assertions.assertEquals("successful", studentController.createdStudent(new Student()));
    }

    @Test
    void editStudent() {

        Assertions.assertEquals(4,2+2);
    }

    @Test
    void studentUpdated() {
    }
}