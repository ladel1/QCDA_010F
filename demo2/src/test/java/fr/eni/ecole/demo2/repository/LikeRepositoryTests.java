package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.IdLike;
import fr.eni.ecole.demo2.entity.Like;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;

@SpringBootTest
@ActiveProfiles("test")
public class LikeRepositoryTests {

    @Autowired
    private LikeRepository likeRepository;

    public void likeTest(){
        // Arrange
        long post = 1L;
        long user = 5L;
        IdLike id = IdLike.builder().post(post).user(user).build();
        Like like = Like.builder().post(post).user(user).createdAt(Instant.now()).build();
        likeRepository.save(like);
        // chercher le like
        Like savedLike = likeRepository.findById(id).get();
        // Assert
        Assertions.assertNotNull(savedLike);
    }
}
