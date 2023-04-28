package com.springboot.jpa.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses (@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("topics/{topicId}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable String courseId) {
		return (Optional<Course>) courseService.getCourse(courseId);
	}
	
	/**
	 * This method is incomplete as dependency between topic and course is not specified.
	 * @param topicId
	 * @param course
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course);
	}
	
	/*
	 * @RequestMapping(method = RequestMethod.DELETE, value =
	 * "/topics/{topicId}/courses/{courseId}") public void
	 * deleteCourse(@PathVariable String topicId, @PathVariable String courseId) {
	 * courseService.deleteCourse(courseId); }
	 */
	
	
}
