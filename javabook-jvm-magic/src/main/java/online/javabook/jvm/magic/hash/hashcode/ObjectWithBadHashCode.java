package online.javabook.jvm.magic.hash.hashcode;

public class ObjectWithBadHashCode {

    private int i;

    public ObjectWithBadHashCode(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
