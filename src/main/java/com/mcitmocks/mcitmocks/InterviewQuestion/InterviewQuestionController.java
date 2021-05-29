package com.mcitmocks.mcitmocks.InterviewQuestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewQuestionController {

    @Autowired
    private InterviewQuestionRepository interviewQuestionRepository;

    @GetMapping(value = "/api/questions/random", produces = "application/json")
    public InterviewQuestion getRandom() {
        return interviewQuestionRepository.getRandom();
    }


}
