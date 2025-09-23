package com.example.app;

import com.example.app.ui.SubscriptionListView;
import com.example.app.vm.SubscriptionListViewModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplication extends Application {
    //private final static Logger logger = LoggerFactory.getLogger(MyApplication.class);

    @Override
    public void start(Stage primaryStage) {
        SubscriptionListViewModel vm = new SubscriptionListViewModel();
        SubscriptionListView view = new SubscriptionListView(vm);

        Scene scene = new Scene(view, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tracker");
        primaryStage.show();
    }



}
