/**
 * Created by Eve Tõnisson ja Kadri Tooming.
 */
public class Onnitlused {
    private int laps_taiskasvanu;
    private int sober_kolleeg;
    private int sugu;
    private String onnitlus;

    public Onnitlused(int laps_taiskasvanu, int sober_kolleeg, int sugu, String onnitlus) {
        this.laps_taiskasvanu = laps_taiskasvanu;
        this.sober_kolleeg = sober_kolleeg;
        this.sugu = sugu;
        this.onnitlus = onnitlus;
    }

    public int getLaps_taiskasvanu() {
        return laps_taiskasvanu;
    }

    public int getSober_kolleeg() {
        return sober_kolleeg;
    }

    public int getSugu() {
        return sugu;
    }

    public String getOnnitlus() {
        return onnitlus;
    }

    @Override
    public String toString() {
        return onnitlus;
    }


}
