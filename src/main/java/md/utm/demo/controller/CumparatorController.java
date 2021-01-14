package md.utm.demo.controller;

import md.utm.demo.entity.Cumparator;
import md.utm.demo.repository.CumparatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cumparator")
public class CumparatorController {

    @Autowired
    private CumparatorRepository cumparatorRepository;

    @GetMapping
    public List<Cumparator>getAll(){
        List<Cumparator> cumparator = cumparatorRepository.findAll();
        return cumparator;
    }

    @PostMapping
    public void save(@RequestBody Cumparator cumparator){
        cumparatorRepository.save(cumparator);
    }

    @PutMapping("/{id}")
    public void updater(@PathVariable Long id, @RequestBody Cumparator cumparator){
        cumparatorRepository.update(id, cumparator);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cumparatorRepository.delete(id);
    }

}
