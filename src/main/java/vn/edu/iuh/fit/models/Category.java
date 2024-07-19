package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category_name", nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "text", name = "category_desc")
    private String desc;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
