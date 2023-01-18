package chapter02.item01;

public class Order {

    private boolean prime;
    private boolean urgent;
    private Product product;
    private OrderStatus orderStatus;

    // 하나의 시그니처로 명확한 역할을 나타내는 생성자
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    // enum 동일성 비교는 == 권장
    public static void main(String[] args) {
        Order order = new Order();
        if (order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("delivered");
        }

        // equlas는 NullPointerException
        if(order.orderStatus.equals(OrderStatus.SHIPPED)) {
            System.out.println("shipped");
        }
    }

}
