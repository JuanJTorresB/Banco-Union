package model;

import util.Enums.TransaccionesEstadoEnum;
import util.Enums.TransaccionesTipoEnum;

import java.sql.Timestamp;

public class Transaccion {
    private int id; // * Autoincrement
    private int id_cuenta;
    private TransaccionesTipoEnum tipo;
    private Double monto;
    private Timestamp fecha; // * Default Timestamp Actual
    private String referencia;
    private Double saldo_anterior;
    private Double saldo_nuevo;
    private TransaccionesEstadoEnum estado; // * Default Exitosa

    public Transaccion(int id, int id_cuenta, TransaccionesTipoEnum tipo, Double monto, Timestamp fecha, String referencia, Double saldo_anterior, Double saldo_nuevo, TransaccionesEstadoEnum estado) {
        this.id = id;
        this.id_cuenta = id_cuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.referencia = referencia;
        this.saldo_anterior = saldo_anterior;
        this.saldo_nuevo = saldo_nuevo;
        this.estado = estado;
    }

    // * Insert Sin Fecha
    public Transaccion(int id_cuenta, TransaccionesTipoEnum tipo, Double monto) {
        this.id_cuenta = id_cuenta;
        this.tipo = tipo;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public TransaccionesTipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TransaccionesTipoEnum tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(Double saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public Double getSaldo_nuevo() {
        return saldo_nuevo;
    }

    public void setSaldo_nuevo(Double saldo_nuevo) {
        this.saldo_nuevo = saldo_nuevo;
    }

    public TransaccionesEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(TransaccionesEstadoEnum estado) {
        this.estado = estado;
    }
}
