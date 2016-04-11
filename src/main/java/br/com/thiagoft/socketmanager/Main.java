package br.com.thiagoft.socketmanager;

import br.com.thiagoft.socketmanager.threads.ThreadKijoSender;
import br.com.thiagoft.socketmanager.utils.CheckSumUtils;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe App
 *
 * @author Thiago Fonseca
 */
public class Main {
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<Thread>();
        
        String kijo = "";
        
        for (int x = 1; x <= 300; x++) {
            kijo = "KIJO99,99,"+x+",V2,";
            kijo += CheckSumUtils.calculaCheckSumHexPara(kijo).toUpperCase();
            kijo += "\r\n";
                    
            Thread thread = new ThreadKijoSender(kijo,30000);
            thread.start();
            
            threadList.add(thread);
        }
        
//        Thread threadSys = new ThreadSysSender("SYS_GET_SERVER_INFO\n",1000);
//        threadSys.start();
    }
}
