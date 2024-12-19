package Repository.Implementations;

import Repository.DAO.ChequesDao;
import model.Cheque;
import util.DatabaseConnectionLogic;
import util.Enums.ChequesEstadoEnum;
import util.Enums.ChequesPrioridadEnum;
import util.Enums.CuentaEstadoEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// * REQ: PATRONES DE DISEÑO - DAO

public class ChequesImpl implements ChequesDao {
    @Override
    public boolean addCheque(Cheque cheque) {
        String sql = "INSERT INTO `cheques` (id_cuenta, beneficiario, monto, monto_letras, prioridad, firma_digital, estado, razon_rechazo, fecha_emision) VALUES (?,?,?,?,?,?,?,?,?);";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1 ,cheque.getId_cuenta());
            stmt.setString(2 ,cheque.getBeneficiario());
            stmt.setDouble(3 ,cheque.getMonto());
            stmt.setString(4 ,cheque.getMonto_letras());
            stmt.setString(5 ,cheque.getPrioridad().toString());
            stmt.setString(6, cheque.getFirma_digital());
            stmt.setString(7, cheque.getEstado().toString());
            stmt.setString(8, cheque.getRazon_rechazo());
            stmt.setDate(9, cheque.getFecha_emision());
            stmt.executeUpdate();
            System.out.println("Cheque Añadido Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Cheque getCheque(String numero_cheque) {
        String sql = "SELECT * FROM `cheques` WHERE numero_cheque=?;";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, numero_cheque);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return (new Cheque(
                        rs.getInt("id"),
                        rs.getString("numero_cheque"),
                        rs.getInt("id_cuenta"),
                        rs.getString("beneficiario"),
                        rs.getDouble("monto"),
                        rs.getString("monto_letras"),
                        ChequesPrioridadEnum.valueOf(rs.getString("prioridad")),
                        rs.getString("firma_digital"),
                        ChequesEstadoEnum.valueOf(rs.getString("estado")),
                        rs.getString("razon_rechazo"),
                        rs.getDate("fecha_emision"),
                        rs.getTimestamp("fecha_proceso"),
                        rs.getBoolean("cobrado"),
                        rs.getDouble("cuenta_saldo_momento"),
                        rs.getTimestamp("fecha_modificacion"),
                        rs.getString("usuario_modificacion")));}
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cheque> getAllChequesCuenta(int id_cuenta) {
        String sql = "SELECT * FROM `cheques` WHERE id_cuenta=?;";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id_cuenta);
            ResultSet rs = stmt.executeQuery();
            List<Cheque> chequesCuenta = new ArrayList<>();
            while (rs.next()){
                chequesCuenta.add(new Cheque(
                        rs.getInt("id"),
                        rs.getString("numero_cheque"),
                        rs.getInt("id_cuenta"),
                        rs.getString("beneficiario"),
                        rs.getDouble("monto"),
                        rs.getString("monto_letras"),
                        ChequesPrioridadEnum.valueOf(rs.getString("prioridad")),
                        rs.getString("firma_digital"),
                        ChequesEstadoEnum.valueOf(rs.getString("estado")),
                        rs.getString("razon_rechazo"),
                        rs.getDate("fecha_emision"),
                        rs.getTimestamp("fecha_proceso"),
                        rs.getBoolean("cobrado"),
                        rs.getDouble("cuenta_saldo_momento"),
                        rs.getTimestamp("fecha_modificacion"),
                        rs.getString("usuario_modificacion")));}
            return chequesCuenta;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateCheque(Cheque cheque) {
        String sql = "UPDATE `cheques` SET id_cuenta=?, beneficiario=?, monto=?, monto_letras=?, prioridad=?, firma_digital=?, estado=?, razon_rechazo=?, fecha_emision=?, fecha_proceso=?, cobrado=?, cuenta_saldo_momento=? ,fecha_modificacion=?, usuario_modificacion=? WHERE id=?;";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1 ,cheque.getId_cuenta());
            stmt.setString(2 ,cheque.getBeneficiario());
            stmt.setDouble(3 ,cheque.getMonto());
            stmt.setString(4 ,cheque.getMonto_letras());
            stmt.setString(5 ,cheque.getPrioridad().toString());
            stmt.setString(6, cheque.getFirma_digital());
            stmt.setString(7, cheque.getEstado().toString());
            stmt.setString(8, cheque.getRazon_rechazo());
            stmt.setDate(9, cheque.getFecha_emision());
            stmt.setTimestamp(10, cheque.getFecha_proceso());
            stmt.setBoolean(11, cheque.isCobrado());
            stmt.setDouble(12, cheque.getCuenta_saldo_momento());
            stmt.setTimestamp(13, cheque.getFecha_modificacion());
            stmt.setString(14,cheque.getUsuario_modificacion());
            stmt.executeUpdate();
            System.out.println("Cheque Actualizado Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
