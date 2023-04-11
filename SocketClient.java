import java.io.*;
import java.net.*;
import java.util.logging.*;

public class SocketClient {
    private static final Logger logger = Logger.getLogger(SocketClient.class.getName());
    public static void main (String[] args) {
        String host = args[0];
        int port = Integer.valueOf(args[1]);
        if (args.length > 2 && args[2].equals("-l")) {
            logger.setLevel(Level.ALL);
        } else {
            logger.setLevel(Level.INFO);
        }
        logger.info("connecting to " + host + " on port " + port);
        try {
            Socket socket = new Socket(host, port);
            InputStream input = socket.getInputStream();
            logger.info("received message: ");
            int readChar = 0;
            while((readChar = input.read()) != -1) {
                System.out.write(readChar);
            }
            socket.close();
        }
        catch (IOException exception) {
            logger.log(Level.SEVERE, "Exception caught", exception);
        }
    }

}œ