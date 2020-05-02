package a02;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class game_Frame extends JFrame implements KeyListener, Runnable {
	int f_width = 800;
	int f_height = 600;

	// x,y
	int x, y;
	// 키보드
	boolean keyUp, keyDown, keyLeft, keyRight = false;

	
	Thread th;

	// 이미지 불러오기 위한 툴킷
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image me_img = tk.getImage("img/f15k.png");
	
	// 더블 버퍼링 (이미지 깜빡임 없애기 위함)
	Image buffImage;
	Graphics buffg;
	

	public game_Frame() {
		init();
		start();

		setTitle("슈팅게임 테스트");
		setSize(f_width, f_height);
		// 현재 모니터 해상도 받아오기
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		// 정중앙 생성
		int f_xpos = (int) (screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int) (screen.getHeight() / 2 - f_height / 2);

		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}

	public void init() {
		x = 100;
		y = 100;

	}

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(this);
		th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		//쓰레드가 노는곳
		while(true) {
			try {
				keyProcess();
				repaint();
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		// 0,0~지정 x,y까지 지움
		g.clearRect(0, 0, f_width, f_height);
		// 이미지 넣기 & 자동그리기
		g.drawImage(me_img, x, y, this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W :
			keyUp = true;
			break;
		case KeyEvent.VK_S :
			keyDown = true;
			break;
		case KeyEvent.VK_A :
			keyLeft = true;
			break;
		case KeyEvent.VK_D :
			keyRight = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W :
			keyUp = false;
			break;
		case KeyEvent.VK_S :
			keyDown = false;
			break;
		case KeyEvent.VK_A :
			keyLeft = false;
			break;
		case KeyEvent.VK_D :
			keyRight = false;
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void keyProcess() {
		if(keyUp == true) y-=5;
		if(keyDown == true) y+=5;
		if(keyLeft == true) x-=5;
		if(keyRight == true) x+=5;
	}
}
