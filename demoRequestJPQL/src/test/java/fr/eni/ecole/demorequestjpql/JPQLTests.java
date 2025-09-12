package fr.eni.ecole.demorequestjpql;

import fr.eni.ecole.demorequestjpql.entity.Article;
import fr.eni.ecole.demorequestjpql.repository.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class JPQLTests {
    @Autowired
    private ArticleRepository articleRepository;

    @BeforeEach
    public void setup() {
        List<Article> articles = List.of(
                Article.builder()
                        .nom("Iphone 16")
                        .prix(1200)
                        .description("lablabla")
                        .reference("fksjdhfksh")
                        .build()
                ,
                Article.builder()
                        .nom("Samsung Galaxy 50")
                        .prix(900)
                        .description("blabalb")
                        .reference("sdfsdf")
                        .build()
                ,
                Article.builder()
                        .nom("PC Dell")
                        .prix(800)
                        .description("blabgdfgalb")
                        .reference("fdgfd")
                        .build()
                ,
                Article.builder()
                        .nom("Ecran HP")
                        .prix(120)
                        .description("5sdf5sd4f")
                        .reference("65d4f6s5d4f")
                        .build()
                ,
                Article.builder()
                        .nom("PlayStation 5")
                        .prix(450)
                        .description("sdfsdfs")
                        .reference("sdf")
                        .build()
                ,
                Article.builder()
                        .nom("Xbox Series X")
                        .prix(600)
                        .description("sdfsdfs")
                        .reference("sdf")
                        .build()
        );

        articleRepository.saveAll(articles);
    }

    @AfterEach
    public void teardown() {
        articleRepository.deleteAll();
    }

    @Test
    void findByNameTest(){
        String nomProduit = "Iphone 16";
        Article article = articleRepository.findByName(nomProduit);
        Assertions.assertNotNull(article);
        Assertions.assertEquals(nomProduit, article.getNom());
        System.out.println(article);
    }

    @Test
    void findByNameSoftTest(){
        String keyword = "Iphone";
        String expectedNomProduit = "Iphone 16";
        List<Article> articles = articleRepository.findBySoftName(keyword);
        Assertions.assertNotNull(articles);
        Assertions.assertEquals(1, articles.size());
        Assertions.assertEquals(expectedNomProduit, articles.get(0).getNom());
        System.out.println(articles);
    }

    @Test
    void findGreaterThanCurrentPriceTest(){
        float prix = 600;
        List<Article> articles = articleRepository.findGreaterThanCurrentPrice(prix);

        Assertions.assertNotNull(articles);
        Assertions.assertEquals(3, articles.size());
        articles.forEach( a->{
            assertThat(a.getPrix()).isGreaterThan(prix);
        });

        System.out.println(articles);
    }
}
