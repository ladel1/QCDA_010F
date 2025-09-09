package fr.eni.ecole.demo2.repository;

import fr.eni.ecole.demo2.entity.IdLike;
import fr.eni.ecole.demo2.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, IdLike>
{
}
