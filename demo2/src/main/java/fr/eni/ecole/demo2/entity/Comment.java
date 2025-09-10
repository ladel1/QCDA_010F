package fr.eni.ecole.demo2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"id","content"})
@Builder
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content",length = 500)
    private String content;

    @Column(name="created_at")
    private Instant createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="post_id", nullable = false)
    @ToString.Exclude
    private Post post;

    public void setPost(Post post){
        this.post = post;
        if(post!=null && !post.getComments().contains(this)){
            post.addComment(this);
        }
    }
}
