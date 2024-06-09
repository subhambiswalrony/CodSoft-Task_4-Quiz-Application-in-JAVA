/*
write a program in JAVA to create a Quiz App which will store questions along with multiple choices
and correct answers. For each question, there will be a specific time, and after submitting all the answers,
it will show the secured score out of total score
*/

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static final int QUESTION_TIME_LIMIT_SECONDS = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] questions = {
                "What is the capital of India?",
                "Who is the Prime Minister of India?",
                // Add more questions here...
        };

        String[] options = {
                "A) Mumbai\nB) Delhi\nC) Chennai\nD) Kolkata",
                "A) Modi\nB) Rahul Gandhi\nC) Amid Saha\nD) Kejriwal",
                // Add more options here...
        };

        char[] correctAnswers = {'B', 'A'};

        int score = 0;

        System.out.println("Welcome to the Quiz App!");
        System.out.println("You have " + QUESTION_TIME_LIMIT_SECONDS + " seconds to answer each question.");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions[i]);
            System.out.println(options[i]);

            char userAnswer = getUserAnswer(scanner);

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.length);

        scanner.close();
    }

    private static char getUserAnswer(Scanner scanner) {
        Timer timer = new Timer();
        char[] answer = {' '};

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                answer[0] = ' ';
            }
        }, QUESTION_TIME_LIMIT_SECONDS * 1000);

        while (answer[0] == ' ') {
            System.out.print("Your answer (A/B/C/D): ");
            String input = scanner.nextLine().toUpperCase();
            if (input.matches("[A-D]")) {
                answer[0] = input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }
        }

        timer.cancel();
        return answer[0];
    }
}
