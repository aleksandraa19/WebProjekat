package com.example.demo.controller;

import com.example.demo.dto.AzuriranaRecenzijaDto;
import com.example.demo.dto.RecenzijaDto;
import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Korisnik;
import com.example.demo.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.Recenzija;
import com.example.demo.service.RecenzijaService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/api/recenzije")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije(HttpSession session){
        List<RecenzijaDto> dtos = recenzijaService.findAll();
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("api/recenzije/{recenzijaId}")
    public ResponseEntity<RecenzijaDto> getRecenzijapoId(@PathVariable(name = "recenzijaId") Long id){
        Recenzija recenzija = recenzijaService.findById(id);
        RecenzijaDto dto = new RecenzijaDto(recenzija.getId(), recenzija.getOcena(), recenzija.getText(), recenzija.getDatumRecenzije(), recenzija.getKorisnik());
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/api/recenzije/dodajRecenziju")
    public ResponseEntity<String> dodajRecenziju (@RequestBody RecenzijaDto recenzijaDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        if (korisnik == null) {
            System.out.println("Nema sesije");
            return ResponseEntity.badRequest().build();
        }
        recenzijaService.dodajRecenziju(recenzijaDto);
        return ResponseEntity.ok("Recenzija je dodata!");
    }

    @PutMapping("/api/recenzija/{recenzijaId}/azuriranje")
    public ResponseEntity<?> azurirajRecenziju(@PathVariable Long recenzijaId, @RequestBody AzuriranaRecenzijaDto dto){
        recenzijaService.azuriraj(recenzijaId,dto);
        return ResponseEntity.ok("Azuriranje uspelo!");
    }

}
