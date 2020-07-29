package application;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Controller implements Initializable {

	@FXML
	private ToggleButton vana;
	@FXML
	private TextField tfZ;
	@FXML
	private TextField tfR;
	@FXML
	private TextField tfW;
	@FXML
	private TextField tfS;
	@FXML
	private TextField tfC;
	@FXML
	private TextField tf1;
	@FXML
	private TextField tf2;
	@FXML
	private TextField tf3;
	@FXML
	private TextField tf4;
	@FXML
	private TextField tf5;
	@FXML
	private TextField tf6;
	@FXML
	private TextField tf7;
	@FXML
	private TextField tf8;
	@FXML
	private TextField tf9;
	@FXML
	private TextField tf0;
	@FXML
	private TextField tfMG1;
	@FXML
	private TextField tfMG2;
	@FXML
	private Button btnHP;
	@FXML
	private Button btnMP;
	@FXML
	private TextField tfHP;
	@FXML
	private TextField tfMP;
	@FXML
	private TextField tfHealtus;
	@FXML
	private TextField tfHealtus2;
	@FXML
	private TextField tfSure;
	@FXML
	private TextField tfUcBesSiklik;
	@FXML
	private TextField tfUcBesSiklik2;
	@FXML
	private TextField tfKlavye;
	@FXML
	private TextField tfFare;
	@FXML
	private TextField tfKlavye2;
	@FXML
	private TextField tfFare2;
	@FXML
	private TextField tfUc;
	@FXML
	private TextField tfBes;
	@FXML
	private TextField tfBas1;
	@FXML
	private TextField tfBekle1;
	@FXML
	private TextField tfBas2;
	@FXML
	private TextField tfBekle2;
	@FXML
	private TextField tfBas3;
	@FXML
	private TextField tfBekle3;
	@FXML
	private TextField tfBas4;
	@FXML
	private TextField tfBas5;
	@FXML
	private TextField tfBekle4;
	@FXML
	private TextField tfBekle5;
	@FXML
	private TextField tfB1;
	@FXML
	private TextField tfTS;
	@FXML
	private TextField tfTS2;
	@FXML
	private TextField tfB2;
	@FXML
	private TextField tfB3;
	@FXML
	private TextField tfB4;
	@FXML
	private TextField tfB5;
	@FXML
	private TextField tfAC;
	@FXML
	private TextField tfUndy;
	@FXML
	private TextField tfPBuff1;
	@FXML
	private TextField tfPBuff2;

	@FXML
	private TextField tfBS2;
	@FXML
	private TextField tfBS3;
	@FXML
	private TextField tfBS4;
	@FXML
	private TextField tfBS5;
	@FXML
	private TextField tfCap;
	@FXML
	private TextField tfAlarm;

	@FXML
	private CheckBox cbHP;
	@FXML
	private CheckBox cbKapat;
	@FXML
	private CheckBox cbMP;
	@FXML
	private CheckBox cbMG;
	@FXML
	private CheckBox cbMob;
	@FXML
	private CheckBox cbHeal;
	@FXML
	private CheckBox cbMage;
	@FXML
	private CheckBox cbKutu;
	@FXML
	private CheckBox cbFT;
	@FXML
	private CheckBox cbAlarm;
	@FXML
	private CheckBox cbUcBes;
	@FXML
	private CheckBox cbCombo;
	@FXML
	private CheckBox cbNova2;
	@FXML
	private CheckBox cbOne;
	@FXML
	private CheckBox cbSpam6;
	@FXML
	private CheckBox cbSpam7;
	@FXML
	private CheckBox cbSpam8;
	@FXML
	private CheckBox cbMobTanimla;
	@FXML
	private CheckBox cbGeriYuru;
	@FXML
	private CheckBox cbDaire;
	@FXML
	private CheckBox cbKoor;
	@FXML
	private CheckBox cbPTHP;
	@FXML
	private CheckBox cbPTHPKoor;
	@FXML
	private CheckBox cbPTHPKoor2;
	@FXML
	private CheckBox cbHealVeOtur;
	@FXML
	private ChoiceBox cbGen;

	@FXML
	private ImageView imMob;
	@FXML
	private ImageView imKoor, imPTHP;

	@FXML
	private RadioButton rdAcKapat;
	@FXML
	private RadioButton rdAcKapat2;
	@FXML
	private RadioButton rdBasiliTut;
	@FXML
	private RadioButton rdBasiliTut2;
	@FXML
	private RadioButton rdKlavye;
	@FXML
	private RadioButton rdKlavye2;
	@FXML
	private RadioButton rdFare;
	@FXML
	private RadioButton rdFare2;
	@FXML
	private RadioButton rdW;
	@FXML
	private RadioButton rdS;

	private Robot r;
	private Timer timerZ;
	private Timer timerR;
	private Timer timerW;
	private Timer timerS;
	private Timer timerC;
	private Timer timer1;
	private Timer timer2;
	private Timer timer3;
	private Timer timer4;
	private Timer timer5;
	private Timer timer6;
	private Timer timer7;
	private Timer timer8;
	private Timer timer9;
	private Timer timer0;
	private Timer timerHPMP;
	private Timer timerMG;
	private Timer timerHeal;
	private Timer timerUcBes;
	private Timer timerCombo;
	private Timer timerHealBuff;
	private Timer timerEvent;
	private Timer timerAlarm;
	private Timer timerAlan;
	private Timer timerUyeSay;
	private Timer timerHealBuff2;
	private Timer timerTS2;

	private TimerTask taskZ;
	private TimerTask taskR;
	private TimerTask taskW;
	private TimerTask taskS;
	private TimerTask taskC;
	private TimerTask task1;
	private TimerTask task2;
	private TimerTask task3;
	private TimerTask task4;
	private TimerTask task5;
	private TimerTask task6;
	private TimerTask task7;
	private TimerTask task8;
	private TimerTask task9;
	private TimerTask task0;
	private TimerTask taskHPMP;
	private TimerTask taskMG;
	private TimerTask taskHeal;
	private TimerTask taskUcBes;
	private TimerTask taskCombo;
	private TimerTask taskHealBuff;
	private TimerTask taskHealBuff2;
	private TimerTask taskEvent;
	private TimerTask taskAlarm;
	private TimerTask taskAlan;
	private TimerTask taskUyeSay;
	private TimerTask taskTS2;

	int pixelXHP = -1, pixelYHP = -1;
	int pixelXKapat = -1, pixelYKapat = -1;
	int pixelXMP = -1, pixelYMP = -1;
	int pixelXMG = -1, pixelYMG = -1, pixelMobX = -1, pixelMobY = -1, ptHPX = -1, ptHPX2 = -1;
	int buff2 = -1, buff3 = -1, buff4 = -1, buff5 = -1, TS = -1, B2Val, B3Val, B4Val, B5Val;
	List<Integer> uyelerY = new ArrayList<Integer>();
	int uyelerX = -1, uyelerY1 = -1, sonIndex = -1, sonIndexSayac = 0;
	String sec = "";
	StringBuilder carXs, carYs;
	int carX, carY, ilkX, ilkY, koorX, koorY, uyelerFinal = 0;

	int bossX = 448, bossY = 32, bossSayac = 1250;
	float yariCap;
	Color clHP, clKapat, clMP, clPTHP;

	String hpYer, mpYer, mgYer1, mgYer2, healYer, healYer2, ucYer, besYer, klavyeYer, klavyeYer2, fareYer, fareYer2,
			B1Yer, B2Yer, B3Yer, B4Yer, B5Yer, TSYer, TSYer2, PBuff, AC, Undy, pBuff1, pBuff2;
	Boolean heal = false, mage = false, ucBes = false, ucBesBas = false, combo = false, comboBas = false, event = false,
			alarm = false, eventBas = false, kutu = false, tarandi = false, kal = false, mobTanimla = false,
			icerde = false, healVeOtur = true, buffliyorum = false, dogruMob = false;

	private ToggleGroup toggleGroup1;
	private ToggleGroup toggleGroup2;
	private ToggleGroup toggleGroup3;
	private ToggleGroup toggleGroup4;
	private ToggleGroup toggleGroup5;

	NativeKeyListener nlKey, nlG, nlKey2, nlKey3;
	NativeMouseListener nlMouse, nlMouse2;
	NativeMouseMotionListener nlBar;

	public Controller() throws AWTException {
		r = new Robot();

	}

	@FXML
	public void basladur() throws InterruptedException, AWTException, IOException, TesseractException {

		int yariCapIstenen = Integer.valueOf(tfCap.getText().toString());

		String bas1, bekle1, bas2, bekle2, bas3, bekle3, bas4, bekle4, bas5, bekle5;
		bas1 = tfBas1.getText().toString();
		bekle1 = tfBekle1.getText().toString();
		bas2 = tfBas2.getText().toString();
		bekle2 = tfBekle2.getText().toString();
		bas3 = tfBas3.getText().toString();
		bekle3 = tfBekle3.getText().toString();
		bas4 = tfBas4.getText().toString();
		bekle4 = tfBekle4.getText().toString();
		bas5 = tfBas5.getText().toString();
		bekle5 = tfBekle5.getText().toString();

		if (cbDaire.isSelected()) {
			kal = true;
			koordinatOku();
			ilkX = carX;
			ilkY = carY;
		}

		if (cbHealVeOtur.isSelected())
			healVeOtur = true;

		if (vana.isSelected() && !isAllValid()) {
			Alert alert = new Alert(AlertType.WARNING, "Uygun sayı değerleri girin.");
			alert.showAndWait();
			vana.setSelected(false);
		}

		if (vana.isSelected() && isAllValid()) {

			hpYer = tfHP.getText().toString();
			mpYer = tfMP.getText().toString();
			mgYer1 = tfMG1.getText().toString();
			mgYer2 = tfMG2.getText().toString();
			healYer = tfHealtus.getText().toString();
			healYer2 = tfHealtus2.getText().toString();
			ucYer = tfUc.getText().toString();
			besYer = tfBes.getText().toString();
			klavyeYer = tfKlavye.getText().toString();
			fareYer = tfFare.getText().toString();
			klavyeYer2 = tfKlavye2.getText().toString();
			fareYer2 = tfFare2.getText().toString();
			B1Yer = tfB1.getText().toString();
			B2Yer = tfB2.getText().toString();
			B3Yer = tfB3.getText().toString();
			B4Yer = tfB4.getText().toString();
			B5Yer = tfB5.getText().toString();

			TSYer = tfTS.getText().toString();

			TSYer2 = tfTS2.getText().toString();
			AC = tfAC.getText().toString();
			Undy = tfUndy.getText().toString();
			pBuff1 = tfPBuff1.getText().toString();
			pBuff2 = tfPBuff2.getText().toString();

			bufflariSifirla();

			vana.setText("Açık");
			vana.getStyleClass().set(1, "green-button");

			if ((pixelXHP > -1 && pixelYHP > -1) || (pixelXKapat > -1 && pixelYKapat > -1)
					|| (pixelXMP > -1 && pixelYMP > -1)) {

				timerHPMP = new Timer(true);

				taskHPMP = new TimerTask() {

					@Override
					public void run() {

						// System.out.println(r.getPixelColor(pixelXHP, pixelYHP).getRed() + " " +
						// clHP.getRed());
						if ((pixelXHP > -1 && pixelYHP > -1)
								&& r.getPixelColor(pixelXHP, pixelYHP).getRed() < clHP.getRed() - 100) {

							try {
								r.keyPress(KeyEvent.class.getField("VK_" + hpYer).getInt(null));
								r.delay(50);
								r.keyRelease(KeyEvent.class.getField("VK_" + hpYer).getInt(null));
							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// if(r.getPixelColor(pixelXMP, pixelYMP).getColorSpace() !=
							// clMP.getColorSpace())
						}

						try {
							Thread.sleep(50);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						if ((pixelXKapat > -1 && pixelYKapat > -1)
								&& r.getPixelColor(pixelXKapat, pixelYKapat).getRed() < clKapat.getRed() - 100) {

							try {
								Runtime rt = Runtime.getRuntime();

								rt.exec("taskkill /F /IM KnightOnLine.exe");
								System.exit(1);

							} catch (IllegalArgumentException | SecurityException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						try {
							Thread.sleep(50);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						if ((pixelXMP > -1 && pixelYMP > -1)
								&& r.getPixelColor(pixelXMP, pixelYMP).getBlue() < clMP.getBlue() - 100) {

							try {
								r.keyPress(KeyEvent.class.getField("VK_" + mpYer).getInt(null));
								r.delay(50);
								r.keyRelease(KeyEvent.class.getField("VK_" + mpYer).getInt(null));
							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// if(r.getPixelColor(pixelXMP, pixelYMP).getColorSpace() !=
							// clMP.getColorSpace())
						}

					}
				};

				timerHPMP.scheduleAtFixedRate(taskHPMP, 2000, 100);

			}

			if (mage) {

				timerMG = new Timer(true);

				taskMG = new TimerTask() {

					@Override
					public void run() {

						try {
							r.keyPress(KeyEvent.class.getField("VK_" + mgYer1).getInt(null));
							r.delay(50);
							r.keyRelease(KeyEvent.class.getField("VK_" + mgYer1).getInt(null));
							r.delay(300);
							r.mouseMove(pixelXMG + 10, pixelYMG + 10);
							r.delay(50);
							r.mouseMove(pixelXMG - 10, pixelYMG - 10);
							r.delay(100);
							r.mouseMove(pixelXMG, pixelYMG);
							r.delay(100);
							r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
							r.delay(50);
							r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

							if (cbNova2.isSelected()) {
								if (cbOne.isSelected()) {
									r.delay(2000);
								} else {
									r.delay(2500);
									r.mousePress(InputEvent.BUTTON2_DOWN_MASK);
									r.delay(50);
									r.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
									r.delay(1000);
									r.keyPress(KeyEvent.VK_C);
									r.delay(50);
									r.keyRelease(KeyEvent.VK_C);
									r.delay(6000);
								}

								r.keyPress(KeyEvent.class.getField("VK_" + mgYer2).getInt(null));
								r.delay(50);
								r.keyRelease(KeyEvent.class.getField("VK_" + mgYer2).getInt(null));
								r.delay(300);
								r.mouseMove(pixelXMG + 10, pixelYMG + 10);
								r.delay(50);
								r.mouseMove(pixelXMG - 10, pixelYMG - 10);
								r.delay(100);
								r.mouseMove(pixelXMG, pixelYMG);
								r.delay(100);
								r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
								r.delay(50);
								r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
							}

							r.delay(3000);

							if (cbOne.isSelected()) {
								r.keyPress(KeyEvent.VK_S);
								r.delay(50);
								r.keyRelease(KeyEvent.VK_S);
								r.delay(100);
							}

							r.keyPress(KeyEvent.VK_C);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_C);

							if (cbNova2.isSelected() && !cbOne.isSelected()) {
								r.delay(50);
								r.mousePress(InputEvent.BUTTON2_DOWN_MASK);
								r.delay(50);
								r.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
							}

						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};

				timerMG.scheduleAtFixedRate(taskMG, 3000, (long) (Float.valueOf(tfSure.getText().toString()) * 1000));

			}

			if (Float.valueOf(tfZ.getText().toString()) > 0) {

				timerZ = new Timer(true);

				taskZ = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_Z);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_Z);
					}
				};

				timerZ.scheduleAtFixedRate(taskZ, 0, (long) (Float.valueOf(tfZ.getText().toString()) * 1000));

			}

			if (Float.valueOf(tfR.getText().toString()) > 0)

			{
				timerR = new Timer(true);
				taskR = new TimerTask() {
					@Override
					public void run() {
						try {
							if (mobTanimla) {
								if (isDogruMob(pixelMobX, pixelMobY)) {
									r.keyPress(KeyEvent.VK_R);
									r.delay(50);
									r.keyRelease(KeyEvent.VK_R);
								} else {
									r.keyPress(KeyEvent.VK_S);
									r.delay(500);
									r.keyRelease(KeyEvent.VK_S);
								}
							} else {
								r.keyPress(KeyEvent.VK_R);
								r.delay(50);
								r.keyRelease(KeyEvent.VK_R);
							}
						} catch (IOException | AWTException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				timerR.scheduleAtFixedRate(taskR, 0, (long) (Float.valueOf(tfR.getText().toString()) * 1000));
			}

			if (Float.valueOf(tfW.getText().toString()) > 0) {
				timerW = new Timer(true);
				taskW = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_W);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_W);
					}
				};
				timerW.scheduleAtFixedRate(taskW, 0, (long) (Float.valueOf(tfW.getText().toString()) * 1000));
			}
			if (Float.valueOf(tfS.getText().toString()) > 0) {
				timerS = new Timer(true);
				taskS = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_S);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_S);
					}
				};
				timerS.scheduleAtFixedRate(taskS, 0, (long) (Float.valueOf(tfS.getText().toString()) * 1000));
			}
			if (Float.valueOf(tfC.getText().toString()) > 0) {
				timerC = new Timer(true);

				taskC = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_C);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_C);
					}
				};
				timerC.scheduleAtFixedRate(taskC, 0, (long) (Float.valueOf(tfC.getText().toString()) * 1000));
			}

			if (Float.valueOf(tf1.getText().toString()) > 0) {
				timer1 = new Timer(true);
				task1 = new TimerTask() {
					@Override
					public void run() {
						try {
							if (mobTanimla) {
								if (isDogruMob(pixelMobX, pixelMobY)) {
									r.keyPress(KeyEvent.VK_1);
									r.delay(50);
									r.keyRelease(KeyEvent.VK_1);
								}
							} else {
								r.keyPress(KeyEvent.VK_1);
								r.delay(50);
								r.keyRelease(KeyEvent.VK_1);
							}

						} catch (IOException | AWTException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				timer1.scheduleAtFixedRate(task1, 0, (long) (Float.valueOf(tf1.getText().toString()) * 1000));

			}

			if (Float.valueOf(tf2.getText().toString()) > 0) {
				timer2 = new Timer(true);
				task2 = new TimerTask() {
					@Override
					public void run() {
						try {
							if (mobTanimla) {
								if (isDogruMob(pixelMobX, pixelMobY)) {
									r.keyPress(KeyEvent.VK_2);
									r.delay(50);
									r.keyRelease(KeyEvent.VK_2);
								}
							} else {
								r.keyPress(KeyEvent.VK_2);
								r.delay(50);
								r.keyRelease(KeyEvent.VK_2);
							}

						} catch (IOException | AWTException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				timer2.scheduleAtFixedRate(task2, 0, (long) (Float.valueOf(tf2.getText().toString()) * 1000));
			}

			if (Float.valueOf(tf3.getText().toString()) > 0) {
				timer3 = new Timer(true);
				task3 = new TimerTask() {
					@Override
					public void run() {
						try {
							if (mobTanimla) {
								if (isDogruMob(pixelMobX, pixelMobY)) {
									r.keyPress(KeyEvent.VK_3);
									r.delay(50);
									r.keyRelease(KeyEvent.VK_3);
								}
							} else {
								r.keyPress(KeyEvent.VK_3);
								r.delay(50);
								r.keyRelease(KeyEvent.VK_3);
							}
						} catch (IOException | AWTException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				timer3.scheduleAtFixedRate(task3, 0, (long) (Float.valueOf(tf3.getText().toString()) * 1000));
			}

			if (Float.valueOf(tf4.getText().toString()) > 0) {
				timer4 = new Timer(true);

				task4 = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_4);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_4);
					}
				};
				timer4.scheduleAtFixedRate(task4, 0, (long) (Float.valueOf(tf4.getText().toString()) * 1000));
			}

			if (Float.valueOf(tf5.getText().toString()) > 0) {
				timer5 = new Timer(true);

				task5 = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_5);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_5);
					}
				};
				timer5.scheduleAtFixedRate(task5, 0, (long) (Float.valueOf(tf5.getText().toString()) * 1000));
			}
			if (Float.valueOf(tf6.getText().toString()) > 0) {
				timer6 = new Timer(true);

				task6 = new TimerTask() {
					@Override
					public void run() {

						if (cbSpam6.isSelected()) {
							for (int i = 0; i < 2; i++) {
								r.keyPress(KeyEvent.VK_6);
								r.delay(15);
								r.keyRelease(KeyEvent.VK_6);
							}
						} else {
							r.keyPress(KeyEvent.VK_6);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_6);
						}

					}
				};
				timer6.scheduleAtFixedRate(task6, 3000, (long) (Float.valueOf(tf6.getText().toString()) * 1000));
			}
			if (Float.valueOf(tf7.getText().toString()) > 0) {
				timer7 = new Timer(true);
				task7 = new TimerTask() {
					@Override
					public void run() {

						if (cbSpam7.isSelected()) {
							for (int i = 0; i < 3; i++) {
								r.keyPress(KeyEvent.VK_7);
								r.delay(15);
								r.keyRelease(KeyEvent.VK_7);
							}
						} else {
							r.keyPress(KeyEvent.VK_7);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_7);
						}
					}
				};
				timer7.scheduleAtFixedRate(task7, 3000, (long) (Float.valueOf(tf7.getText().toString()) * 1000));
			}
			if (Float.valueOf(tf8.getText().toString()) > 0) {
				timer8 = new Timer(true);
				task8 = new TimerTask() {
					@Override
					public void run() {
						if (cbSpam8.isSelected()) {
							for (int i = 0; i < 3; i++) {
								r.keyPress(KeyEvent.VK_8);
								r.delay(15);
								r.keyRelease(KeyEvent.VK_8);
							}
						} else {
							r.keyPress(KeyEvent.VK_8);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_8);
						}
					}
				};
				timer8.scheduleAtFixedRate(task8, 3000, (long) (Float.valueOf(tf8.getText().toString()) * 1000));
			}

			if (Float.valueOf(tf9.getText().toString()) > 0) {
				timer9 = new Timer(true);
				task9 = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_9);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_9);
					}
				};
				timer9.scheduleAtFixedRate(task9, 0, (long) (Float.valueOf(tf9.getText().toString()) * 1000));
			}
			if (Float.valueOf(tf0.getText().toString()) > 0) {
				timer0 = new Timer(true);
				task0 = new TimerTask() {
					@Override
					public void run() {
						r.keyPress(KeyEvent.VK_0);
						r.delay(50);
						r.keyRelease(KeyEvent.VK_0);
					}
				};
				timer0.scheduleAtFixedRate(task0, 0, (long) (Float.valueOf(tf0.getText().toString()) * 1000));
			}

			if (heal) {

				timerHeal = new Timer(true);

				taskHeal = new TimerTask() {

					@Override
					public void run() {

						try {

							for (int i = 0; i < uyelerFinal; i++) {

								if (!buffliyorum && uyelerY.size() > i) {
									int y = uyelerY.get(i);
									if (!healYer.equals("") && ptHPX > -1 && y > -1
											&& r.getPixelColor(ptHPX, y).getRed() < 100 && r.getPixelColor(ptHPX, y).getGreen() < 100 && r.getPixelColor(ptHPX, y).getBlue() < 100) {

										if (sonIndex == i) {
											sonIndexSayac++;
											if (sonIndexSayac < 4) {

												try {
													r.mouseMove(ptHPX, y);
													r.delay(50);

													r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
													r.delay(30);
													r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
													r.delay(100);

													r.keyPress(KeyEvent.class.getField("VK_" + healYer).getInt(null));
													r.delay(50);
													r.keyRelease(KeyEvent.class.getField("VK_" + healYer).getInt(null));
													r.delay(2000);

													if (healVeOtur) {
														r.keyPress(KeyEvent.VK_C);
														r.delay(50);
														r.keyRelease(KeyEvent.VK_C);
													}
												} catch (IllegalArgumentException | IllegalAccessException
														| NoSuchFieldException | SecurityException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												// if(r.getPixelColor(pixelXMP, pixelYMP).getColorSpace() !=
												// clMP.getColorSpace())

											} else if (sonIndexSayac > 45)
												sonIndexSayac = 0;

										} else {
											try {
												r.mouseMove(ptHPX, y);
												r.delay(50);

												r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
												r.delay(30);
												r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
												r.delay(100);

												r.keyPress(KeyEvent.class.getField("VK_" + healYer).getInt(null));
												r.delay(50);
												r.keyRelease(KeyEvent.class.getField("VK_" + healYer).getInt(null));
												r.delay(2000);

												if (healVeOtur) {
													r.keyPress(KeyEvent.VK_C);
													r.delay(50);
													r.keyRelease(KeyEvent.VK_C);
												}
											} catch (IllegalArgumentException | IllegalAccessException
													| NoSuchFieldException | SecurityException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											sonIndex = i;
											sonIndexSayac = 0;
										}

									} else if (!healYer2.equals("") && ptHPX2 > -1 && y > -1
											&& r.getPixelColor(ptHPX2, y).getRed() < 100 && r.getPixelColor(ptHPX2, y).getGreen() < 100 && r.getPixelColor(ptHPX2, y).getBlue() < 100) {

										if (sonIndex == i) {
											sonIndexSayac++;
											if (sonIndexSayac < 4) {

												try {
													r.mouseMove(ptHPX2, y);
													r.delay(50);

													r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
													r.delay(30);
													r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
													r.delay(100);

													r.keyPress(KeyEvent.class.getField("VK_" + healYer2).getInt(null));
													r.delay(50);
													r.keyRelease(
															KeyEvent.class.getField("VK_" + healYer2).getInt(null));
													r.delay(2000);

													if (healVeOtur) {
														r.keyPress(KeyEvent.VK_C);
														r.delay(50);
														r.keyRelease(KeyEvent.VK_C);
													}
												} catch (IllegalArgumentException | IllegalAccessException
														| NoSuchFieldException | SecurityException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												// if(r.getPixelColor(pixelXMP, pixelYMP).getColorSpace() !=
												// clMP.getColorSpace())

											} else if (sonIndexSayac > 45)
												sonIndexSayac = 0;
										} else {
											try {
												r.mouseMove(ptHPX2, y);
												r.delay(50);

												r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
												r.delay(30);
												r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
												r.delay(100);

												r.keyPress(KeyEvent.class.getField("VK_" + healYer2).getInt(null));
												r.delay(50);
												r.keyRelease(KeyEvent.class.getField("VK_" + healYer2).getInt(null));
												r.delay(2000);

												if (healVeOtur) {
													r.keyPress(KeyEvent.VK_C);
													r.delay(50);
													r.keyRelease(KeyEvent.VK_C);
												}
											} catch (IllegalArgumentException | IllegalAccessException
													| NoSuchFieldException | SecurityException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											sonIndex = i;
											sonIndexSayac = 0;
										}

									}

								}
							}

						} catch (IllegalArgumentException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};

				timerHeal.scheduleAtFixedRate(taskHeal, 3000, 300);

				timerUyeSay = new Timer(true);

				taskUyeSay = new TimerTask() {
					@Override
					public void run() {
						try {
							if (!buffliyorum)
								ptUyeleriBul();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};

				timerUyeSay.scheduleAtFixedRate(taskUyeSay, 4000, 7000);

				timerHealBuff2 = new Timer(true);

				taskHealBuff2 = new TimerTask() {
					@Override
					public void run() {

						try {

							buffliyorum = true;

							for (int i = 0; i < uyelerY.size(); i++) {
								if (uyelerY.size() > i) {
									if (!AC.equals("") || !Undy.equals("")) {

										r.mouseMove(uyelerX, uyelerY.get(i));
										r.delay(50);

										r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
										r.delay(30);
										r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
										r.delay(100);

										if (!AC.equals("")) {
											r.keyPress(KeyEvent.class.getField("VK_" + AC).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + AC).getInt(null));
											r.delay(2000);
										}
										if (!Undy.equals("")) {
											r.keyPress(KeyEvent.class.getField("VK_" + Undy).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + Undy).getInt(null));
											r.delay(2000);
										}
									}

									if (!pBuff1.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + pBuff1).getInt(null));
										r.delay(50);
										r.keyRelease(KeyEvent.class.getField("VK_" + pBuff1).getInt(null));
										r.delay(2000);
									}

									if (!pBuff2.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + pBuff2).getInt(null));
										r.delay(50);
										r.keyRelease(KeyEvent.class.getField("VK_" + pBuff2).getInt(null));
										r.delay(2000);
									}

								}
							}

							if (healVeOtur) {
								r.keyPress(KeyEvent.VK_C);
								r.delay(50);
								r.keyRelease(KeyEvent.VK_C);
							}

							buffliyorum = false;

						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};

				timerHealBuff2.scheduleAtFixedRate(taskHealBuff2, 3000, 604000);

				if (!TSYer2.equals("")) {
					timerTS2 = new Timer(true);

					taskHealBuff2 = new TimerTask() {
						@Override
						public void run() {

							try {
								r.keyPress(KeyEvent.class.getField("VK_" + TSYer2).getInt(null));
								r.delay(50);
								r.keyRelease(KeyEvent.class.getField("VK_" + TSYer2).getInt(null));
							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							r.delay(500);

							r.keyPress(KeyEvent.VK_ENTER);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_ENTER);
							r.delay(300);
							r.keyPress(KeyEvent.VK_ENTER);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_ENTER);

						}
					};

					timerTS2.scheduleAtFixedRate(taskTS2, 3000, 3603000);
				}

			}

			if (ucBes) {

				try {
					GlobalScreen.registerNativeHook();
				} catch (NativeHookException ex) {
					System.err.println("There was a problem registering the native hook.");
					System.err.println(ex.getMessage());
				}

				if (rdKlavye.isSelected()) {

					nlKey = new NativeKeyListener() {

						@Override
						public void nativeKeyTyped(NativeKeyEvent arg0) {

						}

						@Override
						public void nativeKeyReleased(NativeKeyEvent e) {
							try {
								if (rdAcKapat.isSelected() && e.getKeyCode() == NativeKeyEvent.class
										.getField("VC_" + klavyeYer).getInt(null)) {
									ucBesBas = !ucBesBas;
								} else if (rdBasiliTut.isSelected() && e.getKeyCode() == NativeKeyEvent.class
										.getField("VC_" + klavyeYer).getInt(null)) {
									ucBesBas = false;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

						@Override
						public void nativeKeyPressed(NativeKeyEvent e) {

							try {
								if (rdBasiliTut.isSelected() && e.getKeyCode() == NativeKeyEvent.class
										.getField("VC_" + klavyeYer).getInt(null)) {

									ucBesBas = true;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

					};

					GlobalScreen.addNativeKeyListener(nlKey);

				} else if (rdFare.isSelected()) {

					nlMouse = new NativeMouseListener() {

						@Override
						public void nativeMouseReleased(NativeMouseEvent e) {

							try {
								if (rdAcKapat.isSelected() && e.getButton() == NativeMouseEvent.class
										.getField("BUTTON" + fareYer).getInt(null)) {
									ucBesBas = !ucBesBas;
								} else if (rdBasiliTut.isSelected() && e.getButton() == NativeMouseEvent.class
										.getField("BUTTON" + fareYer).getInt(null)) {
									ucBesBas = false;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

						@Override
						public void nativeMousePressed(NativeMouseEvent e) {
							try {
								if (rdBasiliTut.isSelected() && e.getButton() == NativeMouseEvent.class
										.getField("BUTTON" + fareYer).getInt(null)) {

									ucBesBas = true;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

						@Override
						public void nativeMouseClicked(NativeMouseEvent arg0) {
							// TODO Auto-generated method stub

						}
					};
					GlobalScreen.addNativeMouseListener(nlMouse);
				}

				timerUcBes = new Timer(true);

				taskUcBes = new TimerTask() {
					@Override
					public void run() {

						if (ucBesBas) {
							try {

								if (rdW.isSelected()) {

									r.keyPress(KeyEvent.class.getField("VK_" + ucYer).getInt(null));
									r.delay(470);
									r.keyRelease(KeyEvent.class.getField("VK_" + ucYer).getInt(null));

									r.keyPress(KeyEvent.VK_W);
									r.delay(110);
									r.keyRelease(KeyEvent.VK_W);

									r.keyPress(KeyEvent.class.getField("VK_" + besYer).getInt(null));
									r.delay(470);
									r.keyRelease(KeyEvent.class.getField("VK_" + besYer).getInt(null));

									r.keyPress(KeyEvent.VK_W);
									r.delay(110);
									r.keyRelease(KeyEvent.VK_W);

								} else {

									r.keyPress(KeyEvent.class.getField("VK_" + ucYer).getInt(null));
									r.delay(470);
									r.keyRelease(KeyEvent.class.getField("VK_" + ucYer).getInt(null));

									r.keyPress(KeyEvent.VK_S);
									r.delay(110);
									r.keyRelease(KeyEvent.VK_S);

									r.keyPress(KeyEvent.class.getField("VK_" + besYer).getInt(null));
									r.delay(470);
									r.keyRelease(KeyEvent.class.getField("VK_" + besYer).getInt(null));

									r.keyPress(KeyEvent.VK_W);
									r.delay(110);
									r.keyRelease(KeyEvent.VK_W);
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				};

				timerUcBes.scheduleAtFixedRate(taskUcBes, 0,
						(long) (Float.valueOf(tfUcBesSiklik.getText().toString()) * 1000));

			}

			if (combo) {

				try {
					GlobalScreen.registerNativeHook();
				} catch (NativeHookException ex) {
					System.err.println("There was a problem registering the native hook.");
					System.err.println(ex.getMessage());
				}

				if (rdKlavye2.isSelected()) {

					nlKey2 = new NativeKeyListener() {

						@Override
						public void nativeKeyTyped(NativeKeyEvent arg0) {

						}

						@Override
						public void nativeKeyReleased(NativeKeyEvent e) {
							try {
								if (rdAcKapat2.isSelected() && e.getKeyCode() == NativeKeyEvent.class
										.getField("VC_" + klavyeYer2).getInt(null)) {
									comboBas = !comboBas;
								} else if (rdBasiliTut.isSelected() && e.getKeyCode() == NativeKeyEvent.class
										.getField("VC_" + klavyeYer2).getInt(null)) {
									comboBas = false;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

						@Override
						public void nativeKeyPressed(NativeKeyEvent e) {

							try {
								if (rdBasiliTut2.isSelected() && e.getKeyCode() == NativeKeyEvent.class
										.getField("VC_" + klavyeYer2).getInt(null)) {

									comboBas = true;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

					};

					GlobalScreen.addNativeKeyListener(nlKey2);

				} else if (rdFare.isSelected()) {

					nlMouse2 = new NativeMouseListener() {

						@Override
						public void nativeMouseReleased(NativeMouseEvent e) {

							try {
								if (rdAcKapat2.isSelected() && e.getButton() == NativeMouseEvent.class
										.getField("BUTTON" + fareYer2).getInt(null)) {
									comboBas = !comboBas;
								} else if (rdBasiliTut2.isSelected() && e.getButton() == NativeMouseEvent.class
										.getField("BUTTON" + fareYer2).getInt(null)) {
									comboBas = false;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

						@Override
						public void nativeMousePressed(NativeMouseEvent e) {
							try {
								if (rdBasiliTut2.isSelected() && e.getButton() == NativeMouseEvent.class
										.getField("BUTTON" + fareYer2).getInt(null)) {

									comboBas = true;
								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}

						}

						@Override
						public void nativeMouseClicked(NativeMouseEvent arg0) {
							// TODO Auto-generated method stub

						}
					};
					GlobalScreen.addNativeMouseListener(nlMouse);
				}

				timerHealBuff = new Timer(true);

				taskHealBuff = new TimerTask() {
					@Override
					public void run() {

						if (comboBas) {
							if (buff2 > -1)
								buff2++;
							if (buff3 > -1)
								buff3++;
							if (buff4 > -1)
								buff4++;
							if (buff5 > -1)
								buff5++;
							if (TS > -1)
								TS++;
						}
					}
				};

				timerHealBuff.scheduleAtFixedRate(taskHealBuff, 3000, 1000);

				timerCombo = new Timer(true);

				taskCombo = new TimerTask() {
					@Override
					public void run() {

						if (comboBas) {
							try {

								if (tarandi) {
									r.keyPress(KeyEvent.VK_Z);
									r.delay(20);
									r.keyRelease(KeyEvent.VK_Z);
									tarandi = false;
								}

								if (mobTanimla) {
									if (isDogruMob(pixelMobX, pixelMobY)) {
										dogruMob = true;

										if (kal && icerde) {

											if (!bas1.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas1).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas1).getInt(null));
											}
											if (!bekle1.equals(""))
												r.delay((int) (Float.valueOf(bekle1) * 1000));

											if (!bas2.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas2).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas2).getInt(null));
											}
											if (!bekle2.equals(""))
												r.delay((int) (Float.valueOf(bekle2) * 1000));

											if (!bas3.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas3).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas3).getInt(null));
											}
											if (!bekle3.equals(""))
												r.delay((int) (Float.valueOf(bekle3) * 1000));

											if (!bas4.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas4).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas4).getInt(null));
											}
											if (!bekle4.equals(""))
												r.delay((int) (Float.valueOf(bekle4) * 1000));

											if (!bas5.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas5).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas5).getInt(null));
											}
											if (!bekle5.equals(""))
												r.delay((int) (Float.valueOf(bekle5) * 1000));

										} else {

											if (!bas1.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas1).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas1).getInt(null));
											}
											if (!bekle1.equals(""))
												r.delay((int) (Float.valueOf(bekle1) * 1000));

											if (!bas2.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas2).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas2).getInt(null));
											}
											if (!bekle2.equals(""))
												r.delay((int) (Float.valueOf(bekle2) * 1000));

											if (!bas3.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas3).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas3).getInt(null));
											}
											if (!bekle3.equals(""))
												r.delay((int) (Float.valueOf(bekle3) * 1000));

											if (!bas4.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas4).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas4).getInt(null));
											}
											if (!bekle4.equals(""))
												r.delay((int) (Float.valueOf(bekle4) * 1000));

											if (!bas5.equals("")) {
												r.keyPress(KeyEvent.class.getField("VK_" + bas5).getInt(null));
												r.delay(20);
												r.keyRelease(KeyEvent.class.getField("VK_" + bas5).getInt(null));
											}
											if (!bekle5.equals(""))
												r.delay((int) (Float.valueOf(bekle5) * 1000));
										}

									} else {
										dogruMob = false;

										if (!tarandi && kutu) {
											int[] x = { 600, 760, 480, 600, 760, 880 };
											int y1 = 330, y2 = 660;
											Boolean buldum = false;

											for (int m = 0; m < 6; m += 2) {
												for (int i = x[m]; i < x[m + 1]; i += 50) {
													for (int j = y1; j < y2; j += 50) {

														r.delay(25);
														r.mouseMove(i, j);
														r.delay(25);
														r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
														r.delay(15);
														r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

														try {
															if (kutuKontrol(i, j - 150)) {

																for (int k = 0; k < 4; k++) {
																	r.delay(250);
																	r.mouseMove(i + 28, j - 175 + (k * 50));
																	r.delay(250);
																	r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
																	r.delay(50);
																	r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
																}
																j = y2;
																i = x[m + 1];

																buldum = true;
															}

														} catch (IOException | AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}

													}
												}

												if (buldum)
													m = 6;
											}
											tarandi = true;
										}

										if (!B1Yer.equals("")) {
											r.keyPress(KeyEvent.class.getField("VK_" + B1Yer).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + B1Yer).getInt(null));
											r.delay(2000);
										}

										if (!B2Yer.equals("") && buff2 >= B2Val) {
											buff2 = 0;
											r.keyPress(KeyEvent.class.getField("VK_" + B2Yer).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + B2Yer).getInt(null));
											r.delay(2000);
										}

										if (!B3Yer.equals("") && buff3 >= B3Val) {
											buff3 = 0;
											r.keyPress(KeyEvent.class.getField("VK_" + B3Yer).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + B3Yer).getInt(null));
											r.delay(2000);
										}

										if (!B4Yer.equals("") && buff4 >= B4Val) {
											buff4 = 0;
											r.keyPress(KeyEvent.class.getField("VK_" + B4Yer).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + B4Yer).getInt(null));
											r.delay(2000);
										}

										if (!B5Yer.equals("") && buff5 >= B5Val) {
											buff5 = 0;
											r.keyPress(KeyEvent.class.getField("VK_" + B5Yer).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + B5Yer).getInt(null));
											r.delay(2000);
										}

										if (!TSYer.equals("") && TS >= 3603) {
											TS = 0;

											r.keyPress(KeyEvent.class.getField("VK_" + TSYer).getInt(null));
											r.delay(50);
											r.keyRelease(KeyEvent.class.getField("VK_" + TSYer).getInt(null));
											r.delay(500);

											r.keyPress(KeyEvent.VK_ENTER);
											r.delay(50);
											r.keyRelease(KeyEvent.VK_ENTER);
											r.delay(300);
											r.keyPress(KeyEvent.VK_ENTER);
											r.delay(50);
											r.keyRelease(KeyEvent.VK_ENTER);

										}

										if (cbGeriYuru.isSelected()) {
											r.keyPress(KeyEvent.VK_S);
											r.delay(20);
											r.keyRelease(KeyEvent.VK_S);
										}

									}
								} else {

									if (!bas1.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + bas1).getInt(null));
										r.delay(20);
										r.keyRelease(KeyEvent.class.getField("VK_" + bas1).getInt(null));
									}
									if (!bekle1.equals(""))
										r.delay((int) (Float.valueOf(bekle1) * 1000));

									if (!bas2.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + bas2).getInt(null));
										r.delay(20);
										r.keyRelease(KeyEvent.class.getField("VK_" + bas2).getInt(null));
									}
									if (!bekle2.equals(""))
										r.delay((int) (Float.valueOf(bekle2) * 1000));

									if (!bas3.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + bas3).getInt(null));
										r.delay(20);
										r.keyRelease(KeyEvent.class.getField("VK_" + bas3).getInt(null));
									}
									if (!bekle3.equals(""))
										r.delay((int) (Float.valueOf(bekle3) * 1000));

									if (!bas4.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + bas4).getInt(null));
										r.delay(20);
										r.keyRelease(KeyEvent.class.getField("VK_" + bas4).getInt(null));
									}
									if (!bekle4.equals(""))
										r.delay((int) (Float.valueOf(bekle4) * 1000));

									if (!bas5.equals("")) {
										r.keyPress(KeyEvent.class.getField("VK_" + bas5).getInt(null));
										r.delay(20);
										r.keyRelease(KeyEvent.class.getField("VK_" + bas5).getInt(null));
									}
									if (!bekle5.equals(""))
										r.delay((int) (Float.valueOf(bekle5) * 1000));

									if (!kal) {
										r.keyPress(KeyEvent.VK_Z);
										r.delay(20);
										r.keyRelease(KeyEvent.VK_Z);
									}

								}

							} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
									| SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (AWTException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}
				};

				timerCombo.scheduleAtFixedRate(taskCombo, 0,
						(long) (Float.valueOf(tfUcBesSiklik2.getText().toString()) * 1000));

			}

			if (event) {

				timerEvent = new Timer(true);

				taskEvent = new TimerTask() {
					@Override
					public void run() {
						if (eventBas) {
							r.keyPress(KeyEvent.VK_B);
							r.delay(50);
							r.keyRelease(KeyEvent.VK_B);
							r.delay(100);
							r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
							r.delay(50);
							r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
							r.delay(100);
							r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
							r.delay(50);
							r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
							r.delay(100);
							r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
							r.delay(50);
							r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
							r.delay(120);
						}
					}
				};

				timerEvent.scheduleAtFixedRate(taskEvent, 3, 500);

				try {
					GlobalScreen.registerNativeHook();
				} catch (NativeHookException ex) {
					System.err.println("There was a problem registering the native hook.");
					System.err.println(ex.getMessage());
				}

				nlKey3 = new NativeKeyListener() {

					@Override
					public void nativeKeyTyped(NativeKeyEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void nativeKeyReleased(NativeKeyEvent e) {
						if (e.getKeyCode() == NativeKeyEvent.VC_G)
							eventBas = !eventBas;

					}

					@Override
					public void nativeKeyPressed(NativeKeyEvent arg0) {
						// TODO Auto-generated method stub

					}
				};

				GlobalScreen.addNativeKeyListener(nlKey3);

			}

			if (alarm) {

				timerAlarm = new Timer(true);

				taskAlarm = new TimerTask() {
					@Override
					public void run() {
						if (alarm) {

							new Thread(new Runnable() {
								// The wrapper thread is unnecessary, unless it blocks on the
								// Clip finishing; see comments.
								public void run() {
									try {

										Clip clip;

										// current status of clip
										String status;
										AudioInputStream audioInputStream;
										String filePath = "sounds/alarm.wav";

										audioInputStream = AudioSystem
												.getAudioInputStream(new File(filePath).getAbsoluteFile());

										// create clip reference
										clip = AudioSystem.getClip();

										// open audioInputStream to the clip
										clip.open(audioInputStream);
										clip.start();
										Thread.sleep(5000);
										clip.stop();

									} catch (Exception e) {
										System.err.println(e.getMessage());
									}
								}
							}).start();

						}
					}
				};

				timerAlarm.scheduleAtFixedRate(taskAlarm, 2,
						(long) (Float.valueOf(tfAlarm.getText().toString()) * 1000));
			}

			if (kal) {
				timerAlan = new Timer(true);
				taskAlan = new TimerTask() {
					@Override
					public void run() {

						if (combo) {
							try {
								koordinatOku();
							} catch (AWTException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							yariCap = (float) Math.sqrt(Math.abs(ilkX - carX) * Math.abs(ilkX - carX)
									+ Math.abs(ilkY - carY) * Math.abs(ilkY - carY));
							if (yariCap <= yariCapIstenen) {

								if (kal && !dogruMob) {

									r.delay(500);
									r.keyPress(KeyEvent.VK_Z);
									r.delay(20);
									r.keyRelease(KeyEvent.VK_Z);
									// System.out.println(yariCap);

								}
								icerde = true;
							} else {
								if (kal) {
									r.keyPress(KeyEvent.VK_S);
									r.delay(2500);
									r.keyRelease(KeyEvent.VK_S);
									r.delay(500);
								}

								icerde = false;
							}
						}
					}
				};
				timerAlan.scheduleAtFixedRate(taskAlan, 3, 100);
			}

		} else {

			vana.setText("Kapalı");
			vana.getStyleClass().set(1, "red-button");

			GlobalScreen.removeNativeKeyListener(nlKey);
			GlobalScreen.removeNativeMouseListener(nlMouse);
			GlobalScreen.removeNativeKeyListener(nlKey2);
			GlobalScreen.removeNativeMouseListener(nlMouse2);
			GlobalScreen.removeNativeKeyListener(nlKey3);

			try {
				GlobalScreen.unregisterNativeHook();
			} catch (NativeHookException e1) {
				e1.printStackTrace();
			}

			if (timerZ != null)
				timerZ.cancel();
			if (timerR != null)
				timerR.cancel();
			if (timerW != null)
				timerW.cancel();
			if (timerC != null)
				timerC.cancel();
			if (timer1 != null)
				timer1.cancel();
			if (timer2 != null)
				timer2.cancel();
			if (timer3 != null)
				timer3.cancel();
			if (timer4 != null)
				timer4.cancel();
			if (timer5 != null)
				timer5.cancel();
			if (timer6 != null)
				timer6.cancel();
			if (timer7 != null)
				timer7.cancel();
			if (timer8 != null)
				timer8.cancel();
			if (timer9 != null)
				timer9.cancel();
			if (timer0 != null)
				timer0.cancel();
			if (timerHPMP != null)
				timerHPMP.cancel();
			if (timerMG != null)
				timerMG.cancel();
			if (timerHeal != null)
				timerHeal.cancel();
			if (timerUcBes != null)
				timerUcBes.cancel();
			if (timerCombo != null)
				timerCombo.cancel();
			if (timerHealBuff != null)
				timerHealBuff.cancel();
			if (timerEvent != null)
				timerEvent.cancel();
			if (timerAlan != null)
				timerAlan.cancel();
			if (timerUyeSay != null)
				timerUyeSay.cancel();
			if (timerHealBuff2 != null)
				timerHealBuff2.cancel();
			if (timerTS2 != null)
				timerTS2.cancel();
			if (timerAlarm != null)
				timerAlarm.cancel();

			System.gc();

		}
	}

	public Boolean isAllValid() {
		return tfZ.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tfR.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tfW.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tfC.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf1.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf2.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf3.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf4.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf5.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf6.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf7.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf8.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf9.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?")
				&& tf0.getText().toString().matches("\\d{1,3}(\\.\\d{1,3})?");
		// && Integer.valueOf(tfHP.getText().toString()) > -1 &&
		// Integer.valueOf(tfHP.getText().toString()) < 10
		// && Integer.valueOf(tfMP.getText().toString()) > -1 &&
		// Integer.valueOf(tfMP.getText().toString()) < 10
		// && Integer.valueOf(tfMG1.getText().toString()) > -1 &&
		// Integer.valueOf(tfMG1.getText().toString()) < 10
		// && Integer.valueOf(tfMG2.getText().toString()) > -1 &&
		// Integer.valueOf(tfMG2.getText().toString()) < 10;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		String libraryPath = "opencv";
		System.setProperty("opencv", libraryPath);
		Field sysPath = null;
		try {
			sysPath = ClassLoader.class.getDeclaredField("sys_paths");
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sysPath.setAccessible(true);
		try {
			sysPath.set(null, null);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		toggleGroup1 = new ToggleGroup();
		toggleGroup2 = new ToggleGroup();
		toggleGroup3 = new ToggleGroup();

		toggleGroup4 = new ToggleGroup();
		toggleGroup5 = new ToggleGroup();

		rdAcKapat.setToggleGroup(toggleGroup1);
		rdBasiliTut.setToggleGroup(toggleGroup1);

		rdKlavye.setToggleGroup(toggleGroup2);
		rdFare.setToggleGroup(toggleGroup2);

		rdW.setToggleGroup(toggleGroup3);
		rdS.setToggleGroup(toggleGroup3);

		rdAcKapat2.setToggleGroup(toggleGroup4);
		rdBasiliTut2.setToggleGroup(toggleGroup4);

		rdKlavye2.setToggleGroup(toggleGroup5);
		rdFare2.setToggleGroup(toggleGroup5);

		vana.getStyleClass().add(1, "red-button");
		cbHeal.setSelected(false);
		cbMage.setSelected(false);
		cbOne.setDisable(true);
		tfMG2.setDisable(true);
		tfHealtus.setDisable(true);
		tfHealtus2.setDisable(true);
		cbHealVeOtur.setDisable(true);
		cbPTHP.setDisable(true);
		cbPTHPKoor.setDisable(true);
		cbPTHPKoor2.setDisable(true);

		tfSure.setDisable(true);
		tfMG1.setDisable(true);
		tfMG2.setDisable(true);
		cbMG.setDisable(true);
		cbNova2.setDisable(true);

		rdAcKapat.setSelected(true);
		rdW.setSelected(true);
		rdKlavye.setSelected(true);
		cbHealVeOtur.setSelected(true);

		tfUcBesSiklik.setDisable(true);
		tfUc.setDisable(true);
		tfBes.setDisable(true);
		tfKlavye.setDisable(true);
		tfFare.setDisable(true);
		rdAcKapat.setDisable(true);
		rdBasiliTut.setDisable(true);
		rdW.setDisable(true);
		rdS.setDisable(true);
		rdKlavye.setDisable(true);
		rdFare.setDisable(true);

		rdAcKapat2.setSelected(true);
		rdKlavye2.setSelected(true);

		tfUcBesSiklik2.setDisable(true);
		tfKlavye2.setDisable(true);
		tfFare2.setDisable(true);
		rdAcKapat2.setDisable(true);
		rdBasiliTut2.setDisable(true);
		rdKlavye2.setDisable(true);
		rdFare2.setDisable(true);
		cbGeriYuru.setDisable(true);

		tfBas1.setDisable(true);
		tfBekle1.setDisable(true);
		tfBas2.setDisable(true);
		tfBekle2.setDisable(true);
		tfBas3.setDisable(true);
		tfBekle3.setDisable(true);
		tfBas4.setDisable(true);
		tfBekle4.setDisable(true);
		tfBas5.setDisable(true);
		tfBekle5.setDisable(true);

		tfB1.setDisable(true);
		tfB2.setDisable(true);
		tfB3.setDisable(true);
		tfB4.setDisable(true);
		tfB5.setDisable(true);
		tfTS.setDisable(true);

		cbKutu.setDisable(true);
		tfBS2.setDisable(true);
		tfBS3.setDisable(true);
		tfBS4.setDisable(true);
		tfBS5.setDisable(true);

		cbMobTanimla.setDisable(true);
		cbMob.setDisable(true);
		cbDaire.setDisable(true);
		cbKoor.setDisable(true);
		cbGen.setDisable(true);
		tfCap.setDisable(true);

		tfAC.setDisable(true);
		tfUndy.setDisable(true);
		tfPBuff1.setDisable(true);
		tfPBuff2.setDisable(true);
		tfTS2.setDisable(true);

		pixelMobX = 681;
		pixelMobY = 20;
		cbGen.getItems().add("26");
		cbGen.getItems().add("36");
		cbGen.getItems().add("50");
		cbGen.getItems().add("70");
		cbGen.getItems().add("100");
		cbGen.getSelectionModel().select(2);

	}

	public void hpmpSec(Event event) throws AWTException {

		if (event.getSource().equals(cbHP))
			sec = "hp";
		else if (event.getSource().equals(cbMP))
			sec = "mp";
		else if (event.getSource().equals(cbKapat))
			sec = "hpKapat";
		else if (event.getSource().equals(cbMG))
			sec = "mage";
		else if (event.getSource().equals(cbMob))
			sec = "mob";
		else if (event.getSource().equals(cbKoor))
			sec = "yer";
		else if (event.getSource().equals(cbPTHP))
			sec = "pthp";
		else if (event.getSource().equals(cbPTHPKoor))
			sec = "pthpkoor";
		else if (event.getSource().equals(cbPTHPKoor2))
			sec = "pthpkoor2";

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
		}

		nlBar = new NativeMouseMotionListener() {

			@Override
			public void nativeMouseMoved(NativeMouseEvent e) {

				if (sec.equals("hp")) {
					pixelXHP = e.getX() - 1;
					pixelYHP = e.getY() - 1;
				} else if (sec.equals("hpKapat")) {
					pixelXKapat = e.getX() - 1;
					pixelYKapat = e.getY() - 1;
				} else if (sec.equals("mp")) {
					pixelXMP = e.getX() - 1;
					pixelYMP = e.getY() - 1;

				} else if (sec.equals("mage")) {
					pixelXMG = e.getX();
					pixelYMG = e.getY();

				} else if (sec.equals("mob")) {
					pixelMobX = e.getX();
					pixelMobY = e.getY();

				} else if (sec.equals("yer")) {
					koorX = e.getX();
					koorY = e.getY();
				} else if (sec.equals("pthp")) {
					uyelerX = e.getX();
					uyelerY1 = e.getY();
				} else if (sec.equals("pthpkoor")) {
					ptHPX = e.getX();
				} else if (sec.equals("pthpkoor2")) {
					ptHPX2 = e.getX();
				}

			}

			@Override
			public void nativeMouseDragged(NativeMouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		};

		GlobalScreen.addNativeMouseMotionListener(nlBar);

		nlG = new NativeKeyListener() {

			@Override
			public void nativeKeyTyped(NativeKeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void nativeKeyReleased(NativeKeyEvent e) {

				Platform.runLater(new Runnable() {

					@Override
					public void run() {

						if (e.getKeyCode() == NativeKeyEvent.VC_G) {

							// System.out.println("HP: " + pixelXHP + " , " + pixelYHP + " MP: " + pixelXMP
							// + " , " + pixelYMP);
							if (sec.equals("hp")) {
								clHP = r.getPixelColor(pixelXHP, pixelYHP);
								cbHP.setText(pixelXHP + " , " + pixelYHP);
							} else if (sec.equals("hpKapat")) {
								clKapat = r.getPixelColor(pixelXKapat, pixelYKapat);
								cbKapat.setText(pixelXKapat + " , " + pixelYKapat);
							} else if (sec.equals("mp")) {
								clMP = r.getPixelColor(pixelXMP, pixelYMP);
								cbMP.setText(pixelXMP + " , " + pixelYMP);
							} else if (sec.equals("mage")) {
								cbMG.setText(pixelXMG + " , " + pixelYMG);
							} else if (sec.equals("mob")) {
								cbMob.setText(pixelMobX + " , " + pixelMobY);
								try {
									mobIsmiAl();
									cbMob.setSelected(true);
								} catch (IOException | AWTException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else if (sec.equals("yer")) {

								try {
									// koordinatOku();
									File temp = new File("images\\koordinat.jpg");

									Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
									BufferedImage capture = new Robot().createScreenCapture(screenRect)
											.getSubimage(koorX - 32, koorY - 5, 64, 10);
									ImageIO.write(capture, "jpg", temp);
									Image image = SwingFXUtils.toFXImage(capture, null);
									imKoor.setImage(image);
									cbKoor.setSelected(true);
								} catch (AWTException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							} else if (sec.equals("pthp")) {

								try {
									File temp = new File("images\\hp2.jpg");

									Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
									BufferedImage capture = new Robot().createScreenCapture(screenRect)
											.getSubimage(uyelerX - 3, uyelerY1 - 3, 6, 6);
									ImageIO.write(capture, "jpg", temp);
									Image image = SwingFXUtils.toFXImage(capture, null);
									imPTHP.setImage(image);
									cbPTHP.setSelected(true);
									//clPTHP = r.getPixelColor(uyelerX, uyelerY1);

									uyelerY.add(uyelerY1);
									ptUyeleriBul();
									cbPTHP.setText("Üye Sayısı: " + uyelerY.size());
								} catch (AWTException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							} else if (sec.equals("pthpkoor")) {
								cbPTHPKoor.setText("HP X: " + ptHPX);
							} else if (sec.equals("pthpkoor2")) {
								cbPTHPKoor2.setText("HP X: " + ptHPX2);
							}
							sec = "";
							// r.getPixelColor(pixelX, pixelY);

							GlobalScreen.removeNativeKeyListener(nlG);
							GlobalScreen.removeNativeMouseMotionListener(nlBar);

						}

					}
				});

			}

			@Override
			public void nativeKeyPressed(NativeKeyEvent e) {

			}
		};

		GlobalScreen.addNativeKeyListener(nlG);

		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);

	}

	public void healAcKapat(Event e) {
		cbHeal = (CheckBox) e.getSource();
		if (cbHeal.isSelected()) {
			tfHealtus.setDisable(false);
			tfHealtus2.setDisable(false);
			cbHealVeOtur.setDisable(false);
			cbPTHP.setDisable(false);
			cbPTHPKoor.setDisable(false);
			cbPTHPKoor2.setDisable(false);
			tfAC.setDisable(false);
			tfUndy.setDisable(false);
			tfPBuff1.setDisable(false);
			tfPBuff2.setDisable(false);
			tfTS2.setDisable(false);
			heal = true;
		} else {
			tfHealtus.setDisable(true);
			tfHealtus2.setDisable(true);
			cbHealVeOtur.setDisable(true);
			cbPTHP.setDisable(true);
			cbPTHPKoor.setDisable(true);
			cbPTHPKoor2.setDisable(true);
			tfAC.setDisable(true);
			tfUndy.setDisable(true);
			tfPBuff1.setDisable(true);
			tfPBuff2.setDisable(true);
			tfTS2.setDisable(true);
			heal = false;
		}
	}

	public void mageAcKapat(Event e) {
		cbMage = (CheckBox) e.getSource();
		if (cbMage.isSelected()) {
			tfSure.setDisable(false);
			tfMG1.setDisable(false);
			tfSure.setText("30.7");
			cbMG.setDisable(false);
			cbNova2.setDisable(false);
			cbNova2.setSelected(false);
			mage = true;
		} else {
			tfSure.setDisable(true);
			tfMG1.setDisable(true);
			tfMG2.setDisable(true);
			cbOne.setDisable(true);
			cbMG.setDisable(true);
			cbNova2.setDisable(true);
			mage = false;
		}
	}

	public void ucBesAcKapat(Event e) {
		cbUcBes = (CheckBox) e.getSource();
		if (cbUcBes.isSelected()) {
			tfUcBesSiklik.setDisable(false);
			tfUc.setDisable(false);
			tfBes.setDisable(false);
			tfKlavye.setDisable(false);
			tfFare.setDisable(false);
			rdAcKapat.setDisable(false);
			rdBasiliTut.setDisable(false);
			rdW.setDisable(false);
			rdS.setDisable(false);
			rdKlavye.setDisable(false);
			rdFare.setDisable(false);

			ucBes = true;
		} else {
			tfUcBesSiklik.setDisable(true);
			tfUc.setDisable(true);
			tfBes.setDisable(true);
			tfKlavye.setDisable(true);
			tfFare.setDisable(true);
			rdAcKapat.setDisable(true);
			rdBasiliTut.setDisable(true);
			rdW.setDisable(true);
			rdS.setDisable(true);
			rdKlavye.setDisable(true);
			rdFare.setDisable(true);

			ucBes = false;
		}
	}

	public void eventAcKapat(Event e) {
		cbFT = (CheckBox) e.getSource();
		if (cbFT.isSelected())
			event = true;
		else
			event = false;
	}

	public void alarmAcKapat(Event e) {
		cbAlarm = (CheckBox) e.getSource();
		if (cbAlarm.isSelected())
			alarm = true;
		else
			alarm = false;
	}

	public void mobAcKapat(Event e) {
		cbMobTanimla = (CheckBox) e.getSource();
		if (cbMobTanimla.isSelected())
			mobTanimla = true;
		else
			mobTanimla = false;
	}

	public void kutuAcKapat(Event e) {
		cbKutu = (CheckBox) e.getSource();
		if (cbKutu.isSelected()) {
			kutu = true;
		} else {
			kutu = false;
		}
	}

	public void comboAcKapat(Event e) {
		cbCombo = (CheckBox) e.getSource();

		if (cbDaire.isSelected())
			kal = true;
		else
			kal = false;

		if (cbCombo.isSelected()) {
			tfUcBesSiklik2.setDisable(false);
			tfKlavye2.setDisable(false);
			tfFare2.setDisable(false);
			rdAcKapat2.setDisable(false);
			rdBasiliTut2.setDisable(false);
			rdKlavye2.setDisable(false);
			rdFare2.setDisable(false);
			cbGeriYuru.setDisable(false);
			cbKutu.setDisable(false);
			cbMobTanimla.setDisable(false);
			cbMob.setDisable(false);
			cbDaire.setDisable(false);
			cbKoor.setDisable(false);
			cbGen.setDisable(false);
			tfCap.setDisable(false);

			tfB1.setDisable(false);
			tfB2.setDisable(false);
			tfB3.setDisable(false);
			tfB4.setDisable(false);
			tfB5.setDisable(false);
			tfTS.setDisable(false);

			tfBS2.setDisable(false);
			tfBS3.setDisable(false);
			tfBS4.setDisable(false);
			tfBS5.setDisable(false);

			tfBas1.setDisable(false);
			tfBekle1.setDisable(false);
			tfBas2.setDisable(false);
			tfBekle2.setDisable(false);
			tfBas3.setDisable(false);
			tfBekle3.setDisable(false);
			tfBas4.setDisable(false);
			tfBekle4.setDisable(false);
			tfBas5.setDisable(false);
			tfBekle5.setDisable(false);

			combo = true;

		} else {
			tfUcBesSiklik2.setDisable(true);
			tfKlavye2.setDisable(true);
			tfFare2.setDisable(true);
			rdAcKapat2.setDisable(true);
			rdBasiliTut2.setDisable(true);
			rdKlavye2.setDisable(true);
			rdFare2.setDisable(true);
			cbGeriYuru.setDisable(true);
			cbKutu.setDisable(true);

			cbMobTanimla.setDisable(true);
			cbMob.setDisable(true);
			cbDaire.setDisable(true);
			cbKoor.setDisable(true);
			cbGen.setDisable(true);
			tfCap.setDisable(true);

			tfB1.setDisable(true);
			tfB2.setDisable(true);
			tfB3.setDisable(true);
			tfB4.setDisable(true);
			tfB5.setDisable(true);
			tfTS.setDisable(true);

			tfBS2.setDisable(true);
			tfBS3.setDisable(true);
			tfBS4.setDisable(true);
			tfBS5.setDisable(true);

			tfBas1.setDisable(true);
			tfBekle1.setDisable(true);
			tfBas2.setDisable(true);
			tfBekle2.setDisable(true);
			tfBas3.setDisable(true);
			tfBekle3.setDisable(true);
			tfBas4.setDisable(true);
			tfBekle4.setDisable(true);
			tfBas5.setDisable(true);
			tfBekle5.setDisable(true);

			combo = false;
		}
	}

	public void ikinciAcKapat(Event e) {
		cbNova2 = (CheckBox) e.getSource();
		if (cbNova2.isSelected()) {
			tfMG2.setDisable(false);
			cbOne.setDisable(false);
		} else {
			tfMG2.setDisable(true);
			cbOne.setDisable(true);
		}
	}

	public void hpmpIptal() {

		pixelXHP = -1;
		pixelYHP = -1;
		pixelXKapat = -1;
		pixelYKapat = -1;
		pixelXMP = -1;
		pixelYMP = -1;

		cbHP.setSelected(false);
		cbMP.setSelected(false);
		cbMob.setSelected(false);
		cbKapat.setSelected(false);
		cbKapat.setText("Koordinat Seç (G)");
		cbHP.setText("Koordinat Seç (G)");
		cbMP.setText("Koordinat Seç (G)");

	}

	public void mobIptal() {

		pixelMobX = 681;
		pixelMobY = 20;

		cbMob.setSelected(false);
		cbMob.setText("681 , 20");
		imMob.setImage(null);

	}

	public void spamSaniye(Event e) {

		if (e.getSource().equals(cbSpam6)) {
			if (cbSpam6.isSelected())
				tf6.setText("121");
			else
				tf6.setText("0");
		} else if (e.getSource().equals(cbSpam7)) {
			if (cbSpam7.isSelected())
				tf7.setText("29");
			else
				tf7.setText("0");

		} else if (e.getSource().equals(cbSpam8)) {

			if (cbSpam8.isSelected())
				tf8.setText("15");
			else
				tf8.setText("0");

		}

	}

	public Boolean isDogruMob(int x, int y) throws IOException, AWTException {

		int gen = Integer.valueOf(cbGen.getSelectionModel().getSelectedItem().toString());
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect).getSubimage(x - (gen / 2), y - 5, gen, 10);

		File kayitliMob = new File("images\\mob.png");
		BufferedImage kayit = ImageIO.read(kayitliMob);

		// ImageIO.write(capture, "jpg", temp);

		float toplam = capture.getWidth() * capture.getHeight(), fark = 1;

		for (int i = 0; i < capture.getWidth(); i++) {
			for (int j = 0; j < capture.getHeight(); j++) {
				int rgba1 = capture.getRGB(i, j);
				int rgba2 = kayit.getRGB(i, j);
				Color col1 = new Color(rgba1, true);
				Color col2 = new Color(rgba2, true);

				if (Math.abs(col1.getRed() - col2.getRed()) > 10 || Math.abs(col1.getGreen() - col2.getGreen()) > 10
						|| Math.abs(col1.getBlue() - col2.getBlue()) > 10)
					fark++;

				// capture.setRGB(i, j, col.getRGB());
			}
		}

		float yuzdeHata = (fark / toplam) * 100;

		// System.out.println(yuzdeHata);

		if (yuzdeHata < 55)
			return true;
		else
			return false;

		// ImageHelper.convertImageToGrayscale(capture);

		// ITesseract instance = new Tesseract();

		// instance.doOCR(temp);
		// System.out.println(ImageReader.extractImage("C:\\Users\\harun088\\Desktop\\temp.png"));
	}

	public void mobIsmiAl() throws IOException, AWTException {

		int gen = Integer.valueOf(cbGen.getSelectionModel().getSelectedItem().toString());
		File temp = new File("images\\mob.png");
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect).getSubimage(pixelMobX - (gen / 2),
				pixelMobY - 5, gen, 10);

		ImageIO.write(capture, "png", temp);

		Image image = SwingFXUtils.toFXImage(capture, null);

		imMob.setImage(image);
	}

	public Boolean kutuKontrol(int x, int y) throws IOException, AWTException {

		int gen = 6;
		int yuk = 208;
		BufferedImage capture;
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		File kayitliKutu = new File("images\\kutu.jpg");
		BufferedImage kayit = ImageIO.read(kayitliKutu);

		capture = r.createScreenCapture(screenRect).getSubimage(x, y, gen, yuk);

		// ImageIO.write(capture, "jpg", temp);

		float toplam = capture.getWidth() * capture.getHeight(), fark = 1;

		for (int i = 0; i < capture.getWidth(); i++) {
			for (int j = 0; j < capture.getHeight(); j++) {
				int rgba1 = capture.getRGB(i, j);
				int rgba2 = kayit.getRGB(i, j);
				Color col1 = new Color(rgba1, true);
				Color col2 = new Color(rgba2, true);

				if (Math.abs(col1.getRed() - col2.getRed()) > 10 || Math.abs(col1.getGreen() - col2.getGreen()) > 10
						|| Math.abs(col1.getBlue() - col2.getBlue()) > 10)
					fark++;
			}
		}
		// capture.setRGB(i, j, col.getRGB()); } }

		float yuzdeHata = (fark / toplam) * 100;

		// System.out.println(yuzdeHata);

		if (yuzdeHata < 70)
			return true;
		else
			return false;

	}

	public void bufflariSifirla() {

		if (!tfBS2.getText().toString().equals("")) {
			B2Val = Integer.valueOf(tfBS2.getText().toString());
			buff2 = B2Val;
		}
		if (!tfBS3.getText().toString().equals("")) {
			B3Val = Integer.valueOf(tfBS3.getText().toString());
			buff3 = B3Val;
		}
		if (!tfBS4.getText().toString().equals("")) {
			B4Val = Integer.valueOf(tfBS4.getText().toString());
			buff4 = B4Val;
		}
		if (!tfBS5.getText().toString().equals("")) {
			B5Val = Integer.valueOf(tfBS5.getText().toString());
			buff5 = B5Val;
		}
		TS = 3603;
	}

	public void koordinatOku() throws AWTException, IOException {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		File temp = new File("images\\koordinat.jpg");
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect).getSubimage(koorX - 32, koorY - 5, 64, 10);

		ImageIO.write(capture, "jpg", temp);

		Mat source = Imgcodecs.imread("images\\koordinat.jpg");

		Mat resizeimage = new Mat();
		Size sz = new Size(source.cols() * 3, source.rows() * 3);
		Imgproc.resize(source, resizeimage, sz);

		Mat dest = new Mat();
		dest = new Mat(resizeimage.rows(), resizeimage.cols(), resizeimage.type());
		Imgproc.GaussianBlur(resizeimage, dest, new Size(0, 0), 10);
		Core.addWeighted(resizeimage, 1.5, dest, -1.5, 0, dest);

		Mat res = new Mat();
		Imgproc.cvtColor(dest, res, Imgproc.COLOR_RGB2GRAY);

		Imgcodecs.imwrite("images\\koordinat.jpg", res);

		File imageFile = new File("images\\koordinat.jpg");
		ITesseract instance = new Tesseract(); // JNA Interface Mapping
		// ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		instance.setDatapath("tessdata"); // path to tessdata directory

		carXs = new StringBuilder();
		carYs = new StringBuilder();

		try {
			String result = instance.doOCR(imageFile);

			Boolean birde = true;
			for (int i = 0; i < result.length(); i++) {
				if (birde && result.substring(i, i + 1).matches("^\\d+$"))
					carXs.append(result.substring(i, i + 1));
				else if (birde && !result.substring(i, i + 1).matches("^\\d+$") && carXs.length() > 0)
					birde = false;

				if (!birde && result.substring(i, i + 1).matches("^\\d+$"))
					carYs.append(result.substring(i, i + 1));
			}

			if (carXs.length() > 0 && carYs.length() > 0) {
				carX = Integer.valueOf(carXs.toString());
				carY = Integer.valueOf(carYs.toString());
			}
			// System.out.println(carX+" , "+carY);
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}

	public void ptUyeleriBul() throws IOException {

		int gen = 6;
		int yuk = 6;
		BufferedImage capture;
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		File kayitliHP = new File("images\\hp.jpg");
		BufferedImage kayit = ImageIO.read(kayitliHP);

		uyelerY = new ArrayList<Integer>();
		uyelerY.add(uyelerY1);

		for (int m = uyelerY1 + 40; m < uyelerY1 + 450; m += 2) {

			if (m > 5 && m < 700) {
				capture = r.createScreenCapture(screenRect).getSubimage(uyelerX - 3, m - 3, gen, yuk);

				// ImageIO.write(capture, "jpg", temp);

				float toplam = capture.getWidth() * capture.getHeight();

				for (int n = 0; n < 4; n++) {
					float fark = 1;

					for (int i = 0; i < capture.getWidth(); i++) {
						for (int j = 0; j < capture.getHeight(); j++) {

							int rgba1 = capture.getRGB(i, j);
							int rgba2 = kayit.getRGB((n * 6) + i, j);
							Color col1 = new Color(rgba1, true);
							Color col2 = new Color(rgba2, true);

							if (Math.abs(col1.getRed() - col2.getRed()) > 70
									|| Math.abs(col1.getGreen() - col2.getGreen()) > 70
									|| Math.abs(col1.getBlue() - col2.getBlue()) > 70)
								fark++;
						}
					}
					// capture.setRGB(i, j, col.getRGB()); } }

					float yuzdeHata = (fark / toplam) * 100;

					if (uyelerY.size() < 8) {

						if (yuzdeHata < 30) {
							uyelerY.add(m);
							m += 51;
							break;
						}
					} else {
						m = uyelerY.get(0) + 500;
					}

				}
			}

		}

		uyelerFinal = uyelerY.size();

	}

	public void bossBul() throws IOException {

		int gen = 16;
		int yuk = 22;

		BufferedImage capture;
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

		File kayitliHP = new File("images\\uniq.jpg");
		BufferedImage kayit = ImageIO.read(kayitliHP);

		capture = r.createScreenCapture(screenRect).getSubimage(bossX - 8, bossY - 11, gen, yuk);

		// ImageIO.write(capture, "jpg", temp);

		float toplam = capture.getWidth() * capture.getHeight(), fark = 1;

		for (int i = 0; i < capture.getWidth(); i++) {
			for (int j = 0; j < capture.getHeight(); j++) {

				int rgba1 = capture.getRGB(i, j);
				int rgba2 = kayit.getRGB(i, j);
				Color col1 = new Color(rgba1, true);
				Color col2 = new Color(rgba2, true);

				if (Math.abs(col1.getRed() - col2.getRed()) > 60 || Math.abs(col1.getGreen() - col2.getGreen()) > 60
						|| Math.abs(col1.getBlue() - col2.getBlue()) > 60)
					fark++;
			}
		}
		// capture.setRGB(i, j, col.getRGB()); } }

		float yuzdeHata = (fark / toplam) * 100;

		if (yuzdeHata < 40) {

		}

	}

	public Boolean bossVar() throws AWTException, IOException, TesseractException {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		File temp = new File("images\\boss.jpg");
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect).getSubimage(bossX + 8, bossY - 11, 450, 16);

		ImageIO.write(capture, "jpg", temp);

		Mat source = Imgcodecs.imread("images\\boss.jpg");

		Mat resizeimage = new Mat();
		Size sz = new Size(source.cols() * 3, source.rows() * 3);
		Imgproc.resize(source, resizeimage, sz);

		Mat dest = new Mat();
		dest = new Mat(resizeimage.rows(), resizeimage.cols(), resizeimage.type());
		Imgproc.GaussianBlur(resizeimage, dest, new Size(0, 0), 10);
		Core.addWeighted(resizeimage, 1.5, dest, -1.5, 0, dest);

		Mat res = new Mat();
		Imgproc.cvtColor(dest, res, Imgproc.COLOR_RGB2GRAY);

		Imgcodecs.imwrite("images\\boss.jpg", res);

		File imageFile = new File("images\\boss.jpg");
		ITesseract instance = new Tesseract(); // JNA Interface Mapping
		// ITesseract instance = new Tesseract1(); // JNA Direct Mapping
		instance.setDatapath("tessdata"); // path to tessdata directory

		String result = instance.doOCR(imageFile);

		return result.contains("unique") ? true : false;
	}

}
