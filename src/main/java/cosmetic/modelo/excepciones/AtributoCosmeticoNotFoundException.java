package cosmetic.modelo.excepciones;


public class AtributoCosmeticoNotFoundException extends RuntimeException {

    AtributoCosmeticoNotFoundException(int id) {
        super("Could not find atributo " + id);
    }
}