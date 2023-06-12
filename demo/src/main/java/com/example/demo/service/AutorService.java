package com.example.demo.service;

import com.example.demo.entity.Knjiga;
import com.example.demo.entity.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Autor;
import com.example.demo.repository.AutorRepository;

import java.util.List;
import java.util.Set;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll(){
        return autorRepository.findAll();
    }

    public Autor findOne(Long id){

        List<Autor> autors = findAll();
        for(Autor a: autors){
            if(a.getId() == id){
                return a;
            }

        }

        return null;
    }

    public Autor findByMejlAdresa(String mejl){return autorRepository.findByMejlAdresa(mejl);}


    public boolean sadrzi(Knjiga k, Long id){
        List<Autor> autors = autorRepository.findAll();


        for(Autor a: autors){
            if(a.getId() == id){
               Set<Knjiga> knjigas = a.getSpisakKnjiga();
                if(knjigas.contains(k)){
                    return true;
                }
            }

        }

        return false;


    }


    public Autor save(Autor a){return autorRepository.save(a);}


    public void dodadKnjiguUListu(Knjiga k, Long id){
        List<Autor> autors = autorRepository.findAll();

        for(Autor a : autors){
            if(a.getId() == id){
                a.getSpisakKnjiga().add(k);
                save(a);
            }
        }
    }




}
