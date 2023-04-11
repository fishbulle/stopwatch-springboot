package com.example.tidtagarur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "saved_times")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimerEntity {

    @Id
    private UUID id;

    @Column(name = "time")
    private double time;

}
