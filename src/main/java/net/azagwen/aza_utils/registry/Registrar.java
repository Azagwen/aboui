package net.azagwen.aza_utils.registry;

import com.google.common.collect.Maps;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;

import java.util.Map;
import java.util.function.Function;

public class Registrar<T> {
    private final Registry<T> registry;
    private final Function<String, Identifier> identifierFunction;
    private final Map<Identifier, T> objects = Maps.newLinkedHashMap();

    public Registrar(Registry<T> registry, Function<String, Identifier> identifierFunction) {
        this.registry = registry;
        this.identifierFunction = identifierFunction;
    }

    protected T register(RegistryHolder<T> holder) {
        var object = Registry.register(this.registry, this.identifierFunction.apply(holder.getName()), holder.getFutureObject().get());
        objects.put(this.identifierFunction.apply(holder.getName()), object);
        return object;
    }

    public void check(Logger logger) {
        var objectSuffix = objects.size() > 1 ? "s" : "";
        logger.info("{} {}{} registered by {} using Aza's Registry Utils.", this.objects.size(), registry.getKey().getValue().getPath(), objectSuffix, identifierFunction.apply("null").getNamespace());
    }
}
