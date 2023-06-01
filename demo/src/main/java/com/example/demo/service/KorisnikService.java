package com.example.demo.service;

import com.example.demo.entity.Polica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Korisnik;
import com.example.demo.repository.KorisnikRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }
    public Set<Polica> napraviPrimarne(Korisnik k){
        boolean oznaka = true;

        Polica p1 = new Polica();
        p1.setNaziv("Want to Read");
        p1.setOznaka(oznaka);

        Polica p2 =  new Polica();
        p2.setNaziv("Currently Reading");
        p2.setOznaka(oznaka);

        Polica p3 = new Polica();
        p3.setNaziv("Read");
        p3.setOznaka(oznaka);
        k.getListaPolica().add(p1);
        k.getListaPolica().add(p2);
        k.getListaPolica().add(p3);
        return k.getListaPolica();

    }
    public Korisnik saveKorisnik(Korisnik k) { return korisnikRepository.save(k);}
    public Korisnik registracija(String korisnickoIme, String ime, String prezime, String lozinka1, String mejl, LocalDate datumRodjenja, String profilnaSlika){
        Korisnik k = new Korisnik();
        k.setIme(ime);
        k.setPrezime(prezime);
        k.setKorisnickoIme(korisnickoIme);
        k.setLozinka(lozinka1);
        k.setMejlAdresa(mejl);
        k.setDatumRodjenja(datumRodjenja);
        k.setProfilnaSlika(profilnaSlika);
        k.napraviPrimarne();
        korisnikRepository.save(k);
        return k;
    }



    public Korisnik login(String korisnickoIme, String sifra){
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(korisnickoIme);



        if(korisnik == null || !korisnik.getLozinka().equals(sifra)){
            return null;
        }
        return korisnik;
    }


    public Korisnik findOne(String username){
        Korisnik korisnik = korisnikRepository.getByKorisnickoIme(username);

        if(korisnik == null){
            return null;
        }

        return korisnik;
    }





}
