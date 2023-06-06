package th.go.md.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.go.md.payment.model.Order;
import th.go.md.payment.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  private OrderRepository orderRepository;

  @GetMapping(value = "", produces="application/json")
  public List<Order> getAllOrders() {
    return orderRepository.findAlll();
  }

  @GetMapping(value = "/{orderId}", produces="application/json")
  public List<Order> getOrderByOrderId(String orderId) {
    return orderRepository.findByOrderId(orderId);
  }

  @PostMapping("/create_test")
  public void createOrderTest() {
    orderRepository.createOrderTest();
  }
}
