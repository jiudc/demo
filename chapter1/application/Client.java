package com.ldc.chapter1.application;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

@Service
public class Client {
    public Object invokeRpc() throws IOException {
        Socket socket = new Socket("127.0.01", 8090);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello,I'm Client");
        bufferedWriter.write("Hello,I'm Client2");
        bufferedWriter.write("Hello,I'm Client3");
        bufferedWriter.write("Hello,I'm Client4");
        bufferedWriter.flush();
        return null;
    }

    public static void main(String[] args) throws IOException {
        Client client=new Client();
        client.invokeRpc();
    }
}
