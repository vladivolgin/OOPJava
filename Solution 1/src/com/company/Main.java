package com.company;
import java.util.Arrays;
import java.util.Scanner;


class Main {
    public static void main(String[] args) { int count = 1;
        Scanner scanner = new Scanner(System.in);//читаем строку с клавиатуры
         String text = scanner.nextLine();
        // читаем строку с клавиатуры
        String[] words = text.toLowerCase().replaceAll("[,.!:?]", "").split("\\s");
        Arrays.sort(words);//массив строк
        for (int i = 1; i < words.length; i++) { if (words[i].equals(words[i - 1])) {
            do {
                count++; i++;
            } while (i < words.length && words[i].equals(words[i - 1]));
        }//Цикл для считывания слов
            System.out.println("Слово \"" + words[i - 1] + "\" встречается в тексте: " + count + " раз.");//вывод результата
            count = 1;
        }
    }
}
