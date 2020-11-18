package at.felixbiedermann.test.service;

import at.felixbiedermann.test.model.Rechnung;
import at.felixbiedermann.test.repo.Rechnungrepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Rechnungservice {

    @Autowired
    Rechnungrepo repo;

    public List<Rechnung> getAllRechnungen(){
        return repo.findAll();
    }



}
