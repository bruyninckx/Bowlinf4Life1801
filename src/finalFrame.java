
public class finalFrame extends frame {
    private int thirdThrow;


    finalFrame(String frame) {
        super(frame);
        thirdThrow = 0;
    }

    @Override
    public void analyze() {
        String frameNew0 = frame.replaceAll("x", "X");  //put everything in caps - we don't want any trouble around here
        String frameNew = frameNew0.replaceAll("-", "0");
        if ("X".equals(frameNew.substring(0, 1))) {
            strike = true;
            firstThrow = 10;
            if ("X".equals(frameNew.substring(1, 2))) {
                secondThrow = 10;
                if("X".equals(frameNew.substring(2, 3))){
                    thirdThrow = 10;
                }
            }
        } else if ("/".equals(frameNew.substring(1, 2))) {
            spare = true;
            firstThrow = Integer.parseInt(frameNew.substring(0, 1));
            secondThrow = 10 - Integer.parseInt(frameNew.substring(0, 1));
            thirdThrow = Integer.parseInt(frameNew.substring(2, 3));
        } else {
            firstThrow = Integer.parseInt(frameNew.substring(0, 1));
            secondThrow = Integer.parseInt(frameNew.substring(1, 2));
        }
    }

    @Override
    public int getScore() {
        return firstThrow + secondThrow + thirdThrow;
    }


}

