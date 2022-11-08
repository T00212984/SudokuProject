package Sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        int[] solution = {4,8,9,6,7,2,3,5,1,3,1,6,5,4,9,2,8,7,7,5,2,8,3,1,4,6,9,2,3,8,1,5,7,9,4,6,5,4,7,3,9,6,1,2,8,6,9,1,2,8,4,5,7,3,1,6,5,9,2,8,7,3,4,9,2,4,7,6,3,8,1,5,8,7,3,4,1,5,6,9,2};
        //https://stackoverflow.com/questions/54174625/i-want-to-have-two-arrays-to-have-the-same-values#:~:text=If%20you%20want%20two%20different,arrayCopy()%20for%20better%20performance!
        int[] problem = Arrays.copyOf(solution, solution.length);

        int difficulty = 1;

        if (difficulty == 1){

            for(int i=0;i<2;i++) {
                int replaceRandom = (int) (Math.random() * 81);
                problem[replaceRandom] = 0;
                System.out.println("Blank position " + (replaceRandom +1));
                System.out.println("Number solution " + solution[replaceRandom]);
            }
        }
        //https://youtu.be/CFLDt6U9SeM
        while(Arrays.stream(problem).anyMatch(element -> element == 0)) {
            Scanner myObj = new Scanner(System.in);
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
