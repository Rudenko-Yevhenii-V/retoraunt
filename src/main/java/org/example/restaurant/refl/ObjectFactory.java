package org.example.restaurant.refl;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory {

    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private final Reflections reflections = new Reflections("org.example.restaurant");

    private ObjectFactory() { }

    public static ObjectFactory getInstance() {
        return OBJECT_FACTORY;
    }

    public <T> T getImplClass(Class<T> tClass) {
        Set<Class<? extends T>> objects = reflections.getSubTypesOf(tClass);
        for (Class<?> object : objects) {
            try {
                return (T) object.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("impl not found");
    }
}
