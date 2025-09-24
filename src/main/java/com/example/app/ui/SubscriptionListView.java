package com.example.app.ui;

import com.example.app.model.Subscription;
import com.example.app.vm.SubscriptionListViewModel;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

public class SubscriptionListView extends VBox {

    public SubscriptionListView(SubscriptionListViewModel vm) {
        TableView<Subscription> table = createSubTable(vm);
        HBox buttonRow = createButtonRow(vm, table);

        getChildren().addAll(table, buttonRow);
    }

    private TableView<Subscription> createSubTable(SubscriptionListViewModel vm){
        TableView<Subscription> table = new TableView<>(vm.getSubscriptions());

        TableColumn<Subscription, String> names = new TableColumn<>("Name");
        names.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Subscription, Number> prices = new TableColumn<>("Price");
        prices.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Subscription, String> renewalDates = new TableColumn<>("Renewal");
        renewalDates.setCellValueFactory(new PropertyValueFactory<>("renewalDate"));

        table.getColumns().addAll(List.of(names, prices, renewalDates));

        Button addButton = new Button("+ Add");
        addButton.setOnAction(_ ->
                vm.addSubscription(new Subscription("Amazon", 9.99, "2025-12-01"))
        );

        return table;
    }

    private HBox createButtonRow(SubscriptionListViewModel vm, TableView<Subscription> table) {
        Button addButton = new Button("+ Add");
        addButton.setOnAction(_ ->
                openAddDialog(vm::addSubscription)
                //vm.addSubscription(new Subscription("Amazon", 9.99, "2025-12-01"))
        );

        Button delButton = new Button("- Delete");
        delButton.setOnAction(_ -> {
                Subscription selected = table.getSelectionModel().getSelectedItem();
                if (selected != null) vm.deleteSubscription(selected);
            }
        );
        return new HBox(10, addButton, delButton);
    }

    private void openAddDialog(Consumer<Subscription> onAdd) {
        Dialog<Subscription> dlg = new Dialog<>();
        dlg.initOwner(getScene().getWindow());
        dlg.setTitle("Insert Info");
        ButtonType ok = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dlg.getDialogPane().getButtonTypes().addAll(ok, ButtonType.CANCEL);

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField priceField = new TextField();
        priceField.setPromptText("Price per month");

        DatePicker renewalPicker = new DatePicker();

        VBox form = new VBox(10,
                new Label("Name:"), nameField,
                new Label("Price:"), priceField,
                new Label("Renewal Date:"), renewalPicker
        );
        form.setPadding(new Insets(10));

        dlg.setResultConverter(bt -> {
            if (bt == ok) {
                try {
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    LocalDate renewal = renewalPicker.getValue();
                    if (name == null || name.isBlank() || renewal == null) {
                        return null;
                    }
                    return new Subscription(name, price, renewal.toString());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
        });

        dlg.getDialogPane().setContent(form);
        dlg.showAndWait().ifPresent(onAdd);
    }
}
