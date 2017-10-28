package Cats;

import java.util.Vector;

public class Cats extends Vector<Cat> {

    private static Cats  ourInstance = new Cats ();

    public static Cats  getInstance() {
        return ourInstance;
    }

    private Cats() {}

    @Override
    public synchronized String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<this.size();i++){
            stringBuffer.append(i).append(") ").append(this.get(i).toString()).append("; ");
        }
        return String.valueOf(stringBuffer);
    }
}