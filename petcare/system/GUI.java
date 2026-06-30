
package petcare.system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


  public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
      gridPane.setPadding(new Insets(20));
        Text title = new Text("   Welcome to Pet care system");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        title.setFill(Color.CORNFLOWERBLUE);
        gridPane.add(title, 0, 0, 2, 1);
        gridPane.setPadding(new Insets(30));

        TextField serviceNoField = new TextField();
        TextField serviceNameField = new TextField();
        TextField serviceTypeField = new TextField();
        TextField playTimeDurationField = new TextField();

        Button createServiceButton = new Button("Print and adding to list ");
        Label outputLabel = new Label();

        gridPane.add(new Label("Service No:"), 0, 1);
        gridPane.add(serviceNoField, 1, 1);
        gridPane.add(new Label("Service Name:"), 0, 2);
        gridPane.add(serviceNameField, 1, 2);
        gridPane.add(new Label("Service Type:"), 0, 3);
        gridPane.add(serviceTypeField, 1, 3);
        gridPane.add(new Label("Play Time Duration (minutes):"), 0, 4);
        gridPane.add(playTimeDurationField, 1, 4);
        gridPane.add(createServiceButton, 0, 5);
        gridPane.add(outputLabel, 0, 6);

        createServiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int serviceNo = Integer.parseInt(serviceNoField.getText());
                String serviceName = serviceNameField.getText();
                String serviceType = serviceTypeField.getText();
                int playTimeDuration = Integer.parseInt(playTimeDurationField.getText());

                PlayingService playingService = new PlayingService(serviceNo, serviceName, serviceType, playTimeDuration);
                PetCareSystem.list.add(playingService);
                System.out.println("**Playing Service Info**\n" + playingService.toString());
            }
        });

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Pet Care System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
  
}
