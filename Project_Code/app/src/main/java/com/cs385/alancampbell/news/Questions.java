package com.cs385.alancampbell.news;

/**
 * Created by Alan Campbell & Cathal McCabe
 * The purpose of the Questions.java file is to hold all the questions, answers and actions to be carried out on the users section.
 *
 */

public class Questions {


    // 1d array of questions
    public String mQuestions[] = {
            "In what modern Quay is it believed that the Vikings landed?",
            "How many pints on average are drank on average every hour in Dublin?",
            "Which Saint is buried in Dublin?",
            "Which of these cities is Dublin not twinned with?",
            "What is in the Book of Kells?",
            "What is Dublin's oldest theatre?",
            "What is known in Gaelic as uisce beatha, or water of life?",
            "Irish rock group U2 own what type of Dublin establishment?",
            "When was Trinity College founded?",
            "You Finished The Quiz With The Top Score",
    };
    // 2d array of multiple choice for each question
    private String mChoices[][] = {
            {"Wood Quay","Arran Quay","Burgh Quay","Sir John Rogerson's Quay"},
            {"6,400","9,800","12,000","15,600"},
            {"St Valentine","St Stephen","St Patrick","St Thomas"},
            {"San Jose","Liverpool","Madrid","Beijing"},
            {"Christian gospel","Maps of Meath","Pagan verses","Celtic myths"},
            {"The Gate","The Abbey","The Gaiety","Smock Alley"},
            {"Rum","Gin","Whiskey","Beer"},
            {"A pub","A hotel","A nightclub","A coffee shop"},
            {"1450","1502","1680","1592"},
            {"End Game","End Game","End Game","End Game"},

    };
    // array of correct answers - in the same order as array of questions these have to match exactly
    private String mCorrectAnswers [] = {"Wood Quay","9,800","St Valentine","Madrid" ,"Christian gospel","Smock Alley","Whiskey","A hotel","1592","End Game"};
    // method returns question from array mQuestions
    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }
    // method return a multple choice item for question based on array index
    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}