package focus.posfocus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import focus.posfocus.models.Postagem;
import focus.posfocus.respository.PostagemRepository;

@Service
public class PostagemService {
    @Autowired
    PostagemRepository repository;

    public Postagem create(Postagem postagem, long idUser){
        return repository.save(postagem);
    }
}
