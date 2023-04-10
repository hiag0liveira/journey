package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table( name = "vendedor" )
public class Vendedor extends Pessoa{

    @Column(name = "cargo",nullable=false, length = 40)
    @NotBlank(message = "Cargo obrigatório.")
    @Length(max = 50, message = "O cargo deve ter no máximo 40 caracteres.")
    private String cargo;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "Setor obrigatório.")
    @Length(max = 50, message = "Setor deve ter no máximo 50 caracteres.")
    private String setor;


    public Vendedor(String cargo, String setor) {
        this.cargo = cargo;
        this.setor = setor;
    }

    public Vendedor() {

    }

}
