package project2;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test01 extends JFrame {
	// map - 0 = 이동가능, 1 - ball, 2 - goal, 3 - wall

	private JLabel imgHero;
	private int heroX;
	private int heroY;

	private int mapX;
	private int mapY;

	private int goalX;
	private int goalY;

	private ImageIcon imgHeroU = new ImageIcon("img/heroU.jpg");
	private ImageIcon imgHeroR = new ImageIcon("img/heroR.jpg");
	private ImageIcon imgHeroL = new ImageIcon("img/heroL.jpg");
	private ImageIcon imgHeroD = new ImageIcon("img/heroD.jpg");
	private ImageIcon wall = new ImageIcon("img/wall.jpg");
	private ImageIcon goal = new ImageIcon("img/goal.jpg");
	private ImageIcon ball = new ImageIcon("img/ball.jpg");

	private boolean focusU;
	private boolean focusL;
	private boolean focusR;
	private boolean focusD;

	private boolean play;

	private JLabel[][] img;
	private int[][] map;

	public Test01() {

		Container c = getContentPane();
		// 시작위치
		heroX = 0;
		heroY = 0;

		// 맵생성
		map = new int[8][8];
		img = new JLabel[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] < 1) {
					map[i][j] = 0;
				}
			}
		}

		mapX = 700;
		mapY = 700;

		// player 초기화
		imgHero = new JLabel(imgHeroU);
		focusU = true;
		focusL = false;
		focusR = false;
		focusD = false;
		play = true;
		imgHero.setSize(100, 100);
		imgHero.setLocation(heroX, heroY);
		c.add(imgHero);

		// swing 기본설정
		setTitle("100px 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		c.setLayout(null);
		// c.add(new MyPanel());

		// wall 생성
		for (int i = 2; i < 8; i++) {
			int r = (int) ((Math.random() * 7));
			map[i][r] = 3;
			img[i][r] = new JLabel(wall);
			img[i][r].setSize(100, 100);
			img[i][r].setLocation(i * 100, r * 100);
			c.add(img[i][r]);
		}
		// ball 생성
		while (true) {
			int r1 = (int) ((Math.random() * 5) + 1);
			int r2 = (int) ((Math.random() * 5) + 1);
			if (map[r1][r2] < 1) {
				map[r1][r2] = 1;
				img[r1][r2] = new JLabel(ball);
				img[r1][r2].setSize(100, 100);
				img[r1][r2].setLocation(r1 * 100, r2 * 100);

				c.add(img[r1][r2]);
				break;
			}
		}
		// goal 생성
		while (true) {
			int r1 = (int) ((Math.random() * 8));
			int r2 = (int) ((Math.random() * 8));
			goalX = r1;
			goalY = r2;

			if (map[r1][r2] < 1) {
				map[r1][r2] = 2;
				img[r1][r2] = new JLabel(goal);
				img[r1][r2].setSize(100, 100);
				img[r1][r2].setLocation(r1 * 100, r2 * 100);

				c.add(img[r1][r2]);
				break;
			}
		}
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (play) {
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						moveR();
					}
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						moveL();
					}
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						moveU();
					}
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						moveD();
					}
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						push();
					}
				}
				imgHero.setLocation(heroX, heroY);

			}
		});

		setSize(816, 838);
		setVisible(true);
	}

	public void push() {
		new Thread(new Runnable() {
			// push 후 move하기 위함
			int pushX = heroX / 100;
			int pushY = heroY / 100;

			@Override
			public void run() {
				// 방향,ball,미는곳이 벽이 아닌지 검사
				if (focusL && map[pushX - 1][pushY] == 1 && map[pushX - 2][pushY] != 3) {
					map[pushX - 2][pushY] = 1;
					for (int i = 0; i <= 5; i++) {
						try {
							Thread.sleep(50);
							img[pushX - 1][pushY].setLocation((pushX * 100) - 100 - (+20 * i), pushY * 100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					img[pushX - 2][pushY] = img[pushX - 1][pushY];
					img[pushX - 1][pushY] = null;
					map[pushX - 1][pushY] = 0;

				} else if (focusR && map[pushX + 1][pushY] == 1 && map[pushX + 2][pushY] != 3) {
					map[pushX + 2][pushY] = 1;
					for (int i = 0; i <= 5; i++) {
						try {
							Thread.sleep(50);
							img[pushX + 1][pushY].setLocation((pushX * 100) + 100 + (20 * i), pushY * 100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					img[pushX + 2][pushY] = img[pushX + 1][pushY];
					img[pushX + 1][pushY] = null;
					map[pushX + 1][pushY] = 0;

				} else if (focusU && map[pushX][pushY - 1] == 1 && map[pushX][pushY - 2] != 3) {
					map[pushX][pushY - 2] = 1;
					for (int i = 0; i <= 5; i++) {
						try {
							Thread.sleep(50);
							img[pushX][pushY - 1].setLocation(pushX * 100, (pushY * 100) - 100 - (20 * i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					img[pushX][pushY - 2] = img[pushX][pushY - 1];
					img[pushX][pushY - 1] = null;
					map[pushX][pushY - 1] = 0;

				} else if (focusD && map[pushX][pushY + 1] == 1 && map[pushX][pushY + 2] != 3) {
					map[pushX][pushY + 2] = 1;
					for (int i = 0; i <= 5; i++) {
						try {
							Thread.sleep(50);
							img[pushX][pushY + 1].setLocation(pushX * 100, (pushY * 100) + 100 + (20 * i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					img[pushX][pushY + 2] = img[pushX][pushY + 1];
					img[pushX][pushY + 1] = null;
					map[pushX][pushY + 1] = 0;
				}
				check();
			}
		}).start();
	}

	public void moveL() {
		focusU = false;
		focusL = true;
		focusR = false;
		focusD = false;
		imgHero.setIcon(imgHeroL);
		if (heroX <= 0) {
			heroX = 0;
		} else if (map[(heroX / 100) - 1][heroY / 100] == 0) {
			heroX -= 100;
		}
	}

	public void moveR() {
		focusU = false;
		focusL = false;
		focusR = true;
		focusD = false;
		imgHero.setIcon(imgHeroR);
		if (heroX >= mapX) {
			heroX = mapX;
		} else if (map[(heroX / 100) + 1][heroY / 100] == 0) {
			heroX += 100;
		}
	}

	public void moveU() {
		focusU = true;
		focusL = false;
		focusR = false;
		focusD = false;
		imgHero.setIcon(imgHeroU);
		if (heroY <= 0) {
			heroY = 0;
		} else if (map[heroX / 100][(heroY / 100) - 1] == 0) {
			heroY -= 100;
		}
	}

	public void moveD() {
		focusU = false;
		focusL = false;
		focusR = false;
		focusD = true;
		imgHero.setIcon(imgHeroD);
		if (heroY >= mapY) {
			heroY = mapY;
		} else if (map[heroX / 100][(heroY / 100) + 1] == 0) {
			heroY += 100;
		}

	}

	public void check() {
		if (map[goalX][goalY] == 1 && play) {
			play = false;
			JOptionPane.showMessageDialog(null, "end");
		}
	}

	class MyPanel extends JPanel {
		public MyPanel() {

		}

	}

	public static void main(String[] args) {
		new Test01();
	}

}
