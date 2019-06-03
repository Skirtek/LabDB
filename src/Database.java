import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Database implements IDatabase {

    @Override
    public boolean Insert(Projekt projekt) {
        boolean IsSuccess = false;
        String query = "INSERT INTO projekt(nazwa,opis, dataczas_utworzenia,data_oddania) VALUES (?, ?, ?, ?)";
        try(Connection connection = DriverManager.getConnection(DatabaseSettings.DBURL, DatabaseSettings.DBUSER, DatabaseSettings.DBPASS)){
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, projekt.getNazwa());
            statement.setString(2, projekt.getOpis());
            statement.setObject(3, projekt.getDataCzasUtworzenia());
            statement.setObject(4, projekt.getDataOddania());

            if(IsSuccess = statement.executeUpdate() > 0){
                ResultSet keys = statement.getGeneratedKeys();
                if(keys.next()){
                    projekt.setProjektId(keys.getInt(1));
                }
                keys.close();
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return IsSuccess;
    }

    @Override
    public boolean Update(Projekt projekt) {
        boolean IsSuccess = false;
        String query = "UPDATE projekt SET nazwa = ? , opis = ?, dataczas_utworzenia = ?, data_oddania = ? WHERE projekt_id = "+projekt.getProjektId()+";";
        try(Connection connection = DriverManager.getConnection(DatabaseSettings.DBURL, DatabaseSettings.DBUSER, DatabaseSettings.DBPASS)){
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, projekt.getNazwa());
            statement.setString(2, projekt.getOpis());
            statement.setObject(3, projekt.getDataCzasUtworzenia());
            statement.setObject(4, projekt.getDataOddania());

            if(IsSuccess = statement.executeUpdate() > 0){
                ResultSet keys = statement.getGeneratedKeys();
                if(keys.next()){
                    projekt.setProjektId(keys.getInt(1));
                }
                keys.close();
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        return IsSuccess;
    }

    @Override
    public List<Projekt> GetAll(Integer offset, Integer limit) {
        List<Projekt> projekty = new ArrayList<>();
        String query = "SELECT * FROM projekt " +
                "ORDER BY dataczas_utworzenia DESC"
                +(offset != null ? " OFFSET ?" : "")
                +(limit != null ? " LIMIT ?" : "");

        try(Connection connection = DriverManager.getConnection(DatabaseSettings.DBURL, DatabaseSettings.DBUSER, DatabaseSettings.DBPASS)){
            PreparedStatement statement = connection.prepareStatement(query);
            if(offset != null){
                statement.setInt(1, offset);
            }

            if(limit != null){
                statement.setInt(offset == null ? 1 : 2, limit);
            }

            ResultSet results = statement.executeQuery();
            while(results.next()){
                Projekt projekt = new Projekt();
                projekt.setProjektId(results.getInt("projekt_id"));
                projekt.setNazwa(results.getString("nazwa"));
                projekt.setOpis(results.getString("opis"));
                projekt.setDataCzasUtworzenia(results.getObject("dataczas_utworzenia", LocalDateTime.class));
                projekt.setDataOddania(results.getObject("data_oddania", LocalDate.class));
                projekty.add(projekt);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return projekty;
    }
}