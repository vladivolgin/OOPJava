package server1;
import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет


    public static void main(String[] args) {
        Random random = new Random();
        int m = random.nextInt(4);
        try {
            try {
                server = new ServerSocket(8030); // серверсокет прослушивает порт 8030
                System.out.println("Сервер запущен!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept(); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться
                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода.
                    // теперь мы можем принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // и отправлять
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.println(word);
                    if (word.equals("Sonet")) {
                        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\cspro\\IdeaProjects\\5lab\\Sonety\\" + m + ".txt");
                        File file = new File("C:\\Users\\cspro\\IdeaProjects\\5lab\\Sonety\\" + m + ".txt");
                        BufferedReader br = new BufferedReader(new FileReader(file));



                        String st;

                        while ((st = br.readLine()) != null) {

                            out.write(st);
                           // out.write("\n");
                        }
                       // int i;
                        //for (int j = 0; j < 14; j++) {
                            //while ((i = fileInputStream.read()) != -1) {

                                //out.write((char) i);
                           // }
                        //}
                            out.flush(); // выталкиваем все из буфера
                        }

                    else{
                            out.write("Неизвестная команда");
                            out.flush();
                        }

                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}