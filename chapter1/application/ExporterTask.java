package com.ldc.chapter1.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ExporterTask implements Runnable{
    Socket socket;

    ExporterTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
