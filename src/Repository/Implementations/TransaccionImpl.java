package Repository.Implementations;

import Repository.DAO.TransaccionDao;
import model.Transaccion;
import util.DatabaseConnectionLogic;
import util.Enums.TransaccionesEstadoEnum;
import util.Enums.TransaccionesTipoEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaccionImpl implements TransaccionDao {
    @Override
    public boolean addTransaccion(Transaccion transaccion) {
        String sql = "INSERT INTO transacciones (id_cuenta, tipo, monto) VALUES (?, ?, ?);";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1 ,transaccion.getId_cuenta());
            stmt.setString(2 ,transaccion.getTipo().toString());
            stmt.setDouble(3 ,transaccion.getMonto());
            stmt.executeUpdate();
            System.out.println("Transaccion Añadida Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Transaccion> getAllTransaccions(int id_cuenta) {
        String sql = "SELECT * FROM transacciones WHERE id_cuenta=1;";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            List<Transaccion> transacciones = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                transacciones.add(new Transaccion(
                        rs.getInt("id"),
                        rs.getInt("id_cuenta"),
                        TransaccionesTipoEnum.valueOf(rs.getString("tipo")),
                        rs.getDouble("monto"),
                        rs.getTimestamp("fecha"),
                        rs.getString("referencia"),
                        rs.getDouble("saldo_anteriror"),
                        rs.getDouble("saldo_nuevo"),
                        TransaccionesEstadoEnum.valueOf(rs.getString("estado"))
                ));
            }
            return transacciones;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean upadteTransaccion(Transaccion transaccion) {
        String sql = "UPDATE transacciones SET id_cuenta=?, tipo=?, monto=?, fecha=?, referencia=?, saldo_anterior=?, saldo_nuevo=?, estado=?, WHERE id=?;";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1 ,transaccion.getId_cuenta());
            stmt.setString(2 ,transaccion.getTipo().toString());
            stmt.setDouble(3 ,transaccion.getMonto());
            stmt.setTimestamp(4 ,transaccion.getFecha());
            stmt.setString(5 ,transaccion.getReferencia());
            stmt.setDouble(6 ,transaccion.getSaldo_anterior());
            stmt.setDouble(7 ,transaccion.getSaldo_nuevo());
            stmt.setString(8 ,transaccion.getEstado().toString());
            stmt.setInt(9 ,transaccion.getId());
            stmt.executeUpdate();
            System.out.println("Transaccion Actualizada Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
