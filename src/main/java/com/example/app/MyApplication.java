package com.example.app;

import javafx.application.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import org.slf4j.*;

public class MyApplication extends Application {
    private final static Logger logger = LoggerFactory.getLogger(MyApplication.class);

    private final StringProperty greeting = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContent(), 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContent() {
        VBox results = new VBox(20, createInputRow(), createEmphasizeButton(), createOutputLabel());
        results.setAlignment(Pos.CENTER);
        return results;
    }

    private Node createInputRow() {
        TextField inputTextField = new TextField();
        inputTextField.textProperty().bindBidirectional(name);
        HBox inputRow = new HBox(new Label("Name: "), inputTextField);
        inputRow.setAlignment(Pos.CENTER);
        inputRow.setSpacing(6);
        return inputRow;
    }

    private Node createEmphasizeButton(){
        Button actionButton = new Button("!!!");
        actionButton.setOnAction(event -> setEmphasize());

        return actionButton;
    }

    private Node createOutputLabel(){
        Label results = new Label();
        results.textProperty().bind(greeting);
        return results;
    }

    private void setEmphasize(){
        greeting.set(name.get() + "!!!");
    }


}
