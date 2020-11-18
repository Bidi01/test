package at.felixbiedermann.test.model;

import at.felixbiedermann.test.model.Rechnung;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Kunde
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vorname;
    private String nachname;

    public Kunde(String vorname) {
        this.vorname = vorname;
    }

    public List<Rechnung> getRechnungen() {
        return rechnungen;
    }

    public void setProjektaufgaben(List<Rechnung> rechnung) {
        this.rechnungen = rechnung;
    }
    @JsonManagedReference
    @OneToMany
            (
                    mappedBy = "kunde",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true,
                    fetch = FetchType.LAZY
            )
    private List<Rechnung> rechnungen = new ArrayList<>();




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Kunde()
    {

    }



}
