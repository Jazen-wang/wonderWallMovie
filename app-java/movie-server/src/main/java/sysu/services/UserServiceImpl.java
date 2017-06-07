package sysu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.eneties.OrderForm;
import sysu.persistence.models.Seat;
import sysu.persistence.models.User;
import sysu.persistence.models.UserOrder;
import sysu.persistence.repositories.OrderRepository;
import sysu.persistence.repositories.SeatRepository;
import sysu.persistence.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Shower on 2017/6/3 0003.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userRepository.findUserByUsername(name);
    }

    @Override
    public Optional<User> getUserByNameAndPassword(String name, String password) {
        return userRepository.findUserByUsernameAndPassword(name, password);
    }

    @Override
    public boolean isUsernamePresent(String name) {
        return userRepository.findUserByUsername(name).isPresent();
    }

    @Override
    public UserOrder generateOrder(long userId, OrderForm orderForm) {
        List<Seat> updated = orderForm.getSeats().stream()
                .map(seat -> {
                    Seat old = seatRepository.findById(seat.getId());
                    old.setSold(true);
                    return old;
                })
                .collect(Collectors.toList());
        seatRepository.save(updated);
        User u = userRepository.findUserById(userId).get();
        UserOrder order = new UserOrder(u,
                orderForm.getOrderDate(),
                orderForm.getTicketPrice(),
                orderForm.getSeats().size(),
                updated);
        order = orderRepository.save(order);
        return order;
    }
}
