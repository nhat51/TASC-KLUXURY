package com.example.kluxury.service.order;

import com.example.kluxury.entity.*;
import com.example.kluxury.entity.dto.OrderDetailDto;
import com.example.kluxury.entity.dto.OrderDto;
import com.example.kluxury.repo.*;
import com.example.kluxury.utils.OrderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    WardRepository wardRepository;

    @Override
    public Order getCart(int userId) {
        return orderRepository.getCart(userId);
    }

    @Override
    public Order addToCart(int userId, OrderDetailDto orderDetailDto) {
        //Tìm sản phầm theo id truyền vào
        Optional<Product> product = productRepository.findById(orderDetailDto.getProduct_id());
        OrderDetail orderDetail = new OrderDetail();
        //Nếu có thì set tên và id của sản phẩm trong orderDetail
        if (product.isPresent()) {
            OrderDetailId key = new OrderDetailId();
            key.setProduct_id(product.get().getId());
            orderDetail.setId(key);

            orderDetail.setProduct(product.get());
            orderDetail.setProduct_name(product.get().getName());
        }
        //set số lượng và giá của sản phầm tại thời điểm bán
        orderDetail.setAmount(orderDetailDto.getAmount());
        orderDetail.setUnit_price(orderDetailDto.getUnit_price());
        // Tìm trong db xem ng dùng đã có cart hay chưa
        Order exist = orderRepository.getCart(userId);
        //trường hợp người dùng đã có cart trong db r
        if (exist != null){
            Set<OrderDetail> listOrderDetail = exist.getOrderDetails();
            if (listOrderDetail.size() == 0 ){
                listOrderDetail.add(orderDetail);
                orderDetail.setOrder(exist);
                return orderRepository.save(exist);
            }
            for (OrderDetail od : listOrderDetail) {
                if (od.getProduct().getId() == orderDetailDto.getProduct_id()){
                    od.setAmount(od.getAmount() + 1);
                    exist.setTotalMoney();
                    return orderRepository.save(exist);
                }
            }
            orderDetail.setOrder(exist);
            orderDetail.setAmount(orderDetailDto.getAmount());
            listOrderDetail.add(orderDetail);
            exist.setOrderDetails(listOrderDetail);
            exist.setTotalMoney();
            return orderRepository.save(exist);
        }

        //trường hợp chưa có cart trong db
        Order newOrder = new Order();
        User cartOwner = userRepository.getById(userId);
        newOrder.set_shopping_cart(true);
        newOrder.setUser(cartOwner);
        Order orderSaved = orderRepository.save(newOrder);
        orderDetail.setOrder(orderSaved);
        Set<OrderDetail> orderDetails = new HashSet<>();
        orderDetails.add(orderDetail);
        orderSaved.setOrderDetails(orderDetails);
        return orderRepository.save(orderSaved);
    }

    @Override
    public Order updateCart(int userId, Set<OrderDetail> list) {
        Order cart = orderRepository.getCart(userId);
        if (list.size() == 0){
            return cart;
        }
        cart.setOrderDetails(list);
        return orderRepository.save(cart);
    }

    @Override
    public Order removeItem(int userId, int productId) {
        Order cart = orderRepository.getCart(userId);
        Set<OrderDetail> setItem = cart.getOrderDetails();
        setItem.removeIf(item -> productId == item.getProduct().getId());
        cart.setOrderDetails(setItem);
        return orderRepository.save(cart);
    }

    @Override
    public Order proceedOrder(int userID, OrderDto orderDto) {
        Order cart = orderRepository.getCart(userID);
        Province province = provinceRepository.getById(orderDto.getProvince_id());
        District district = districtRepository.getById(orderDto.getDistrict_id());
        Ward ward = wardRepository.getById(orderDto.getWard_id());

        cart.setCustomer_name(orderDto.getCustomer_name());
        cart.setProvince_id(orderDto.getProvince_id());
        cart.setShip_city(province.getName());
        cart.setDistrict_id(orderDto.getDistrict_id());
        cart.setShip_district(district.getName());
        cart.setWard_id(orderDto.getWard_id());
        cart.setShip_address(orderDto.getShip_address());
        cart.setShip_ward(ward.getName());
        cart.setShip_note(orderDto.getShip_note());
        cart.setShip_phone(orderDto.getPhone_number());

        cart.set_shopping_cart(false);
        /*
        * Order status
        * 1. PENDING
        * 2. SHIPPING
        * 3. COMPLETE
        * */
        cart.setStatus(1);

        return orderRepository.save(cart);
    }

    @Override
    public List<Order> getAll(OrderFilter filter) {

        return orderRepository.findAll();
    }

    @Override
    public List<Order> getByUserId() {
        return null;
    }
}
