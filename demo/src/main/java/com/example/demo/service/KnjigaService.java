package com.example.demo.service;

import com.example.demo.dto.AzuriranaKnjigaDto;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.Zanr;
import com.example.demo.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Knjiga;
import com.example.demo.repository.KnjigaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private ZanrService zanrService;

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }




    /*public List<Knjiga> findByKorisnik(Korisnik korisnik) {
        return knjigaRepository.findByKorisnik(korisnik);
    }*/

    public Knjiga getKnjigaByName(String name) {

        List<Knjiga> knjige = findAll();

        for (Knjiga k : knjige) {
            if (k.getNaslov().equals(name)) {
                return k;
            }
        }
        return null;
    }



    public void napraviKnjigu(String naslov, int brstrana, String isbn, Zanr zanr, LocalDate datum, String foto,String opis){

        Knjiga knjiga = new Knjiga();
        knjiga.setBrStrana(brstrana);
        knjiga.setISBN(isbn);
        knjiga.setNaslov(naslov);
        knjiga.setOpis(opis);
        knjiga.setDatumObjavljivanja(datum);
        knjiga.setNaslovnaFotografija(foto);
        knjiga.setZanr(zanr);

        //knjigaRepository.save(knjiga);

    }

    public Knjiga save(Knjiga k){
        return knjigaRepository.save(k);



    public Long napraviKnjigu(String naslov, int brstrana, String isbn, LocalDate datum, String foto,String opis, double ocena){
        Knjiga knjiga = new Knjiga();
        knjiga.setNaslov(naslov);
        knjiga.setOpis(opis);
        knjiga.setDatumObjavljivanja(datum);
        knjiga.setBrStrana(brstrana);
        knjiga.setNaslovnaFotografija(foto);
        knjiga.setOcena(ocena);
        knjiga.setISBN(isbn);

        knjigaRepository.save(knjiga);
        return knjiga.getId();
    }



    public Knjiga getKnjigaById(Long id){
        List<Knjiga> knjige = findAll();

        for (Knjiga k : knjige) {
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }


    public Knjiga updateKnjigaAdmin(Long knjigaId, AzuriranaKnjigaDto updateKnjigaDto) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(knjigaId);
        knjiga.get().setNaslov(updateKnjigaDto.getNaslov());
        knjiga.get().setNaslovnaFotografija(updateKnjigaDto.getNaslovnaFotografija());

        String updatedISBN = updateKnjigaDto.getISBN();
        if (updatedISBN != null && !updatedISBN.isEmpty()) {
            knjiga.get().setISBN(updatedISBN);
        }
        knjiga.get().setDatumObjavljivanja(updateKnjigaDto.getDatumObjavljivanja());
        knjiga.get().setBrStrana(updateKnjigaDto.getBrojStrana());
        knjiga.get().setOpis(updateKnjigaDto.getOpis());
        knjiga.get().setZanr(zanrService.findById(updateKnjigaDto.getZanrId()));
        return save(knjiga.get());
    }







}
