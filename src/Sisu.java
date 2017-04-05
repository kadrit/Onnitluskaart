
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;



/**
 * Created by Eve Tõnisson ja Kadri Tooming
 */

/*
* Programm on mõeldud selleks, et aidata õnnitluskaarti koostada. Kasutaja saab valida, kas õnnitletav on laps/täiskasvanu,
* sõber/kolleeg, mees/naine. Luuletus valitakse juhuslikult sisestatud parameetritele vastavate
* luuletuste seast*
* */
public class Sisu {
    public static void main(String[] args) throws FileNotFoundException {
        String nimi;
        int vanus;
        int kolleegSober;
        int sugu;
        String onnitleja;

        //kasutajalt sisendi küsimine: (eeldame, et kasutaja sisestab andmed nõutud kujul)
        nimi = JOptionPane.showInputDialog(null, "Sisesta nimi:  ", "Mis on sünnipäevalapse nimi?",
                JOptionPane.QUESTION_MESSAGE);


        vanus = Integer.parseInt(JOptionPane.showInputDialog(null, "Sisesta 1 kui laps, 2 kui täiskasvanu ", "Kas " + nimi + " on laps või täiskasvanu?",
                JOptionPane.QUESTION_MESSAGE));

        //eeldame, et int tüüpi teisendatavate muutujate puhul sisestab kasutaja kindlasti numbri, aga meetod kontrollib, kas ikka sisestati 1 või 2.
        sisestuseKontroll.veateade(vanus);

        //hargneb vastavalt kas laps või täiskasvanu, laps on alati sõber. Lapse puhul valik kas tüdruk või poiss, täiskasvanu puhul kas mees või naine.
        if (vanus == 1) {
            kolleegSober = 1;
            sisestuseKontroll.veateade(kolleegSober);
            sugu = Integer.parseInt(JOptionPane.showInputDialog(null, "Sisesta 1 kui tüdruk, 2 kui poiss ", "Kas " + nimi + " on poiss või tüdruk?",
                    JOptionPane.QUESTION_MESSAGE));
            sisestuseKontroll.veateade(sugu);
        } else {
            kolleegSober = Integer.parseInt(JOptionPane.showInputDialog(null, "Sisesta 1 kui sõber, 2 kui kolleeg ", "Kas " + nimi + " on kolleeg või sõber?",
                    JOptionPane.QUESTION_MESSAGE));
            sisestuseKontroll.veateade(kolleegSober);

            sugu = Integer.parseInt(JOptionPane.showInputDialog(null, "Sisesta 1 kui naine, 2 kui mees ", "Kas " + nimi + " on mees või naine",
                    JOptionPane.QUESTION_MESSAGE));
            sisestuseKontroll.veateade(sugu);
        }


        onnitleja = JOptionPane.showInputDialog(null, "Sisesta õnnitleja nimi:  ", "Mis on õnnitleja nimi?",
                JOptionPane.QUESTION_MESSAGE);


        // kontrollib kas sõber (1), siis lisab Kallis, muidu lisab Hea;
        if (kolleegSober == 1)
            System.out.println("Kallis " + nimi + "!" + "\n");
        else
            System.out.println("Hea " + nimi + "!" + "\n");


        // luuletuste sisselugemine failist:
        java.io.File fail = new java.io.File("proov3.txt");
        java.util.Scanner s = new java.util.Scanner(fail, "UTF-8");
        ArrayList<Onnitlused> list = new ArrayList<>();

        while (s.hasNextLine()) {
            String rida = s.nextLine();
            String[] tükid = rida.split(";");
            Onnitlused onnitlused = new Onnitlused(Integer.parseInt(tükid[0]), Integer.parseInt(tükid[1]), Integer.parseInt(tükid[2]), tükid[3]);
            /*loetakse sisse ja lisatakse listi ainult need read, mis vastavad kasutaja poolt sisestatud parameetritele (st rea 3 esimest sümbolit on võrdsed sellega,
            mis vastavad kasutaja sisestatud parameetritele*/
            if (Integer.parseInt(tükid[0]) == vanus && Integer.parseInt(tükid[1]) == kolleegSober && Integer.parseInt(tükid[2]) == sugu) {
                list.add(onnitlused);
            }
        }
        s.close();

        //Juhusliku arvu leidmine, mille alusel valitakse luuletuste listist välja juhuslik luuletus
        Random r = new Random();
        int a = r.nextInt(list.size());


        //Juhuslikult leitud luuletuse ekraanile toomine:
        String valitudLuuletus = list.get(a).getOnnitlus();
        String[] luuleread = valitudLuuletus.split("/");
        for (int i = 0; i < luuleread.length; i++) {
            System.out.println(luuleread[i]);

        }

        //Väljastab õnnitluse ja õnnitleja nime:
        System.out.println("\n" + "Palju õnne!");
        System.out.println("\n" + onnitleja);


    }
}