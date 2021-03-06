package lv.javaguru.homework.lesson10.level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookRepository implements Repository<Book> {

    private Map<String, Book> repository = new HashMap<>();
    private int count = 0;

    public Map<String, Book> getRepository() {
        return repository;
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(repository.values());
    }

    @Override
    public Book findById(String id) throws ItemNotFoundException {
        if (!repository.containsKey(id)) {
            throw new ItemNotFoundException("Item with id = \"" + id + "\" not found.");
        } else {
            return repository.get(id);
        }
    }

    @Override
    public void save(Book item) {
        count++;
        String generatedId = Integer.toString(count);
        item.setId(generatedId);
        repository.put(generatedId, item);
    }

    @Override
    public void delete(String id) throws ItemNotFoundException {
        //šeit nav būtiski, ka elemnts neeksistē repository,
        //jo to tā vai tā bija jādzēš
        //Tādēļ, ja elemnta nav saraksta no kur vēlamies dzēst, uzskatam ka operācija veikta sekmīgi
//        if (!repository.containsKey(id)) {
//            throw new ItemNotFoundException("Item with id = \"" + id + "\" not found.");
//        } else {
//            System.out.println(repository.remove(id));
//        }
        if (repository.remove(id) == null) {
            throw new ItemNotFoundException("Item with id = \"" + id + "\" not found.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookRepository)) return false;
        BookRepository that = (BookRepository) o;
        return Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }

    @Override
    public String toString() {
        return "BookRepository{" +
                "repository=" + repository +
                '}';
    }
}
