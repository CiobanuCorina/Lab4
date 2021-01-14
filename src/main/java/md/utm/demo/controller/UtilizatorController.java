package md.utm.demo.controller;

import md.utm.demo.entity.Utilizator;
import md.utm.demo.exception.UtilizatorNotFoundException;
import md.utm.demo.repository.UtilizatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/utilizator")
public class UtilizatorController {

    private static final Logger logger = LoggerFactory.getLogger(UtilizatorController.class);

    @Autowired
    private UtilizatorRepository utilizatorRepository;


    @GetMapping
    public List<Utilizator> getAll(){
        List<Utilizator> utilizator = utilizatorRepository.findAll();
        return utilizator;
    }

    //Get id
    @GetMapping("/{id}")
    public Utilizator findById(@PathVariable Long id) throws Exception{
        if(id < 1 || id > utilizatorRepository.count()){
            throw new UtilizatorNotFoundException(id);
        }
        Utilizator utilizator = utilizatorRepository.findById(id);
        return utilizator;
    }

    @GetMapping("/carte")
    public List<Utilizator> findAllBooks(){
        List<Utilizator> utilizatori = utilizatorRepository.findAllBooks();
        return utilizatori;
    }

    @PostMapping
    public void save(@RequestBody Utilizator utilizator){
        utilizatorRepository.save(utilizator);
    }

    @PutMapping("/{id}")
    public void updater(@PathVariable Long id, @RequestBody Utilizator utilizator){
        utilizatorRepository.update(id, utilizator);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        utilizatorRepository.delete(id);
    }

    @PatchMapping("/{id}/{varsta}")
    public void updateVarsta(@PathVariable Long id, @PathVariable int varsta){
        utilizatorRepository.updateVarsta(id, varsta);
    }


    @ExceptionHandler({ UtilizatorNotFoundException.class })
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex)
    {
        logger.error("raised " + ex);
        return new ResponseEntity<Object>( "Utilizator not found", new HttpHeaders(), HttpStatus.BAD_REQUEST); }


}
