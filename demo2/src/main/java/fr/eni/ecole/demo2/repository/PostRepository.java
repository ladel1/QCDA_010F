package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>
{
}
