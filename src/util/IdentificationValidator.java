package util;

import Repository.Implementations.ClienteImpl;
import model.Cliente;
import util.Enums.ClientesEstadoEnum;

public class IdentificationValidator {

    private static final ClienteImpl clientesImpl = new ClienteImpl();

    public static boolean isIdentificationValid(String string){
        if (isLessThan(string, 10) && isDigit(string)){
            Cliente cliente = clientesImpl.getClientePorId(string);
            return cliente != null && cliente.getEstado()== ClientesEstadoEnum.Activo;
        }
        return false;
    }

    public static boolean isLessThan(String string, int lessThan){
        return  string.length()<=lessThan;
    }
    public static boolean isDigit(String string){
        try {
            Long.parseLong(string);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
