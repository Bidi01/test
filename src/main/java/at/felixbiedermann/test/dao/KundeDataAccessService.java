package at.felixbiedermann.test.dao;

import at.felixbiedermann.test.model.Kunde;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("kundeDAO")
public class KundeDataAccessService implements KundeDAO {

    private static List<Kunde> DB = new ArrayList<>();

    @Override
    public int insertKunde(UUID id, Kunde kunde) {
        DB.add(new Kunde(id, kunde.getVorname(), kunde.getNachname()));
        return 0;
    }

    @Override
    public List<Kunde> selectAllKunde() {
        return DB;
    }

    @Override
    public Optional<Kunde> selectKundeByID(UUID id) {
        return DB.stream()
                .filter(kunde -> kunde.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteKundeByID(UUID id) {
        Optional<Kunde> kundeMaybe = selectKundeByID(id);
        if (kundeMaybe.isEmpty()){
            return 0;
        }
        DB.remove(kundeMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonByID(UUID id, Kunde update) {
            return selectKundeByID(id)
                    .map(kunde -> {
                        int indexOfKundeToUpdate = DB.indexOf(kunde);
                        if (indexOfKundeToUpdate >= 0){
                            DB.set(indexOfKundeToUpdate, new Kunde(id, update.getVorname(), update.getNachname()));
                            return 1;
                        }
                        return 0;
                    })
                    .orElse(0);
        }
    }


