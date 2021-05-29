package com.mcitmocks.mcitmocks.InterviewQuestion;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "interview_questions")
public class InterviewQuestion {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String questionName;
    private String questionText;
    private String answerText;
    private QuestionDifficulty questionDifficulty;

    @ElementCollection
    private Set<QuestionType> questionTypes;

    protected InterviewQuestion() {
    }

    @ConstructorProperties({"questionName", "questionText", "answerText", "questionDifficulty", "questionTypes"})
    public InterviewQuestion(String questionName, String questionText, String answerText, QuestionDifficulty questionDifficulty, Set<QuestionType> questionTypes) {
        this.questionName = questionName;
        this.questionText = questionText;
        this.answerText = answerText;
        this.questionDifficulty = questionDifficulty;
        this.questionTypes = questionTypes;
    }

    public String getQuestionName() {
        return this.questionName;
    }

    public QuestionDifficulty getQuestionDifficulty() {
        return this.questionDifficulty;
    }

    public Set<QuestionType> getQuestionTypes() {
        return this.questionTypes;
    }

    @Override
    public String toString() {
        return "InterviewQuestion{" +
                "id='" + id + '\'' +
                ", questionName='" + questionName + '\'' +
                ", questionText='" + questionText + '\'' +
                ", answerText='" + answerText + '\'' +
                ", questionDifficulty=" + questionDifficulty +
                ", questionTypes=" + questionTypes +
                '}';
    }
}
