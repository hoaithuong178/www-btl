package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @Column(name = "image_url")
    private String url;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
