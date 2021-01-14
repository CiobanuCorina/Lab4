package md.utm.demo.repository;

import md.utm.demo.entity.Carte;
import md.utm.demo.entity.Utilizator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilizatorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Utilizator> findAll(){
        List<Utilizator> utilizator = jdbcTemplate.query("SELECT * FROM utilizator",
                (response, rowNumber) ->
                new Utilizator(response.getLong("id"),
                        response.getString("nume"),
                        response.getString("prenume"),
                        response.getInt("varsta"),
                        response.getString("adresa"),
                        response.getInt("telefon")));
        return utilizator;
    }

    public Utilizator findById(Long id){
        Utilizator utilizator = jdbcTemplate.queryForObject("SELECT * FROM utilizator WHERE id =?",
                new Object[]{id},
                (response, rowNumber)->
                new Utilizator(response.getLong("id"),
                        response.getString("nume"),
                        response.getString("prenume"),
                        response.getInt("varsta"),
                        response.getString("adresa"),
                        response.getInt("telefon"))
        );
        return utilizator;
    }

    public List<Utilizator> findAllBooks(){
        List<Utilizator> utilizatori = jdbcTemplate.query("select * from utilizator u join carte_utilizator cu on u.id = cu.id_utilizator\n" +
                "join carte c on c.id = cu.id_carte",
                (response, rowNumber)->
                new Utilizator(response.getLong("id"),
                        response.getString("nume"),
                        response.getString("prenume"),
                        response.getInt("varsta"),
                        response.getString("adresa"),
                        response.getInt("telefon"),
                        new Carte(response.getLong("id"),
                                response.getString("denumire"),
                                response.getString("autor"),
                                response.getInt("anulEditiei"),
                                response.getString("editura"),
                                response.getString("ISBN"),
                                response.getInt("nrPagini"))));
        return utilizatori;
    }

    public void save(Utilizator utilizator){
        jdbcTemplate.update("INSERT INTO utilizator(nume, prenume, varsta, adresa, telefon) " +
                "VALUES (?, ?, ?, ?, ?)",
                utilizator.getNume(), utilizator.getPrenume(), utilizator.getVarsta(), utilizator.getAdresa(), utilizator.getTelefon());
    }

    public void update(Long id, Utilizator utilizator){
        jdbcTemplate.update("UPDATE utilizator SET nume = ?, prenume = ?, varsta = ?, adresa = ?, telefon = ?" +
                "WHERE id = ?",
                utilizator.getNume(),utilizator.getPrenume(), utilizator.getVarsta(), utilizator.getAdresa(), utilizator.getTelefon(),id);
    }

    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM utilizator WHERE id = ?", id);
    }

    public void updateVarsta(Long id, int varsta){
        jdbcTemplate.update("UPDATE utilizator SET varsta = ? where id = ?",
                varsta, id);
    }

    public int count(){
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query("SELECT * FROM utilizator", countCallback);
        return countCallback.getRowCount();
        /*int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM utilizator",
                new Object[]{},
                Integer.class);
        return count;*/
    }

}
