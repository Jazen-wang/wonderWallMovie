package sysu.eneties;

import sysu.persistence.models.Seat;
import sysu.persistence.models.User;
import sysu.persistence.models.UserOrder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Shower on 2017/6/7 0007.
 */
public class OrderDTO extends UserOrder {
    public OrderDTO(User user,
                    LocalDateTime orderDate,
                    int ticketPrice,
                    int ticketCount,
                    List<Seat> seats) {
        super(user, orderDate, ticketPrice, ticketCount, seats);
    }
}
