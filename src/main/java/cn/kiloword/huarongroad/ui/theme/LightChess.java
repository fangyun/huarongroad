package cn.kiloword.huarongroad.ui.theme;

import javafx.scene.image.Image;

public class LightChess implements ChessAssets {
	public Image getHuangzhong() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/huangzhong_2.png"));
	}

	public Image getCaocao() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/caocao_2.png"));
	}

	public Image getZhaoyun() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/zhaoyun_2.png"));
	}

	public Image getMachao() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/machao_2.png"));
	}

	public Image getZhangfei() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/zhangfei_2.png"));
	}

	public Image getGuanyu() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/guanyu_2.png"));
	}

	public Image getZu() {
		return new Image(LightChess.class.getResourceAsStream("/drawable/zu_2.png"));
	}
}