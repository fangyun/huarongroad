/**
 * @Copyright kiloword.cn
 */
package cn.kiloword.util;

/**
 * @author Fang Yun
 *
 */
public class IntRange {
	public static IntRange EMPTY = new IntRange(1, 0);
	private Integer first;
	private Integer last;
	private Integer start;
	private Integer endInclusive;

	public IntRange(Integer start, Integer endInclusive) {
		this.first = start;
		this.last = endInclusive;
	}

	public Integer getStart() {
		start = first;
		return start;
	}

	public Integer getEndInclusive() {
		endInclusive = last;
		return endInclusive;
	}

	@Override
	public String toString() {
		return "IntRange [first=" + first + ", last=" + last + "]";
	}

	public boolean intersect(IntRange that) {
		return !(this.last < that.first) && !(this.first > that.last);
	}
}
