package Repository.DAO;

import model.Cheque;

import java.util.List;

// * REQ: PATRONES DE DISEÑO - DAO

public interface ChequesDao {
    boolean addCheque(Cheque cheque);
    List<Cheque> getAllChequesCuenta(int id_cuenta);
    Cheque getCheque(String numero_cheque);
    boolean updateCheque(Cheque cheque);

}
