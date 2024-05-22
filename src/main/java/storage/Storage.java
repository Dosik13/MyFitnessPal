package storage;

import exercises.Nameable;

import java.util.List;

public class Storage<T extends Nameable> {
    private static final String ENTITY_CANNOT_BE_NULL = "T cannot be null";
    private static final String ENTITY_NAME_CANNOT_BE_NULL = "T name cannot be null";
    private final List<T> entities;

    public Storage(List<T> entities) {
        this.entities = entities;
    }

    public final List<T> getEntities() {
        return entities;
    }

    public final void addEntity(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException(ENTITY_CANNOT_BE_NULL);
        }
        entities.add(entity);
    }

    public final void removeEntity(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException(ENTITY_CANNOT_BE_NULL);
        }
        entities.remove(entity);
    }

    public final void removeEntityByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ENTITY_NAME_CANNOT_BE_NULL);
        }

        for (T entity : entities) {
            if (entity.getName().equals(name)) {
                entities.remove(entity);
                return;
            }
        }
    }

    public final T getEntityByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ENTITY_NAME_CANNOT_BE_NULL);
        }
        for (T entity : entities) {
            if (entity.getName().equals(name)) {
                return entity;
            }
        }
        return null;
    }
}
