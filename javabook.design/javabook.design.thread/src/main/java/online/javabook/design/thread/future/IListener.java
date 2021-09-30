package online.javabook.design.thread.future;

public interface IListener {

    void OnResult(String result);

    void OnException(Exception result);
}
