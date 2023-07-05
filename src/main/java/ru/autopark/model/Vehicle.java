package ru.autopark.model;

import ru.autopark.model.enums.Brand;
import ru.autopark.model.enums.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Vehicle {
    private Long id;
    private Brand brand;
    private Model model;
    private LocalDate releaseDate;
    private Integer mileage;
    private Long autoParkId;

    public Vehicle() {
    }

    public Vehicle(Long id, Brand brand, Model model, LocalDate releaseDate, Integer mileage, Long autoParkId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.releaseDate = releaseDate;
        this.mileage = mileage;
        this.autoParkId = autoParkId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Long getAutoParkId() {
        return autoParkId;
    }

    public void setAutoParkId(Long autoParkId) {
        this.autoParkId = autoParkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && brand == vehicle.brand && model == vehicle.model && Objects.equals(releaseDate, vehicle.releaseDate) && Objects.equals(mileage, vehicle.mileage) && Objects.equals(autoParkId, vehicle.autoParkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, releaseDate, mileage, autoParkId);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand=" + brand +
                ", model=" + model +
                ", releaseDate=" + releaseDate +
                ", mileage=" + mileage +
                ", vehicleId=" + autoParkId +
                '}';
    }
}
