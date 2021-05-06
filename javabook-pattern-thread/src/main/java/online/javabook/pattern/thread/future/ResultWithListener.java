package online.javabook.pattern.thread.future;

import java.util.ArrayList;
import java.util.List;

public abstract class ResultWithListener implements Result {

    protected List<IListener> listenerList = new ArrayList<>();

    @Override
    public void addListener(IListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(IListener listener) {
        listenerList.remove(listener);
    }

    @Override
    public void doOnResult(String result) {
        for (IListener listener : listenerList){
            listener.OnResult(result);
        }
    }

    @Override
    public void doOnException(Exception exception) {
        for (IListener listener : listenerList){
            listener.OnException(exception);
        }
    }
}
