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
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String district;
    private String ward;
    private String address;
    @OneToOne(mappedBy = "address")
    private ShippingAddress shippingAddress;
}

