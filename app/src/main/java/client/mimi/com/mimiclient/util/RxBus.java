package client.mimi.com.mimiclient.util;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class RxBus {

    private final Subject<Object> mBus;
    private static RxBus instance;

    private RxBus() {
        mBus = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    public void post(Object obj) {
        mBus.onNext(obj);
    }

    public <T> Observable<T> toObservable(Class<T> clz) {
        return mBus.ofType(clz);
    }

    public Observable<Object> toObservable() {
        return mBus;
    }

    public boolean hasSubscribers() {
        return mBus.hasObservers();
    }
}
