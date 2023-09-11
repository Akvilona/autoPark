/**
 * Создал Андрей Антонов 08.09.2023 16:06
 **/
package library.service;

import library.exception.ErrorCode;
import library.exception.ServiceException;
import library.model.BookUser;
import library.model.CommentUser;
import library.repository.CommentUserRepository;

public class CommentUserService {
    private String commentUser;
    private final UserService userService;
    private final LibraryService libraryService;
    private final CommentUserRepository commentUserRepository;



    public CommentUserService(final String commentUser, final UserService userService, final LibraryService libraryService, final CommentUserRepository commentUserRepository) {
        this.commentUser = commentUser;
        this.userService = userService;
        this.libraryService = libraryService;
        this.commentUserRepository = commentUserRepository;
    }

    public CommentUser commentUserAdd(final Long userId, final Long bookUserId, final String commentUser) {
        if (!userService.exist(userId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_02, userId);
        }
        if (!libraryService.returnBook(bookUserId).getBookId().equals(bookUserId)) {
            throw new ServiceException(ErrorCode.ERR_CODE_04, bookUserId);
        }

        BookUser bookUser = libraryService.returnBook(bookUserId);
        CommentUser commentUser1 = new CommentUser(bookUser.getId(), commentUser);
        commentUserRepository.save(commentUser1);
        return  commentUser1;
    }
}
