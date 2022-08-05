package cn.kiloword.huarongroad.ui.theme;

import javafx.scene.image.Image;

public class WoodChess implements ChessAssets {
	public Image getHuangzhong() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/huangzhong_3.png"));
	}

	public Image getCaocao() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/caocao_3.png"));
	}

	public Image getZhaoyun() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/zhaoyun_3.png"));
	}

	public Image getMachao() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/machao_3.png"));
	}

	public Image getZhangfei() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/zhangfei_3.png"));
	}

	public Image getGuanyu() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/guanyu_3.png"));
	}

	public Image getZu() {
		return new Image(WoodChess.class.getResourceAsStream("/drawable/zu_3.png"));
	}
}