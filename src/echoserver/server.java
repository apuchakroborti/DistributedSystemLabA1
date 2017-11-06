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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class server {
    private int searchString;
    private String search;
    private StringBuilder foundAt;
    private Socket socket;
    private ServerSocket server;
    private BufferedReader dIn;
    private PrintWriter dOut;
    private String dataFromClient;
    private String dataToClient;
    private Integer prevTrans;
    private Integer balance;

    private boolean IpFound;
    private String lastDNS;
    private int NoRunThread;
    private boolean find;
    

    server() throws IOException{
        server = new ServerSocket(8080);
        
    }

    public void StartServer() throws IOException{//SERVER START FROM HERE
        boolean start=true;
        int begin=0;
        while(true){
            try{
            	//Scanner input=new Scanner(System.in);
            	
                System.out.println("Server trying");
                socket = server.accept();
                dOut = new PrintWriter(socket.getOutputStream(),true);
                dIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                
                    while(true)
                    {
                        //String first=dIn.readLine().toString();
                        String fromClient=dIn.readLine().toString();
                        
                        System.out.println("Waiting....");
                        System.out.println("Received from client:"+fromClient);
                        if(fromClient.equals("BEGIN")){
                            //System.out.println("Server connection done"+fromClient);
                            begin=1;
                            dOut.println("Connection established");
                            dOut.flush();
                        }
                        else if(fromClient.equals("END"))
                        {
                            dOut.println("Connection aborted");
                            dOut.flush();
                            start=false;
                            break;
                        }
                        else if(begin==1) {
                            dOut.println(fromClient);
                            dOut.flush();
                        }
                        else{
                            dOut.println("");
                            dOut.flush();
                        }
                    }

                    
                
                if(start==false){
                    dOut.close();
                    dIn.close();
                    socket.close();
                    server.close();
                    break;
                }
                

            }catch(Exception e){
                continue;
            }
        }
       // server sb=new server();
        //sb.StartServer();
    }

    }