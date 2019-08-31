package cokolwiek.company;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";

        if (args.length < 1) {
            System.out.println("Podaj nazwe pliku:");
            try {
                fileName = brIn.readLine();
            } catch (IOException e) {
                System.out.println("\nBlad wejscia-wyjscia.");
                return;
            }
        } else {
            fileName = args[0];
        }

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("Plik o tej nazwie juz istnieje.");
            return;
        }
        RandomAccessFile raf = null;

        try {
            raf = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna utworzyc pliku.");
            return;
        }

        String line = "";

        try {
            while (true) {
                line = brIn.readLine();
                if ("quit".equals(line) || line == null) {
                    break;
                }
                raf.writeBytes(line + "\n");
            }
            raf.close();
        } catch (IOException e) {
            System.out.println("\nBlad wejscia-wyjscia");
            return;
        }
    }
}
