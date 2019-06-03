import java.util.List;

public interface IDatabase {
    boolean Insert(Projekt projekt);

    boolean Update(Projekt projekt);

    List<Projekt> GetAll(Integer offset, Integer limit);
}
