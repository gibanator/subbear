package com.example.app.vm;

import com.example.app.model.Subscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SubscriptionListViewModel {
    private final ObservableList<Subscription> subscriptions = FXCollections.observableArrayList();

    public SubscriptionListViewModel() {
        subscriptions.addAll(
                new Subscription("Apple", 7.99, "2025-01-23"),
                new Subscription("Youtube", 13.99, "2025-01-23")
        );
    }

    public ObservableList<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription sub) {
        subscriptions.add(sub);
    }

    public boolean deleteSubscription(Subscription sub) {
        return subscriptions.remove(sub);
    }
}
