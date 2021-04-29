
// A Java program for a Client

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream write = null;
    private DataInputStream read = null;

    // constructor to put ip address and port
    public Client(String address, int port) {
        // establish a connection

        try {
            socket = new Socket(address, port);
            System.out.println("Connected");


            read = new DataInputStream(socket.getInputStream());
            write = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        Scanner scanner = new Scanner(System.in);
        while (!line.equals("exit")) {
            try {
                line = scanner.nextLine();
                write.writeUTF(line);
                System.out.println(read.readUTF());
                System.out.println(read.readUTF());
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection
        try {
            write.close();
            read.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

}