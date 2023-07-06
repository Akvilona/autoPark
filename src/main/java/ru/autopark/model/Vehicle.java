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

    public Vehicle(final Long id, final Brand brand, final Model model, final LocalDate releaseDate, final Integer mileage, final Long autoParkId) {
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

    public void setId(final Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(final Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(final Model model) {
        this.model = model;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(final Integer mileage) {
        this.mileage = mileage;
    }

    public void setMileage(final int mileage) {
        this.mileage = mileage;
    }

    public Long getAutoParkId() {
        return autoParkId;
    }

    public void setAutoParkId(final Long autoParkId) {
        this.autoParkId = autoParkId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && brand == vehicle.brand && model == vehicle.model && Objects.equals(releaseDate, vehicle.releaseDate) && Objects.equals(mileage, vehicle.mileage) && Objects.equals(autoParkId, vehicle.autoParkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, releaseDate, mileage, autoParkId);
    }

    @Override
    public String toString() {
        return "Vehicle{"
                + "id=" + id
                + ", brand=" + brand
                + ", model=" + model
                + ", releaseDate=" + releaseDate
                + ", mileage=" + mileage
                + ", vehicleId=" + autoParkId
                + '}';
    }
}
