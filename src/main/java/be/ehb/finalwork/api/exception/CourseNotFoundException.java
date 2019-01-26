package be.ehb.finalwork.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Teacher not found")
public class CourseNotFoundException extends Exception{
}
