package Stripe;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Map;

public class ShippingCost {

    Map<String, Object> order = Map.of(
            "country", "US",
            "items", List.of(
                    Map.of("product", "mouse", "quantity", 5),
                    Map.of("product", "laptop", "quantity", 2)
            )
    );

    Map<String, List<Map<String, Object>>> shipping1 = Map.of(
            "US", List.of(
                    Map.of("product", "mouse", "cost", 500),
                    Map.of("product", "laptop", "cost", 1000)
            ),
            "CA", List.of(
                    Map.of("product", "mouse", "cost", 700),
                    Map.of("product", "laptop", "cost", 1200)
            )
    );

    Map<String, List<Map<String, Object>>> shipping2 = Map.of(
            "US", List.of(
                    Map.of("product", "mouse", "cost", List.of(
                            Map.of("minQuantity", 0, "maxQuantity", 2, "cost", 200),
                            Map.of("minQuantity", 3, "maxQuantity", -1, "cost", 700)
                    )),
                    Map.of("product", "laptop", "cost", List.of(
                            Map.of("minQuantity", 0, "maxQuantity", -1, "cost", 700)
                    ))
            ),
            "CA", List.of(
                    Map.of("product", "mouse", "cost", 500),
                    Map.of("product", "laptop", "cost", 1000)
            )
    );

    public ShippingCost() {

        String country = order.get("country").toString();
        List<Map<String, Object>> items = (List<Map<String, Object>>) order.get("items");

        //getFirstShipping(country, items);
        getSecondShipping(country, items);

    }

    public void getFirstShipping(String country, List<Map<String, Object>> items){
        int finalCost = 0;


        System.out.println("Country: " + country);

        for (Map<String, Object> item : items) {
            String product = (String) item.get("product");
            int quantity = (int) item.get("quantity");

            finalCost += getFirstShippingCost(country, product) * quantity;
            System.out.println("Product: " + getFirstShippingCost(country, product) + " Cost: " + quantity);

        }
        System.out.println("Final Cost: " + finalCost);
    }

    public int getFirstShippingCost(String country, String product) {

         List<Map<String, Object>> result =  shipping1.get(country);

         for (Map<String, Object> item : result) {
             if (item.get("product").equals(product)) {
                return (int)item.get("cost");
             }

         }

         return -1;
    }


    public void getSecondShipping(String country, List<Map<String, Object>> orders ) {

        int costItem;
        int totalCost = 0;

        for (Map<String, Object> order : orders) {
            costItem = 0;
            int quantity = (Integer) order.get("quantity");
            String product = (String) order.get("product");

            for (Map<String, Object> val : getSecondShippingCost(country, product)) {

                int maxQuantity = (Integer) val.get("maxQuantity");

                if (maxQuantity == -1) {
                    costItem += (int) val.get("cost") * quantity;
                }
                else {
                    costItem += (int) val.get("cost") * (maxQuantity+1);
                    quantity = quantity - (maxQuantity+1);
                }
            }
            System.out.println("Cost for item " + product + " is " + costItem);
            totalCost += costItem;
        }

        System.out.println("Total cost: " + totalCost);

    }


    public List<Map<String, Object>> getSecondShippingCost(String country, String product) {

        List<Map<String, Object>> result =  shipping2.get(country);

        for (Map<String, Object> item : result) {
            if (item.get("product").equals(product)) {
                return (List<Map<String, Object>>) item.get("cost");
            }

        }
        return null;
    }



    public static void main(String[] args) {
        ShippingCost shippingCost = new ShippingCost();
    }
}
