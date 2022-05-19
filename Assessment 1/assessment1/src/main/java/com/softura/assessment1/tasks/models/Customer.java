package com.softura.assessment1.tasks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    private String name;
    private int customerId;
    private String selectedPlan;
    private int amount;
}
