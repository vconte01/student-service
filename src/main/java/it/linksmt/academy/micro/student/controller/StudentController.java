package it.linksmt.academy.micro.student.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.linksmt.academy.micro.student.model.Student;
import it.linksmt.academy.micro.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "Student", description = "The student API")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Value( "${env}")
    private String env;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    @Operation( summary = " List all Students")
    public ResponseEntity<List<Student>> getStudents() {

        logger.info("Get all Students" +env);

        return ResponseEntity.ok(studentService.getAll());

    }

    @ApiResponses(value = {
                            @ApiResponse(responseCode = "200",
                                         description = "Student the book",
                                         content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class)) }
                                        ),
                            @ApiResponse(responseCode = "400",
                                         description = "Invalid id supplied",
                                         content = @Content),
                            @ApiResponse(responseCode = "404",
                                         description = "Student not found",
                                          content = @Content)
                           }
                 )
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {

        logger.info("Get single Students");

        return ResponseEntity.ok(studentService.getStudent(id));

    }

    @PostMapping()
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {

        logger.info("Post single Student");

        return ResponseEntity.ok( studentService.insert(student));

    }

    @PutMapping("/{id})")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {

        logger.info("Update single Student");
        return ResponseEntity.ok(studentService.update(student));

    }

    @DeleteMapping("/{id})")
    public void deleteStudent(Long id) {

        logger.info("Delete single Students");
        studentService.delete(id);

    }

}
