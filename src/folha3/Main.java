package folha3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> Students = new ArrayList<>();

        Students.add("Daniel Carrilho");
        Students.add("Belissandro Cabral");
        Students.add("João Gama");
        Students.add("Carlos Raimundo");
        Students.add("João Magarreiro");
        Students.add("Pedro Gaspar");
        Students.add("Dénis Furtado");
        Students.add("Mamadu Embaló");
        Students.add("Álvaro Melo");
        Students.add("Nuno Fernandes");
        Students.add("Pedro Andrade");
        Students.add("Afonso Botelho");
        Students.add("Fausto Serodio");
        Students.add("Rafael Carvalho");
        Students.add("André Silva");
        Students.add("Diogo Constantino");

        double rand = Math.random();

        int choice = (int)(rand * Students.size());

        if (choice == Students.size()){
            choice--;
        }


        System.out.println("\n" +choice + " : " +Students.get(choice) + "\t(rand = " +rand + " ; double choice = " + (rand * Students.size()) + ")");

    }
}
