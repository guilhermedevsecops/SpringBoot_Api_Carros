package com.guilhermedevsecops.start.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CarroService {
    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros(){
        return rep.findAll();
    }

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Carro> getCarroTipo(String tipo) {
        
        return rep.findByTipo(tipo);
    }

    public Carro save(Carro carros) {
        return rep.save(carros);
    }

    public Carro update(Carro carro, Long id) {
        Assert.notNull(id, "Registro não encontrado");

        //buscar no banco de dados
        Optional<Carro> optional = getCarroById(id);
        if(optional.isPresent()){
            Carro db = optional.get();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            rep.save(db);
            return db;


        }else{
            throw new RuntimeException("Não foi possivel encontrar o registro");
        }

        
    }

    public String delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if(carro.isPresent()){
            rep.deleteById(id);
            return "Carro excluido";
        }
        else{
            return "Carro não existe";
        }
       
    }
    
}
