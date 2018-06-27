package lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            ServerSocket myServerSocket = new ServerSocket(9999); //stworzenie gniazda servwera i przypisanie mu portu (tu 9999)

            // Oczekiwanie na po��czenie od hosta
            System.out.println("Serwer: Start na ho�cie-"
                    +InetAddress.getLocalHost().getCanonicalHostName()
                    +" port: "+myServerSocket.getLocalPort());
            Socket skt = myServerSocket.accept();

            //Opcje odczytu i zapisu z i do strumienia
            BufferedReader Input = new BufferedReader(new InputStreamReader(skt.getInputStream())); //odczyt
            PrintStream Output = new PrintStream(skt.getOutputStream());                            //zapis

            //Pr�ba odczytania wej�cia ze strumienia
            String buf = Input.readLine();

            //Sprawdzenie, czy serwer odebra� wiadomo�� i pr�ba odpisania hostowi
            if (buf !=null){
                System.out.println("Serwer, odczyt: [ "+buf+" ]");
                Output.print("Serwer: No siemka!"); //Odpowied� dla hosta w przypadku odebrania wiadomo�ci
            }
            // Zamkni�cie po��czenia ze strony serwera
            skt.close();
            System.out.println("Serwer - Od��czony");

        }
        catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Uuuups, co� si� skopa�o. nie podzia�am!");
        }
    }
}
