package ro.pickupservice.data.order;

import ro.pickupservice.controllers.order.bean.request.CreateOrderRequest;
import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.data.order.entity.Order;

public class OrderMapper {

    public static OrderDto mapOrderToOrderDto(ro.pickupservice.data.order.entity.Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setDropOffLatitude(order.getDropOffLatitude());
        orderDto.setDropOffLongitude(order.getDropOffLongitude());
        orderDto.setDropOffLocation(order.getDropOffLocation());
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

    public static ro.pickupservice.data.order.entity.Order mapOrderRequestToOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setDropOffLatitude(request.getDropOffLatitude());
        order.setDropOffLongitude(request.getDropOffLongitude());
        order.setDropOffLocation(request.getDropOffLocation());
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
}
