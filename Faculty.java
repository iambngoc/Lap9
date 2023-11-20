package Lap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;
	
	public Faculty(String name, String address) {
		this.name = name;
		this.address = address;
		this.courses = new ArrayList<>();
	}
public Course getMaxPracticalCourse() {
	int max = 0;
	Course maxPC = null;
	for (Course c : courses) {
		if (c.numStudentOfCourse()> max) {
			max = c.numStudentOfCourse();
			maxPC = c;
		}
	}
	return maxPC;
}

public void addCourses(Course course) {
    this.courses.add(course);
}
public Map<Integer, List<Student>> groupStudentsByYear() {
    Map<Integer, List<Student>> result = new HashMap<>();
    for (Course course : courses) {
        Set<Map.Entry<Integer, List<Student>>> set = course.groupStudentsByYear().entrySet();
        for (Map.Entry<Integer, List<Student>> ele : set) {
            if (result.containsKey(ele.getKey())) {
                result.get(ele.getKey()).addAll(ele.getValue());
            } else {
                result.put(ele.getKey(), ele.getValue());
            }
        }
    }
    return result;
}

public Set<Course> filterCourses(String type) {
    Set<Course> result = new TreeSet<>(new Comparator<Course>() {
        @Override
        public int compare(Course o1, Course o2) {
            return o1.getStudents().size() - o2.getStudents().size();
        }
    });

    for (Course course : courses) {
        if (course.getType().equals(type)) result.add(course);
    }

    return result;
}


public static void main(String[] args) {
	Student st1 = new Student("111", "Nam", 2004);
	Student st2 = new Student("112", "Na", 2003);
	
	Student st3 = new Student("115", "Hoa", 2004);
	Student st4 = new Student("116", "Hoang", 2005);
	Student st5 = new Student("117", "Sung", 2003);
		
	Course cr1 = new Course("A11", "Toan", "LT", "Viet");
	cr1.addStudent(st1);
	cr1.addStudent(st2);
	
	Course cr2 = new Course("A12", "GTNM", "TH", "Hung");
	cr2.addStudent(st3);
	cr2.addStudent(st4);
	cr2.addStudent(st5);
	
	Course cr3 = new Course("A13", "Xac suat", "LT", "Tram");
	cr3.addStudent(st1);
	cr3.addStudent(st2);
	cr3.addStudent(st3);
	cr3.addStudent(st4);
	cr3.addStudent(st5);
	
	Faculty f = new Faculty("CNTT", "Behind the library");
	f.addCourses(cr1);
	f.addCourses(cr2);
	f.addCourses(cr3);
//	System.out.println(f.getMaxPracticalCourse());
//	System.out.println(f.groupStudentsByYear());
	System.out.println(f.filterCourses("LT"));
	
}
}