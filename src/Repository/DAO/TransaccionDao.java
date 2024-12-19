package Repository.DAO;

import model.Transaccion;

import java.util.List;

public interface TransaccionDao {
    boolean addTransaccion(Transaccion transaccion);
    List<Transaccion>getAllTransaccions(int id_cuenta);
    boolean upadteTransaccion(Transaccion transaccion);
}
