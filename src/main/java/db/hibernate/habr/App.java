package db.hibernate.habr;

import db.hibernate.habr.entity.Comment;
import db.hibernate.habr.entity.Post;
import db.hibernate.habr.repository.CommentRepository;
import db.hibernate.habr.repository.PostRepository;
import net.datafaker.Faker;

import java.util.List;

public class App {
    public static void main(final String[] args) {

        PostRepository fPostRepository = new PostRepository();
        CommentRepository fCommentRepository = new CommentRepository();

        Faker faker = new Faker();

        Post fPost = Post.builder()
                .name(faker.name().fullName())
                .createDate(faker.date().birthday().toLocalDateTime().toLocalDate())
                .build();

        Comment fComment = Comment.builder()
                .comment(faker.name().title())
                .createDate(faker.date().birthday().toLocalDateTime().toLocalDate())
                .post(fPost)
                .build();

        fCommentRepository.save(fComment);

        List<Post> all = fPostRepository.findAll();
        System.out.println(all);

        fCommentRepository.delete(1L);

        List<Post> all1 = fPostRepository.findAll();
        System.out.println(all1);
    }
}
