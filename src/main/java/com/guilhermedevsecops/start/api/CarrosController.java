package com.guilhermedevsecops.start.api;

import org.springframework.web.bind.annotation.RestController;

import com.guilhermedevsecops.start.domain.Carro;
import com.guilhermedevsecops.start.domain.CarroService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    @GetMapping
    public Iterable<Carro> getCarro(){
        return service.getCarros();
    }

    @GetMapping("/{id}")
    public Optional<Carro> getCarroId(@PathVariable("id") Long id){
        return service.getCarroById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getCarroTipo(@PathVariable("tipo") String tipo){
        return service.getCarroTipo(tipo);
    }

    @PostMapping
    public String post(@RequestBody Carro carro){
        try{
            Carro car = service.save(carro);
            return "Carro incluido" +  car;
        }catch(Exception e){
            return "Erro" + e.getMessage();
        }
        
    }

    @PutMapping("/{id}")
    public Carro put(@PathVariable("id") Long id, @RequestBody Carro carro) {   
        return service.update(carro, id);
    
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        try{
            service.delete(id);
            return "Carro excluido";
        }catch(Exception e){
            return "Erro ao deletar o carro " + e.getMessage();
        }
    }
    
    
}
