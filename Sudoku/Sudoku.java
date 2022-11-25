/*package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku extends SudokuGUI{
    public static void main(String[] args) {
        int[] solution = {4,8,9,6,7,2,3,5,1,3,1,6,5,4,9,2,8,7,7,5,2,8,3,1,4,6,9,2,3,8,1,5,7,9,4,6,5,4,7,3,9,6,1,2,8,6,9,1,2,8,4,5,7,3,1,6,5,9,2,8,7,3,4,9,2,4,7,6,3,8,1,5,8,7,3,4,1,5,6,9,2};
        //https://stackoverflow.com/questions/54174625/i-want-to-have-two-arrays-to-have-the-same-values#:~:text=If%20you%20want%20two%20different,arrayCopy()%20for%20better%20performance!
        int[] problem = Arrays.copyOf(solution, solution.length);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose Difficulty\nEasy/Medium/Hard");
        String difficulty = myObj.nextLine();


        if (difficulty.equals("easy")){
            for(int i=0;i<2;i++) {
                int replaceRandom = (int) (Math.random() * 81);
                problem[replaceRandom] = 0;
                System.out.println("Blank position " + (replaceRandom +1));
                System.out.println("Number solution " + solution[replaceRandom]);
            }
        }


/*
        JFrame test = new JFrame("test");
        JTextField test3 = new JTextField();
        //test.add(test3);
        //JPanel test2 = new JPanel();

        test.setLayout(new GridLayout(9,9));
        for(int i=1;i<=81;i++){
            if(Integer.parseInt(String.valueOf(problem[i-1]))==0){
                test.add(new JButton());


                /*

                test3.add(new JTextField(""));
                test3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(Integer.parseInt(test3.getText())==0){
                            test3.setText("test");
                        }else{
                            test3.setText("not0");
                        }
                    }
                });
//
            }else {
                test.add(new JButton(String.valueOf(problem[i - 1])));
            }
        }
        test.setSize(400,400);
        test.setVisible(true);


        new SudokuGUI();


        //https://youtu.be/CFLDt6U9SeM
        while(Arrays.stream(problem).anyMatch(element -> element == 0)) {

            System.out.println("enter which position you would like to change");
            int changePosition = Integer.parseInt(myObj.nextLine());

            System.out.println("what number do you choose");
            int guess = Integer.parseInt(myObj.nextLine());

            if (guess == solution[changePosition-1]) {
                problem[changePosition-1]=guess;
                System.out.println("correct");
                System.out.println(Arrays.toString(problem));
            } else {
                System.out.println("incorrect");
            }
        }


    }

}
*/