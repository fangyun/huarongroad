/**
 * @Copyright kiloword.cn
 */
package cn.kiloword.huarongroad;

import java.util.ArrayList;
import java.util.List;

import cn.kiloword.util.IntOffset;
import cn.kiloword.util.IntRange;
import javafx.scene.image.Image;

/**
 * @author Fang Yun
 *
 */
public class Chess {
	public static final int BORAD_GRID_PX = 100;
	public static final int BOARD_WIDTH = BORAD_GRID_PX * 4;
	public static final int BOARD_HEIGHT = BORAD_GRID_PX * 5;

	private String name;// 角色名称
	private Image asset; // 角色图片
	public Integer w = 0; // 棋子宽度
	public Integer h = 0; // 棋子长度
	private IntOffset offset = new IntOffset(0, 0); // 偏移量

	private int bottom;
	private int left;
	private int right;
	private int top;
	private int height;
	private int width;

	public Chess(String name, Image asset, Integer w, Integer h) {
		this.name = name;
		this.asset = asset;
		this.w = w;
		this.h = h;
		this.offset = new IntOffset(0, 0);
		recalculate();
	}

	private void recalculate() {
		getLeft();
		getRight();
		getTop();
		getBottom();
	}

	public IntOffset getOffset() {
		return offset;
	}

	public Integer getW() {
		return w;
	}

	public Integer getH() {
		return h;
	}

	public String getName() {
		return name;
	}

	public Chess() {
	}

	public Chess moveBy(IntOffset offset) {
		this.offset = this.offset.add(offset);
		recalculate();
		return copy(this);
	}

	private Chess copy(Chess chess) {
		Chess n = new Chess();
		n.name = chess.name;
		n.asset = chess.asset;
		n.w = chess.w;
		n.h = chess.h;
		n.offset = chess.offset;
		n.recalculate();
		return n;
	}

	public Chess moveByX(int x) {
		return moveBy(new IntOffset(x, 0));
	}

	public Chess moveByY(int y) {
		return moveBy(new IntOffset(0, y));
	}

	int getWidth() {
		width = w * BORAD_GRID_PX;
		return width;
	}

	int getHeight() {
		height = h * BORAD_GRID_PX;
		return height;
	}

	int getLeft() {
		left = offset.x;
		return left;
	}

	int getTop() {
		top = offset.y;
		return top;
	}

	int getRight() {
		right = getLeft() + getWidth();
		return right;
	}

	int getBottom() {
		bottom = getTop() + getHeight();
		return bottom;
	}

	boolean isToRightOf(Chess other) {
		IntRange th = new IntRange(top, bottom - 1);
		IntRange that = new IntRange(other.top, other.bottom - 1);
		boolean r = (left >= other.right) && (th.intersect(that));
		return r;
	}

	public Image getAsset() {
		return asset;
	}

	boolean isToLeftOf(Chess other) {
		IntRange me = new IntRange(top, bottom - 1);
		IntRange that = new IntRange(other.top, other.bottom - 1);
		boolean r = (right <= other.left) && (me.intersect(that));
		return r;
	}

	boolean isAboveOf(Chess other) {
		IntRange th = new IntRange(left, right - 1);
		IntRange that = new IntRange(other.left, other.right - 1);
		boolean r = (bottom <= other.top) && (th.intersect(that));
		return r;
	}

	boolean isBelowOf(Chess other) {
		IntRange me = new IntRange(left, right - 1);
		IntRange that = new IntRange(other.left, other.right - 1);
		boolean r = (top >= other.bottom) && (me.intersect(that));
		return r;
	}

	Chess checkAndMoveX(Integer deltaX, List<Chess> all) {
		if (Math.abs(deltaX) >= this.width) {
			return null;
		}
		List<Chess> others = new ArrayList<>(all.stream().filter(it -> !it.name.equals(name)).toList());
		for (int i = 0; i < others.size(); i++) {
			Chess other = others.get(i);
			if (deltaX > 0 && this.isToLeftOf(other) && (right + deltaX) >= other.left) {
				Chess c = moveByX(other.left - right);
				return c;
			} else if (deltaX < 0 && this.isToRightOf(other) && (left + deltaX) <= other.right) {
				Chess c = moveByX(other.right - left);
				return c;
			}
		}
		if (deltaX > 0) {
			Chess c = moveByX(Math.min(deltaX, BOARD_WIDTH - right));
			return c;
		} else {
			Chess c = moveByX(Math.max(deltaX, 0 - left));
			return c;
		}
	}

	Chess checkAndMoveY(Integer deltaY, List<Chess> others) {
		if (Math.abs(deltaY) >= this.height) {
			return null;
		}
		List<Chess> oths = others.stream().filter(it -> !it.name.equals(name)).toList();
		for (Chess other : oths) {
			if (deltaY > 0 && this.isAboveOf(other) && (bottom + deltaY) >= other.top) {
				Chess c = moveByY(other.top - bottom);
				return c;
			} else if (deltaY < 0 && this.isBelowOf(other) && (top + deltaY) <= other.bottom) {
				Chess c = moveByY(other.bottom - top);
				return c;
			}
		}
		if (deltaY > 0) {
			Chess c = moveByY(Math.min(deltaY, BOARD_HEIGHT - bottom));
			return c;
		} else {
			Chess c = moveByY(Math.max(deltaY, 0 - top));
			return c;
		}
	}

	@Override
	public String toString() {
		return "Chess [name=" + name + ", asset=" + asset.getUrl() + ", w=" + w + ", h=" + h + ", offset=" + offset
				+ ", bottom=" + bottom + ", height=" + height + ", left=" + left + ", right=" + right + ", top=" + top
				+ ", width=" + width + "]";
	}
}
