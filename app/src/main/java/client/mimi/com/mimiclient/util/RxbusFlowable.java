package client.mimi.com.mimiclient.util;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

public class RxbusFlowable {
    private final FlowableProcessor<Object> mBus;

    private RxbusFlowable() {
        // toSerialized method made bus thread safe
        mBus = PublishProcessor.create().toSerialized();
    }

    public static RxbusFlowable get() {
        return Holder.BUS;
    }

    public void post(Object obj) {
        mBus.onNext(obj);
    }

    public <T> Flowable<T> toFlowable(Class<T> tClass) {
        return mBus.ofType(tClass);
    }

    public Flowable<Object> toFlowable() {
        return mBus;
    }

    public boolean hasSubscribers() {
        return mBus.hasSubscribers();
    }

    private static class Holder {
        private static final RxbusFlowable BUS = new RxbusFlowable();
    }
}
