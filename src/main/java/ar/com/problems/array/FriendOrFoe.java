package ar.com.problems.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FriendOrFoe {

    /**
     * Method to filter friends whose name has 4 characters.
     * @param names List of Strings.
     * @return List of Strings with 4 characters.
     */
    public static List<String> friend(List<String> names){

        List<String>  friends = new ArrayList<>();

        // Iterate over the list of names
        for (String name : names) {
                // Add the name to the list of friends
            if(name.length() == 4){
                friends.add(name);
            }
        }

        return friends;
    }

    /**
     * Method to filter friends whose name has 4 characters using Stream API.
     * @param names List of Strings.
     * @return List of Strings with 4 characters.
     */
    public static List<String> friendStream(List<String> names) {
        // Use Stream API to filter the list of names
        // and return a list of names with 4 characters
        return names.stream()
                .filter(name -> name.length() == 4)
                .collect(Collectors.toList());
    }

    /**
     * Method to filter friends whose name has 4 characters using Stream API.
     * This method uses a variable argument parameter.
     * @param names List of Strings.
     * @return List of Strings with 4 characters.
     */
    public static List<String> friendLambda(String ...names) {
        // Use Stream API to filter the list of names
        // and return a list of names with 4 characters
        return friendStream(List.of(names));
    }

}
