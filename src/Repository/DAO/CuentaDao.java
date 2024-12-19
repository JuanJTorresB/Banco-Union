package Repository.DAO;

import model.Cuenta;

import java.util.List;

public interface CuentaDao {
    boolean addCuenta(Cuenta cuenta);
    Cuenta getCuenta(int id_cuenta, int id_cliente);
    List<Cuenta> getAllClienteCuentas(int id_cliente);
    boolean updateCuenta(Cuenta cuenta);
}
