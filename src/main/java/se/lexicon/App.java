package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Kalle Moraeus", "Big Bengt", "Sleepy Joe"});
        System.out.println(NameRepository.getSize()); //get the current size of "names"
        // call more methods as needed
        //System.out.println(Arrays.toString(NameRepository.names)); //Print the content of the "names" as a string
        //NameRepository.clear(); //clears all names
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them
        String searchFullName = NameRepository.find("Kalle Moraeus"); //method to search for a specific name
        System.out.println(searchFullName); //prints name if found, else print null
        boolean addSuccesful = NameRepository.add("Erik Nilsson");
        if(addSuccesful){ //checks if the name was added with success
            System.out.println("Name was added Successfully!");
        } else {
            System.out.println("Name already exists");
        }

        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them
        System.out.println(Arrays.toString(NameRepository.findByFirstName("Erik"))); //get all names with first name Erik
        System.out.println(Arrays.toString(NameRepository.findByLastName("Moraeus"))); //get all names with first name Erik

        NameRepository.update("Kalle Moraeus", "Kalle Kula");
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them

        NameRepository.remove("Kalle Kula"); //remove name from array
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them

    }
}
