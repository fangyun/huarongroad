/**
 * @Copyright kiloword.cn
 */
package cn.kiloword.huarongroad;

import java.lang.reflect.Constructor;

import cn.kiloword.huarongroad.ui.theme.ChessAssets;
import cn.kiloword.huarongroad.ui.theme.DarkChess;

/**
 * @author Fang Yun
 *
 */
public class Constants {
	private static ChessAssets c = initTheme();
	public static final Chess zhang = new Chess("张飞", c.getZhangfei(), 1, 2);
	public static final Chess cao = new Chess("曹操", c.getCaocao(), 2, 2);
	public static final Chess huang = new Chess("黄忠", c.getHuangzhong(), 1, 2);
	public static final Chess zhao = new Chess("赵云", c.getZhaoyun(), 1, 2);
	public static final Chess ma = new Chess("马超", c.getMachao(), 1, 2);
	public static final Chess guan = new Chess("关羽", c.getGuanyu(), 2, 1);
	public static final Chess[] zu = new Chess[] { new Chess("卒0", c.getZu(), 1, 1), new Chess("卒1", c.getZu(), 1, 1),
			new Chess("卒2", c.getZu(), 1, 1), new Chess("卒3", c.getZu(), 1, 1), };

	private static ChessAssets initTheme() {
		String c = System.getProperty("theme");
		if ("${theme}".equals(c)) {
			c = DarkChess.class.getSimpleName();
		}
		c = DarkChess.class.getPackageName() + "." + c;
		try {
			Constructor<?> constructor = Class.forName(c).getConstructor(new Class[] {});
			return (ChessAssets) constructor.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
