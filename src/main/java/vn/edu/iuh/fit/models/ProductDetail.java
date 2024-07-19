package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import javax.sound.midi.Soundbank;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @Column(name = "product_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    @Column(nullable = false)
    private int size;
    @Column(name = "product_price", columnDefinition = "float", nullable = false)
    private double price;
    @Column(name = "product_quantity", nullable = false)
    private int quantity;
    @Column(name = "image_url", nullable = false)
    private String image;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToMany(mappedBy = "productDetail")
    private Set<OrderDetail> orderDetails;
}
