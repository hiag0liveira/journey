package hiag0liveira.github.io.upcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "cliente" )
public class Cliente extends Pessoa{

    @Column(length = 30)
    private String tipoCliente;

    @OneToMany
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private List<Carro> carros;

    public Cliente(String nome, String cpf, String cnpj, String email, String telefone, String tipoCliente) {
        super(nome, cpf, cnpj, email, telefone);
        this.tipoCliente = tipoCliente;
    }

    public Cliente() {

    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
