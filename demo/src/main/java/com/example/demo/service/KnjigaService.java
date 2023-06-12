package com.example.demo.service;

import com.example.demo.dto.AzuriranaKnjigaDto;
import com.example.demo.entity.*;
import com.example.demo.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.demo.repository.KnjigaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private ZanrService zanrService;
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private PolicaService policaService;

    @Autowired
    private StavkaPoliceService stavkaPoliceService;

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



    public void kreirajKnjigu(String naslov, int brstrana, String isbn, Zanr zanr, LocalDate datum, String foto,String opis){

        Knjiga knjiga = new Knjiga();
        knjiga.setBrStrana(brstrana);
        knjiga.setISBN(isbn);
        knjiga.setNaslov(naslov);
        knjiga.setOpis(opis);
        knjiga.setDatumObjavljivanja(datum);
        knjiga.setNaslovnaFotografija(foto);
        knjiga.setZanr(zanr);

        knjigaRepository.save(knjiga);

    }

    public Knjiga save(Knjiga k) {
        return knjigaRepository.save(k);
    }
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
    public boolean pronadjiKnjiguNaPrimarnoj(Long citalacId, Long knjigaId){
        Korisnik korisnik = korisnikService.findById(citalacId);
        Set<Polica> korisnikovePolice = korisnik.getListaPolica();

        for (Polica p : korisnikovePolice) {
            if(policaService.daLiJePrimarna(p.getId())){
                for (StavkaPolice stavka : p.getStavkaPolice()) {
                    if (stavka.getKnjiga().getId() == knjigaId) {
                        return true;
                    }
                }
            }
        }
        return false;
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


    public void deleteKnjiga(Long citalac_autor_Id, Long policaId, Long knjigaId) {
        Knjiga knjiga = getKnjigaById(knjigaId);
        Korisnik korisnik = korisnikService.findById(citalac_autor_Id);
        Polica polica = policaService.findById(policaId);
        Set<Polica> korisnikovePolice = korisnik.getListaPolica();
        if(polica.getOznaka()){
            if(polica.getNaziv().equals("Read")){
                for (Polica p : korisnikovePolice) {
                    if (p.getStavkaPolice().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {
                        for (StavkaPolice stavka : p.getStavkaPolice()) {
                            if (stavka.getKnjiga().equals(knjiga)) {
                                stavkaPoliceService.deleteStavkaPolice(p.getId(), stavka.getId());
                            }
                        }
                    }
                }
            }
            else {
                for (Polica p : korisnikovePolice) {
                    if (p.getStavkaPolice().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {
                        for (StavkaPolice stavka : p.getStavkaPolice()) {
                            if (stavka.getKnjiga().equals(knjiga)) {
                                stavka.setKnjiga(null);
                            }
                        }
                    }
                }
            }
        }
        else {
            for (StavkaPolice stavka : polica.getStavkaPolice()) {
                if (stavka.getKnjiga().equals(knjiga)) {
                    stavkaPoliceService.deleteStavkaPolice(policaId, stavka.getId());
                }
            }
        }
    }




}
