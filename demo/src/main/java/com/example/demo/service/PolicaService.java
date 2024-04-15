package com.example.demo.service;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.PolicaDto;
import com.example.demo.dto.RecenzijaDto;
import com.example.demo.entity.*;
import com.example.demo.repository.KnjigaRepository;
import com.example.demo.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PolicaRepository;

import javax.swing.text.ChangedCharSetException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    @Autowired
    private StavkaPoliceService stavkaPoliceService;
    @Autowired
    private KnjigaService knjigaService;






    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica savePolica(Polica p){return policaRepository.save(p);}

    public Set<Polica> findByKorisnik(Korisnik korisnik) {
        Set<Polica> police = korisnik.getListaPolica();
        return police;
    }
    public Polica findById(Long pId){
        List<Polica> police = policaRepository.findAll();
        for(Polica polica:police){
            if(polica.getId() == pId){
                return polica;
            }
        }
        return null;
    }
    public Polica findByIdKorisnikove(Long pId, Set<Polica> korisnikovePolice){
        for(Polica polica:korisnikovePolice){
            if(polica.getId() == pId){
                return polica;
            }
        }
        return null;
    }

    public Polica save(Polica p) { return policaRepository.save(p); }

    public Polica findPrimarnu(Set<Polica> korisnikovePolice, Knjiga zadataKnjiga){
        Set<StavkaPolice> stavke = null;
        for(Polica p: korisnikovePolice){
            stavke = p.getStavkaPolice();
            for(StavkaPolice sp: stavke){
                if(sp.getKnjiga() == zadataKnjiga){
                    return p;
                }
            }
        }
        return null;
    }

//    public void dodajKnjiguNaPrimarnuPolicu(Polica nadjena, Polica zadata, Knjiga knjiga){
//        //pravimo stavku sa zadatom policom i knjigom, prolazimo kroz sve stavke nadjene police
//        //i tu pronalazimo stavku sa knjigom i BRISEMO JE
//
//        if(zadata.getNaziv().equals("Read")){
//            StavkaPolice sp = null;
//            sp.setKnjiga(knjiga);
//            //recenzijaService.dodajRecenziju();
//        } else {
//            for(StavkaPolice sp: )
//        }
//    }

    public void dodajKnjiguNaPolicu(Long knjigaId, Long policaId) throws ChangeSetPersister.NotFoundException {
        Polica polica = findById(policaId);
        Knjiga knjiga = knjigaService.getKnjigaById(knjigaId);
        StavkaPolice stavka = new StavkaPolice();
        stavka.setKnjiga(knjiga);
        stavkaPoliceService.save(stavka);
        polica.getStavkaPolice().add(stavka);
        save(polica);
    }

    public void obrisiKnjiguSaPolice(Long knjigaId, Long nadjenaId){
        Polica polica = findById(nadjenaId);
        Knjiga knjiga = knjigaService.getKnjigaById(knjigaId);
        //StavkaPolice sp = stavkaPoliceService.findByKnjigaId(knjigaId);

    }

//        for(Polica p: lista){
//            if(p.getNaziv().equals(polica.getNaziv())) {
//                stavke = p.getStavkaPolice();
//                StavkaPolice novaStavka = null;
//                novaStavka.setKnjiga(knjiga);
//                stavkaPoliceService.save(novaStavka);
//                stavke.add(novaStavka);
//                p.setStavkaPolice(stavke);
//                save(p);
//            } else{
//                //pravimo novu policu
//                StavkaPolice novaStavka = null;
//                novaStavka.setKnjiga(knjiga);
//                stavkaPoliceService.save(novaStavka);
//                stavke.add(novaStavka);
//                Polica novaPolica = null;
//                novaPolica.setStavkaPolice(stavke);
//                novaPolica.setNaziv(polica.getNaziv());
//                save(novaPolica);
//                //novaPolica.setOznaka(polica.getOznaka());
//                lista.add(novaPolica);
//            }
    public boolean daLiJePrimarna(Long pId){
        List<Polica> police = policaRepository.findAll();
        Polica p = null;
        for(Polica polica:police){
            if(polica.getId() == pId){
                p = polica;
            }
        }
        if (p.getNaziv().equals("Read") || p.getNaziv().equals("Want To Read") || p.getNaziv().equals("CurrentlyReading")){
            return true;
        }
        return false;
    }


    public Polica  napraviPolicu(String naziv){

       /* List<Polica> policas = policaRepository.findAll();

        for(Polica po: policas){
            if(po.getNaziv().equals(naziv)){
                return null;
            }

        }*/

        Polica p = new Polica();
        p.setNaziv(naziv);
        p.setOznaka(false);
        policaRepository.save(p);
        return p;
    }

    public boolean obrisiPolicu(Long id){

      List<Polica> police =  policaRepository.findAll();

        for(Polica p: police){
            if(p.getId() == id){
                    policaRepository.deleteById(p.getId());
                    return true;
            }

        }
        return false;

    }







}
