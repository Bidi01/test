package at.felixbiedermann.test.api;
import at.felixbiedermann.test.model.Kunde;
import at.felixbiedermann.test.service.Kundeservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {
   public Kundeservice kundeservice;

    public Controller(Kundeservice kundeservice) {
        this.kundeservice = kundeservice;
    }

    @RequestMapping("/kunde")
    public List<Kunde> showAllKunden(){
        return kundeservice.ListAll();
    }

    @PostMapping(path= "/kunde")
    public ResponseEntity<String> addKunde (@RequestBody Kunde kunde)
    {
        kundeservice.addKunde(kunde);
        return new ResponseEntity<>("Done", HttpStatus.ACCEPTED);
    }

}
