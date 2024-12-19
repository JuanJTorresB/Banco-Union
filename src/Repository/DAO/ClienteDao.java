package Repository.DAO;

import model.Cheque;
import model.Cliente;

public interface ClienteDao {
    boolean addCliente(Cliente cliente);
    Cliente getClientePorId(String identificacion);
    boolean upadateCliente(Cliente cliente);
}
