package at.felixbiedermann.test.service;

import at.felixbiedermann.test.dao.KundeDAO;
import at.felixbiedermann.test.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KundeService {
    private final KundeDAO kundeDAO;

    @Autowired
    public KundeService(@Qualifier("kundeDAO") KundeDAO kundeDAO) {this.kundeDAO = kundeDAO;}

    public int addKunde(Kunde kunde){
        return kundeDAO.insertKunde(UUID.randomUUID(), kunde);
    }

    public List<Kunde> getAllKunde() {return kundeDAO.selectAllKunde();}

    public Optional<Kunde> getKundeById(UUID id){
        return kundeDAO.selectKundeByID(id);
    }
    public int deleteKunde(UUID id){
        return kundeDAO.deleteKundeByID(id);
    }

    public int updateKunde(UUID id, Kunde newKunde){
        return kundeDAO.updatePersonByID(id, newKunde);
    }
}
