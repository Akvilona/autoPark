/**
 * Создал Андрей Антонов 08.09.2023 15:15
 **/
package library.repository;

import library.model.CommentUser;
import nio.dz.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentUserRepository implements CrudRepository<CommentUser, Long> {

    private final List<CommentUser> commentUsers = new ArrayList<>();

    @Override
    public Optional<CommentUser> findById(final Long id) {
        for (CommentUser commentUser : commentUsers) {
            if (commentUser.getId().equals(id)) {
                return Optional.of(commentUser);
            }
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return "CommentUserRepository{"
                + "commentUsers=" + commentUsers
                + '}';
    }

    @Override
    public void save(final CommentUser commentUser) {
        commentUsers.add(commentUser);
    }

    @Override
    public void delete(final Long id) {
        commentUsers.removeIf(commentUser -> commentUser.getId().equals(id));
    }

    @Override
    public List<CommentUser> findAll() {
        return commentUsers;
    }
}
