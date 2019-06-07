import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            MainUI uiContainer = new MainUI();
            JFrame frame = new JFrame("SimpleCRUD");
            frame.setPreferredSize(new Dimension(800,800));
            frame.setContentPane(uiContainer.mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

            Database database = new Database();

            uiContainer.textArea1.setFont(uiContainer.textArea1.getFont().deriveFont(24f));
            uiContainer.pobierzWierszeZTabeliButton.addActionListener(e -> {
                Thread thread = new Thread(() -> {
                    List<Projekt> result = database.GetAll(0, 100);
                    StringBuilder builder = new StringBuilder();
                    for (Projekt projekt : result) {
                        builder.append(projekt.getNazwa()).append("\n");
                    }
                    uiContainer.textArea1.setText(builder.toString());
                });
                thread.start();
            });

/*            Projekt proj = new Projekt("Nowy projekt", "Testowy projekt", LocalDateTime.now(), LocalDate.now().plusDays(7));
            database.Insert(proj);

            database.Update(new Projekt(18, "Testowy apdejt", "Zapdejtowany projekt", LocalDateTime.now(), LocalDate.now().plusDays(7)));*/

/*            List<Projekt> result = database.GetAll(0, 100);
            for (Projekt projekt : result) {
                System.out.println(projekt.getNazwa());
            }*/
/*
            System.out.println();
            database.Delete(18);*/

/*            result = new ArrayList<>();
            result = database.GetAll(0, 100);
            for (Projekt projekt : result) {
                System.out.println(projekt.getNazwa());
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
