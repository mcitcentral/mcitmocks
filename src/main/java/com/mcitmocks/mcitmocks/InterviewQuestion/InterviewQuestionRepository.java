package com.mcitmocks.mcitmocks.InterviewQuestion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterviewQuestionRepository extends CrudRepository<InterviewQuestion, String> {

    @Query(value = "SELECT * FROM interview_questions ORDER BY random() LIMIT 1", nativeQuery = true)
    InterviewQuestion getRandom();

}
