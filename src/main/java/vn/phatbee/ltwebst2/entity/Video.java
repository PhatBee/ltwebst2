package vn.phatbee.ltwebst2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v from Video v")
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "videoid")
    private int videoid;

    @Column(name = "active")
    private int active;

    @Column(name = "description", columnDefinition = "nvarchar(500) null")
    private String description;

    @Column(name = "poster", columnDefinition = "nvarchar(500) null")
    private String poster;

    @Column(name = "title", columnDefinition = "nvarchar(255) null")
    @NotEmpty(message = "Không được để trống")
    private String title;

    @Column(name = "views")
    private int views;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

}
