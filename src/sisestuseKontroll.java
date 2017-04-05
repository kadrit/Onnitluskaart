/**
 * Created by Eve_T on 05.04.2017.
 */
public class sisestuseKontroll {
    int muutuja;

    public sisestuseKontroll(int muutuja) {
        this.muutuja = muutuja;
    }

    public int getMuutuja() {
        return muutuja;
    }

    public static void veateade(int muutuja) {
        if (muutuja != 1 && muutuja != 2) {
            System.out.println("Luuletuse saamiseks sisesta andmed nii nagu nõutud!");
            System.exit(0);
        }
    }
}