module com.example.app {
    requires javafx.controls;
    requires org.slf4j;
    requires javafx.base;
    requires java.desktop;

    exports com.example.app;
    exports com.example.app.ui;
    exports com.example.app.vm;
    exports com.example.app.model;
}