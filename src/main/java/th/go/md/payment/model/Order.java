package th.go.md.payment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "order_id")
  private String order_id;

  @Column(name = "order_datetime")
  private String order_datetime;

  @Column(name = "order_datetime_utx")
  private Integer order_datetime_utx;

  public String getId() {
    return order_id;
  }
  public String getDatetime() {
    return order_datetime;
  }
  public Integer getDatetimeUtx() {
    return order_datetime_utx;
  }
  public void setId(String order_id) {
    this.order_id = order_id;
  }
  public void setDate(String order_datetime) {
    this.order_datetime = order_datetime;
  }
  public void setDateUnixtimestamp(Integer order_datetime_utx) {
    this.order_datetime_utx = order_datetime_utx;
  }
}