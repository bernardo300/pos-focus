package focus.posfocus.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import focus.posfocus.models.Usuario;
import focus.posfocus.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public ResponseEntity<List<Usuario>>  getUsuario(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario>  getUsuario(@PathVariable("id") long id){  
        return new ResponseEntity<>(service.getUsuario(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Usuario>  hello(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.createUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteUsuario(@PathVariable("id") long id){
        service.deletar(id);
        return new ResponseEntity<>("Deletado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/q")
    public ResponseEntity<String> hello(@RequestParam(required = true) String nome){
        return new ResponseEntity<>("Hello Spring " + nome, HttpStatus.OK);
    }
}
