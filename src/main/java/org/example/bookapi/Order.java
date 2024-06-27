package org.example.bookapi;
import jakarta.persistence.*;

import java.util.Set;

@Entity
    @Table(name = "orders")
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String orderDate;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        private Customer customer;

        @ManyToMany
        @JoinTable(
                name = "order_product",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id")
        )
        private Set<Product> products;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public Set<Product> getProducts() {
            return products;
        }

        public void setProducts(Set<Product> products) {
            this.products = products;
        }
    }
