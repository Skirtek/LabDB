import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Database database = new Database();
            //Projekt projekt = new Projekt("Javka", "Oddany z Javki", LocalDateTime.now(), LocalDate.now().plusDays(7));
            //database.Insert(projekt);

            database.Update(new Projekt(13, "Update", "Update z Javki", LocalDateTime.now(), LocalDate.now().plusDays(7)));

            List<Projekt> result = database.GetAll(0, 100);
            for (Projekt projekt : result) {
                System.out.println(projekt.getNazwa());
            }
            //System.out.println("Id projektu "+ projekt.getProjektId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
