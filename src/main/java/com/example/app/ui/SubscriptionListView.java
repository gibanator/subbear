package com.example.app.ui;

import com.example.app.model.Subscription;
import com.example.app.vm.SubscriptionListViewModel;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.List;

public class SubscriptionListView extends VBox {
    public SubscriptionListView(SubscriptionListViewModel vm){
        TableView<Subscription> table = new TableView<>(vm.getSubscriptions());

        TableColumn<Subscription, String> names = new TableColumn<>("Name");
        names.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().name())
        );

        TableColumn<Subscription, Number> prices = new TableColumn<>("Price");
        prices.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().price())
        );

        TableColumn<Subscription, String> renewalDates = new TableColumn<>("Renewal");
        renewalDates.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().renewalDate())
        );

        table.getColumns().addAll(List.of(names, prices, renewalDates));

        Button addButton = new Button("+ Add");
        addButton.setOnAction(_ ->
                vm.addSubscription(new Subscription("Amazon", 9.99, "2025-12-01"))
        );

        getChildren().addAll(table, addButton);
    }
}
