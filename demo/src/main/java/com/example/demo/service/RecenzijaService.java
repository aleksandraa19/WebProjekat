package com.example.demo.service;

import com.example.demo.dto.AzuriranaRecenzijaDto;
import com.example.demo.dto.RecenzijaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Recenzija;
import com.example.demo.repository.RecenzijaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

//    public List<Recenzija> findAll(){
//        return recenzijaRepository.findAll();
//    }

    public Recenzija findById(Long id){
        Optional<Recenzija> foundRecenzija = recenzijaRepository.findById(id);
        if (foundRecenzija.isPresent()) {
            return foundRecenzija.get();
        }
        return null;
    }
    public List<RecenzijaDto> findAll(){
        List<Recenzija> recenzijeList = recenzijaRepository.findAll();

        List<RecenzijaDto> dtos = new ArrayList<>();
        for(Recenzija recenzija : recenzijeList){
            RecenzijaDto dto = new RecenzijaDto(recenzija.getId(), recenzija.getOcena(), recenzija.getText(), recenzija.getDatumRecenzije(), recenzija.getKorisnik());
            dtos.add(dto);
        }
        return dtos;

    }
    public Recenzija save(Recenzija r){
        return recenzijaRepository.save(r);
    }
    public Recenzija azuriraj(Long recenzijaId, AzuriranaRecenzijaDto dto){
        Recenzija r = findById(recenzijaId);
        r.setOcena(dto.getOcena());
        r.setText(dto.getTekst());
        r.setKorisnik(dto.getKorisnik());
        r.setDatumRecenzije(dto.getDatum());
        return save(r);
    }
    public Recenzija dodajRecenziju(RecenzijaDto r){
        Recenzija recenzija = new Recenzija();
        recenzija.setDatumRecenzije(r.getDatumRecenzije());
        recenzija.setKorisnik(r.getKorisnik());
        recenzija.setText(r.getText());
        recenzija.setOcena(r.getOcena());
        return save(recenzija);
    }
}
