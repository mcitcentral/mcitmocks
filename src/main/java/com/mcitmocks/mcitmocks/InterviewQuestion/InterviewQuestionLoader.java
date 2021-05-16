package com.mcitmocks.mcitmocks.InterviewQuestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class InterviewQuestionLoader implements CommandLineRunner {

    @Autowired
    private InterviewQuestionRepository interviewQuestionRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SEED INTERVIEW QUESTIONS");
        seedInterviewQuestions();
    }

    private void seedInterviewQuestions() {
        HashSet<QuestionType> questionTypes1 = new HashSet<>();
        questionTypes1.add(QuestionType.ARRAY);
        InterviewQuestion question1 = new InterviewQuestion("Two Sum", QuestionDifficulty.EASY, questionTypes1);
        interviewQuestionRepository.save(question1);

        HashSet<QuestionType> questionTypes2 = new HashSet<>();
        questionTypes2.add(QuestionType.LINKED_LIST);
        questionTypes2.add(QuestionType.RECURSION);
        InterviewQuestion question2 = new InterviewQuestion("Reverse Linked List", QuestionDifficulty.EASY, questionTypes2);
        interviewQuestionRepository.save(question2);

        HashSet<QuestionType> questionTypes3 = new HashSet<>();
        questionTypes3.add(QuestionType.TREE);
        questionTypes3.add(QuestionType.RECURSION);
        InterviewQuestion question3 = new InterviewQuestion("Binary Tree Inorder Traversal", QuestionDifficulty.EASY, questionTypes3);
        interviewQuestionRepository.save(question3);
    }
}
