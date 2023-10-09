/**
 * Создал Андрей Антонов 08.10.2023 18:06
 **/
package hibernate.habr;

import hibernate.habr.entity.FComment;
import hibernate.habr.entity.FPost;
import hibernate.habr.repository.FCommentRepository;
import hibernate.habr.repository.FPostRepository;
import hibernate.habr.utils.FComponentFactory;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.List;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class app {
    // todo: реализовать модель постов и комментариев

    public static void main(String[] args) {

        FPostRepository fPostRepository = FComponentFactory.fCreateRepository(FPostRepository.class);
        FCommentRepository fCommentRepository = FComponentFactory.fCreateRepository(FCommentRepository.class);

        Faker faker = new Faker();

        FPost fPost = FPost.builder()
                .name(faker.name().fullName())
                .dateCreate(faker.date().birthday().toLocalDateTime().toLocalDate())
                .build();

        FComment fComment = FComment.builder()
                .comment(faker.name().title())
                .dateCreate(faker.date().birthday().toLocalDateTime().toLocalDate())
                .FPost(fPost)
                .build();

        fCommentRepository.save(fComment);


        List<FPost> all = fPostRepository.findAll();
        System.out.println(all);

        fCommentRepository.delete(1L);

        List<FPost> all1 = fPostRepository.findAll();
        System.out.println(all1);

    }
}
