module com.mycompany.learninvaders {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.learninvaders to javafx.fxml;
    exports com.mycompany.learninvaders;
}
