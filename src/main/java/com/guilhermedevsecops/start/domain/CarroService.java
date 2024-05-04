package com.guilhermedevsecops.start.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.guilhermedevsecops.start.domain.dto.CarroDTO;

@Service
public class CarroService {
    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros(){
        List<Carro> carros = rep.findAll();
        List<CarroDTO> list = carros.stream()
                                    .map(CarroDTO::create)
                                    .collect(Collectors.toList());
        
        return list;
    }

    public Optional<CarroDTO> getCarroById(Long id) {
       return rep.findById(id).map(CarroDTO::create);
    }

    public List<CarroDTO> getCarroTipo(String tipo) {
        
        return rep.findByTipo(tipo).stream()
                                   .map(CarroDTO::create)
                                   .collect(Collectors.toList());
    }

    public CarroDTO inserir(Carro carros) {
        Assert.isNull(carros.getId(), "Não foi possivel inserir registro");

        return CarroDTO.create(rep.save(carros));
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Registro não encontrado");

        //buscar no banco de dados
        Optional<Carro> optional = rep.findById(id);


        if(optional.isPresent()){
            Carro db = optional.get();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            rep.save(db);
            
            return CarroDTO.create(db);


        }else{
            return null;
        }

        
    }

    public Boolean delete(Long id) {
        Optional<Carro> carro = rep.findById(id);
        if(carro.isPresent()){
            rep.deleteById(id);
            return true;
        }
        else{
            return false;
        }
       
    }
    
}
