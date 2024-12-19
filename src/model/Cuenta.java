package model;

import util.Enums.CuentaEstadoEnum;
import util.Enums.TipoDeCuentaEnum;

import java.sql.Timestamp;

public class Cuenta {
    private int id; // * Autoincrement
    private int id_cliente;
    private TipoDeCuentaEnum tipo;
    private Double saldo; // * Default 0.0
    private Double limiteSaldo;
    private Timestamp fecha_apertura; // * Default Fecha Actual
    private CuentaEstadoEnum estado; // * Default Activa

    // * Get
    public Cuenta(int id, int id_cliente, TipoDeCuentaEnum tipo, Double saldo, Double limiteSaldo, Timestamp fecha_apertura, CuentaEstadoEnum estado) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limiteSaldo = limiteSaldo;
        this.fecha_apertura = fecha_apertura;
        this.estado = estado;
    }

    // * Insert Into
    public Cuenta(int id_cliente, TipoDeCuentaEnum tipo, Double limiteSaldo) {
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.limiteSaldo = limiteSaldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public TipoDeCuentaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeCuentaEnum tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimiteSaldo() {
        return limiteSaldo;
    }

    public void setLimiteSaldo(Double limiteSaldo) {
        this.limiteSaldo = limiteSaldo;
    }

    public Timestamp getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Timestamp fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public CuentaEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(CuentaEstadoEnum estado) {
        this.estado = estado;
    }
}
