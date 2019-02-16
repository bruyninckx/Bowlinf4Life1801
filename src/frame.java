
public class frame {
    String frame;
    int firstThrow;
    int secondThrow;
    boolean strike;
    boolean spare;
    private int addScore;


    frame(String frame) {
        this.addScore = 0;
        this.frame = frame;
    }

    public void analyze() {
        String frameNew = frame.replaceAll("-", "0");
        if ("X".equalsIgnoreCase(frameNew.substring(0, 1))) {
            strike = true;
            firstThrow = 10;
            secondThrow = -1;
        } else if ("/".equals(frameNew.substring(1, 2))) {
            spare = true;
            firstThrow = Integer.parseInt(frameNew.substring(0, 1));
            secondThrow = 10 - Integer.parseInt(frameNew.substring(0, 1));
        } else {
            firstThrow = Integer.parseInt(frameNew.substring(0, 1));
            secondThrow = Integer.parseInt(frameNew.substring(1, 2));
        }
    }

    public int getScore() {
        if (secondThrow < 0) {
            return firstThrow + addScore;
        } else {
            return firstThrow + secondThrow + addScore;
        }
    }

    void addScore(int score) {
        this.addScore += score;
    }

    boolean isStrike() {
        return strike;
    }

    boolean isSpare() {
        return spare;
    }

    int getFirstThrow() {
        return firstThrow;
    }

    int getSecondThrow() {
        return secondThrow;
    }
}
