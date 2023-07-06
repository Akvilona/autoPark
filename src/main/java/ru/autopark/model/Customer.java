package ru.autopark.model;

import java.util.Objects;

public class Customer {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Long autoParkId;

    public Customer(final Long id, final String name, final String address, final String phone, final Long autoParkId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.autoParkId = autoParkId;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getAutoParkId() {
        return autoParkId;
    }

    public void setAutoParkId(final Long autoParkId) {
        this.autoParkId = autoParkId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone);
    }

    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", na1me='" + name + '\''
                + ", address='" + address + '\''
                + ", phone='" + phone + '\''
                + ", autoParkId=" + autoParkId
                + '}';
    }
}

