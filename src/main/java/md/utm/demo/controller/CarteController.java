package md.utm.demo.controller;

import lombok.Getter;
import md.utm.demo.entity.Carte;
import md.utm.demo.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carte")
public class CarteController {

    @Autowired
    private CarteRepository carteRepository;

    List<String> names = new ArrayList<>();

    @GetMapping
    public List<Carte> test(){
        List<Carte> cartelist = carteRepository.findAll();
        return cartelist;
    }

    @GetMapping("/{id}")
    public Carte findById(@PathVariable Long id){
        Carte carte = carteRepository.findById(id);
        return carte;
    }

    @GetMapping("/nrPagini/{nrPage}")
    public List<Carte> findAllByNrPage(@PathVariable Integer nrPage){
        List<Carte> booklist = carteRepository.findAllByNrPage(nrPage);
        return booklist;
    }

    @GetMapping("/{id}/{name}")
    public Carte findByIdAndName(@PathVariable Long id, @PathVariable String name){
        Carte carte = carteRepository.findByIdAndName(id, name);
        return carte;
    }

    @PostMapping("/test/{name}")
    public List<String> test(@PathVariable String name){
        names.add(name);
        return names;
    }

    @PostMapping
    public void save(@RequestBody Carte carte){
        carteRepository.save(carte);
    }

    @PutMapping("/{id}")
    public void updater(@PathVariable Long id, @RequestBody Carte carte){
        carteRepository.update(id, carte);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        carteRepository.delete(id);
    }

}
