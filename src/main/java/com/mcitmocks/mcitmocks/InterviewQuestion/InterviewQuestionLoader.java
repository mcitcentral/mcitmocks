package com.mcitmocks.mcitmocks.InterviewQuestion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class InterviewQuestionLoader implements CommandLineRunner {

    @Autowired
    private InterviewQuestionRepository interviewQuestionRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SEED INTERVIEW QUESTIONS");
        seedInterviewQuestions();
    }

    private static List<InterviewQuestion> readJsonQuestions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/main/java/com/mcitmocks/mcitmocks/InterviewQuestion/mock-questions.json"), new TypeReference<List<InterviewQuestion>>() {
        });
    }

    private void seedInterviewQuestions() throws IOException {
        readJsonQuestions().forEach(interviewQuestionRepository::save);
    }

    public static void main(String[] args) throws IOException {
        readJsonQuestions().forEach(System.out::println);
    }
}
