package com.softura.assessment1.tasks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class RegisteredCandidates extends Candidates{
    private Candidates generalInfo;
    private LocalDate dateOfRegistration;
    private String registerNumber;
    private Course course;
}
