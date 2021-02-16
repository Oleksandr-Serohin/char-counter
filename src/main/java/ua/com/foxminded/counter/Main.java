package ua.com.foxminded.counter;

import ua.com.foxminded.counter.uniquechars.Counter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Date: Feb 11-2021 Class read at console sentence, give them on processed,
 * take processed sentence and print them.
 *
 * @author Aleksandr Serogin
 * @version 1.0001
 */

public class Main {

     /**
     * The main method off this application.
     * @param args array of string arguments.
     */
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner (System.in);
        while (in.hasNextLine ()) {
            Counter counter = new Counter ();
            System.out.print (counter.calculatedUniqueCharacterTheirNumber (in.nextLine ()));
        }
    }
}