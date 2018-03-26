package ro.pickupservice.data.order;

import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.data.order.entity.Order;
import ro.pickupservice.data.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static OrderDto mapOrderToOrderDto(ro.pickupservice.data.order.entity.Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setDropOffLatitude(order.getDropOffLatitude());
        orderDto.setDropOffLongitude(order.getDropOffLongitude());
        orderDto.setDropOffLocation(order.getDropOffLocation());
        orderDto.setDropOffDate(order.getDropOffDate());
        orderDto.setFragile(order.getFragile());
        orderDto.setHeight(order.getHeight());
        orderDto.setId(order.getId());
        orderDto.setLength(order.getLength());
        orderDto.setPickUpDate(order.getPickUpDate());
        orderDto.setPickUpLatitude(order.getPickUpLatitude());
        orderDto.setPickUpLocation(order.getPickUpLocation());
        orderDto.setPickUpLongitude(order.getPickUpLongitude());
        orderDto.setWidth(order.getWidth());
        return orderDto;
    }

    public static Order mapOrderRequestToOrder(CreateOrderRequest request, User user) {
        Order order = new Order();
        order.setUser(user);
        order.setDropOffLatitude(request.getDropOffLatitude());
        order.setDropOffLongitude(request.getDropOffLongitude());
        order.setDropOffLocation(request.getDropOffLocation());
        order.setDropOffDate(request.getDropOffDate());
        order.setFragile(request.getFragile());
        order.setHeight(request.getHeight());
        order.setLength(request.getLength());
        order.setPickUpDate(request.getPickUpDate());
        order.setPickUpLatitude(request.getPickUpLatitude());
        order.setPickUpLocation(request.getPickUpLocation());
        order.setPickUpLongitude(request.getPickUpLongitude());
        order.setWidth(request.getWidth());
        return order;
    }

    public static List<OrderDto> mapOrdersToOrdersDto(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order o: orders) {
            orderDtos.add(mapOrderToOrderDto(o));
        }
        return orderDtos;
    }

}
