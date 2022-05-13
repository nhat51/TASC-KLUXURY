package com.example.kluxury.service.order;

import com.example.kluxury.entity.*;
import com.example.kluxury.entity.dto.OrderDetailDto;
import com.example.kluxury.entity.dto.OrderDto;
import com.example.kluxury.repo.*;
import com.example.kluxury.response.MyPage;
import com.example.kluxury.specification.OrderSpecification;
import com.example.kluxury.specification.SearchCriteria;
import com.example.kluxury.utils.OrderFilter;
import com.example.kluxury.utils.SQLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

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
        Order order = orderRepository.getCart(userId);
        return order;
    }

    @Override
    public Order addToCart(int userId, OrderDetailDto orderDetailDto) {
        /*Tìm sản phầm theo id truyền vào*/
        Optional<Product> product = productRepository.findById(orderDetailDto.getProduct_id());
        OrderDetail orderDetail = new OrderDetail();
        /*Nếu có thì set tên và id của sản phẩm trong orderDetail*/
        if (product.isPresent()) {
            OrderDetailId key = new OrderDetailId();
            key.setProduct_id(product.get().getId());
            orderDetail.setId(key);

            orderDetail.setProduct(product.get());
            orderDetail.setProduct_name(product.get().getName());
            orderDetail.setUnit_price(product.get().getPrice());
            orderDetail.setProduct_thumbnail(product.get().getImages());
        }
        //set số lượng và giá của sản phầm tại thời điểm bán
        orderDetail.setAmount(orderDetailDto.getAmount());
        // Tìm trong db xem ng dùng đã có cart hay chưa
        Order exist = orderRepository.getCart(userId);
        //trường hợp người dùng đã có cart trong db r
        if (exist != null){
            Set<OrderDetail> listOrderDetail = exist.getOrderDetails();
            if (listOrderDetail.size() == 0 ){
                listOrderDetail.add(orderDetail);
                orderDetail.setOrder(exist);
                exist.setTotalMoney();
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
        newOrder.setUser_id(cartOwner.getId());
        Order orderSaved = orderRepository.save(newOrder);
        orderDetail.setOrder(orderSaved);
        Set<OrderDetail> orderDetails = new HashSet<>();
        orderDetails.add(orderDetail);
        orderSaved.setOrderDetails(orderDetails);
        orderSaved.setTotalMoney();
        return orderRepository.save(orderSaved);
    }

    @Override
    public Order controlValue(int userId, OrderDetailDto orderDetailDto) {
        System.out.println(orderDetailDto.toString());
        Optional<Product> product = productRepository.findById(orderDetailDto.getProduct_id());
        Order cart = orderRepository.getCart(userId);
        if (product.isPresent() && orderDetailDto.getIs_increase() == 1){
            OrderDetailId key = new OrderDetailId();
            key.setOrder_id(cart.getId());
            key.setProduct_id(product.get().getId());

            OrderDetail orderDetail = orderDetailRepository.getById(key);
            orderDetail.setAmount(orderDetail.getAmount() + 1);
            cart.setTotalMoney();
        }
        if (product.isPresent() && orderDetailDto.getIs_increase() == 0){
            OrderDetailId key = new OrderDetailId();
            key.setOrder_id(cart.getId());
            key.setProduct_id(product.get().getId());

            OrderDetail orderDetail = orderDetailRepository.getById(key);
            orderDetail.setAmount(orderDetail.getAmount() - 1);
            cart.setTotalMoney();
        }

        return orderRepository.save(cart);
    }

    @Override
    public Order updateCart(int userId, Set<OrderDetailDto> orderDetailDtos) {
        Order cart = orderRepository.getCart(userId);
        Set<OrderDetail> listOrderDetail = cart.getOrderDetails();
        for (OrderDetailDto odDto: orderDetailDtos) {
            for (OrderDetail od: listOrderDetail ) {
                if (odDto.getProduct_id() == od.getProduct().getId()){
                    od.setAmount(odDto.getAmount());
                }
            }
        }
//        cart.setOrderDetails(listOrderDetail);
        cart.setTotalMoney();
        return orderRepository.save(cart);
    }

    @Override
    public Order removeItem(int userId, int productId) {
        Order cart = orderRepository.getCart(userId);
        OrderDetailId key = new OrderDetailId();
        key.setOrder_id(cart.getId());
        key.setProduct_id(productId);
        OrderDetail orderDetail = orderDetailRepository.getById(key);
        cart.removeOderDetailFromOrder(orderDetail);
        orderDetailRepository.delete(orderDetail);

        System.out.println(orderDetail.getProduct().getName());
        cart.setTotalMoney();
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
    public MyPage getAll(OrderFilter filter) {
        Specification<Order> spec = Specification.where(null);
        PageRequest pageRequest = PageRequest.of(filter.getPage() - 1, filter.getPageSize());

        if (filter.getProvince_id() > 0) {
            spec = spec.and(new OrderSpecification(new SearchCriteria(OrderFilter.PROVINCE_ID, SQLConstant.EQUAL, filter.getProvince_id())));
        }
        if (filter.getDistrict_id() > 0) {
            spec = spec.and(new OrderSpecification(new SearchCriteria(OrderFilter.DISTRICT_ID, SQLConstant.EQUAL, filter.getDistrict_id())));
        }
        if (filter.getWard_id() > 0) {
            spec = spec.and(new OrderSpecification(new SearchCriteria(OrderFilter.WARD_ID, SQLConstant.EQUAL, filter.getWard_id())));
        }
        if (filter.getCreated_at() != null) {
            spec = spec.and(new OrderSpecification(new SearchCriteria(OrderFilter.CREATED_AT, SQLConstant.EQUAL, filter.getCreated_at())));
        }

        Page<Order> page = orderRepository.findAll(spec, pageRequest);
        MyPage mypage = new MyPage();
        mypage.setContent(page.getContent());
        mypage.setPageSize(page.getSize());
        mypage.setTotalPage(page.getTotalPages());
        mypage.setPage(page.getNumber() + 1);
        return mypage;
    }

    @Override
    public List<Order> getByUserId() {
        return null;
    }
}
