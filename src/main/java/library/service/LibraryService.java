/**
 * Создал Андрей Антонов 05.09.2023 7:28
 **/
package library.service;

import library.model.User;
import library.repository.BookRepository;
import library.repository.UserRepository;

public class LibraryService {

    private final BookService bookService;
    private final UserService userService;

    public LibraryService(final BookService bookService, final UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }


    public void bookIssue (Long userId, Long bookId) {
        // 1 - проверить что пользователь существует
        // 2 - проверить что книга существует
        // получить книгу по Id
        // 3 - привязать книгу к пользователю
        // 4 - удалить книгу из библиотеки

        if (userService.findById(userId).getId().equals(userId) &&
            bookService.findById(bookId).getId().equals(bookId)) {

        }
        else{
            // если пользователь не найден создать исключение
        }
    }
}
