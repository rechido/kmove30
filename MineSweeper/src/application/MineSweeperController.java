package application;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MineSweeperController implements Initializable {
	// 디버깅용 log
	private Logger log = Logger.getLogger(this.getClass());
	// 메인 앱 참조
	private Main main;

	public void setMain(Main main) {
		this.main = main;
	}

	private Button[] btns;

	public void setBtns(Button[] btns) {
		this.btns = btns;
	}

	private String[] texts = new String[9 * 9];

	public void initializeTexts() {
		for (int cnt = 0; cnt < texts.length; cnt++)
			this.texts[cnt] = "";
		for (int cnt = 0; cnt < btns.length; cnt++) {
			this.btns[cnt].setText("");
			this.btns[cnt].setDisable(false);
		}

	}

	int width, height;

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@FXML
	private Button restart;
	@FXML
	private AnchorPane gamePane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		restart.setOnAction(e -> restartAction(e));
	}

	public void restartAction(ActionEvent event) {
		restart();
	}

	public void restart() {
		initializeTexts();
		installBomb();
		installNumbers();
		xCount = 0;
		// showTexts();
	}

	public AnchorPane getGamePane() {
		return gamePane;
	}

	public void setGamePane(AnchorPane gamePane) {
		this.gamePane = gamePane;
	}

	public void installBomb() {
		Random random = new Random();
		int max = main.getWidth() * main.getHeight();
		int bombCount = main.getBombCount();
		Set<Integer> generated = new LinkedHashSet<Integer>(); // 중복추첨방지용
		while(generated.size()<10) {
			Integer next = random.nextInt(max);
			// As we're adding to a set, this will automatically do a containment check
			generated.add(next);
		}
		log.info(generated);
		Iterator<Integer> iter = generated.iterator();
		while (iter.hasNext()) {
			int num = iter.next();
			texts[num] = "B";
		}

	}

	public void installNumbers() {
		int row = 0, col = 0;

		for (row = 0; row < height; row++)
			for (col = 0; col < width; col++) {

				int bombCount = 0;
				if (texts[row * width + col].equals("B"))
					continue;
				else {
					for (int i = row - 1; i <= row + 1; i++)
						for (int j = col - 1; j <= col + 1; j++) {
							if (i == row && j == col)
								continue;
							else if (i < 0 || i >= height || j < 0 || j >= width)
								continue;
							else if (texts[i * width + j].equals("B"))
								bombCount += 1;
						}
					int num = row * width + col;
					int num2 = bombCount;
					texts[num] = String.valueOf(num2);

				}
			}
	}

	public void installButtons() {
		for (int cnt = 0; cnt < btns.length; cnt++) {
			int num = cnt;
			btns[num].addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					MouseButton button = event.getButton();
	                if(button==MouseButton.PRIMARY){
	                	leftClickAction(num);
	                }else if(button==MouseButton.SECONDARY){
	                	rightClickAction(num);
	                }
				}
			});

		}

	}

	public void leftClickAction(int position) {
		
		int row = position / width;
		int col = position % width;
		click(row, col);
	}

	public void click(int row, int col) {
		if (btns[row * width + col].isDisabled())
			return;
		else if(btns[row * width + col].getText().equals("X"))
			return;
		if (texts[row * width + col].equals("B")) {
			btns[row * width + col].setText(texts[row * width + col]);
			btns[row * width + col].setDisable(true);
			main.alertMessage("Bomb!", "You died.");
			restart();
		} else if (texts[row * width + col].equals("0")) {
			btns[row * width + col].setText(texts[row * width + col]);
			btns[row * width + col].setDisable(true);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					for (int i = row - 1; i <= row + 1; i++)
						for (int j = col - 1; j <= col + 1; j++) {
							if (i == row && j == col)
								continue;
							else if (i < 0 || i >= height || j < 0 || j >= width)
								continue;
							else
								click(i, j);
						}
				}
			});

		} else {
			btns[row * width + col].setText(texts[row * width + col]);
			btns[row * width + col].setDisable(true);
		}
		// log.info("btn " + row + " " + col);
	}
	
	private int xCount = 0;
	
	public void rightClickAction(int position) {
		if(btns[position].getText().equals("X")) {
			btns[position].setText("");
			xCount--;
		}
		else {
			btns[position].setText("X");
			xCount++;
			if(xCount==main.getBombCount()) {
				for(int cnt=0; cnt<btns.length; cnt++)
					if(btns[cnt].getText().equals("X") && !texts[cnt].equals("B")) {
						main.alertMessage("Wrong answer!", "You died.");
						restart();
						return;
					}
				main.setEndTime(System.currentTimeMillis());
				long elapsedTime = main.getEndTime() - main.getStartTime();
				elapsedTime = elapsedTime / 1000;
				main.alertMessage("Success!", "You Won.\n" + elapsedTime + "초");
				main.showMain();
			}
				
		}
			
	}

	public void printTexts() {
		for (int cnt = 0; cnt < texts.length; cnt++) {
			log.info(String.format("texts[%d] = %s", cnt, texts[cnt]));
		}
	}

	public void showTexts() {
		for (int cnt = 0; cnt < btns.length; cnt++) {
			btns[cnt].setText(texts[cnt]);
		}
	}

}
