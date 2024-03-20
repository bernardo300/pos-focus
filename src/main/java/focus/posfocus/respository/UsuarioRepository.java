package focus.posfocus.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import focus.posfocus.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
