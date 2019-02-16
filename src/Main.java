

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int score;

    private static List<frame> frames = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String output = scanner.nextLine();
        String[] framesString = output.split(" ");

        //FIRST 9 FRAMES OUTPUT SCANNER
        for (int i = 0; i < 9; i++) {
            frames.add(new frame(framesString[i]));
            frames.get(i).analyze();
        }

        //FINAL FRAME OUTPUT SCANNER
        StringBuilder finalFrameString = new StringBuilder();
        for (int i = 9; i < framesString.length; i++) {
            finalFrameString.append(framesString[i]);
        }
        frames.add(new finalFrame(finalFrameString.toString()));
        frames.get(9).analyze();


        //CALCULATE SCORE FIRST 8 FRAMES
        for (int i = 0; i < 8; i++) { //check first 8 frames
            if (frames.get(i).isSpare()) {  //if its a spare, add score from next throw
                frames.get(i).addScore(frames.get(i + 1).getFirstThrow());
            }
            if (frames.get(i).isStrike()) {  //if its a strike, add score from next 2 throws
                if (frames.get(i + 1).isStrike()) {
                    frames.get(i).addScore(frames.get(i + 1).getFirstThrow() + frames.get(i + 2).getFirstThrow());
                } else {
                    frames.get(i).addScore(frames.get(i + 1).getFirstThrow() + frames.get(i + 1).getSecondThrow());
                }
            }
            score += frames.get(i).getScore();
        }

        //CALCULATE SCORE PENULTIMATE FRAME
        if (frames.get(8).isSpare()) {  //if its a spare, add score from next throw
            frames.get(8).addScore(frames.get(8 + 1).getFirstThrow());
        }
        if (frames.get(8).isStrike()) {  //if its a strike, add score from next 2 throws
            frames.get(8).addScore(frames.get(8 + 1).getFirstThrow() + frames.get(8 + 1).getSecondThrow());
        }
        score += frames.get(8).getScore();


        //CALCULATE SCORE FINAL FRAME
        score += frames.get(9).getScore();

        //OUTPUT SCORE
        System.out.println("SCORE:");
        System.out.println(score);

    }
}

