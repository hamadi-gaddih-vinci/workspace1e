import java.time.Duration;
import java.time.LocalDateTime;

public class TestAppelTelephonique {
    public static void main(String[] args) {
        AppelTelephonique appelTelephonique1 = new AppelTelephonique(LocalDateTime.now(), "0477651207", Duration.ofMinutes(30), 0.20 );
        System.out.println(appelTelephonique1);
        try {
            AppelTelephonique appelTelephonique2 = new AppelTelephonique(LocalDateTime.now(), "04776515", Duration.ZERO);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
