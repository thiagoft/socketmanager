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
 * Thread INFO SENDER
 *
 * @author Thiago Fonseca
 */
public class ThreadSysSender extends Thread {
    
    private String mensagem;
    private int delay;

    public ThreadSysSender(String mensagem, int delay) {
        this.mensagem = mensagem;
        this.delay = delay;
    }
        
    @Override
    public void run() {
        try
        {
            while(true) {
                Socket socketClient = new Socket("192.168.140.182",60350);

                System.out.println("Kijo Sender conectado: " + socketClient.getInetAddress().getHostAddress());

                DataOutputStream ooos = new DataOutputStream(socketClient.getOutputStream());
                
                escreveNoSocket(ooos,this.mensagem);
                
                Thread.sleep(delay); 
                
                socketClient.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void escreveNoSocket(DataOutputStream dos, String msg) throws IOException {
        dos.write(msg.getBytes());
    }
    
}
