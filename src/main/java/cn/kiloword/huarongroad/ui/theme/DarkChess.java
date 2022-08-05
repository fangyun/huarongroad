package cn.kiloword.huarongroad.ui.theme;

import javafx.scene.image.Image;

public class DarkChess implements ChessAssets {
	public Image getHuangzhong() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/huangzhong.png"));
	}

	public Image getCaocao() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/caocao.png"));
	}

	public Image getZhaoyun() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/zhaoyun.png"));
	}

	public Image getMachao() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/machao.png"));
	}

	public Image getZhangfei() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/zhangfei.png"));
	}

	public Image getGuanyu() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/guanyu.png"));
	}

	public Image getZu() {
		return new Image(DarkChess.class.getResourceAsStream("/drawable/zu.png"));
	}
}