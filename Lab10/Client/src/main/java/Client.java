
// A Java program for a Client

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client(String address, int port) throws IOException {
        Socket socket = null;
        DataInputStream read = null;
        DataOutputStream write = null;

        socket = new Socket(address, port);
        read = new DataInputStream(socket.getInputStream());
        write = new DataOutputStream(socket.getOutputStream());
        System.out.println("Connected");

        String line = "";
        Scanner scanner = new Scanner(System.in);
        while (!line.equals("exit")) {
            line = scanner.nextLine();
            write.writeUTF(line);
            System.out.println(read.readUTF());
            System.out.println(read.readUTF());
        }

        write.close();
        read.close();
        socket.close();

    }
}