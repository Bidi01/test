package at.felixbiedermann.test.dao;


import at.felixbiedermann.test.model.Kunde;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface KundeDAO {

    int insertKunde(UUID id, Kunde kunde);

    default int insertPerson(Kunde kunde){
        UUID id = UUID.randomUUID();
        return insertKunde(id, kunde);
    }

    List<Kunde> selectAllKunde();
    Optional<Kunde> selectKundeByID(UUID id);
    int deleteKundeByID(UUID id);
    int updatePersonByID(UUID id, Kunde kunde);

}
