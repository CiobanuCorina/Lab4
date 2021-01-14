package md.utm.demo.repository;

import md.utm.demo.entity.Cumparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CumparatorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cumparator> findAll(){
        List<Cumparator> cumparator = jdbcTemplate.query("SELECT * FROM cumparator",
                (response,rowNumber) ->
                new Cumparator(response.getString("nume"),
                        response.getString("prenume"),
                        response.getInt("varsta"),
                        response.getString("produs"),
                        response.getDouble("suma"),
                        response.getInt("cantitatea")));
        return cumparator;
    }

    public void save(Cumparator cumparator){
        jdbcTemplate.update("INSERT INTO cumparator(nume, prenume, varsta, produs, suma, cantitatea)" +
                "VALUES (?, ?, ?, ?, ?, ?)",
                cumparator.getNume(),cumparator.getPrenume(),cumparator.getVarsta(),cumparator.getProdus(),
                cumparator.getSuma(),cumparator.getCantitate());
    }

    public void update(Long id, Cumparator cumparator){
        jdbcTemplate.update("UPDATE cumparator SET nume = ?, prenume = ?, varsta = ?, produs = ?, suma = ?, cantitatea = ?" +
                        "WHERE id  = ?",
                cumparator.getNume(), cumparator.getPrenume(), cumparator.getVarsta(), cumparator.getProdus(), cumparator.getSuma(), cumparator.getCantitate(), id);
    }

    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM cumparator WHERE id = ?", id);
    }
}
