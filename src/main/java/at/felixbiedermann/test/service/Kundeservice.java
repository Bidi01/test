package at.felixbiedermann.test.service;

import at.felixbiedermann.test.model.Kunde;
import at.felixbiedermann.test.model.Rechnung;
import at.felixbiedermann.test.repo.Kunderepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Kundeservice
{
    @Autowired
    Kunderepo repo;

    public void addKunde(Kunde p)
    {
        repo.save(p);
    }
    public List<Kunde> ListAll()
    {
        return repo.findAll();
    }

    public Kunde getKunde(long id)
    {
        Optional<Kunde> temp  = repo.findById(id);
        if (temp.isPresent())
        {
            Kunde kunde = temp.get();
            return kunde;
        }
        return null;
    }
    public void deleteKunde(long id)
    {
        repo.deleteById(id);
    }
    public Kundeservice()
    {

    }
    public void editKunde(long id, Kunde kunde)
    {
        Optional<Kunde> temp = repo.findById(id);
        if(temp.isPresent())
        {
            Kunde temp2 = temp.get();
            temp2.setNachname(kunde.getNachname());
            temp2.setVorname(kunde.getVorname());
            repo.save(temp2);
        }

    }
    public List<Rechnung> getRechnungen(long id) {
        return null;
    }
}
