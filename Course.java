package Lap9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	public Course(String id, String title, String type, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = new ArrayList<>();
		this.lecturer = lecturer;
	}

	public int numStudentOfCourse() {
		return students.size();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getLeader() {
		return lecturer;
	}

	public void setLeader(String lecturer) {
		this.lecturer = lecturer;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> result = new HashMap<>();
		for (Student student : students) {
			if (result.containsKey(student.getYear())) {
				result.get(student.getYear()).add(student);
			} else {
				List<Student> list = new ArrayList<>();
				list.add(student);
				result.put(student.getYear(), list);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", type=" + type + ", students=" + students + ", lecturer="
				+ lecturer + "]";
	}
}