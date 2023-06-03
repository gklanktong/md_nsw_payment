package th.go.md.payment.repository;

import java.util.List;
import th.go.md.payment.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, String> {

  @Query(value = "SELECT * FROM orders WHERE order_id = ?1", nativeQuery = true)
  List<Order> findByOrderId(String order_id);

  @Query(value = "SELECT * FROM orders", nativeQuery = true)
  List<Order> findAlll();

  String sql03 = "insert into orders(order_id,order_datetime,order_datetime_utx) values "
  + "(uuid(),now(),unix_timestamp())";
  @Modifying
  @Transactional
  @Query(value = sql03, nativeQuery = true)
  void createOrderTest();

}
