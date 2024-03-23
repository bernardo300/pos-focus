package focus.posfocus.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import focus.posfocus.models.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
    
}
