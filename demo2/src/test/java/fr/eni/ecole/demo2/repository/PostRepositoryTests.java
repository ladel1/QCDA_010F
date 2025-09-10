package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Comment;
import fr.eni.ecole.demo2.entity.Post;
import fr.eni.ecole.demo2.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class PostRepositoryTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void ajouterPostTest()
    {
        log.info("***********AjouterPostTest**********");
        Post post = Post.builder()
                .content("Formation Nextjs 15")
                .build();

        User user = User.builder()
                .username("Sarah")
                .build();

        user.getPosts().add(post);

        userRepository.save(user);

        log.info(userRepository.findByUsername("Sarah").toString());

    }

    @Test
    @Transactional
    void ajouterPostAvecCommentTest()
    {
        // save post
        Post post = Post.builder()
                .content("Github/GitLab ablbalaabla")
                .build();

        User user = User.builder()
                .username("Hugo")
                .build();

        user.getPosts().add(post);

        userRepository.save(user);
        System.out.println("post: "+post);
        Assertions.assertNotNull(post.getId());

        // add comment
        Comment comment = Comment.builder()
                .content("Bonne formation wowo blabalblab")
                .createdAt(Instant.now())
                .build();
        comment.setPost(post);
        commentRepository.save(comment);
        Assertions.assertNotNull(comment.getId());
        System.out.println("comment: "+comment);
    }

}
