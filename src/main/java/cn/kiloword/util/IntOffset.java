package cn.kiloword.util;

public class IntOffset {
	public int x;
	public int y;

	public IntOffset(int i, int j) {
		this.x = i;
		this.y = j;
	}

	public IntOffset add(IntOffset o) {
		return new IntOffset(this.x + o.x, this.y + o.y);
	}

	@Override
	public String toString() {
		return "IntOffset [x=" + x + ", y=" + y + "]";
	}
}