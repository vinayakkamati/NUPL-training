package com.neptune.taskmanagement.client;

import com.neptune.taskmanagement.dto.ProjectDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProjectApiLiveTest {

    private static final String BASE_URL = "http://localhost:8080/projects/";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void givenProjectExist_whenGet_thenSuccess(){
        ResponseEntity<ProjectDto> response = restTemplate.getForEntity(BASE_URL+"1", ProjectDto.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());
    }

    @Test
    public void givenNewProject_whenCreate_thenSuccess(){
        ProjectDto newProject = new ProjectDto("test 123");
        ResponseEntity<Void> response = restTemplate.postForEntity(BASE_URL + "create", newProject, Void.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);;
    }

}
