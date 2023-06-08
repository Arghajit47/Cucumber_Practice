package AmazonImplimentation;

import java.util.ArrayList;
import java.util.List;

    public class Product {
        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public List<String> getProductList() {
            List<String> productList = new ArrayList<>();
            productList.add("Apple MacBook Pro");
            productList.add("Apple MacBook Air");
            productList.add("iPhone 13 pro max");
            return productList;
        }

    }
