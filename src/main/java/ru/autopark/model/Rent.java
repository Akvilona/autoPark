package ru.autopark.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rent {
    private Long vehicleId;
    private Long customerId;
    private LocalDateTime createDateTime;
    private Duration duration;

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
