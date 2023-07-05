/**
 * Создал Андрей Антонов 02.07.2023 19:41
 **/
package ru.autopark.repository;

public interface AutoParkRepository {
    long add(long id, String name);

    boolean deleteByName(String name);
}
