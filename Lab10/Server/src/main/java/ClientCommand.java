import DAO_classes.Add;
import DAO_classes.Select;
import objects.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientCommand implements Runnable {
    DataInputStream read = null;
    DataOutputStream write = null;
    Socket socket = null;

    public ClientCommand(Socket socket) throws IOException {
        this.read = new DataInputStream(socket.getInputStream());
        this.write = new DataOutputStream(socket.getOutputStream());
        this.socket = socket;
    }

    @Override
    public void run() {
        User connectedUser = null;
        String line = "";
        boolean exit = false;
        while (!exit) {
            try {
                line = read.readUTF();
                System.out.print("Received -> ");
                System.out.println(line);
                write.writeUTF("Request received");
                String[] components = line.split(" ");
                switch (components[0]) {
                    case "register":
                        if (components.length > 2) {
                            write.writeUTF("Command not valid! Name must not contain spaces");
                        } else if (connectedUser != null) {
                            write.writeUTF("You are already connected, logout first");
                        } else {
                            User user = Select.getUserByName(components[1]);
                            if (user != null) {
                                write.writeUTF("Name not valid");
                            } else {
                                user = new User(components[1]);
                                Add.addUser(user);
                                write.writeUTF("User created");
                            }
                        }
                        break;
                    case "login":
                        if (components.length > 2) {
                            write.writeUTF("Command not valid! Name must not contain spaces");
                        } else if (connectedUser != null) {
                            write.writeUTF("You are already connected, logout first");
                        } else {
                            User user = Select.getUserByName(components[1]);
                            if (user == null) {
                                write.writeUTF("User does not exist, please register first");
                            } else {
                                connectedUser = user;
                                write.writeUTF("Logged in successfully");
                            }
                        }
                        break;
                    case "friend":
                        break;
                    case "send":
                        break;
                    case "read":
                        break;
                    case "stop":
                        break;
                    case "logout":
                        connectedUser = null;
                        write.writeUTF("logout successful");
                        break;
                    case "exit":
                        exit = true;
                        write.writeUTF("\n");
                        break;
                    default:
                        write.writeUTF("Command not valid!");
                }
            } catch (IOException | SQLException i) {
                System.out.println(i);
            }
        }
        System.out.println("Closing connection");

        // close connection
        try {
            socket.close();
            read.close();
            write.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
