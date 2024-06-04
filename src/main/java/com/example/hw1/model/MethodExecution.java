package com.example.hw1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "method_execution")
@AllArgsConstructor
@NoArgsConstructor
public class MethodExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String methodName;

    @Column(name = "duration")
    private Long duration;
}
