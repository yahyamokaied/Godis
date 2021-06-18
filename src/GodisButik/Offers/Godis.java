package GodisButik.Offers;

import org.jetbrains.annotations.NotNull;
import java.util.UUID;

public class Godis {

    private final UUID id;
    private final String name;

    public Godis(@NotNull String name) {



        this.id = java.util.UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
    public String name() {
        return name;
    }

@Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Godis godis = (Godis) o;

    if (!id.equals(godis.id)) return false;
    return name.equals(godis.name);
    }

@Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }
}
