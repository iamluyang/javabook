package online.javabook.gof.behavioral.patterns5.memento1.browser.memento;

import java.util.ArrayList;
import java.util.List;

public class History {

    private int index = -1;

    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
        index++;
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

    public Memento getUndo() {
        if (index == -1) {
            return null;
        }
        index = Math.max(0, --index);
        return mementoList.get(index);
    }

    public Memento getRedo() {
        if (index == mementoList.size()) {
            return null;
        }
        index = Math.min(mementoList.size() - 1, ++index);
        return mementoList.get(index);
    }
}
