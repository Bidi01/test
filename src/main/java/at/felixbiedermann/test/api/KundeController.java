package at.felixbiedermann.test.api;

import at.felixbiedermann.test.model.Kunde;
import at.felixbiedermann.test.service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/kunde")
@RestController
public class KundeController {

    private final KundeService kundeService;

    @Autowired
    public KundeController(KundeService kundeService) {this.kundeService = kundeService; }

    @PostMapping
    public void addKunde(@Valid @NonNull @RequestBody Kunde kunde){
        kundeService.addKunde(kunde);
    }

    @GetMapping
    public List<Kunde> getAllKunde() {return kundeService.getAllKunde();}

    @GetMapping(path = "/{id}")
    public Kunde getKundeById(@PathVariable("id") UUID id) {
        return kundeService.getKundeById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteKundeById(@PathVariable("id") UUID id) {kundeService.deleteKunde(id);}

    @PutMapping(path = "/{id}")
    public void updatePerson(@PathVariable("id")UUID id, @Valid @NonNull @RequestBody Kunde kundeToUpdate){
        kundeService.updateKunde(id, kundeToUpdate);
    }
}
