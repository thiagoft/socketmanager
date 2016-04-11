/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thiagoft.socketmanager.threads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Thread KIJO Sender
 *
 * @author Thiago Fonseca
 */
public class ThreadKijoSender extends Thread {
    
    private String mensagemKijo;
    private int delay;

    public ThreadKijoSender(String mensagemKijo, int delay) {
        this.mensagemKijo = mensagemKijo;
        this.delay = delay;
    }
        
    @Override
    public void run() {
        try
        {
            Socket socketClient = new Socket("192.168.140.182",60350);
            
            System.out.println("Kijo Sender conectado: " + socketClient.getInetAddress().getHostAddress());

            DataOutputStream ooos = new DataOutputStream(socketClient.getOutputStream());
            
            while(true) {
                escreveNoSocket(ooos,this.mensagemKijo);
                Thread.sleep(delay);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void escreveNoSocket(DataOutputStream dos, String msg) throws IOException {
        dos.write(msg.getBytes());
    }
}
