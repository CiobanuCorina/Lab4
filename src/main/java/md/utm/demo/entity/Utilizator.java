package md.utm.demo.entity;


import lombok.*;


@Data
@NoArgsConstructor
public class Utilizator {

    private Long id;
    private String nume;
    private String prenume;
    private int varsta;
    private String adresa;
    private int telefon;
    private Carte carte;

    public Utilizator(Long id, String nume, String prenume, int varsta, String adresa, int telefon){
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Utilizator(Long id, String nume, String prenume, int varsta, String adresa, int telefon, Carte carte){
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.telefon = telefon;
        this.carte = carte;
    }

    public Long getId(){
        return this.id;
    }

    public String getNume(){
        return this.nume;
    }

    public String getPrenume(){
        return this.prenume;
    }

    public int getVarsta(){
        return this.varsta;
    }

    public String getAdresa(){
        return this.adresa;
    }

    public int getTelefon(){
        return this.telefon;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNume(String nume){
        this.nume = nume;
    }

    public void setPrenume(String prenume){
        this.prenume = prenume;
    }

    public void setVarsta(int varsta){
        this.varsta = varsta;
    }

    public void setAdresa(String adresa){
        this.adresa = adresa;
    }

    public void setTelefon(int telefon){
        this.telefon = telefon;
    }
}
