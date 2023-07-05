package ru.autopark.model;

public class Customer {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Long autoParkId;

    public Customer(Long id, String name, String address, String phone, Long autoParkId) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAutoParkId() {
        return autoParkId;
    }

    public void setAutoParkId(Long autoParkId) {
        this.autoParkId = autoParkId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", autoParkId=" + autoParkId +
                '}';
    }
}

