package com.example;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Employee {
    private int id;
	private String name;
	private String dept;
	private List<Project> projects;
	private double salary;
	private String gender;
}
