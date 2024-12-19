package Repository.Implementations;

import Repository.DAO.ClienteDao;
import model.Cliente;
import util.DatabaseConnectionLogic;
import util.Enums.ChequesEstadoEnum;
import util.Enums.ChequesPrioridadEnum;
import util.Enums.ClientesEstadoEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ClienteDao {
    @Override
    public boolean addCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (identificacion, nombre, apellido, direccion, telefono, correo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1 ,cliente.getIdentificacion());
            stmt.setString(2 ,cliente.getNombre());
            stmt.setString(3 ,cliente.getApellido());
            stmt.setString(4 ,cliente.getDireccion());
            stmt.setString(5 ,cliente.getTelefono());
            stmt.setString(6, cliente.getCorreo());
            stmt.setString(7, cliente.getEstado().toString());
            stmt.executeUpdate();
            System.out.println("Cliente Añadido Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Cliente getClientePorId(String identificacion) {
        String sql = "SELECT * FROM clientes WHERE identificacion=?";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, identificacion);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return (new Cliente(
                        rs.getInt("id"),
                        rs.getString("identificacion"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        ClientesEstadoEnum.valueOf(rs.getString("estado")),
                        rs.getTimestamp("fecha_registro"),
                        rs.getTimestamp("ultima_actividad")
                ));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean upadateCliente(Cliente cliente) {
        String sql = "UPDATE clientes (identificacion=?, nombre=?, apellido=?, direccion=?, telefono=?, correo=?, estado=?, fecha_registro=?, ultima_actividad=?) WHERE id=?";
        try (Connection connection = DatabaseConnectionLogic.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1 ,cliente.getIdentificacion());
            stmt.setString(2 ,cliente.getNombre());
            stmt.setString(3 ,cliente.getApellido());
            stmt.setString(4 ,cliente.getDireccion());
            stmt.setString(5 ,cliente.getTelefono());
            stmt.setString(6, cliente.getCorreo());
            stmt.setString(7, cliente.getEstado().toString());
            stmt.setTimestamp(8, cliente.getFecha_registro());
            stmt.setTimestamp(9, cliente.getUltima_actividad());
            stmt.setInt(10, cliente.getId());
            stmt.executeUpdate();
            System.out.println("Cliente Actualizado Correctamente");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
