package hiag0liveira.github.io.upcar.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table( name = "pessoa" )
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable=false, length = 150)
    @NotBlank(message = "Por favor insira o nome do Usuario")
    @Length(max = 150, message = "Nome deve ter no máximo 150 caracteres.")
    private String nome;

    @Column(name = "cpf",nullable=true, length = 14, unique =true, updatable=true)
    @CPF(message = "CPF inválido.")
    @NotNull(message = "Por favor insira um CPF valido")
    private String cpf;

    @Column(nullable = true, updatable = true, length = 18)
    private String cnpj;

    @Column(name = "email",nullable=false, length = 80)
    private String email;


    @Column(nullable = true, updatable = true, length = 15)
    private String telefone;

    @JoinColumn(name = "endereco_pessoa_id", referencedColumnName = "id")
    @OneToMany
    private List<Endereco> enderecos;

    public Pessoa(String nome, String cpf, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}
