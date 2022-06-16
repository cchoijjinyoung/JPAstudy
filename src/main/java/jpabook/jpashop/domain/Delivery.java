package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import jpabook.jpashop.domain.Address;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY) // 일대일 맵핑 - FK를 어디에 두던 상관없다. - 주로 액세스를 많이 하는 곳에 둔다.(여기서는 order에 두는 것을 선호)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMP
    //EnumType.ORDINAL는 숫자로 들어가는데(예시 : 1, 2, 3, ..)
    //READY와 COMP사이에 하나가 추가되면 COMP숫자가 하나 밀려버린다.
    //웬만하면 STRING으로 사용하기.

}
