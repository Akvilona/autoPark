/**
 * Создал Андрей Антонов 29.08.2023 15:41
 **/
package library.service;

import library.model.UserBook;
import library.repository.UserBookRepository;

public class UserBookService {
    private final UserBookRepository userBookRepository;

    public UserBookService(final UserBookRepository userBookRepository) {
        this.userBookRepository = userBookRepository;
    }

    public void addUserBook(final UserBook userBook) {
        userBookRepository.addUserBook(userBook);
    }

    public void removeUserBook(final UserBook userBook) {
        userBookRepository.removeUserBook(userBook);
    }

}
