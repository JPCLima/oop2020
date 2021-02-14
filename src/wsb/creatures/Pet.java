package wsb.creatures;

import java.sql.SQLException;

public class Pet extends Animal {
    public Pet(Species species) throws SQLException {
        super(species);
    }
}
