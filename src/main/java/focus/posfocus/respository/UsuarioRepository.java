package focus.posfocus.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import focus.posfocus.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByEmail(String email);
}
