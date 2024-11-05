package MongoDB;

import javafx.util.Pair;

import java.util.*;

public class SortedLoginDetails {

    public static void getSortedLoginDetails(){
        ArrayList<Pair<Integer, String>> users = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> logins = new ArrayList<>();
        HashSet<Integer> userAvailableSet = new HashSet<>();
        HashMap<String, Integer> resultSet = new HashMap<>();
        HashMap<String, Integer> uniqueResultSetCounter = new HashMap<>();

        users.add(new Pair<>(1,"qw"));
        users.add(new Pair<>(2,"er"));

        //logins.add(new Pair<>(1,1));
        // logins.add(new Pair<>(1,1));
        // logins.add(new Pair<>(1,3));
        logins.add(new Pair<>(2,4));
        logins.add(new Pair<>(2,5));
        logins.add(new Pair<>(1,7));

        for (Pair<Integer, String> user: users){
            userAvailableSet.add(user.getLeft());
        }

        for (Pair<Integer, Integer> login: logins){
            if (getUsers(userAvailableSet, login.getLeft())){

                String userLogin = getUsers(users, login.getLeft());
                if (!resultSet.containsKey(userLogin)){
                    resultSet.put(userLogin, 1);
                    uniqueResultSetCounter.put(userLogin, login.getRight());
                }
                else if (!(uniqueResultSetCounter.containsKey(userLogin) && uniqueResultSetCounter.containsValue(login.getRight()))){
                    resultSet.put(userLogin, resultSet.get(userLogin) + 1);
                    uniqueResultSetCounter.put(userLogin, login.getRight());
                }
            }
        }


        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(resultSet.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Output the sorted map
        System.out.println("Sorted by Values (Descending): " + sortedMap);

        //Users - [{1,"qw"},{2,"er"}]
        //Logins - [{1,1},{1,1},{1,3},{2,4},{2,5},{1,7}]
        //output (Print in descending order based on login attempts)
        //"qw" : 3
        //"er" : 2
        //User "qw" logged 4 times in total, unique attempts - 3. you can assume any input type (either 2d array or List).


    }

    public static String getUsers(ArrayList<Pair<Integer, String>> users, int userValue){
        for (Pair<Integer, String> user: users){
            if (user.getLeft() == userValue){
                return user.getRight();
            }
        }
        return null;
    }
    public static boolean getUsers(HashSet<Integer> userAvailableSet , int userValue){
        return userAvailableSet.contains(userValue);
    }

    public static void main(String[] args) {
        SortedLoginDetails.getSortedLoginDetails();
    }

}
