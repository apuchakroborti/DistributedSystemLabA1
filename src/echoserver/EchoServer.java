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


import java.io.IOException;
import java.util.Scanner;


public class EchoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("press 1.for client\n press 2.forserver\n");
	        Scanner sc = new Scanner(System.in);
	        int choose=sc.nextInt();
	        if(choose == 1){
	            client client = new client("127.0.0.1");
	            client.StartClient();
	            //Client1 client = new Client1("127.0.0.1");
	            //client.doTask();
	            
                    
	        }
	        else{
                    while(true){
	            server server2ob = new server();
	            server2ob.StartServer();
                    }
                //Server1 server2ob = new Server1();
	        //server2ob.SdoTask();
                }
    }
    
}
