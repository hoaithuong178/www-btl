package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_date", columnDefinition = "datetime", nullable = false)
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private PayMethod payMethod;
    @Column(columnDefinition = "float", nullable = false)
    private Double total;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddress shippingAddress;

}
