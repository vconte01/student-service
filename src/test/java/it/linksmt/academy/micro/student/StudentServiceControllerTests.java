package it.linksmt.academy.micro.student;

import it.linksmt.academy.micro.student.model.Student;
import it.linksmt.academy.micro.student.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentServiceControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;


    private String url;

    @Test
    void check_get_students_is_ok() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(status().isOk());
    }

    @Test
    void check_get_student_is_ok() throws Exception {

        given(studentService.getStudent(anyLong())).willReturn(new Student("Vincenzo", "Conte"));

        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Vincenzo"));
    }




}
