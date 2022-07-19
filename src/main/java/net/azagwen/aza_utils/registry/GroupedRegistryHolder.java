package net.azagwen.aza_utils.registry;

import com.google.common.collect.Maps;
import net.minecraft.util.StringIdentifiable;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class GroupedRegistryHolder<T, V extends StringIdentifiable>{
    private final Map<V, T> values = Maps.newLinkedHashMap();

    public GroupedRegistryHolder(Registrar<T> registrar, V[] variants, String name, Function<V, Supplier<T>> futureObject) {
        for (var variant : variants) {
            var fullName = String.format("%s_%s", variant.asString(), name);
            var holder = new RegistryHolder<>(registrar, fullName, futureObject.apply(variant));
            values.put(variant, holder.get());
        }
    }

    public T get(V variant) {
        return this.values.get(variant);
    }
}
