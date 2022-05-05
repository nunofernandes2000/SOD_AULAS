package Ficha6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUM_WORDS = 100000;

    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + "\\src\\Ficha6\\";
        System.out.println(path);

        List<String> originalWordsList = getOriginalWordsList(path);

        FileWriter writer = null;
        try {
            writer = new FileWriter(path + "lista_palavras.txt");

        } catch (IOException e) {
            System.out.println("Erro ao tentar criar o ficheiro \"lista_palavras.txt\"");
        }

        try {
            for (int i = 0; i < NUM_WORDS; i++) {
                writer.write(originalWordsList.get((int) (Math.random() * originalWordsList.size())) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao tentar escrever no ficheiro \"lista_palavras.txt\" ou ao tentar fechá-lo");
        }

        System.out.println("Novo ficheiro \"lista_palavras.txt\" criado em " + path + " com " + NUM_WORDS + " palavras");

    }



    private static List<String> getOriginalWordsList(String path){

        List<String> newWordsList = new ArrayList<>();

        File file = new File(path + "words.txt");

        BufferedReader reader;
        String word;

        try {
            reader = new BufferedReader(new FileReader(file));

            while((word = reader.readLine()) != null){
                newWordsList.add(word);
            }

            reader.close();


        } catch (FileNotFoundException e) {
            System.out.println("O ficheiro \"words.txt\" não está na pasta indicada");
        } catch (IOException e) {
            System.out.println("Falha de leitura do ficheiro\"words.txt\" ou a tentar fechá-lo");
        }
        return newWordsList;
    }
}
