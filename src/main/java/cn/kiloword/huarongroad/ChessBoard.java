/**
 * @Copyright kiloword.cn
 */
package cn.kiloword.huarongroad;

import static cn.kiloword.huarongroad.Chess.BOARD_HEIGHT;
import static cn.kiloword.huarongroad.Chess.BOARD_WIDTH;
import static cn.kiloword.huarongroad.Chess.BORAD_GRID_PX;
import static cn.kiloword.huarongroad.Constants.cao;
import static cn.kiloword.huarongroad.Constants.guan;
import static cn.kiloword.huarongroad.Constants.huang;
import static cn.kiloword.huarongroad.Constants.ma;
import static cn.kiloword.huarongroad.Constants.zhang;
import static cn.kiloword.huarongroad.Constants.zhao;
import static cn.kiloword.huarongroad.Constants.zu;

import java.util.ArrayList;
import java.util.List;

import cn.kiloword.util.IntOffset;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @author Fang Yun
 *
 */
public class ChessBoard {
	class Triple {
		public Chess chess;
		public Integer x;
		public Integer y;

		Triple(Chess n, Integer x, Integer y) {
			this.chess = n;
			this.x = x;
			this.y = y;
		}
	}

	private List<Triple> state;

	public Scene opening() {
		state = new ArrayList<Triple>();
		state.add(new Triple(zhang, 0, 0));
		state.add(new Triple(cao, 1, 0));
		state.add(new Triple(zhao, 3, 0));
		state.add(new Triple(huang, 0, 2));
		state.add(new Triple(ma, 3, 2));
		state.add(new Triple(guan, 1, 2));
		state.add(new Triple(zu[0], 0, 4));
		state.add(new Triple(zu[1], 1, 3));
		state.add(new Triple(zu[2], 2, 3));
		state.add(new Triple(zu[3], 3, 4));

		Pane pan = new Pane();
		pan.setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);
		state.forEach(t -> {
			ImageView iv = new ImageView(t.chess.getAsset());
			iv.setFitWidth(t.chess.getWidth());
			iv.setFitHeight(t.chess.getHeight());
			t.chess.moveBy(new IntOffset(t.x * BORAD_GRID_PX, t.y * BORAD_GRID_PX));
			iv.relocate(t.chess.getLeft(), t.chess.getTop());
			pan.getChildren().add(iv);
			makeDraggable(t, iv);
		});

		Scene scene = new Scene(pan, BOARD_WIDTH, BOARD_HEIGHT);
		scene.setFill(Color.BROWN);
		return scene;
	}

	private double startX;
	private double startY;

	void makeDraggable(Triple t, ImageView iv) {
		iv.setOnMousePressed(e -> {
			startX = e.getSceneX() - iv.getTranslateX();
			startY = e.getSceneY() - iv.getTranslateY();
		});
		iv.setOnMouseDragged(e -> {
			double deltaX = e.getSceneX() - startX;
			double deltaY = e.getSceneY() - startY;
			List<Chess> chessState = state.stream().map(it -> it.chess).toList();
			for (int i = 0; i < chessState.size(); i++) {
				Chess it = chessState.get(i);
				if (it.getName().equals(t.chess.getName())) {
					if (deltaX != 0) {
						Chess c = it.checkAndMoveX((int) deltaX, chessState);
						if (c != null) {
							iv.relocate(c.getLeft(), c.getTop());
						}
					}
					if (deltaY != 0) {
						Chess c = it.checkAndMoveY((int) deltaY, chessState);
						if (c != null) {
							iv.relocate(c.getLeft(), c.getTop());
						}
					}
				}
			}
		});
	}
}
