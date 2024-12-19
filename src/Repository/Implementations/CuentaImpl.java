package Repository.Implementations;

import Repository.DAO.CuentaDao;
import model.Cliente;
import model.Cuenta;
import util.DatabaseConnectionLogic;
import util.Enums.ClientesEstadoEnum;
import util.Enums.CuentaEstadoEnum;
import util.Enums.TipoDeCuentaEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaImpl implements CuentaDao {
    @Override
    public boolean addCuenta(Cuenta cuenta) {
        String sql = "INSERT INTO cuentas (id_cliente, tipo, saldo, limite_saldo) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1 ,cuenta.getId_cliente());
            stmt.setString(2 ,cuenta.getTipo().toString());
            stmt.setDouble(3 ,cuenta.getSaldo());
            stmt.setDouble(4 ,cuenta.getLimiteSaldo());
            stmt.executeUpdate();
            System.out.println("Cuenta Añadida Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    //  ! El Usuario Solo debe Ingresa La Id_cuenta, el id cliente lo sabe el software
    public Cuenta getCuenta(int id_cuenta, int id_cliente) {
        String sql = "SELECT * FROM cuentas WHERE id_cuenta=? AND id_cliente=?";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id_cuenta);
            stmt.setInt(2, id_cliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return (new Cuenta(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        TipoDeCuentaEnum.valueOf(rs.getString("tipo")),
                        rs.getDouble("saldo"),
                        rs.getDouble("limiteSaldo"),
                        rs.getTimestamp("fecha_apertura"),
                        CuentaEstadoEnum.valueOf(rs.getString("estado"))
                ));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Cuenta> getAllClienteCuentas(int id_cliente) {
        String sql = "SELECT * FROM cuentas WHERE id_cliente=?";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id_cliente);
            ResultSet rs = stmt.executeQuery();
            List<Cuenta> cuentas = new ArrayList<>();
            while (rs.next()){
                 cuentas.add(new Cuenta(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        TipoDeCuentaEnum.valueOf(rs.getString("tipo")),
                        rs.getDouble("saldo"),
                        rs.getDouble("limiteSaldo"),
                        rs.getTimestamp("fecha_apertura"),
                        CuentaEstadoEnum.valueOf(rs.getString("estado"))
                ));
            }
            return cuentas;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateCuenta(Cuenta cuenta) {
        String sql = "UPDATE cuentas (id_cliente=?, tipo=?, saldo=?, limite_saldo=?, estado=?) WHERE id=?";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1 ,cuenta.getId_cliente());
            stmt.setString(2 ,cuenta.getTipo().toString());
            stmt.setDouble(3 ,cuenta.getSaldo());
            stmt.setDouble(4 ,cuenta.getLimiteSaldo());
            stmt.setString(5 ,cuenta.getEstado().toString());
            stmt.setInt(6 ,cuenta.getId());
            stmt.executeUpdate();
            System.out.println("Cuenta Actualizada Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
