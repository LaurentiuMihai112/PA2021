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
                        if (connectedUser == null) {
                            write.writeUTF("You must be connected");
                        } else {
                            StringBuilder response = new StringBuilder("Added:\n");
                            for (int i = 1; i < components.length; i++) {
                                User newFriend = Select.getUserByName(components[i]);
                                if (newFriend != null) {
                                    Add.addFriend(connectedUser, newFriend);
                                    response.append(newFriend.getName()).append(" (OK)\n");
                                } else {
                                    response.append(components[i]).append(" (Not existent user)\n");
                                }
                            }
                            write.writeUTF(String.valueOf(response));
                        }
                        break;
                    case "send":
                        if (connectedUser == null) {
                            write.writeUTF("You must be connected");
                        } else {
                            StringBuilder message = new StringBuilder();
                            for (int i = 1; i < components.length; i++) {
                                message.append(components[i]).append(" ");
                            }
                            String response = Add.addMessage(connectedUser, String.valueOf(message));
                            write.writeUTF(response);
                        }
                        break;
                    case "read":
                        if (connectedUser == null) {
                            write.writeUTF("You must be connected");
                        } else if (components.length > 1) {
                            write.writeUTF("Command not valid!");
                        } else {
                            var messages = Select.getMessages(connectedUser.getId());
                            StringBuilder response = new StringBuilder();
                            for (String message : messages) {
                                response.append(message).append("\n");
                            }
                            write.writeUTF(String.valueOf(response));
                        }
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
