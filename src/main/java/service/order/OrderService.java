package service.order;

import file_data_IO.FileIO;
import model.Order;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class OrderService implements IOrderService{
    private int lastId = 0;
    private final String ORDER_DATA_PATH = "order_data.txt";
    private Map<String, Order> orderMap;
    FileIO<Map<String, Order>> fileIO = (FileIO<Map<String, Order>>) FileIO.getInstance();

    private static final OrderService instance = new OrderService();
    private OrderService() {
        orderMap = findAll();
        this.updateLastId();
    }

    public static OrderService getInstance() {
        return instance;
    }
    @Override
    public void updateData() {
        fileIO.writeFile(ORDER_DATA_PATH, orderMap);
    }

    @Override
    public Map<String, Order> findAll() {
        Map<String, Order> map = fileIO.readFile(ORDER_DATA_PATH);
        if (map == null){
            map = new HashMap<>();
        }
        return map;
    }

    @Override
    public Order add(Order order) {
        this.lastId++;
        order.setId(getLastId());
        orderMap.put(String.valueOf(getLastId()), order);
        orderMap.get("id").setId(this.lastId);
        updateData();
        return order;
    }

    @Override
    public void edit(Order order) {

    }

    @Override
    public Order delete(String id) {
        return null;
    }

    private void updateLastId() {
        if (this.orderMap.isEmpty()){
            this.orderMap.put("id", new Order(0,null, "id"));
            this.lastId = 0;
        }else {
            this.lastId = orderMap.get("id").getId();
        }
    }

    public void sendOrder(){
        for (Order order: orderMap.values()) {
            order.setStatus("order");
        }
    }

    public int getLastId() {
        return lastId;
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }
}
