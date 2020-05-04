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

	protected int goalX;
	protected int goalY;

	private ImageIcon imgHeroU = new ImageIcon("img/heroU.jpg");
	private ImageIcon imgHeroR = new ImageIcon("img/heroR.jpg");
	private ImageIcon imgHeroL = new ImageIcon("img/heroL.jpg");
	private ImageIcon imgHeroD = new ImageIcon("img/heroD.jpg");
	private ImageIcon ball = new ImageIcon("img/ball.jpg");
	private ImageIcon goal = new ImageIcon("img/goal.jpg");
	private ImageIcon wall = new ImageIcon("img/wall.jpg");


	private boolean focusU;
	private boolean focusL;
	private boolean focusR;
	private boolean focusD;

	private boolean play;

	protected JLabel[][] img;
	protected int[][] map;

	public Test01() {
		//RandomMap randomMap = new RandomMap();
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

		// swing 기본설정
		setTitle("100px 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		c.setLayout(null);
		// c.add(new MyPanel());
		// player 초기화
		imgHero = new JLabel(imgHeroU);
		focusU = true;
		focusL = false;
		focusR = false;
		focusD = false;
		play = true;
		imgHero.setSize(100, 100);
		
		//wall - 벽, ball - 공, goal - 도착점, hero - 플레이어
//		for (int i = 0; i < 8; i++) {
//			wallMaker(0, i,c);
//			wallMaker(i, 0,c);
//			wallMaker(i, 7,c); 
//			wallMaker(7, i,c); 
//		}
//		wallMaker(1, 3, c);
//		wallMaker(2, 3, c);
//		wallMaker(3, 3, c);
//		wallMaker(4, 3, c);
//		wallMaker(2, 1, c);
		
		ballMaker(2, 2, c);
		goalMaker(1, 6, c);
		heroMaker(1, 1, c);
		
//		// wall 생성 - 랜덤
//		for (int i = 0; i < 16; i++) {
//			int r = (int) ((Math.random() * 7));
//			int r2 = (int) ((Math.random() * 6)+1);
//			if(map[r2][r]!=3) {
//				map[r2][r] = 3;
//				img[r2][r] = new JLabel(wall);
//				img[r2][r].setSize(100, 100);
//				img[r2][r].setLocation(r2 * 100, r * 100);
//				c.add(img[r2][r]);
//			}
//		}
//		// ball 생성
//		while (true) {
//			int r1 = (int) ((Math.random() * 5) + 1);
//			int r2 = (int) ((Math.random() * 5) + 1);
//			if (map[r1][r2] < 1) {
//				map[r1][r2] = 1;
//				img[r1][r2] = new JLabel(ball);
//				img[r1][r2].setSize(100, 100);
//				img[r1][r2].setLocation(r1 * 100, r2 * 100);
//				c.add(img[r1][r2]);
//				break;
//			}
//		}
//		// goal 생성
//		while (true) {
//			int r1 = (int) ((Math.random() * 8));
//			int r2 = (int) ((Math.random() * 8));
//			goalX = r1;
//			goalY = r2;
//			if (map[r1][r2] < 1 && map[r1][r2]!=3) {
//				map[r1][r2] = 2;
//				img[r1][r2] = new JLabel(goal);
//				img[r1][r2].setSize(100, 100);
//				img[r1][r2].setLocation(r1 * 100, r2 * 100);
//				c.add(img[r1][r2]);
//				break;
//			}
//		}
		


//		while(true) {
//			int r1 = (int) ((Math.random() * 8));
//			int r2 = (int) ((Math.random() * 8));
//			if(map[r1][r2]==0) {
//				heroX=r1*100;
//				heroY=r2*100;
//				imgHero.setLocation(heroX, heroY);
//				c.add(imgHero);
//				break;
//			}
//		}
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
	public void wallMaker(int x, int y, Container c) {
		map[x][y] = 3;
		img[x][y] = new JLabel(wall);
		img[x][y].setSize(100, 100);
		img[x][y].setLocation(x * 100, y * 100);
		c.add(img[x][y]);
	}
	
	public void ballMaker(int x,int y,Container c) {
		map[x][y] = 1;
		img[x][y] = new JLabel(ball);
		img[x][y].setSize(100, 100);
		img[x][y].setLocation(x * 100, y * 100);
		c.add(img[x][y]);
	}
	public void goalMaker(int x,int y,Container c) {
		goalX=x;
		goalY=y;
		map[x][y] = 2;
		img[x][y] = new JLabel(goal);
		img[x][y].setSize(100, 100);
		img[x][y].setLocation(x * 100, y * 100);
		c.add(img[x][y]);
	}
	
	public void heroMaker(int x,int y,Container c) {
		heroX=x*100;
		heroY=y*100;
		imgHero.setLocation(x*100, y*100);
		c.add(imgHero);
	}
	
	class MyPanel extends JPanel {
		public MyPanel() {

		}

	}

	public static void main(String[] args) {
		new Test01();

	}

}
