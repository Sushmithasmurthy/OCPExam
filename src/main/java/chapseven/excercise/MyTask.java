package chapseven.excercise;

import java.util.concurrent.ForkJoinTask;

/**
 * Created by SushmithaShamanth on 9/20/17.
 */
public class MyTask extends ForkJoinTask {
    @Override
    public Object getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Object value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
