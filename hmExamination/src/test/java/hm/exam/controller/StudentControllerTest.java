package hm.exam.controller;


import com.sun.xml.bind.v2.runtime.output.SAXOutput;
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

    //Instantiate
    Student student;

    @InjectMocks //creates objects and inject mocked dependencies
    StudentController studentController;

    @Mock //To create mock object for IStudentRepository dependency instead of calling the real Repository
    IStudentRepository iStudentRepository;

    @BeforeEach //Before doing anything do this
    void setUp(){
        student = new Student(); //Declared the instance
    }

    @Test
    void createdStudent() {
        Assertions.assertEquals("successful", studentController.createdStudent(student));
        System.out.println("Test completed!");
    }

    @Test
    void createstudent(){
        Assertions.assertEquals("hejjj", studentController.createdStudent(student));
    }

}