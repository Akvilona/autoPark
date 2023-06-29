/**
 * Создал Андрей Антонов 29.06.2023 6:53
 **/
package ru.autopark.model;

import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;

public class Vehicle {
    private Long id;
    /* марка, модель, год выпуска, пробег*/
    private Brand brand;
    private Model model;
    private LocalDate releaseDate;
    private int mileage;
    private Long vehicleId;

    public Vehicle() {
    }

    public Vehicle(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage, Long vehicleId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.releaseDate = releaseDate;
        this.mileage = mileage;
        this.vehicleId = vehicleId;
    }

    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand=" + brand +
                ", model=" + model +
                ", releaseDate=" + releaseDate +
                ", mileage=" + mileage +
                ", vehicleId=" + vehicleId +
                '}';
    }
}
