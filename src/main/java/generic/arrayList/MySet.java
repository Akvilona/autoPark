package generic.arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MySet {
    public static void main(String[] args) {
        //1) проверяется hash code, если hash code равен,
        //2) проверяется equals
        //3) если equals == true => то такой объект в коллекции

//        Set<User> userSet = new HashSet<>();
//
//        User user = new User(1, "1");
//        System.out.println(user.hashCode());
//
//        userSet.add(new User(2, "asd"));
//        userSet.add(new User(3, "ssss"));
//        userSet.add(new User(4, "dsa"));
//        userSet.add(new User(5, "fff"));
//
//        user.setName("2");
//
//        //С осторожностью менять значимые поля
//        System.out.println(userSet.contains(user));
//
//        userSet.forEach(user1 -> System.out.println(user1));
//
//        for (User u: userSet) {
//            System.out.println(u);
//        }






        User user1 = new User(1, "2");
        User user2 = new User(2, "2");
        Map<Integer, User> integerUserMap = new HashMap<>();
        integerUserMap.put(1, user1);
        integerUserMap.put(2, user1);

        Set<Integer> integers = integerUserMap.keySet();
        Collection<User> values = integerUserMap.values();

        for (Map.Entry<Integer, User> entry: integerUserMap.entrySet()) {
            Integer key = entry.getKey();
            User value = entry.getValue();

            System.out.println("key: " + key);
            System.out.println("value: " + value);
        }

        Map<String, List<User>> stringListMap = new HashMap<>();

        stringListMap.put("11b", new ArrayList<>());

        List<User> b11b = stringListMap.get("11b");
        b11b.add(new User(1, "1"));
        b11b.add(new User(2, "2"));
        b11b.add(new User(3, "3"));

        stringListMap.put("10a", new ArrayList<>());
        List<User> userList10a = stringListMap.get("10a");
        userList10a.add(new User(1, "4"));
        userList10a.add(new User(2, "5"));
        userList10a.add(new User(3, "6"));

        for (Map.Entry<String, List<User>> entry: stringListMap.entrySet()) {
            for (User u: entry.getValue()) {
                System.out.println(u);
            }
        }
    }
}
