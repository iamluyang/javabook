package online.javabook.gof.behavioral.patterns5.memento2.grapheditor.memen;

import java.util.ArrayList;
import java.util.List;

public class GraphCommandHistory {

    private int index = -1;

    private List<GraphCommandMemento> mementoList = new ArrayList<GraphCommandMemento>();

    public void add(GraphCommandMemento state){
        mementoList.add(state);
        index++;
    }

    public GraphCommandMemento get(int index){
        return mementoList.get(index);
    }

    public GraphCommandMemento getUndo() {
        if (index == -1) {
            return null;
        }
        index = Math.max(0, --index);
        return mementoList.get(index);
    }

    public GraphCommandMemento getRedo() {
        if (index == mementoList.size()) {
            return null;
        }
        index = Math.min(mementoList.size() - 1, ++index);
        return mementoList.get(index);
    }
}
