package hm.exam.controller;

import hm.exam.model.Student;
import hm.exam.repository.IStudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //@RestController used to make REST API request and return data in JSON or XML (combi @ResponseBody and @Controller)
public class StudentRestController {

    //Todo: Use this for postman

    IStudentRepository studentRepository;

    public StudentRestController(IStudentRepository iStudentRepository) {
        this.studentRepository = iStudentRepository;
    }

    //Create student
    @PostMapping("/students")
    public  ResponseEntity<String> create(@ModelAttribute Student studentToCreate){
        Student student = studentRepository.save(studentToCreate);
        // ResponseEntity constructor expects parameters as status(), header() and body()
        return  ResponseEntity.status(201).header("Location","/students/" + student.getId()+student.getSupervisor()).body("{'Msg': "+student.getFirstName()+"'student created'}");
    }
    //Read all students
    @GetMapping("/students")
    public Iterable<Student> index(){
        return studentRepository.findAll();
    }
    //Read student by id
    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Long id){
        Optional<Student> response = studentRepository.findById(id);
        if(response.isPresent()){
            return ResponseEntity.status(200).body(response);
        }else{
            return ResponseEntity.status(404).body(response);
        }
    }
    //Update students
    @PutMapping("/students")
    public ResponseEntity<String> update(@ModelAttribute Student studentToUpdate){
        studentRepository.save(studentToUpdate);
        return ResponseEntity.status(204).body("{'msg':'success!'}");
    }
    //Delete by id
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        return ResponseEntity.status(200).body("{'msg' : 'deleted'}");
    }

}
