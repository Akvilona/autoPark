package ru.autopark.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rent {
    private Long vehicleId;
    private Long customerId;

    private Long autoParkId;

    private LocalDateTime createDateTime;
    private Duration duration;

    public Rent(Long vehicleId, Long customerId, Long autoParkId, LocalDateTime createDateTime, Duration duration) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.autoParkId = autoParkId;
        this.createDateTime = createDateTime;
        this.duration = duration;
    }

    public Rent(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Rent() {
        duration = Duration.ofDays(365);
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

    public Long getAutoParkId() {
        return autoParkId;
    }

    public void setAutoParkId(Long autoParkId) {
        this.autoParkId = autoParkId;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "vehicleId=" + vehicleId +
                ", customerId=" + customerId +
                '}';
    }
}
