package at.hochbichler.camel.bean;

import java.util.logging.Logger;

public class DataModifier {
    Logger log = Logger.getLogger(DataModifier.class.getName());

    public String map(String input) {
        String newBody = null;
        try {
            newBody = input.replace(",", "*");
        } catch (RuntimeException e) {
            log.severe("RuntiomeException: " + e);
            throw e;
        } catch (Exception e) {
            log.severe("Exception: " + e);
            throw e;
        }

        return  newBody;
    }
}
