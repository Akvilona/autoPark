/**
 * Создал Андрей Антонов 29.06.2023 7:09
 **/
package ru.autopark.model;

public class Customer {
    private Long id;
    private String name;

    private Long autoParkId;

    public Customer(Long id, String name, Long autoParkId) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", autoParkId=" + autoParkId +
                '}';
    }
}

