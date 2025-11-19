package se.lexicon.dao.sequencer;

public class CustomerIdSequencer {
    private static int currentId = 0;

    private CustomerIdSequencer() {
    }

    public static int nextId() {
        return currentId++;
    }


}
