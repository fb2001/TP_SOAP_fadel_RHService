package hai702.tp2.demo.main;

import java.io.BufferedReader;

public class IntegerInputProcessor extends ComplexUserInputProcessor<Integer> {

    public IntegerInputProcessor(BufferedReader input) {
        super(input);
    }

    @Override
    protected void setMessage() {
        message = "Entrer an entier";
    }

    @Override
    protected void setValidityCriterion() { //prend en entrer un string et essaye de le parser et nous donné un resultat
        isValid = str -> {
            try {
                Integer value = Integer.parseInt(str);
                return value instanceof Integer;
            } catch (NumberFormatException e) {
                return false;
            }
        };

    }

    @Override
    protected void setParser() {
        try {
            parser = Integer.class.getMethod("parseInt", String.class);
        } catch (SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
