package online.javabook.jvm.magic.string.split;

public class StringSpliter {

    private String string;

    private char splitChar;

    private int currentIndex = 0;

    public StringSpliter(String str, char splitChar) {
        this.string = str;
        this.splitChar = splitChar;
    }

    public boolean hasMoreTokens() {
        if(currentIndex==-1) {
            return false;
        }else{
            return true;
        }
    }

    public String nextToken() {
        int splitIndex = string.indexOf(splitChar, currentIndex);
        if(splitIndex == -1) {
            String token = string.substring(currentIndex);
            currentIndex = splitIndex;
            return token;
        }
        String token = string.substring(currentIndex, splitIndex);
        currentIndex = splitIndex + 1;
        return token;
    }
}
