import Repository.Implementations.ChequesImpl;
import Repository.Implementations.ClienteImpl;
import Repository.Implementations.CuentaImpl;
import model.Cheque;
import model.Cliente;
import model.Cuenta;
import util.FileManagment;
import util.IdentificationValidator;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static final ClienteImpl clienteImpl = new ClienteImpl();
    private static final ChequesImpl chequeImpl = new ChequesImpl();

    private static final CuentaImpl cuetaImpl = new CuentaImpl();

    public static void main(String[] args) {
        boolean flagLogin = true;
        while (flagLogin){
            System.out.println("Bienvenido Digite Su Numero De Identidad");
            Scanner scanner = new Scanner(System.in);
            String enteredIdentification = scanner.nextLine();
            if (IdentificationValidator.isIdentificationValid(enteredIdentification)){
                flagLogin = false;
                UserActual.setClienteActual(clienteImpl.getClientePorId(enteredIdentification.trim()));
                System.out.println("Bienvenido Señor/a: " + UserActual.getClienteActual().getApellido());
            } else {
                System.out.println("Identificacion No ENcontrada");
            }
        }
        boolean flagMainMenu = true;
        while (flagMainMenu){
            System.out.println("Que Desea Hacer");
            System.out.printf("""
                    1. Depositos
                    2. Retiros
                    3. Emitir Cheque
                    4. Cobrar Cheque
                    5. Reporte Cheques
                    * Salir
                    """);
            Scanner scanner = new Scanner(System.in);
            String enteredOptionMainMenu = scanner.nextLine();
            switch (enteredOptionMainMenu.trim()){
                case "1":
                    System.out.println("a");
                    break;
                case "2":
                    System.out.println("b");
                    break;
                case "3":
                    boolean emitirChequesMenu = true;
                    while (emitirChequesMenu){
                        System.out.println("Id Cuenta");
                        String enteredIdCuenta = scanner.nextLine();
                        if (cuetaImpl.getCuenta(enteredIdCuenta())){
                            emitirChequesMenu = false;
                            System.out.println("Id Cuenta Invalida");
                            break;
                        }
                        System.out.println("beneficiario");
                        String enteredBeneficiario = scanner.nextLine();
                        System.out.println("monto");
                        String enteredmonto = scanner.nextLine();
                        System.out.println("monto_letras");
                        String enteredmonto_letras = scanner.nextLine();
                        System.out.println("prioridad");
                        String enteredprioridad = scanner.nextLine();
                        System.out.println("firma_digital");
                        String enteredfirma_digital = scanner.nextLine();
                        System.out.println("fecha_emision");
                        String enteredChequeNumber = scanner.nextLine();
                    }
                    break;
                case "5":
                    boolean repoteChequesMenu = true;
                    while (repoteChequesMenu){
                        System.out.println("Digite * Para Volver");
                        System.out.println("Cual es el numero del cheque que quiere hacer el reporte");
                        String enteredChequeNumber = scanner.nextLine();
                        if (enteredChequeNumber.trim().equals("*")){
                            repoteChequesMenu = false;
                        }
                        Cheque cheque = chequeImpl.getCheque(enteredChequeNumber);
                        if (cheque != null && cuetaImpl.getAllClienteCuentas(UserActual.getClienteActual().getId()).contains(cuetaImpl.getCuenta(cheque.getId_cuenta(),UserActual.getClienteActual().getId()))){
                            FileManagment.generateReport(cheque);
                        } else {
                            System.out.println("Numero De Cheque No Valido");
                        }
                    }
                    break;
                case "*":
                    System.out.println("Esperamos Haber Podido Ayudarle");
                    System.out.println("Gracias Por Usar Nuestros Servicios");
                    flagMainMenu = false;
                    break;
            }
        }
    }
}
