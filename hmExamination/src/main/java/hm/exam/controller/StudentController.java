package hm.exam.controller;

import hm.exam.model.Student;
import hm.exam.repository.IStudentRepository;
import hm.exam.repository.ISupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Optional;

@Controller //Returns view
public class StudentController {

    @Autowired
    private IStudentRepository iStudentRepository; //Declared
    @Autowired
    private ISupervisorRepository iSupervisorRepository; //Declared

    //Get all students
    @GetMapping("/student-overview")
    public String studentOverview(Model model){
        model.addAttribute("studentsToReturn", iStudentRepository.findAll());
        return "overview-student";
    }
    //Get student to create
    @GetMapping("/create-student")
    public String createStudent(Model model){
        Student student = new Student(); //instantiate
        model.addAttribute("studentToBeInserted", student);
        //find the supervisor by id to create a student with the a supervisor_id
        model.addAttribute("selectSupervisor", iSupervisorRepository.findAll());
        return "create-student";
    }
    //Saves the created student
    @PostMapping("/create-student")
    public String createdStudent(@ModelAttribute Student newStudent){
        iStudentRepository.save(newStudent);
        return "successful";
    }
    //Get student to update
    @GetMapping("/edit-student/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model){
        Optional<Student> student = iStudentRepository.findById(id);

        model.addAttribute("selectSupervisor", iSupervisorRepository.findAll());
        //save the updated student with supervisor_id
        model.addAttribute("studentToBeUpdated",iStudentRepository.findById(id));
        iStudentRepository.deleteById(student.get().getId());

        return "edit-student";
    }
    //Update student
    @PostMapping("/edit-student")
    public String studentUpdated(@ModelAttribute Student StudentToBeUpdated){
        iStudentRepository.save(StudentToBeUpdated);

        return "successful";
    }
    //Deletes student by id
    @GetMapping("/delete-student/{id}")
    private String deleteStudent(@PathVariable("id") Long id){
        Optional<Student> student = iStudentRepository.findById(id);

        iStudentRepository.deleteById(student.get().getId());

        return "successful";
    }
}