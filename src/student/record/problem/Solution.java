package student.record.problem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Student s1  = new Student(1001, 40);
		Student s2  = new Student(1002, 50);
		Student s3  = new Student(1003, 60);
		Student s4  = new Student(1002, 80);
		Student s5  = new Student(1005, 35);
		Student s6  = new Student(1005, 55);
		Student s7  = new Student(1007, 68);
		Student s8  = new Student(1009, 99);
		Student s9  = new Student(1009, 10);
		Student s10 = new Student(1004, 89);
		
		Map<Integer, Student> recordMap = new HashMap<>();
		saveRecord(recordMap, s1);
		saveRecord(recordMap, s2);
		saveRecord(recordMap, s3);
		saveRecord(recordMap, s4);
		saveRecord(recordMap, s5);
		saveRecord(recordMap, s6);
		saveRecord(recordMap, s7);
		saveRecord(recordMap, s8);
		saveRecord(recordMap, s9);
		saveRecord(recordMap, s10);
		
		List<Student> studentList = recordMap.values().stream().collect(Collectors.toList());
		studentList.sort(Comparator.comparing(Student::getScore).reversed());
		studentList.forEach(System.out::println);
	}
	
	public static void saveRecord(Map<Integer, Student> recordMap, Student s) {
		if (recordMap.containsKey(s.getRollNo())) {
			int maxScore = recordMap.get(s.getRollNo()).getScore();
			
			if (maxScore < s.getScore()) {
				recordMap.put(s.getRollNo(), s);
			}
		} else {
			recordMap.put(s.getRollNo(), s);
		}
	}
}
