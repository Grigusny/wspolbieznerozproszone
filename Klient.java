package lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Klient {
    public static void main(String[] args){

        //Tworzenie gniazda, i sprawdzenie czy host/pory serwera nas�uchuje
        String host;
        int port;

        if(args.length==0){
            host= "localhost";
            port = 9999;
        }
        else{
            host = args[0];
            String portStr = args[1];
            try {
                port=Integer.parseInt(portStr);
            }
            catch(NumberFormatException nfe){
                System.out.println("Uuups, z�y numer portu. Prze��czam na domyslny port: 9999");
                port = 9999;
            }
        }
        try{
            //Pr�ba po��czenia z serwerem
            System.out.println("Klient: Pr�ba pod��czenia do serwera jako host-"+host+" port: "+port+'.');
            Socket skt = new Socket(host,port);

            //Opcje odczytu i zapisu z i do strumienia
            BufferedReader Input = new BufferedReader(new InputStreamReader(skt.getInputStream())); //odczyt
            PrintStream Output = new PrintStream(skt.getOutputStream());

            //Przes�anie sprawdzaj�cej wiadomo�ci na serwer:
            Output.println("Klient: Siema Heniu!");

            //Sprawdzenie, czy serwer odpowiedzia�.
            String buf=Input.readLine();
            if(buf !=null){
                System.out.println("Klient: Odpowied� serwera [ "+buf+" ]");
            }
            else
                System.out.println("Klient: Brak odpowiedzi z serwera.");


            LinaGui lina = new LinaGui();
            lina.grafika();


            // Zamkni�cie po��czenia ze strony klienta
            skt.close();
            System.out.println("Klient - Od��czony");

        }
        catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Uuuups, co� si� skopa�o. nie podzia�am!");
        }
    }
}
