package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here


        File file = new File("/home/marcin/Downloads/GuessTheMovie/src/com/company/movies.txt");
        Scanner in = new Scanner(file);


        Random random = new Random();
        int number = random.nextInt(25);


        String line = in.nextLine();



        Pattern ptn = Pattern.compile("[a-zA-Z]");
        Matcher mtch = ptn.matcher(line);
        String hiddenMovie = mtch.replaceAll("-");
        System.out.println(mtch.replaceAll("-"));

        char[] array = hiddenMovie.toCharArray();
        Scanner scanner = new Scanner(System.in);

        final int attempt =21;
        int revealed =0;


        ///////////////////////////////////////////////////////////////

        for (int i = 1; i <= 20; i++) {

            System.out.println("Letters revealed: " + revealed +" Attempts  left:" + (attempt -i) + "  Give me one letter:");

            int index =0;
            char c = scanner.next().charAt(0);
            int occurrence = 0;

            System.out.println( line.length());

            for (int k = 0; k < line.length(); k++) {

                occurrence = line.indexOf(c,index);

                if (occurrence >= 0) {
                    array[occurrence] = c;
                    revealed++;
                    index = occurrence +1;
                }


            }

            for (char l : array) {
                System.out.print(l);
            }
            System.out.println();

        }


    }
}