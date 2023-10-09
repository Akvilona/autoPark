/**
 * Создал Андрей Антонов 08.10.2023 18:56
 **/
package hibernate.habr.utils;

import hibernate.habr.repository.FCommentRepository;
import hibernate.habr.repository.FPostRepository;

public class FComponentFactory {

    public static <T> T fCreateRepository(final Class<T> fClass) {
        if (fClass.equals(FPostRepository.class)) {
            return (T) new FPostRepository();
        } else if (fClass.equals(FCommentRepository.class)) {
            return (T) new FCommentRepository();
        }

        throw new IllegalArgumentException("Unknown repository type: " + fClass.getName());
    }
}
