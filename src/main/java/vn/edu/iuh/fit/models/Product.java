package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(nullable = false)
    private String thumnail;
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> images;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
//    @OneToMany(mappedBy = "product")
//    private Set<ProductDetail> productDetails;

}
