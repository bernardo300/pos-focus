package focus.posfocus.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import focus.posfocus.models.Postagem;
import focus.posfocus.models.Usuario;
import focus.posfocus.respository.PostagemRepository;
import focus.posfocus.services.UsuarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Tag(
    name = "Usuario Controller",
    description = "Extensions Information")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @Autowired
    private PostagemRepository postagemRepository;
    
    @GetMapping
    public ResponseEntity<List<Usuario>>  getUsuario(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario>  getUsuario(@PathVariable("id") long id){  
        return new ResponseEntity<>(service.getUsuario(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Usuario>  salvar(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.createUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario>  editarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.createUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteUsuario(@PathVariable("id") long id){
        service.deletar(id);
        return new ResponseEntity<>("Deletado", HttpStatus.NOT_FOUND);
    }

    @PostMapping({"/{id}/postagens"})
    public ResponseEntity<Usuario>  salvarPostagem(@PathVariable("id") long id, @RequestBody Postagem postagem){
        var usuario = service.getUsuario(id);
        usuario.getPostagens().add(postagem);
        return new ResponseEntity<>(service.createUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}/postagens/{idP}"})
    public ResponseEntity<Usuario>  deletarPostagem(@PathVariable("id") long id, @PathVariable("idP") long idP){
        var usuario = service.getUsuario(id);
        usuario.getPostagens().removeIf(p ->p.getId() == idP);
        postagemRepository.deleteById(idP);
        return new ResponseEntity<>(service.createUsuario(usuario), HttpStatus.CREATED);
    }

}
