package focus.posfocus.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull @NonNull
    private String nome;

    @NotNull @NonNull @NotBlank
    private String email;

    @Size(min = 3, max = 5,message = "Senha deve ter entre 3 e 5 caracteres")
    private String senha;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(value = CascadeType.ALL)
    @ToString.Exclude
    private List<Postagem>postagens = new ArrayList<>();

}
