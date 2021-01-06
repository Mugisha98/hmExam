package hm.exam.controller;

import hm.exam.model.Supervisor;
import hm.exam.repository.ISupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupervisorRESTController {

    @Autowired
    ISupervisorRepository iSupervisorRepository;

    @GetMapping("/supervisors")
    public Iterable<Supervisor> get(){
        return iSupervisorRepository.findAll();
    }
}
