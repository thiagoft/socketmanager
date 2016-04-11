/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagoft.socketmanager.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Client Socket
 * Exemplo
 *
 * @author Thiago Fonseca
 */
public class ClientSocket {
    
    public static void main(String[] args) {
        try
        {

            Socket socketClient = new Socket("192.168.140.182",60350);
            
            System.out.println("Cliente conectado: " + socketClient.getInetAddress().getHostAddress());

//            Thread.sleep(10000);
            DataOutputStream ooos = new DataOutputStream(socketClient.getOutputStream());
            
            String msg = "SYS_GET_SERVER_INFO\n";

            ooos.write(msg.getBytes());


            DataInputStream ois = new DataInputStream(socketClient.getInputStream());
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
