package a02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class game_Frame extends JFrame implements KeyListener, Runnable {
	// ȭ��ũ��
	int f_width;
	int f_height;

	// x,y
	int x, y;

	int[] cx = { 0, 0, 0 }; // ��� ��ũ�� �ӵ� ����� ����
	int bx = 0; // ��ü ��� ��ũ�� �� ����

	// Ű����
	boolean keyUp, keyDown, keyLeft, keyRight = false;
	boolean keySpace = false;

	int cnt; // ���� Ÿ�̹� ������ ���� ���ѷ����� ī������ ����

	int player_Speed; // ���� ĳ���� �̵��ӵ�
	int missile_Speed; // �̻��� �ӵ�
	int fire_Speed; // �̻��� ���� �ӵ�
	int enemy_Speed; // �� �̵� �ӵ� ����

	// ���� ���� 0:����, 1:�̻��� �߻�, 2:�浹
	int player_Status = 0;

	int game_Score; // ���� ���� ���
	int player_HP; // �ÿ��̾� ĳ���� ü��

	// int e_w, e_h
	// int m_w, m_h

	Thread th;

	// �̹��� �ҷ����� ���� ��Ŷ

	Image[] Player_img;// �÷��̾� �ִϸ��̼� ǥ���� ���� �迭
	Image[] Cloud_img;// �����̴� ������ �̹��� �迭
	Image[] Explo_img;// ���� ����Ʈ �̹��� �迭
	Image BackGround_img; // ���ȭ��
	Image Missile_img; // �̻��� �̹��� ����
	Image Enemy_img; // �� �̹���
	Image Missile2_img; //�� �̻���

	// �̻��� ���� �迭
	ArrayList Missile_List = new ArrayList();
	// �ټ��� �� ���� �迭
	ArrayList Enemy_List = new ArrayList();
	// �ټ��� ���� ����Ʈ ó���ϱ� ���� �迭
	ArrayList Explosion_List = new ArrayList();

	// ���� ���۸� (�̹��� ������ ���ֱ� ����)
	Image buffImage;
	Graphics buffg;

	Missile ms; // �̻��� Ŭ���� ���� Ű
	Enemy en; // ���ʹ� Ŭ���� ���� Ű
	Explosion ex; // ���� ����Ʈ�� Ŭ���� ���� Ű

	public game_Frame() {
		init();
		start();

		setTitle("���ð��� �׽�Ʈ");
		setSize(f_width, f_height);

		// ���� ����� �ػ� �޾ƿ���
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		// ���߾� ����
		int f_xpos = (int) (screen.getWidth() / 2 - f_width / 2);
		int f_ypos = (int) (screen.getHeight() / 2 - f_height / 2);

		setLocation(f_xpos, f_ypos);
		setResizable(false);
		setVisible(true);
	}

	public void init() {
		x = 100;
		y = 100;
		f_width = 1200;
		f_height = 600;

		// �̹��� �ҷ����� ��� ���� -> getImage->ImageIcon
		Missile_img = new ImageIcon("img/Missile.png").getImage();
		Missile2_img = new ImageIcon("img/Missile2.png").getImage();
		Enemy_img = new ImageIcon("img/enemy.png").getImage();

		// �÷��̾� �ִϸ��̼� ǥ���� ����
		Player_img = new Image[5];
		for (int i = 0; i < Player_img.length; ++i) {
			Player_img[i] = new ImageIcon("img/f15k_" + i + ".png").getImage();
		}
		// ���ȭ�� �̹���
		BackGround_img = new ImageIcon("img/background.png").getImage();

		Cloud_img = new Image[3];
		for (int i = 0; i < Cloud_img.length; ++i) {
			Cloud_img[i] = new ImageIcon("img/cloud_" + i + ".png").getImage();
		}
		Explo_img = new Image[3];
		for (int i = 0; i < Explo_img.length; ++i) {
			Explo_img[i] = new ImageIcon("img/explo_" + i + ".png").getImage();
		}

		// ���� �ִϸ��̼��� ���� �����̸��� �ѹ����� �迭�� ����
		// ��� �̹����� Swing�� ImageIcon���� �޾� ����, ���̸� �ٷ� ����

		game_Score = 0; // ���� ���ھ� �ʱ�ȭ
		player_HP = 3; // ���� �÷��̾� ü��
		player_Speed = 5; // �����̴� �ӵ�
		missile_Speed = 11; // �̻��� ������ �ӵ�
		fire_Speed = 15; // �̻��� ���� �ӵ� ����
		enemy_Speed = 7; // ���� ������� �ӵ� ����
	}

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);

		th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		// �����尡 ��°�
		try {
			while (true) {
				keyProcess();
				enemyProcess();
				missileProcess();

				explosionProcess();

				repaint();
				Thread.sleep(20);
				cnt++;// ���� ���� ī����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void missileProcess() {
		if (keySpace) {
			player_Status = 1;
			// �̻��� �߻��ϸ� �÷��̾� ĳ���� ���¸� 1�� ����

			// �÷��̾� �̻��� ����ӵ� ����
			if ((cnt % fire_Speed) == 0) {
				// 150, 30�� �̹����� �����
				ms = new Missile(x + 150, y + 30,0 ,missile_Speed,0);
				Missile_List.add(ms); // �ش� �̻��� �߰�
				ms = new Missile(x + 150, y + 30,330 ,missile_Speed,0);
				Missile_List.add(ms); // �ش� �̻��� �߰�
				ms = new Missile(x + 150, y + 30,30,missile_Speed,0);
				Missile_List.add(ms); // �ش� �̻��� �߰�
			}
		}

		for (int i = 0; i < Missile_List.size(); ++i) {
			ms = (Missile) Missile_List.get(i);
			ms.move();
			if (ms.x > f_width - 20 || ms.x < 0|| ms.y< 0 ||ms.y>f_height) {
				Missile_List.remove(i);
			}
			
			//���� �߻��� �̻����� �÷��̾�� �浹�ϴ��� �˻�
			if (Crash(x, y, ms.x, ms.y, Player_img[0], Missile_img)
					&& ms.who ==1) {
				player_HP--;
				ex = new Explosion(x, y, 1);
				Explosion_List.add(ex);
				Missile_List.remove(i);
			}
			// ���ǻ� �׸��׸��� �κп� �ִ� �̻��� �̵���
			// �̻����� ȭ�鿡 ������� ���ó���� �������� �ű�
			for (int j = 0; j < Enemy_List.size(); ++j) {
				en = (Enemy) Enemy_List.get(j);
				if (Crash(ms.x, ms.y, en.x, en.y, Missile_img, Enemy_img)
						&& ms.who==0) {
					// �̻����� ��ǥ �� �̹��� ����
					// ���� ��ǥ �� �̹��� ������ �޾� �浹 ���� �޼ҵ�� �ѱ�
					// true,false���� ���� �޾� true�� �Ʒ��� ����

					Missile_List.remove(i);
					Enemy_List.remove(j);

					game_Score += 10;

					// ���� ��ġ�� �ִ� ���� �߽� ��ǥ x,y ���� ���� ���� ���� �� 0 �Ǵ� 1 �޽��ϴ�.
					// ���� ���� �� - 0 : ����, 1 : �ܼ� �ǰ�
					ex = new Explosion(en.x + Enemy_img.getWidth(null) / 2, en.y + Enemy_img.getHeight(null), 0);

					// �浹�������� ����� ���� ��ġ�� ����Ʈ �߰�
					Explosion_List.add(ex);
				}
			}
		}
	}

	public void enemyProcess() {
		// �� �ൿ ó�� �޼ҵ�
		for (int i = 0; i < Enemy_List.size(); ++i) {
			// �迭�� ���� �����Ǿ� ���� �� �ش�Ǵ� ���� �Ǻ�
			en = (Enemy) (Enemy_List.get(i));
			en.move();
			if (en.x < -200) {
				Enemy_List.remove(i);
			}
			if(cnt%50==0) {
				ms = new Missile(en.x, en.y+25, 180, missile_Speed, 1);
				Missile_List.add(ms);
			}
			if (Crash(x, y, en.x, en.y, Player_img[0], Enemy_img)) {
				// �÷��̾�� ���� �浹 ����
				player_HP--;
				Enemy_List.remove(i);
				game_Score += 10;

				ex = new Explosion(en.x + Enemy_img.getWidth(null) / 2, 
						en.y + Enemy_img.getHeight(null) / 2, 
						0);
				Explosion_List.add(ex);

				ex = new Explosion(x, y, 1);

				Explosion_List.add(ex);
			}

		}

		if (cnt % 200 == 0) {// ���� 300ȸ ����
			// �� ��ǥ�� ���� ���� �� �� �迭�� �߰�
			en = new Enemy(f_width + 100, 100, enemy_Speed);
			Enemy_List.add(en);
			en = new Enemy(f_width + 100, 200, enemy_Speed);
			Enemy_List.add(en);
			en = new Enemy(f_width + 100, 300, enemy_Speed);
			Enemy_List.add(en);
			en = new Enemy(f_width + 100, 400, enemy_Speed);
			Enemy_List.add(en);
			en = new Enemy(f_width + 100, 500, enemy_Speed);
			Enemy_List.add(en);
		}
	}

	public void explosionProcess() {
		// ���� ����Ʈ ó���� �޼ҵ�

		// ����Ʈ ó��
		for (int i = 0; i < Explosion_List.size(); ++i) {
			ex = (Explosion) Explosion_List.get(i);
			ex.effect();
		}
	}

	public boolean Crash(int x1, int y1, int x2, int y2, Image img1, Image img2) {
		// x1, y1 = �̻��� ��ǥ
		// x2, y2 = ����ü ��ǥ

		boolean check = false;
		if (Math.abs((x1 + img1.getWidth(null) / 2) - (x2 + img2.getWidth(null) / 2)) < (img2.getWidth(null) / 2
				+ img1.getWidth(null) / 2)
				&& Math.abs((y1 + img1.getHeight(null) / 2)
						- (y2 + img2.getHeight(null) / 2)) < (img2.getHeight(null) / 2 + img1.getHeight(null) / 2)) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public void paint(Graphics g) {
		// ������۸� ���� ũ�⸦ ȭ�� ũ��� ���� ����
		buffImage = createImage(f_width, f_height);
		// ������ �׷��� ��ü�� ���
		buffg = buffImage.getGraphics();

		update(g);
	}

	public void update(Graphics g) {

		draw_Background(); //���
		draw_Player(); //�÷��̾�
		draw_Enemy(); //��
		draw_Missile(); //�̻���

		draw_Explosion(); //���� ����Ʈ
		draw_StatusText(); // ���� ǥ�� �ؽ�Ʈ
		
		// ȭ�鿡 ���ۿ� �׸� �׸��� ������ �׸���
		g.drawImage(buffImage, 0, 0, this);
	}

	public void draw_Background() {
		// ���

		// ȭ�������
		buffg.clearRect(0, 0, f_width, f_height);

		if (bx > -3500) {
			// �⺻ ���� 0�� bx�� -3500���� ũ�� ����
			buffg.drawImage(BackGround_img, bx, 0, this);
			bx -= 1;
			// bx�� 0���� -1��ŭ ��� ���̹Ƿ� ����̹����� x��ǥ�� ��� �������� �̵�
			// �׷��Ƿ� ��ü ����� �������� õõ�� �����δ�.
		} else {
			bx = 0;
		}

		// ���� 3�� �̵�
		for (int i = 0; i < cx.length; ++i) {
			if (cx[i] < 1400) {
				cx[i] += 5 + i * 3;
			} else {
				cx[i] = 0;
			}
			buffg.drawImage(Cloud_img[i], 1200 - cx[i], 50 + i * 200, this);
		}
	}

	public void draw_Player() {

		switch (player_Status) {
			case 0:// ����
				if ((cnt / 5 % 2 == 0)) {
					buffg.drawImage(Player_img[1], x, y, this);
				} else {
					buffg.drawImage(Player_img[2], x, y, this);
				}
				break;
			case 1 : //�̻��� �߻�
				if ((cnt / 5 % 2 == 0)) {
					buffg.drawImage(Player_img[3], x, y, this);
				} else {
					buffg.drawImage(Player_img[4], x, y, this);
				}
				//�߻��� 0����
				player_Status=0;
				break;
			case 2 : //�浹
				break;
			}
	}

	public void draw_Missile() {// �̻��� ���� Ȯ��
		for (int i = 0; i < Missile_List.size(); ++i) {
			// �̻��� ��ġ���� Ȯ��
			ms = (Missile) (Missile_List.get(i));
			//�÷��̾�
			if(ms.who==0) {
				buffg.drawImage(Missile_img, ms.x, ms.y, this);
			}
			
			//��
			if(ms.who==1) {
				buffg.drawImage(Missile2_img, ms.x, ms.y, this);
			}
		}
	}

	public void draw_Enemy() {// �� �̹����� �׸��� �κ�
		for (int i = 0; i < Enemy_List.size(); ++i) {
			en = (Enemy) (Enemy_List.get(i));
			buffg.drawImage(Enemy_img, en.x, en.y, this);
		}
	}
	
	public void draw_Explosion() {
		//����Ʈ
		
		for (int i = 0; i < Explosion_List.size(); ++i) {
			//���� ����Ʈ ���� ���� üũ�ϸ� ����Ʈ�� ����
			ex = (Explosion) Explosion_List.get(i);
			
			if(ex.damage == 0) {
				//�������� 0�̸� ���߿� �̹��� �׸���
				if(ex.ex_cnt<7) {
					buffg.drawImage(Explo_img[0], 
							ex.x-Explo_img[0].getWidth(null)/2, 
							ex.y-Explo_img[0].getHeight(null)/2,
							this);
				}else if(ex.ex_cnt<14) {
					buffg.drawImage(Explo_img[1], 
							ex.x-Explo_img[1].getWidth(null)/2, 
							ex.y-Explo_img[1].getHeight(null)/2,
							this);
				}else if(ex.ex_cnt<21) {
					buffg.drawImage(Explo_img[2], 
							ex.x-Explo_img[2].getWidth(null)/2, 
							ex.y-Explo_img[2].getHeight(null)/2,
							this);
				}else if(ex.ex_cnt>21) {
					//������ ���� ī���͸� ����Ͽ� �̹����� ���������� �׸�
					Explosion_List.remove(i);
					ex.ex_cnt=0;
				}
			}else {
				if(ex.ex_cnt <7) {
					buffg.drawImage(Explo_img[0], ex.x+120, ex.y+15, this);
				}else if(ex.ex_cnt <14) {
					buffg.drawImage(Explo_img[1], ex.x+60, ex.y+5, this);
				}else if(ex.ex_cnt < 21) {
					buffg.drawImage(Explo_img[2], ex.x+5, ex.y+10, this);
				}else if(ex.ex_cnt >21) {
					//�ܼ� �ǰ� ���� ���������� �̹����� �׸����� ������ ���� �ణ �ٸ� ������� �׸�
					Explosion_List.remove(i);
					ex.ex_cnt=0;
				}
			}
		}
	}

	public void draw_StatusText() {
		//���� üũ�� �ؽ�Ʈ
		
		//��Ʈ ���� , �⺻ ���� ������ 20
		buffg.setFont(new Font("Default",Font.BOLD,20));
		
		//��ǥ x : 1000, y : 70�� ���ھ� ǥ��
		buffg.drawString("SCORE : " + game_Score, 1000, 70);
		
		//��ǥ x : 1000, y : 90�� �÷��̾� ü�� ǥ��
		buffg.drawString("HP : "+player_HP,1000, 90);
		
		//��ǥ x : 1000, y : 110�� ���ھ� ǥ��
		buffg.drawString("Missile Count : " + Missile_List.size(), 1000, 110);
		
		//��ǥ x : 1000, y : 130�� �÷��̾� ü�� ǥ��
		buffg.drawString("Enemy Count : "+Enemy_List.size(),1000, 130);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			keyUp = true;
			break;
		case KeyEvent.VK_S:
			keyDown = true;
			break;
		case KeyEvent.VK_A:
			keyLeft = true;
			break;
		case KeyEvent.VK_D:
			keyRight = true;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			keyUp = false;
			break;
		case KeyEvent.VK_S:
			keyDown = false;
			break;
		case KeyEvent.VK_A:
			keyLeft = false;
			break;
		case KeyEvent.VK_D:
			keyRight = false;
			break;
		case KeyEvent.VK_SPACE:
			keySpace = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void keyProcess() {
		if (keyUp == true) {
			if(y+Player_img[0].getHeight(null) < f_height) {
				y -= 5;
			}
		}

		if (keyDown == true){
			if(y>20) {
				y += 5;
			}
		}
		if (keyLeft == true) {
			if(x>0) {
				x-=5;
			}
		}
		if (keyRight == true) {
			if(x+Player_img[0].getWidth(null) < f_width) {
				x += 5;	
			}
		}
		player_Status=0;
	}
}
