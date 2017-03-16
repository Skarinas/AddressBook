package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        initRootLayout();
        showPersonOverview();
    }

    // Инициализируем корневой макет
    public void initRootLayout(){
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("RootLayout.fxml"));

        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        } catch (IOException e) {e.printStackTrace();}
    }

    // Показывает в корневом макете сведения об адресатах.
    public void showPersonOverview(){
        try{
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);
            // Даем контроллеру доступ к главному проложению
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {e.printStackTrace();}
    }
    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public  ObservableList<Person> getPersonData(){
        return personData;
    }
    public Main(){
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
