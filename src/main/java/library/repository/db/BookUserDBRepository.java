package library.repository.db;

import library.model.BookUser;
import nio.dz.CrudRepository;

import java.util.List;
import java.util.Optional;

public class BookUserDBRepository implements CrudRepository<BookUser, Long> {

    @Override
    public Optional<BookUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public BookUser save(BookUser bookUser) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<BookUser> findAll() {
        return null;
    }
}
