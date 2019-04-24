package com.labs.group8.view;

import com.labs.group8.model.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class MainView extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Book> bookData = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Constructor
     */
    public MainView() {
        // Add some sample data
        bookData.add(new Book("Hans", "Muster", new Date(), 123));
        bookData.add(new Book("Ruth", "Mueller", new Date(), 123));
        bookData.add(new Book("Heinz", "Kurz", new Date(), 123));
        bookData.add(new Book("Cornelia", "Meier", new Date(), 123));
        bookData.add(new Book("Werner", "Meyer", new Date(), 123));
        bookData.add(new Book("Lydia", "Kunz", new Date(), 123));
        bookData.add(new Book("Anna", "Best", new Date(), 123));
        bookData.add(new Book("Stefan", "Meier", new Date(), 123));
        bookData.add(new Book("Martin", "Mueller", new Date(), 123));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Book> getBookData() {
        return bookData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Library");

        initRootLayout();

        showBookOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            Path path = Paths.get(new URL("file:///S:/SecondLabLib/Information-System-dev/src/main/java/com/labs/group8/view/rootLayout.fxml").toURI());
            System.out.println(path);
            loader.setLocation(new URL("file:///S:/SecondLabLib/Information-System-dev/src/main/java/com/labs/group8/view/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showBookOverview() {
        try {
            // Load book overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new URL("file:///S:/SecondLabLib/Information-System-dev/src/main/java/com/labs/group8/view/BookOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set book overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Даём контроллеру доступ к главному приложению.
            BookOverviewController controller = loader.getController();
            controller.setMainView(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
