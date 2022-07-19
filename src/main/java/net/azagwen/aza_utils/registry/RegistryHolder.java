package net.azagwen.aza_utils.registry;

import java.util.function.Supplier;

public class RegistryHolder<T>{
    private final Supplier<T> futureObject;
    private final String name;
    private final T value;

    public RegistryHolder(Registrar<T> registrar, String name, Supplier<T> futureObject) {
        this.futureObject = futureObject;
        this.name = name;
        this.value = registrar.register(this);
    }

    public T get() {
        return this.value;
    }

    protected Supplier<T> getFutureObject() {
        return this.futureObject;
    }

    protected String getName() {
        return this.name;
    }
}
