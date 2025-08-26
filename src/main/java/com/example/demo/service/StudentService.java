package com.example.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private ElasticsearchClient client;

    private static final String INDEX = "student";

    public void saveStudent(Student student) throws IOException {
        IndexRequest<Student> request = IndexRequest.of(i -> i
                .index(INDEX)
                .id(student.getId())
                .document(student)
        );
        client.index(request);
    }

    public List<Student> searchByName(String name) throws IOException {
        SearchRequest request = SearchRequest.of(s -> s
                .index(INDEX)
                .query(q -> q
                        .queryString(m -> m
                                .defaultField("name")
                                .query("*" + name + "*")
                        )
                )
        );

        SearchResponse<Student> response = client.search(request, Student.class);

        return response.hits().hits().stream()
                .map(hit -> hit.source())
                .collect(Collectors.toList());
    }
}
