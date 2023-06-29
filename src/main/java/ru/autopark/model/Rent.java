/**
 * Создал Андрей Антонов 29.06.2023 7:23
 **/
package ru.autopark.model;

public class Rent {
    private Long vehicleId;
    private Long customerId;

    public Rent() {
    }

    public Rent(Long vehicleId, Long customerId) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "vehicleId=" + vehicleId +
                ", customerId=" + customerId +
                '}';
    }
}
