import java.util.List;

public interface IDatabase {
    boolean Insert(Projekt projekt);

    boolean Update(Projekt projekt);

    boolean Delete(Integer projektId);

    List<Projekt> GetAll(Integer offset, Integer limit);
}
