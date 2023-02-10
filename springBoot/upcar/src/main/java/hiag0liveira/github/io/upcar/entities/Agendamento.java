package hiag0liveira.github.io.upcar.entities;

import java.sql.Date;
import java.time.Clock;

public class Agendamento {
    private Date data;
    private Clock hora;

    public Agendamento(Date data, Clock hora) {
        this.data = data;
        this.hora = hora;
    }

    public void agendarVisita(){

    }

    public void consultarVisitasAgendadas(){
        
    }
}
