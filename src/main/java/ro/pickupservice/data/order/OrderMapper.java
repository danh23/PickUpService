package ro.pickupservice.data.order;

import ro.pickupservice.controllers.order.bean.response.OrderDto;
import ro.pickupservice.data.order.entity.Order;

public class OrderMapper {

    public static OrderDto mapOrderToOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setDropOffLatitude(order.getDropOffLatitude());
        orderDto.setDropOffLongitude(order.getdropOffLongitude());
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
}
