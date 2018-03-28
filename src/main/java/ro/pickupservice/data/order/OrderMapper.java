package ro.pickupservice.data.order;

import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.controllers.order.bean.response.OrderSummary;
import ro.pickupservice.data.order.entity.Order;
import ro.pickupservice.data.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static OrderDto mapOrderToOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setTitle(order.getTitle());
        orderDto.setDropOffLocation(order.getDropOffLocation());
        orderDto.setDropOffAddress(order.getDropOffAddress());
        orderDto.setDropOffDate(order.getDropOffDate());
        orderDto.setFragile(order.getFragile());
        orderDto.setDimensions(order.getDimensions());
        orderDto.setWeight(order.getWeight());
        orderDto.setId(order.getId());
        orderDto.setPickUpDate(order.getPickUpDate());
        orderDto.setPickUpAddress(order.getPickUpAddress());
        orderDto.setPickUpLocation(order.getPickUpLocation());
        return orderDto;
    }

    public static Order mapOrderRequestToOrder(CreateOrderRequest request, User user) {
        Order order = new Order();
        order.setUser(user);
        order.setTitle(request.getTitle());
        order.setDropOffLocation(request.getDropOffLocation());
        order.setDropOffAddress(request.getDropOffAddress());
        order.setDropOffDate(request.getDropOffDate());
        order.setFragile(request.getFragile());
        order.setPickUpDate(request.getPickUpDate());
        order.setPickUpAddress(request.getPickUpAddress());
        order.setPickUpLocation(request.getPickUpLocation());
        order.setDimensions(request.getDimensions());
        order.setWeight(request.getWeight());
        return order;
    }

    public static OrderSummary mapOrderToOrderSummary(Order order){
        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setId(order.getId());
        orderSummary.setTitle(order.getTitle());
        orderSummary.setLocation(order.getPickUpLocation());
        return orderSummary;
    }

    public static List<OrderSummary> mapOrdersToOrderSummaryList(List<Order> orders) {
        List<OrderSummary> orderSummaries = new ArrayList<>();
        for(Order o: orders) {
            orderSummaries.add(mapOrderToOrderSummary(o));
        }
        return orderSummaries;
    }

    public static List<OrderDto> mapOrdersToOrderDtoList(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order o: orders){
            orderDtos.add(mapOrderToOrderDto(o));
        }
        return orderDtos;
    }
}
