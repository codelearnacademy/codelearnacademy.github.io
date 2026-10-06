package es.educacion.ficheros.repository;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public abstract class AbstractFileRepository<T, ID> implements IRepository<T, ID> {

    protected final Path path;
    protected List<T> entities;

    private final Function<T, ID> idExtractor;

    protected AbstractFileRepository(Path path, Function<T, ID> idExtractor) {
        this.path = path;
        this.idExtractor = idExtractor;
        this.entities = new ArrayList<>();
    }

    protected abstract List<T> readAll();

    protected abstract void writeAll(List<T> entities);

    @Override
    public List<T> findAll() {
        return List.copyOf(entities);
    }

    @Override
    public Optional<T> findById(ID id) {
        return entities.stream()
                .filter(entity -> Objects.equals(idExtractor.apply(entity), id))
                .findFirst();
    }

    @Override
    public void create(T entity) {
        ID id = idExtractor.apply(entity);

        if (findById(id).isPresent()) {
            throw new IllegalArgumentException("Ya existe una entidad con identificador: " + id);
        }

        List<T> updated = new ArrayList<>(entities);
        updated.add(entity);
        persist(updated);
    }

    @Override
    public boolean update(T entity) {
        ID id = idExtractor.apply(entity);
        List<T> updated = new ArrayList<>(entities);

        for (int i = 0; i < updated.size(); i++) {
            if (Objects.equals(idExtractor.apply(updated.get(i)), id)) {
                updated.set(i, entity);
                persist(updated);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(ID id) {
        List<T> updated = new ArrayList<>(entities);

        boolean removed = updated.removeIf(
                entity -> Objects.equals(idExtractor.apply(entity), id)
        );

        if (removed) {
            persist(updated);
        }

        return removed;
    }

    private void persist(List<T> updated) {
        writeAll(updated);
        entities = new ArrayList<>(updated);
    }
}
