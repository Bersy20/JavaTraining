package com.softura.assessment1.tasks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    private String name;
    private int salaryRate;
    private String isSalaried;
}
