package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: implement getSize method
        return names.length; //returns the current length(size) of the array
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        //todo: implement setNames method
        NameRepository.names = names; //create a new array with the same name, and move the reference to it instead
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER); //sort the names in the new array
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: implement clear method
        names = new String[0]; //creates a new array with the same name.
        //names = Arrays.copyOf(names, 0); //another way of solving it, but could be worse in performance
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: implement findAll method
        return Arrays.copyOf(names, names.length); //returns an exact copy of names
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: implement find method
        for (String name : names) { //loops through array, and return name if found
            if (name.equalsIgnoreCase(fullName)) { //compares names case insensitively
                return name;
            }
        }
        return null; //returns null if name was not found
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: implement add method
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER); //sort the names before binary search
        int isNameNew = Arrays.binarySearch(names, fullName); //search if name to be added is found
        if (isNameNew < 0) { //if new, expand array and add it to the back
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = fullName;
            Arrays.sort(names, String.CASE_INSENSITIVE_ORDER); //sort the names after the new name was added
            return true;
        } else {
            return false;
        }

    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        //todo: findByFirstName method
        String[] foundNames = new String[0];
        firstName = firstName.toLowerCase(); //converts string to lowercase for case-insensitive comparison
        int nameCounter = 0; //counter for found names, for index use

        for (String name : names) {
            if (name.toLowerCase().startsWith(firstName)) { //if the names matches
                foundNames = Arrays.copyOf(foundNames, foundNames.length + 1); //expand the array before adding the name found
                foundNames[nameCounter] = name; //add the full name to the new array
                nameCounter++; //increase found name counter
            }
        }
        if (nameCounter == 0) {
            foundNames = Arrays.copyOf(foundNames, foundNames.length + 1);
            foundNames[0] = "No matches found for first name: " + firstName;
        }
        return foundNames;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        //todo: implement findByLastName method
        String[] foundNames = new String[0];
        lastName = lastName.toLowerCase(); //converts string to lowercase for case-insensitive comparison
        int nameCounter = 0;

        for (String name : names) {
            if (name.toLowerCase().endsWith(lastName)) { //if the name matches
                foundNames = Arrays.copyOf(foundNames, foundNames.length + 1); //expand the array before adding the name found
                foundNames[nameCounter] = name; //add the full name to the new array
                nameCounter++; //increase found name counter
            }
        }
        if (nameCounter == 0) {
            foundNames = Arrays.copyOf(foundNames, foundNames.length + 1);
            foundNames[0] = "No names found with last name: " + lastName;
        }
        return foundNames;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: implement update method
        int originalNameIndex = Arrays.binarySearch(names, original);
        if (originalNameIndex >= 0) {
            if (Arrays.binarySearch(names, updatedName) < 0) { //if index of updated name is less than zero it wasn't found
                names[originalNameIndex] = updatedName;
                Arrays.sort(names, String.CASE_INSENSITIVE_ORDER); //sort the names after updating name
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        //todo: implement remove method
        String[] tempArray = new String[names.length - 1]; //temporary array to store names during removal
        int tempCounter = 0;
        int indexOfNameToBeRemoved = -1; //initiate to -1 in case no matching name was found
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                indexOfNameToBeRemoved = i; //if name was found, save the index for it
                break; //exit loop early if name was found.
            }
        }
        if(indexOfNameToBeRemoved < 0){
            return false; //return false if name was not found
        }

        for(int i = 0; i < names.length; i++){ //iterate through the array and add every name but the index to be removed
            if(i != indexOfNameToBeRemoved){
                tempArray[tempCounter] = names[i]; //add name to tempArray
                tempCounter++;
            }
        }
        names = tempArray;
        return true;


        //alternative solution, isn't case-insensitve
        /*
        String[] tempArray = new String[names.length];
        fullName = fullName.toLowerCase(); //coverts string to lowercase before comparison
        int tempIndexCounter = 0;
        int indexOfNameFound = Arrays.binarySearch(names, fullName);
        if (indexOfNameFound < 0) { //if less than zero name was not found
            return false;
        }
        for (int i = 0; i < names.length; i++) {
            if (i == indexOfNameFound) {  //when it comes to original name skip to next
                continue; //skip to the next iteration
            } else {
                tempArray[tempIndexCounter] = names[i]; //add every name to temp array
                tempIndexCounter++;
            }
        }
        names = Arrays.copyOf(tempArray, tempIndexCounter); //copy tempArray to names array

        return true;

         */
    }
}