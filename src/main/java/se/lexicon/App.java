package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Kalle Moraeus", "Big Bengt", "Sleepy Joe"});
        System.out.println(NameRepository.getSize()); //get the current size of "names"
        // call more methods as needed


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

        boolean wasItSuccessful = NameRepository.remove("Kalle KULAS"); //remove name from array
        System.out.println(wasItSuccessful);
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them
        wasItSuccessful = NameRepository.remove("Kalle KULA"); //remove name from array
        System.out.println(wasItSuccessful);
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them


        NameRepository.setNames(new String[]{"Erik Svensson", "Johan Javan", "Mehr Kavad", "Mehrdad Javan", "Kalle Moraeus", "Big Bengt", "Sleepy Joe"});
        size = NameRepository.getSize();
        System.out.println(size);
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them

        NameRepository.setNames(new String[]{"Erik Svensson", "Johan Javan", "Mehr Kavad"});
        size = NameRepository.getSize();
        System.out.println(size);
        System.out.println(Arrays.toString(NameRepository.findAll())); //get all names and print them

        searchFullName = NameRepository.find("erik sveNsson"); //method to search for a specific name
        System.out.println(searchFullName); //prints name if found, else print null


    }
}
