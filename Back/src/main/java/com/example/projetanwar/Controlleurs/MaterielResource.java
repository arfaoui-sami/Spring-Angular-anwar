package com.example.projetanwar.Controlleurs;


import com.example.projetanwar.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projetanwar.entities.Materiel;
import com.example.projetanwar.security.services.MaterielService;


import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/materiel")
public class MaterielResource {

    private final MaterielService materielService;

    public MaterielResource(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Materiel>> getAllMateriels () {
        List<Materiel> materiels= materielService.findAllMateriels();
        return new ResponseEntity<>(materiels, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Materiel> getMaterielById (@PathVariable("id") Long id) {
        Materiel materiel = materielService.findMaterielById(id);
        return new ResponseEntity<>(materiel, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Materiel> addMateriel(@RequestBody Materiel materiel) {
        Materiel newMateriel = materielService.addMateriel(materiel);

        return new ResponseEntity<>(newMateriel, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Materiel> updateMateriel(@RequestBody Materiel materiel) {
        Materiel updateMateriel = materielService.updateMateriel(materiel);
        return new ResponseEntity<>(updateMateriel, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMateriel(@PathVariable("id") Long id) {
        materielService.deleteMateriel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
