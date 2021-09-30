package online.javabook.jvm.magic.hash.hashcode;

public class ObjectWithGoodHashCode {

    private int i;

    public ObjectWithGoodHashCode(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
