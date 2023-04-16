package hiag0liveira.github.io.upcar.service;


import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private Clientes repositorioCliente;

    public ClienteService( Clientes clientes ) {
        this.repositorioCliente = clientes;
    }

    public Cliente getClienteById(Integer id){
        return repositorioCliente
                .findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    public void saveOneNewCliente(Cliente cliente ){
        repositorioCliente.save(cliente);
    }

    public void deleteClienteByID(Integer id ){
        repositorioCliente.findById(id)
                .map( cliente -> {
                    repositorioCliente.delete(cliente );
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    public void updateCliente(  Integer id, Cliente cliente ){
        repositorioCliente
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    repositorioCliente.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado") );
    }

    public List<Cliente> findAllClientes(){
        return repositorioCliente.findAll();
    }
}