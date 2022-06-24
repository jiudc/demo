package com.ldc.chapter1.application;

import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class Servicer {
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }

    public void startClient(String rpcApi) {
        new Thread(() -> {
            while (true) {
                try {
                    Class<?> aClass = Class.forName(rpcApi);
                    aClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onListen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while (!"quit".equalsIgnoreCase(s = reader.readLine())) {
            System.out.println(String.format("now Listen s[%s]", s));
        }
    }

    public static void main(String[] args) throws IOException {
        Servicer servicer = new Servicer();
        servicer.onListen();
    }

}
