/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author apu
 */
//client 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;


public class client {
    private Socket socket;
    private String search;
    private String IP;
    private String dataFromServer;
    private BufferedReader dIn; //data input
    private PrintWriter dOut;
    private BufferedReader sc;
    private Random rand;

    client(String s) throws IOException{
        IP = s;
        socket = new Socket(IP , 8080);
        dIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dOut = new PrintWriter(socket.getOutputStream(), true);
        sc = new BufferedReader(new InputStreamReader(System.in));
        rand = new Random();
    }

    public void StartClient() throws IOException{
    
        boolean begin=false;
        while(true)
        {
            System.out.println("Enter the search string");
            search = sc.readLine();

            System.out.println("The String that you have entered: "+search);

            if(search.toString().equals("BEGIN")){
                begin=true;
            }
            if(begin==true)
            {
            
                dOut.println(search);
                dOut.flush();
                dataFromServer = dIn.readLine();

                String reply=dataFromServer.toString();
                if(reply.equals("Connection aborted"))
                {
                    break;
                }


                System.out.println("Data from server:"+dataFromServer);
                //dOut.println("");
                //dOut.flush();
            }
            
        }
        dIn.close();
        dOut.close();
        socket.close();
    	
    }
}
