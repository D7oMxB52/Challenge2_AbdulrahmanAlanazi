package com.personservice.personservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personservice.personservice.model.Person;
import com.personservice.personservice.services.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @MockBean
    PersonService personService;

    @InjectMocks
    private PersonController personController;

    @Autowired
    private MockMvc mockMvc;

    Person person1 = new Person(1,"abdul","10 Fake st","3000","25"
                              ,"student","abdul@gmail.com","3344566");

//
//
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }
//
//

    @Test
    void shouldReturnPeople() throws Exception {
        when(personService.getPeople()).thenReturn(List.of(new Person(1,"abdul","10 Fake st","3000","25"
                ,"student","abdul@gmail.com","3344566")));
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/persons/person").contentType(MediaType.APPLICATION_JSON)
                 )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)));
    }

    @Test
    void shouldGiveBadRequest() throws Exception{
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/wrong")
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void shouldCreatePerson() throws Exception {
        when(personService.createPerson(ArgumentMatchers.any())).thenReturn(person1);

        ObjectMapper mapper = new ObjectMapper();
        String person1Json = mapper.writeValueAsString(person1);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(person1Json);
        ResultActions perform = mockMvc.perform(requestBuilder);

        MockHttpServletResponse response = perform.andReturn().getResponse();
        int status = response.getStatus();

        assertEquals(200, status);

    }

}