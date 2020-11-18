package at.felixbiedermann.test.model;


import at.felixbiedermann.test.model.Kunde;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Rechnung
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long rechnr;
    private String rechndatum;
    private Float rechnbetrag;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "rechnungs_id")
    @JsonIgnore
    private Kunde kunde;

    public Rechnung()
    {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRechnr() {
        return rechnr;
    }

    public void setRechnr(Long rechnr) {
        this.rechnr = rechnr;
    }

    public String getRechndatum() {
        return rechndatum;
    }

    public void setRechndatum(String rechndatum) {
        this.rechndatum = rechndatum;
    }

    public Float getRechnbetrag() {
        return rechnbetrag;
    }

    public void setRechnbetrag(Float rechnbetrag) {
        this.rechnbetrag = rechnbetrag;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
