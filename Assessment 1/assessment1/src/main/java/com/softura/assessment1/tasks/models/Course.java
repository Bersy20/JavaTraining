package com.softura.assessment1.tasks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    private CourseList courseName;
    private int courseFee;
    private ModeOfClass modeOfClass;
    private Timing timing;
}
