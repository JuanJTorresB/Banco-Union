package model;

import util.Enums.ClientesEstadoEnum;

import java.sql.Timestamp;

public class Cliente {
    private int id; // * Autoincrement
    private String identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private ClientesEstadoEnum estado; // * Default Active
    private Timestamp fecha_registro; // * Default Current Time Stamp
    private Timestamp ultima_actividad;

    // * Constructor Para El Get
    public Cliente(int id, String identificacion, String nombre, String apellido, String direccion, String telefono, String correo, ClientesEstadoEnum estado, Timestamp fecha_registro, Timestamp ultima_actividad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.ultima_actividad = ultima_actividad;
    }

    // * Constructor Para El Insert
    public Cliente(String identificacion, String nombre, String apellido, String direccion, String telefono, String correo, Timestamp ultima_actividad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ultima_actividad = ultima_actividad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ClientesEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(ClientesEstadoEnum estado) {
        this.estado = estado;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Timestamp getUltima_actividad() {
        return ultima_actividad;
    }

    public void setUltima_actividad(Timestamp ultima_actividad) {
        this.ultima_actividad = ultima_actividad;
    }
}
