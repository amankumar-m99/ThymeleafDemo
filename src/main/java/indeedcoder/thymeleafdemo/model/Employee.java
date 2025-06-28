package indeedcoder.thymeleafdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {

	private String name;
	private int age;
	private double salary;
}
