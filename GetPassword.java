package Main;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class GetPassword extends Application {
    private static final String cmdCommand = "cmd /c";
    private static List<String> wifiList = new ArrayList<>();
    private static List<String> passwordList = new ArrayList<>();
    private static Map<String, String> wifiPassord = new HashMap<>();
    private static Scanner scan = new Scanner(System.in);
    private static File document = new File("wifiPass.txt");
    public void start(Stage primaryStage) {
        startBox();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void startBox() {
        Alert startBox = new Alert(Alert.AlertType.CONFIRMATION);
        startBox.setTitle("Start");
        startBox.setHeaderText("Click Button Scan to scan for saved wifi in your computer");
        ButtonType scanButton = new ButtonType("Scan", ButtonBar.ButtonData.OK_DONE);
        ButtonType exitButton = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);
        startBox.getDialogPane().getButtonTypes().setAll(scanButton, exitButton);

        Optional<ButtonType> result = startBox.showAndWait();
        if (result.get() == scanButton) {
            this.getWifiPassword();
            this.choiceBox();
        }
    }

    private void choiceBox(){
        this.wifiList = new ArrayList<>(wifiPassord.keySet());
        ChoiceDialog<String> dialog = new ChoiceDialog<>("",wifiList);
        dialog.setTitle("Scann successful");
        dialog.setHeaderText("");
        dialog.setContentText("Choose a wifi");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            String answer = wifiPassord.get(result.get());
            this.resultBox(result.get(), answer);
        }
    }

    private static void resultBox(String wifiName, String answer){
        Alert resultBox= new Alert(Alert.AlertType.INFORMATION);
        resultBox.setTitle("Password for " + wifiName);
        resultBox.setHeaderText(null);
        resultBox.setContentText(answer);
        ButtonType export = new ButtonType("Export all Wifi", ButtonBar.ButtonData.FINISH);
        ButtonType OK = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        resultBox.getDialogPane().getButtonTypes().setAll(export, OK);
        Optional<ButtonType> result = resultBox.showAndWait();
        if(result.get() == export){
            writeData();
            open(document);
        }



    }

    public static void writeData(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("wifiPass.txt"))){
            for(String wifi: wifiPassord.keySet()){
                writer.write(wifi + ": " + wifiPassord.get(wifi));
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("can not save");
        }

    }
    public static void printWifiPassord(){
        for(String wifi: wifiPassord.keySet()){
            System.out.println(wifi + ": " + wifiPassord.get(wifi));
        }
    }

    public static void printWifiList(){
        wifiList.forEach(System.out::println);
    }

    public static void getWifiPassword(){
        getWifiList();
        getPassWordList();
    }
    public static void getWifiList(){
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(cmdCommand + "netsh wlan show profile ");
            InputStream input = process.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(input));
            for(int i = 1 ; i <= 9; i++){
                read.readLine();
            }
            String line ="";
            while((line = read.readLine()) != null){
                line =line.substring(line.indexOf(":")+1);
                wifiList.add(line);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static void getPassWordList(){
        Process process;
        BufferedReader reader;
        String line;
        String password = "";
        try {
            Runtime runtime = Runtime.getRuntime();
            for(String wifi: wifiList) {
                process = runtime.exec(cmdCommand + "netsh wlan show profile " + wifi + " key=clear");
                reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Security key"))
                        break;
                }
//                System.out.println(line);
                if (line != null) {
                    if (line.contains("Present")) {
                        line = reader.readLine();
                        password = line.substring(line.indexOf(":")+1);
//                        System.out.println(password);
                    } else password = "There is no password for this wifi";
                    wifiPassord.put(wifi, password);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void open(File document) {
    	Desktop desktop = Desktop.getDesktop();
    	try {
			desktop.open(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    }


