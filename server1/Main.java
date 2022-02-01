package server1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanIn = new Scanner(System.in);
        System.out.println("Запустить программу в режиме сервера или клиента?\nS(erver)\nC(lient)");
        while (true) {
            char answer = Character.toLowerCase(scanIn.nextLine().charAt(0));
            if (answer == 's'){
                new MyServerSocket();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("Некорректный ввод. Повторите.");
            }
        }
    }

    private static class MyServerSocket {
    }
}