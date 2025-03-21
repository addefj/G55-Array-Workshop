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
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        //todo: implement setNames method
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: implement clear method
        names = Arrays.copyOf(names, 0);
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: implement findAll method
        String[] copyOfNamesArray = names;
        return copyOfNamesArray;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: implement find method
        int indexOfTarget = Arrays.binarySearch(names, fullName);
        if (indexOfTarget < 0) {
            return null;
        } else {
            return names[indexOfTarget];
        }
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: implement add method
        int isNameNew = Arrays.binarySearch(names, fullName);
        if (isNameNew < 0) { //check if name is new
            names = Arrays.copyOf(names, names.length + 1);
            names[names.length - 1] = fullName;
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
        boolean isFirstName;
        String[] foundNames = new String[0];
        int nameCounter = 0;

        for (int i = 0; i < names.length; i++) {
            isFirstName = names[i].startsWith(firstName);
            if (isFirstName) {
                foundNames = Arrays.copyOf(foundNames, foundNames.length + 1);
                foundNames[nameCounter] = names[i];
                nameCounter++;
            }
        }
        if (nameCounter == 0) {
            foundNames = Arrays.copyOf(foundNames, foundNames.length + 1);
            foundNames[0] = "No names found with first name: " + firstName;
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
        boolean isLastName;
        String[] foundNames = new String[0];
        int nameCounter = 0;

        for (int i = 0; i < names.length; i++) {
            isLastName = names[i].endsWith(lastName);
            if (isLastName) {
                foundNames = Arrays.copyOf(foundNames, foundNames.length + 1);
                foundNames[nameCounter] = names[i];
                nameCounter++;
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
        int canOriginalNameBeFound = Arrays.binarySearch(names, original);
        if (canOriginalNameBeFound >= 0) {
            int isUpdatedNameNew = Arrays.binarySearch(names, updatedName);
            if (isUpdatedNameNew < 0) {
                names[canOriginalNameBeFound] = updatedName;
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
        String[] tempArray = new String[0];
        int tempIndexCounter = 0;
        int indexOfNameFound = Arrays.binarySearch(names, fullName);
        if (indexOfNameFound < 0) { //if less than zero name was not found
            return false;
        }
        for (int i = 0; i < names.length; i++) {
            if (i == indexOfNameFound) {  //prevent original name to be copied to tempArray
            continue; //skip to the next iteration
            }else{
                tempArray = Arrays.copyOf(tempArray, tempArray.length +1); //expand tempArray to fit next name
                tempArray[tempIndexCounter] = names[i]; //add every name to temp array
                tempIndexCounter++;
            }
        }
        names = Arrays.copyOf(tempArray, tempArray.length); //copy tempArray to names array

        return true;


    }
}