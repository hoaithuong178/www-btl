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
@Table(name = "shipping_address")
public class ShippingAddress {
    @Id
    @Column(name = "shipping_address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_receiver", nullable = false)
    private String name;
    private String phone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "shippingAddress")
    private Set<Order> orders;

}
