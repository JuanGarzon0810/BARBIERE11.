package dao;

import conexion.Conexion;
import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // ===========================
    // GUARDAR CLIENTE
    // ===========================
    public boolean guardarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes(nombre, telefono, correo, direccion) VALUES(?,?,?,?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getDireccion());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println("Error al guardar cliente: " + e.getMessage());
            return false;

        }

    }

    // ===========================
    // LISTAR CLIENTES
    // ===========================
    public List<Cliente> listarClientes() {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY id";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDireccion(rs.getString("direccion"));

                lista.add(cliente);

            }

        } catch (Exception e) {

            System.out.println("Error al listar clientes: " + e.getMessage());

        }

        return lista;

    }

    // ===========================
    // BUSCAR CLIENTE
    // ===========================
    public Cliente buscarCliente(String nombre) {

        String sql = "SELECT * FROM clientes WHERE nombre=?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setDireccion(rs.getString("direccion"));

                return cliente;

            }

        } catch (Exception e) {

            System.out.println("Error al buscar cliente: " + e.getMessage());

        }

        return null;

    }

    // ===========================
    // ACTUALIZAR CLIENTE
    // ===========================
    public boolean actualizarCliente(Cliente cliente) {

        String sql = "UPDATE clientes SET telefono=?, correo=?, direccion=? WHERE nombre=?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getTelefono());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getNombre());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println("Error al actualizar cliente: " + e.getMessage());

        }

        return false;

    }

    // ===========================
    // ELIMINAR CLIENTE
    // ===========================
    public boolean eliminarCliente(String nombre) {

        String sql = "DELETE FROM clientes WHERE nombre=?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println("Error al eliminar cliente: " + e.getMessage());

        }

        return false;

    }

}