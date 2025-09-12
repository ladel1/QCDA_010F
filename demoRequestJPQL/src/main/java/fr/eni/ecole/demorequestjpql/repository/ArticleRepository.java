package fr.eni.ecole.demorequestjpql.repository;

import fr.eni.ecole.demorequestjpql.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>
{
    @Query("SELECT a FROM Article a WHERE a.nom = :name")
    Article findByName(@Param("name") String name);

    @Query("SELECT a FROM Article a WHERE a.prix > :price")
    List<Article> findGreaterThanCurrentPrice(@Param("price") float price);

    @Query(value = "SELECT a.* FROM articles a WHERE a.nom LIKE %:name%",nativeQuery = true)
    List<Article> findBySoftName(@Param("name") String name);
}
