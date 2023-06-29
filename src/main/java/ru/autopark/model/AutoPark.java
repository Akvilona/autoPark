/**
 * ������ ������ ������� 29.06.2023 6:51
 **/
package ru.autopark.model;

public class AutoPark {
    private Long id;
    private String name;

    public AutoPark(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AutoPark() {
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

    @Override
    public String toString() {
        return "AutoPark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
