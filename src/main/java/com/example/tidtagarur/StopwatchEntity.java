package com.example.tidtagarur;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "saved_times")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StopwatchEntity {

    @Id
    @SequenceGenerator(
            name = "time_seq",
            sequenceName = "time_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "time_seq"
    )
    @Column(name = "time_id")
    private Integer id;

    @Column(name = "savedTime")
    private double time;
}