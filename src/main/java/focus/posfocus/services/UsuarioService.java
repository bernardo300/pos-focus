package focus.posfocus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import focus.posfocus.models.Usuario;
import focus.posfocus.respository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> getPearson(){
        return null;
    }

    public Usuario createUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getUsuario(long id) {
        return repository.findById(id).get();
    }

    public void deletar(long id) {
        repository.deleteById(id);
    }
}
