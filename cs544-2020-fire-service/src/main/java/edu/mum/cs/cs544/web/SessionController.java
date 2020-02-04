package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Session;
import edu.mum.cs.cs544.service.session.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private ISessionService sessionService;

    @GetMapping(value = "/session")
    public List<Session> getAllSession(){
        return this.sessionService.findAll();
    }

    @GetMapping(value = "/session/{id}")
    public Session getSession(@PathVariable Integer id){
        return this.sessionService.findById(id);
    }

    @PostMapping(value = "/session")
    public Session saveSession(@Valid Session session){
        return this.sessionService.save(session);
    }

    @PutMapping(value = "/session/{id}")
    public Session updateSession(@Valid Session session){
        return this.sessionService.save(session);
    }

    @DeleteMapping(value = "/session/{id}")
    public boolean deleteSession(@PathVariable Integer id){
        return this.sessionService.delete(id);
    }
}
