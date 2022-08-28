package user.ishmaust.shophelper.servicies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.ishmaust.shophelper.repositories.dao.OrderRepository;
import user.ishmaust.shophelper.repositories.entity.Order;
import user.ishmaust.shophelper.servicies.interfacies.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order addEntity(Order entity) {
    return orderRepository.save(entity);
  }

  @Override
  public Optional<Order> findById(Long id) {
    return orderRepository.findById(id);
  }

  @Override
  public void removeEntity(Long id) {
    orderRepository.deleteById(id);
  }

  @Override
  public void removeEntity(Order entity) {
    orderRepository.delete(entity);
  }
}
