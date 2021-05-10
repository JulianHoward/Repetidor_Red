import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RepetidoraRed {

    public static final int PUERTO = 6849;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PUERTO);
        Socket clienteSocket = server.accept();

        PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream());
        salida.println("Hola");
        salida.flush();

        BufferedReader lectorEntrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        String linea = lectorEntrada.readLine();

        while(!linea.equals("FIN")){
            salida.println("Repitiendo: " + linea);
            salida.flush();

            linea = lectorEntrada.readLine();
        }

        lectorEntrada.close();
        salida.close();
        clienteSocket.close();
        server.close();
    }
}
