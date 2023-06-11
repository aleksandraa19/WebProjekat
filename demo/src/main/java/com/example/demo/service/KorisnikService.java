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

    public boolean dodajPolicu(Long id,Polica polica){

        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){

               Set<Polica> policas = k.getListaPolica();

               for(Polica p: policas){
                   if(p.getNaziv().equals(polica.getNaziv())){
                       return false;
                   }

               }

                k.getListaPolica().add(polica);
                korisnikRepository.save(k);

            }
        }
        return true;
    }


    public Polica obrisiPolicuizListe(Long id, String naziv){

        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                Set<Polica> policas = k.getListaPolica();

                for(Polica p: policas){
                    if(p.getNaziv().equals(naziv) && p.getOznaka()== false){
                        k.getListaPolica().remove(p);
                        return p;
                    }

                }


            }


        }
        return null;

    }


    public void AzurirajIme(String ime,Long id){

        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                k.setIme(ime);
                korisnikRepository.save(k);
            }
        }
    }


    public void AzurirajPrezime(String prezime,Long id){
        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                k.setPrezime(prezime);
                korisnikRepository.save(k);
            }
        }


    }


    public void DodajDatum(LocalDate datum, Long id){
        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                k.setDatumRodjenja(datum);
                korisnikRepository.save(k);
            }
        }


    }

    public void DodajOpis(String opis, Long id){
        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                k.setOpis(opis);
                korisnikRepository.save(k);
            }
        }

    }


    public void MenjajSifru(String sifra, Long id){
        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                k.setLozinka(sifra);
                korisnikRepository.save(k);
            }
        }


    }

    public void MenjajMejl(String mejl,Long id){
        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                k.setMejlAdresa(mejl);
                korisnikRepository.save(k);
            }
        }



    }

    public boolean proveriSifru(String sifra, Long id){

        List<Korisnik> korisniks = korisnikRepository.findAll();

        for(Korisnik k: korisniks){
            if(k.getId() == id){
                if(k.getLozinka().equals(sifra)){
                    return true;
                }

            }
        }

        return false;

    }



}
