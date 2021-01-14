package md.utm.demo.repository;

import md.utm.demo.entity.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class CarteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Carte> findAll(){
        List<Carte> carte = jdbcTemplate.query("SELECT * FROM carte",
                (response, rowNumber)->
                new Carte(response.getLong("id"),
                        response.getString("denumire"),
                        response.getString("autor"),
                        response.getInt("anulEditiei"),
                        response.getString("editura"),
                        response.getString("ISBN"),
                        response.getInt("nrPagini")));
        return carte;
    }

    public Carte findById(Long id){
        Carte carte = jdbcTemplate.queryForObject("SELECT * FROM carte WHERE id = ?",
                new Object[]{id},
                (response, rowNumber)->
                        new Carte(response.getLong("id"),
                                response.getString("denumire"),
                                response.getString("autor"),
                                response.getInt("anulEditiei"),
                                response.getString("editura"),
                                response.getString("ISBN"),
                                response.getInt("nrPagini"))
                );
        return carte;
    }

    public List<Carte> findAllByNrPage(Integer nrPage){
        List<Carte> booklist = jdbcTemplate.query("SELECT * FROM carte WHERE nrPagini = ?",
                new Object[]{nrPage},
                (response, rowNumber)->
                        new Carte(response.getLong("id"),
                                response.getString("denumire"),
                                response.getString("autor"),
                                response.getInt("anulEditiei"),
                                response.getString("editura"),
                                response.getString("ISBN"),
                                response.getInt("nrPagini"))
                );
        return booklist;
    }

    public Carte findByIdAndName(Long id, String name){
        Carte carte = jdbcTemplate.queryForObject("SELECT * FROM carte WHERE id = ? AND denumire = ?",
                new Object[]{id, name},
                (response, rowNumber)->
                        new Carte(response.getLong("id"),
                                response.getString("denumire"),
                                response.getString("autor"),
                                response.getInt("anulEditiei"),
                                response.getString("editura"),
                                response.getString("ISBN"),
                                response.getInt("nrPagini"))
                );
        return carte;
    }

    public void save(Carte carte){
        jdbcTemplate.update("INSERT INTO carte(id, denumire, autor, anulEditiei, editura, ISBN, nrPagini) VALUES (?, ?, ?, ?, ?, ?, ?)",
                carte.getId(), carte.getDenumire(), carte.getAutor(), carte.getAnulEditiei(), carte.getEditura(), carte.getISBN(), carte.getNrPagini());
    }

    public void update(Long id, Carte carte){
        jdbcTemplate.update("UPDATE carte SET denumire = ?, autor = ?, anulEditiei = ?, editura = ?, ISBN = ?, nrPagini = ? WHERE id = ?", carte.getDenumire(), carte.getAutor(), carte.getAnulEditiei(), carte.getEditura(), carte.getISBN(), carte.getNrPagini(), id);
    }

    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM carte WHERE id = ?", id);
    }

}
