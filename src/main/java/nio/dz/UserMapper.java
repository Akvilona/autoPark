package nio.dz;

import nio.User;

import java.math.BigDecimal;
import java.util.List;

public class UserMapper {
    private static final String POLE_SEPARATOR = ";";
    public static User getUser(final String line) {
        String[] cols = line.split(POLE_SEPARATOR);
        return User.builder()
                .id(Integer.parseInt(cols[0]))
                .name(cols[1])
                .age(Integer.parseInt(cols[2]))
                .salary(new BigDecimal(cols[3]))
                .build();
    }

    public static String formatUserLine(final User user) {
        return user.getId() + POLE_SEPARATOR + user.getName() + POLE_SEPARATOR
                + user.getAge() + POLE_SEPARATOR + user.getSalary().doubleValue() + System.lineSeparator();
    }

    public static String formatUserLine(final List<User> userList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User u : userList) {
            stringBuilder.append(formatUserLine(u));
        }
        return stringBuilder.toString();
    }
}
