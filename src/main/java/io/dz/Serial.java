/**
 * Создал Андрей Антонов 09.08.2023 17:43
 **/
package io.dz;

import io.User;

import java.io.*;

public class Serial {

    public boolean serIn(User user) throws IOException {

        boolean flag = false;

        FileOutputStream fos = new FileOutputStream("temp.out");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(user);

        oos.close();

        return flag;
    }
}
