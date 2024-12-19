package model;

import util.Enums.ChequesEstadoEnum;
import util.Enums.ChequesPrioridadEnum;
import util.Enums.CuentaEstadoEnum;

import java.sql.Date;
import java.sql.Timestamp;

// * REQ: PATRONES DE DISEÑO - DAO

public class Cheque {
    private int id; // * Autoincrement
    private String numero_cheque; // * Automatizado Con Cheque Sequencia
    private int id_cuenta;
    private String beneficiario;
    private Double monto;
    private String monto_letras;
    private ChequesPrioridadEnum prioridad;
    private String firma_digital;
    private ChequesEstadoEnum estado; // * Default Pendiente
    private String razon_rechazo; // TODO: Manejar Enum
    private Date fecha_emision;
    private Timestamp fecha_proceso;
    private boolean cobrado; // * Default False
    private Double cuenta_saldo_momento;

    private Timestamp fecha_modificacion;
    private String usuario_modificacion;

    // * Get

    public Cheque(int id, String numero_cheque, int id_cuenta, String beneficiario, Double monto, String monto_letras, ChequesPrioridadEnum prioridad, String firma_digital, ChequesEstadoEnum estado, String razon_rechazo, Date fecha_emision, Timestamp fecha_proceso, boolean cobrado, Double cuenta_saldo_momento, Timestamp fecha_modificacion, String usuario_modificacion) {
        this.id = id;
        this.numero_cheque = numero_cheque;
        this.id_cuenta = id_cuenta;
        this.beneficiario = beneficiario;
        this.monto = monto;
        this.monto_letras = monto_letras;
        this.prioridad = prioridad;
        this.firma_digital = firma_digital;
        this.estado = estado;
        this.razon_rechazo = razon_rechazo;
        this.fecha_emision = fecha_emision;
        this.fecha_proceso = fecha_proceso;
        this.cobrado = cobrado;
        this.cuenta_saldo_momento = cuenta_saldo_momento;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    // * Insert

    public Cheque(int id_cuenta, String beneficiario, Double monto, String monto_letras, ChequesPrioridadEnum prioridad, String firma_digital, ChequesEstadoEnum estado, String razon_rechazo, Date fecha_emision) {
        this.id_cuenta = id_cuenta;
        this.beneficiario = beneficiario;
        this.monto = monto;
        this.monto_letras = monto_letras;
        this.prioridad = prioridad;
        this.firma_digital = firma_digital;
        this.estado = estado;
        this.razon_rechazo = razon_rechazo;
        this.fecha_emision = fecha_emision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_cheque() {
        return numero_cheque;
    }

    public void setNumero_cheque(String numero_cheque) {
        this.numero_cheque = numero_cheque;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMonto_letras() {
        return monto_letras;
    }

    public void setMonto_letras(String monto_letras) {
        this.monto_letras = monto_letras;
    }

    public ChequesPrioridadEnum getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(ChequesPrioridadEnum prioridad) {
        this.prioridad = prioridad;
    }

    public String getFirma_digital() {
        return firma_digital;
    }

    public void setFirma_digital(String firma_digital) {
        this.firma_digital = firma_digital;
    }

    public ChequesEstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(ChequesEstadoEnum estado) {
        this.estado = estado;
    }

    public String getRazon_rechazo() {
        return razon_rechazo;
    }

    public void setRazon_rechazo(String razon_rechazo) {
        this.razon_rechazo = razon_rechazo;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Timestamp getFecha_proceso() {
        return fecha_proceso;
    }

    public void setFecha_proceso(Timestamp fecha_proceso) {
        this.fecha_proceso = fecha_proceso;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public Double getCuenta_saldo_momento() {
        return cuenta_saldo_momento;
    }

    public void setCuenta_saldo_momento(Double cuenta_saldo_momento) {
        this.cuenta_saldo_momento = cuenta_saldo_momento;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }
}
