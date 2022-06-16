package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Embedded
    private Address address;

    private String name;

    @OneToMany(mappedBy = "member") //나는 Order 클래스에 있는 member 필드에 의해서 맵핑된 거울일 뿐이야.
    private List<Order> orders = new ArrayList<>();
}
