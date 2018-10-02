package tacoLoco.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacoLoco.model.OrderedTaco;
import tacoLoco.model.Taco;
import tacoLoco.model.Total;

@RestController
public class TacoController {

    OrderedTaco orderedVeggieTaco = new OrderedTaco("Veggie Taco", 2.50);
    OrderedTaco orderedChickenTaco = new OrderedTaco("Chicken Taco", 3.00);
    OrderedTaco orderedBeefTaco = new OrderedTaco("Beef Taco", 3.00);
    OrderedTaco orderedChorizoTaco = new OrderedTaco("Chorizo Taco", 3.50);
    ArrayList<OrderedTaco> tacoList = new ArrayList<>(Arrays.asList(orderedVeggieTaco, orderedChickenTaco, orderedBeefTaco, orderedChorizoTaco));

    @RequestMapping("/tacos-menu")
    public ArrayList tacos() {

        return tacoList;
    }

    @RequestMapping(value = "/veggie-taco")
    public ResponseEntity<Taco> get() {

        Taco veggieTaco = new Taco("Veggie Taco", 2.50);

        return new ResponseEntity<>(veggieTaco, HttpStatus.OK);
    }

    @RequestMapping(value = "/order-veggie-taco", method = RequestMethod.POST)
    public ResponseEntity<OrderedTaco> update(@RequestBody OrderedTaco orderTaco) {

        return new ResponseEntity<>(orderTaco, HttpStatus.OK);
    }

    @RequestMapping(value = "/taco-order", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody ArrayList<OrderedTaco> orderedTaco) {
        ArrayList<Object> orderList = new ArrayList<>();
        Total total = new Total();

        for (OrderedTaco taco: orderedTaco
                ) {
            if (!taco.getName().equals("Veggie Taco") && !taco.getName().equals("Chicken Taco") &&
                    !taco.getName().equals("Beef Taco") && !taco.getName().equals("Chorizo Taco") ||
                     taco.getPrice() < 0 || taco.getOrdered() < 0
                    ){

                System.out.print(HttpStatus.BAD_REQUEST);
                System.out.print(taco.getName());
                return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
            }

            addTacosToOrder(total, orderList, taco);
        }

        generateOrderTotal(orderList, total);

        return new ResponseEntity<ArrayList>(orderList, HttpStatus.OK);
    }

    private void generateOrderTotal(ArrayList orderList, Total total) {
        if (total.getNumberOrdered() >= 4){
            BigDecimal pointEighty = new BigDecimal("0.80");
            BigDecimal calculateTotal = new BigDecimal(total.getTotal());
            total.setTotal(calculateTotal.multiply(pointEighty).doubleValue());
            total.setDiscount(true);
        }

        orderList.add(total);
    }

    //this method sums the number of tacos ordered and the price of each taco
    private void addTacosToOrder(Total total, ArrayList orderList, OrderedTaco taco) {
        taco.setOrdered(taco.getOrdered());
        total.setNumberOrdered(total.getNumberOrdered() + taco.getOrdered());
        total.setTotal(total.getTotal() + taco.getOrdered() * taco.getPrice());
        orderList.add(taco);
    }
}