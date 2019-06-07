import java.time.LocalDate;
import java.time.LocalDateTime;

public class Projekt {

    private int ProjektId;
    private String Nazwa;
    private String Opis;
    private LocalDateTime DataCzasUtworzenia;
    private LocalDate DataOddania;

    Projekt() {
    }

    Projekt(int projektId, String nazwa, String opis, LocalDateTime dataCzasUtworzenia, LocalDate dataOddania) {
        ProjektId = projektId;
        Nazwa = nazwa;
        Opis = opis;
        DataCzasUtworzenia = dataCzasUtworzenia;
        DataOddania = dataOddania;
    }

    public Projekt(String nazwa, String opis, LocalDateTime dataCzasUtworzenia, LocalDate dataOddania) {
        Nazwa = nazwa;
        Opis = opis;
        DataCzasUtworzenia = dataCzasUtworzenia;
        DataOddania = dataOddania;
    }

    public int getProjektId() {
        return ProjektId;
    }

    public void setProjektId(int projektId) {
        ProjektId = projektId;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public LocalDateTime getDataCzasUtworzenia() {
        return DataCzasUtworzenia;
    }

    public void setDataCzasUtworzenia(LocalDateTime dataCzasUtworzenia) {
        DataCzasUtworzenia = dataCzasUtworzenia;
    }

    public LocalDate getDataOddania() {
        return DataOddania;
    }

    public void setDataOddania(LocalDate dataOddania) {
        DataOddania = dataOddania;
    }
}
