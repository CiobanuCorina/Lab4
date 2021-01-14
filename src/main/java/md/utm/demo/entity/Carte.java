package md.utm.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Carte {

    private Long id;
    private String denumire;
    private String autor;
    private Integer anulEditiei;
    private String editura;
    private String ISBN;
    private Integer nrPagini;

    public Carte(Long id, String denumire, String autor, Integer anulEditiei, String editura, String ISBN, Integer nrPagini){
        this.id = id;
        this.denumire = denumire;
        this.autor = autor;
        this.anulEditiei = anulEditiei;
        this.editura = editura;
        this.ISBN = ISBN;
        this.nrPagini = nrPagini;
    }

    public Long getId(){
        return this.id;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnulEditiei() {
        return anulEditiei;
    }

    public String getEditura() {
        return editura;
    }

    public String getISBN() {
        return ISBN;
    }

    public Integer getNrPagini() {
        return nrPagini;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnulEditiei(Integer anulEditiei) {
        this.anulEditiei = anulEditiei;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNrPagini(Integer nrPagini) {
        this.nrPagini = nrPagini;
    }
}
