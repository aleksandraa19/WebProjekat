package com.example.demo.service;

import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.PolicaDto;
import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Korisnik;
import com.example.demo.entity.StavkaPolice;
import com.example.demo.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Polica;
import com.example.demo.repository.PolicaRepository;

import java.util.List;
import java.util.Set;

@Service
public class PolicaService {

    @Autowired
    private PolicaRepository policaRepository;

    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica savePolica(Polica p){return policaRepository.save(p);}

    public Set<Polica> findByKorisnik(Korisnik korisnik) {
        Set<Polica> police = korisnik.getListaPolica();
        return police;
    }

    public Polica save(Polica p) { return policaRepository.save(p); }

    public void dodajKnjiguNaPolicu(KnjigaDto knjiga, Korisnik korisnik, PolicaDto polica){
        Knjiga novaKnjiga = null;
        novaKnjiga.setZanr(knjiga.getZanr());
        novaKnjiga.setISBN(knjiga.getISBN());
        novaKnjiga.setNaslov(knjiga.getNaslov());
        novaKnjiga.setOcena(knjiga.getOcena());
        novaKnjiga.setBrStrana(knjiga.getBrStrana());
        novaKnjiga.setDatumObjavljivanja(knjiga.getDatumObjavljivanja());
        novaKnjiga.setNaslovnaFotografija(knjiga.getNaslovnaFotografija());
        novaKnjiga.setOpis(knjiga.getOpis());

        Set<Polica> lista = korisnik.getListaPolica();
        Set<StavkaPolice> stavke = null;
        for(Polica p: lista){
            if(p.getNaziv().equals(polica.getNaziv())){
                stavke = p.getStavkaPolice();
                StavkaPolice novaStavka = null;
                novaStavka.setKnjiga(novaKnjiga);
                stavkaPoliceService.save(novaStavka);
                stavke.add(novaStavka);
                p.setStavkaPolice(stavke);
                save(p);
            } else{
                //pravimo novu policu
                StavkaPolice novaStavka = null;
                novaStavka.setKnjiga(novaKnjiga);
                stavkaPoliceService.save(novaStavka);
                stavke.add(novaStavka);
                Polica novaPolica = null;
                novaPolica.setStavkaPolice(stavke);
                novaPolica.setNaziv(polica.getNaziv());
                save(novaPolica);
                //novaPolica.setOznaka(polica.getOznaka());
                lista.add(novaPolica);
            }
        }
    }
    public boolean daLiJePrimarna(PolicaDto p){
        if (p.getNaziv().equals("Read") || p.getNaziv().equals("Want to Read") || p.getNaziv().equals("Currently Reading")){
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
