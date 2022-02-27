package com.ioannou.feescalculator;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private ZonedDateTime entranceTime;
    private ZonedDateTime exitTime;
    @Column(name="vehicle_type")
    @Enumerated(EnumType.STRING)
    private Type type;
    private String plate;

    public enum Type {
        CAR,
        TRUCK,
        BUS
    }

    public long getDuration() {
        return Duration.between(entranceTime, exitTime).toMinutes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(ZonedDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public ZonedDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(ZonedDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", entranceTime=" + entranceTime +
                ", exitTime=" + exitTime +
                ", type='" + type + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(entranceTime, vehicle.entranceTime) && Objects.equals(exitTime, vehicle.exitTime) && type == vehicle.type && Objects.equals(plate, vehicle.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entranceTime, exitTime, type, plate);
    }
}
