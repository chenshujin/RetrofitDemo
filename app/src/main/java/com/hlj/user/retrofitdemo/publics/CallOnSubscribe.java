package com.hlj.user.retrofitdemo.publics;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

/**
 * Created by ${csj} on 16/6/8.
 */
public class CallOnSubscribe<T> implements Observable.OnSubscribe<Response<T>> {
    private  Call<T> originalCall;

    CallOnSubscribe(Call<T> originalCall) {
        this.originalCall = originalCall;
    }

    @Override public void call(final Subscriber<? super Response<T>> subscriber) {
        // Since Call is a one-shot type, clone it for each new subscriber.
        final Call<T> call = originalCall.clone();

        // Attempt to cancel the call if it is still in-flight on unsubscription.
       /*
        public static Subscription create(final Action0 unsubscribe) {
            return BooleanSubscription.create(unsubscribe);
        }*/
        subscriber.add(Subscriptions.create(new Action0() {
            @Override
            public void call() {
                call.cancel();
            }
        }));

        try {
            Response<T> response = call.execute();
            if (!subscriber.isUnsubscribed()) {
                subscriber.onNext(response);
            }
        } catch (Throwable t) {
            Exceptions.throwIfFatal(t);
            if (!subscriber.isUnsubscribed()) {
                subscriber.onError(t);
            }
            return;
        }

        if (!subscriber.isUnsubscribed()) {
            subscriber.onCompleted();
        }
    }
}
