import java.io.*;
import java.nio.file.Files;

public class Logger {

    private static String fileName; // numele fisierului in care se scrie, respectiv "stdout" pentru consola

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        Logger.fileName = fileName;
    }

    public static void init(String name) throws IOException {
        if (name.equals("stdout")) {
            setFileName("stdout");
            return; // daca afisarea se face la consola nu trebuie creat niciun fisier
        }

        /* creaza un director in care se vor crea fisierele logger-ului, daca nu exista deja */
        File dir = new File("./log");
        if (!dir.exists()) {
            dir.mkdir();
        }
        name = (name.split("\\."))[0]; // testx.in => testx
        String fileName = "./log/" + name + "_logged"; // textx => testx_logged
        /* creeaza un nou fisier nu numele obtinut; daca exista deja un fisier cu acelasi nume, va fi sters */
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        Files.createFile(file.toPath());
        setFileName(fileName); // retine in campul fileName numele fisierului obtinut
    }

    /* afiseaza mesajul dat ca parametru in fisierul fileName, respectiv la consola */
    public static void log(String message) throws IOException {

        if (getFileName().equals("stdout"))
            System.out.print(message);
        else {
            /* se va scrie la finalul fisierului, pastrand ceea ce exista deja */
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(message);
            bw.close();
        }

    }

    /* intoarce un String reprezentand numele Pokemonilor care se lupta si proprietatile acestora */
    public static String participants(Pokemon pokemon1, Pokemon pokemon2) {
        String str = "\n~~ Battle between " + pokemon1.getName() + " and " + pokemon2.getName() + " ~~\n\n";

        str += pokemon1 + "\n";
        str += pokemon2 + "\n";

        return str;
    }

}