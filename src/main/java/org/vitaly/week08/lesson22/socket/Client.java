package org.vitaly.week08.lesson22.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by vitaly on 22.03.17.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5555);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String s = "hello server";

        outputStream.write(s.getBytes());

        byte[] buffer = new byte[1024];
        inputStream.read(buffer);
        String answer = new String(buffer, 0, buffer.length);
        System.out.printf(answer);

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
