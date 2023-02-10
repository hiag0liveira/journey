package hiag0liveira.github.io.upcar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hiag0liveira.github.io.upcar.entities.Cliente;
import hiag0liveira.github.io.upcar.repository.ClientesRepository;

@Service
public class ClientesService {

    private ClientesRepository repository;
    

    //injeção de dependencia via construtor para não estourar a base de dados
    @Autowired
    public ClientesService(ClientesRepository repository){
        this.repository = repository;
    }
    
    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
        // ClientesRepository clientesRepository = new ClientesRepository();
        // clientesRepository.persistir(cliente);   

    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}


