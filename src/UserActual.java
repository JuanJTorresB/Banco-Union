import model.Cliente;

public class UserActual {
    private static Cliente clienteActual;

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void setClienteActual(Cliente clienteActual) {
        UserActual.clienteActual = clienteActual;
    }
}
