package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long>
{
}
