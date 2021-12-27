package com.paypal.bfs.test.bookingserv.entity;

import com.paypal.bfs.test.bookingserv.dto.Address;
import com.paypal.bfs.test.bookingserv.transformer.AddressToStringConverter;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BookingEntity {

  @Id
  @GeneratedValue
  private Integer id;

  private String firstName;

  private String lastName;

  private Date dateOfBirth;

  private Date checkinDatetime;

  private Date checkoutDatetime;

  private Double totalPrice;

  private Double deposit;

  @Convert(converter = AddressToStringConverter.class)
  private Address address;

  @Type(type = "json")
  @Column(columnDefinition = "text")
  private Map<String, Object> additionalProperties = new HashMap<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    BookingEntity booking = (BookingEntity) o;
    return id != null && Objects.equals(id, booking.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
