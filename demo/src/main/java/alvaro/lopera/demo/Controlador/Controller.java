package alvaro.lopera.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alvaro.lopera.demo.Entidades.Nave;
import alvaro.lopera.demo.Repositorio.NaveRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping( value = "/Nave" )
public class Controller {
    
    @Autowired
    NaveRepository nr;

    @PostMapping(value="/Nave")
    public Nave createNave(@RequestBody Long id, @RequestBody int vida) {
        return nr.save(new Nave(id, vida));
    }
    
    @GetMapping
    public List<Nave> getAllNaves ( ) {
        return nr.findAll();
    }

}
