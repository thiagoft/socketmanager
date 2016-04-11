/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagoft.socketmanager.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Server Socket
 * Exemplo
 *
 * @author Thiago Fonseca
 */
public class ServidorSocket {
    public static void main(String[] args) {
        try
        {

            ServerSocket socketServer = new ServerSocket(60350);
            
            Socket socket = socketServer.accept(); 
            System.out.println("Cliente conectado: " + socket.getInetAddress().getHostAddress());

//            Thread.sleep(10000);
            DataOutputStream ooos = new DataOutputStream(socket.getOutputStream());
            
            String msg = "MAG200\n\r\n";

            ooos.write(msg.getBytes());


            DataInputStream ois = new DataInputStream(socket.getInputStream());
            String mensajeAux;

            byte[] by = null;

            do
            {
                by = new byte[1];
                by[0] = ois.readByte();
                mensajeAux = new String(by, StandardCharsets.UTF_8);
                System.out.print(mensajeAux);

            } while (mensajeAux != null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
