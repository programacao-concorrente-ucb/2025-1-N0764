package socket_send_receive;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws InterruptedException {
        String mensagem = "Hello world!";
        try {
            ServerSocket servidor = new ServerSocket(12345);
            Socket socket = servidor.accept();
            ObjectOutputStream saida =
                new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada =
                new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < mensagem.length(); i++) {
                saida.writeObject(String.valueOf(mensagem.charAt(i)));
                Thread.sleep(3000);
                System.out.println("SERVIDOR: " + entrada.readObject());
            }
            saida.writeObject(null);
            entrada.close();
            saida.close();
            socket.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
