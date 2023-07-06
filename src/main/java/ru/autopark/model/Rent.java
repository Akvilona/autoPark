package ru.autopark.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rent {

    private Long id;
    private Long vehicleId;
    private Long customerId;
    private Long autoParkId;
    private LocalDateTime createDateTime;
    private Duration duration;

    public Rent(final Long vehicleId,
                final Long customerId,
                final Long autoParkId,
                final LocalDateTime createDateTime,
                final Duration duration) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.autoParkId = autoParkId;
        this.createDateTime = createDateTime;
        this.duration = duration;
    }

    public Rent(final Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Rent() {
        final int ofDays = 365;
        duration = Duration.ofDays(ofDays);
    }

    public Rent(final Long vehicleId, final Long customerId) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(final Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerId) {
        this.customerId = customerId;
    }

    public Long getAutoParkId() {
        return autoParkId;
    }

    public void setAutoParkId(final Long autoParkId) {
        this.autoParkId = autoParkId;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(final LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(final Duration duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rent{"
                + "vehicleId=" + vehicleId
                + ", customerId=" + customerId
                + '}';
    }
}
