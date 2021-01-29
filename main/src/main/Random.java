
public class Random {

    public Random() {
    }

    public int rand() {
        int j = Math.abs((int) (Math.random() * 10) - 2);
        return j;
    }

    public int rand1() {
        int j = (int) (Math.round(Math.random()));
        return j;
    }

    public int randW() {
        int j = Math.abs((int) ((Math.random() * 1280)));
        return j;
    }
}
