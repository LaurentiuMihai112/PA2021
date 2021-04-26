// A Java program for a Server

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {

    // constructor with port
    public Server(int port) throws IOException {

        ServerSocketClass serverSocketClass = new ServerSocketClass(port);
        serverSocketClass.socket = serverSocketClass.server.accept();
        System.out.println("Client accepted");

        // takes input from the client socket
        serverSocketClass.read = new DataInputStream(serverSocketClass.socket.getInputStream());
        serverSocketClass.write = new DataOutputStream(serverSocketClass.socket.getOutputStream());
        String line = "";

        // reads message from client until "Over" is sent
        while (!line.equals("Over")) {
            try {
                line = serverSocketClass.read.readUTF();
                System.out.println(line);
                serverSocketClass.write.writeUTF("Request received");


            } catch (IOException i) {
                System.out.println(i);
            }
        }
        System.out.println("Closing connection");

        // close connection
        serverSocketClass.socket.close();
        serverSocketClass.read.close();
        serverSocketClass.write.close();

    }
}