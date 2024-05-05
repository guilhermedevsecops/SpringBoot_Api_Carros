package com.guilhermedevsecops.start.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guilhermedevsecops.start.domain.Carro;
import com.guilhermedevsecops.start.domain.CarroService;
import com.guilhermedevsecops.start.domain.dto.CarroDTO;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

    @SuppressWarnings("rawtypes")
    @GetMapping
    public ResponseEntity getCarro(){
        return ResponseEntity.ok(service.getCarros());
    }

    @GetMapping("/{id}")
    @SuppressWarnings("rawtypes")
    public ResponseEntity getCarroId(@PathVariable("id") Long id){
       CarroDTO carro = service.getCarroById(id);
        
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/tipo/{tipo}")
    @SuppressWarnings("rawtypes")
    public ResponseEntity getCarroTipo(@PathVariable("tipo") String tipo){
        List<CarroDTO> carros = service.getCarroTipo(tipo);
        
        return carros.isEmpty() ?
               ResponseEntity.noContent().build():
               ResponseEntity.ok(carros);
    }

    @SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity post(@RequestBody Carro carro){
            CarroDTO car = service.inserir(carro);
            URI location = getUri(car.getId());
            return ResponseEntity.created(location).build();
        
    }

    @PutMapping("/{id}")
    @SuppressWarnings("rawtypes")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {   
        carro.setId(id);
        CarroDTO c = service.update(carro, id);
        
        return c != null ? 
                    ResponseEntity.ok(c) :
                    ResponseEntity.notFound().build();
    
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);

        return ResponseEntity.ok().build();
                
    }
    
    private URI getUri(Long id){
        return ServletUriComponentsBuilder.fromCurrentRequest()
                                          .path("/{id}")
                                          .buildAndExpand(id)
                                          .toUri();
    }    
}
