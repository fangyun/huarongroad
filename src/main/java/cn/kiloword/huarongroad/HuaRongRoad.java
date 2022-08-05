/**
 * @Copyright kiloword.cn
 */
package cn.kiloword.huarongroad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Fang Yun
 *
 */
public class HuaRongRoad extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ChessBoard cb = new ChessBoard();
		Scene scene = cb.opening();
		primaryStage.setTitle("华容道");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}