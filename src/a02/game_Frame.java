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
	// 화면크기
	int f_width;
	int f_height;

	// x,y
	int x, y;

	int[] cx = { 0, 0, 0 }; // 배경 스크롤 속도 제어용 변수
	int bx = 0; // 전체 배경 스크롤 용 변수

	// 키보드
	boolean keyUp, keyDown, keyLeft, keyRight = false;
	boolean keySpace = false;

	int cnt; // 각종 타이밍 조절을 위해 무한루프를 카운터할 변수

	int player_Speed; // 유저 캐릭터 이동속도
	int missile_Speed; // 미사일 속도
	int fire_Speed; // 미사일 연사 속도
	int enemy_Speed; // 적 이동 속도 설정

	// 유저 상태 0:평상시, 1:미사일 발사, 2:충돌
	int player_Status = 0;

	int game_Score; // 게임 점수 계산
	int player_HP; // 플에이어 캐릭터 체력

	// int e_w, e_h
	// int m_w, m_h

	Thread th;

	// 이미지 불러오기 위한 툴킷

	Image[] Player_img;// 플레이어 애니매이션 표현을 위한 배열
	Image[] Cloud_img;// 움직이는 구름용 이미지 배열
	Image[] Explo_img;// 폭팔 이펙트 이미지 배열
	Image BackGround_img; // 배경화면
	Image Missile_img; // 미사일 이미지 변수
	Image Enemy_img; // 적 이미지
	Image Missile2_img; //적 미사일

	// 미사일 관리 배열
	ArrayList Missile_List = new ArrayList();
	// 다수의 적 관리 배열
	ArrayList Enemy_List = new ArrayList();
	// 다수의 폭팔 이펙트 처리하기 위한 배열
	ArrayList Explosion_List = new ArrayList();

	// 더블 버퍼링 (이미지 깜빡임 없애기 위함)
	Image buffImage;
	Graphics buffg;

	Missile ms; // 미사일 클래스 접근 키
	Enemy en; // 에너미 클래스 접근 키
	Explosion ex; // 폭팔 이펙트용 클래스 접근 키

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
		f_width = 1200;
		f_height = 600;

		// 이미지 불러오기 방식 변경 -> getImage->ImageIcon
		Missile_img = new ImageIcon("img/Missile.png").getImage();
		Missile2_img = new ImageIcon("img/Missile2.png").getImage();
		Enemy_img = new ImageIcon("img/enemy.png").getImage();

		// 플레이어 애니메이션 표현을 위함
		Player_img = new Image[5];
		for (int i = 0; i < Player_img.length; ++i) {
			Player_img[i] = new ImageIcon("img/f15k_" + i + ".png").getImage();
		}
		// 배경화면 이미지
		BackGround_img = new ImageIcon("img/background.png").getImage();

		Cloud_img = new Image[3];
		for (int i = 0; i < Cloud_img.length; ++i) {
			Cloud_img[i] = new ImageIcon("img/cloud_" + i + ".png").getImage();
		}
		Explo_img = new Image[3];
		for (int i = 0; i < Explo_img.length; ++i) {
			Explo_img[i] = new ImageIcon("img/explo_" + i + ".png").getImage();
		}

		// 폭팔 애니메이션을 위해 파일이름을 넘버마다 배열로 받음
		// 모든 이미지는 Swing의 ImageIcon으로 받아 넓이, 높이를 바로 얻음

		game_Score = 0; // 게임 스코어 초기화
		player_HP = 3; // 최초 플레이어 체력
		player_Speed = 5; // 움직이는 속도
		missile_Speed = 11; // 미사일 움직임 속도
		fire_Speed = 15; // 미사일 연사 속도 설정
		enemy_Speed = 7; // 적이 날라오는 속도 설정
	}

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);

		th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		// 쓰레드가 노는곳
		try {
			while (true) {
				keyProcess();
				enemyProcess();
				missileProcess();

				explosionProcess();

				repaint();
				Thread.sleep(20);
				cnt++;// 무한 루프 카운터
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void missileProcess() {
		if (keySpace) {
			player_Status = 1;
			// 미사일 발사하면 플레이어 캐릭터 상태를 1로 변경

			// 플레이어 미사일 연사속도 조절
			if ((cnt % fire_Speed) == 0) {
				// 150, 30은 이미지를 고려함
				ms = new Missile(x + 150, y + 30,0 ,missile_Speed,0);
				Missile_List.add(ms); // 해당 미사일 추가
				ms = new Missile(x + 150, y + 30,330 ,missile_Speed,0);
				Missile_List.add(ms); // 해당 미사일 추가
				ms = new Missile(x + 150, y + 30,30,missile_Speed,0);
				Missile_List.add(ms); // 해당 미사일 추가
			}
		}

		for (int i = 0; i < Missile_List.size(); ++i) {
			ms = (Missile) Missile_List.get(i);
			ms.move();
			if (ms.x > f_width - 20 || ms.x < 0|| ms.y< 0 ||ms.y>f_height) {
				Missile_List.remove(i);
			}
			
			//적이 발사한 미사일이 플레이어와 충돌하는지 검사
			if (Crash(x, y, ms.x, ms.y, Player_img[0], Missile_img)
					&& ms.who ==1) {
				player_HP--;
				ex = new Explosion(x, y, 1);
				Explosion_List.add(ex);
				Missile_List.remove(i);
			}
			// 편의상 그림그리기 부분에 있던 미사일 이동과
			// 미사일이 화면에 벗어났을시 명령처리를 이쪽으로 옮김
			for (int j = 0; j < Enemy_List.size(); ++j) {
				en = (Enemy) Enemy_List.get(j);
				if (Crash(ms.x, ms.y, en.x, en.y, Missile_img, Enemy_img)
						&& ms.who==0) {
					// 미사일의 좌표 및 이미지 파일
					// 적의 좌표 및 이미지 파일을 받아 충돌 판정 메소드로 넘김
					// true,false값을 리턴 받아 true면 아래를 실행

					Missile_List.remove(i);
					Enemy_List.remove(j);

					game_Score += 10;

					// 적이 위치해 있는 곳의 중심 좌표 x,y 값과 폭발 설정 받은 값 0 또는 1 받습니다.
					// 폭발 설정 값 - 0 : 폭발, 1 : 단순 피격
					ex = new Explosion(en.x + Enemy_img.getWidth(null) / 2, en.y + Enemy_img.getHeight(null), 0);

					// 충돌판정으로 사라진 적의 위치에 이펙트 추가
					Explosion_List.add(ex);
				}
			}
		}
	}

	public void enemyProcess() {
		// 적 행동 처리 메소드
		for (int i = 0; i < Enemy_List.size(); ++i) {
			// 배열에 적이 생성되어 있을 때 해당되는 적을 판별
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
				// 플레이어와 적의 충돌 판정
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

		if (cnt % 200 == 0) {// 루프 300회 마다
			// 각 좌표로 적을 생성 한 후 배열에 추가
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
		// 폭발 이펙트 처리용 메소드

		// 이펙트 처리
		for (int i = 0; i < Explosion_List.size(); ++i) {
			ex = (Explosion) Explosion_List.get(i);
			ex.effect();
		}
	}

	public boolean Crash(int x1, int y1, int x2, int y2, Image img1, Image img2) {
		// x1, y1 = 미사일 좌표
		// x2, y2 = 적기체 좌표

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
		// 더블버퍼링 버퍼 크기를 화면 크기와 같게 설정
		buffImage = createImage(f_width, f_height);
		// 버퍼의 그래픽 객체를 얻기
		buffg = buffImage.getGraphics();

		update(g);
	}

	public void update(Graphics g) {

		draw_Background(); //배경
		draw_Player(); //플레이어
		draw_Enemy(); //적
		draw_Missile(); //미사일

		draw_Explosion(); //폭팔 이펙트
		draw_StatusText(); // 상태 표시 텍스트
		
		// 화면에 버퍼에 그린 그림을 가져와 그리기
		g.drawImage(buffImage, 0, 0, this);
	}

	public void draw_Background() {
		// 배경

		// 화면지우기
		buffg.clearRect(0, 0, f_width, f_height);

		if (bx > -3500) {
			// 기본 값이 0인 bx가 -3500보다 크면 실행
			buffg.drawImage(BackGround_img, bx, 0, this);
			bx -= 1;
			// bx를 0에서 -1만큼 계속 줄이므로 배경이미지의 x좌표는 계속 좌측으로 이동
			// 그러므로 전체 배경은 좌측으로 천천히 움직인다.
		} else {
			bx = 0;
		}

		// 구름 3개 이동
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
			case 0:// 평상시
				if ((cnt / 5 % 2 == 0)) {
					buffg.drawImage(Player_img[1], x, y, this);
				} else {
					buffg.drawImage(Player_img[2], x, y, this);
				}
				break;
			case 1 : //미사일 발사
				if ((cnt / 5 % 2 == 0)) {
					buffg.drawImage(Player_img[3], x, y, this);
				} else {
					buffg.drawImage(Player_img[4], x, y, this);
				}
				//발사후 0으로
				player_Status=0;
				break;
			case 2 : //충돌
				break;
			}
	}

	public void draw_Missile() {// 미사일 존재 확인
		for (int i = 0; i < Missile_List.size(); ++i) {
			// 미사일 위치값을 확인
			ms = (Missile) (Missile_List.get(i));
			//플레이어
			if(ms.who==0) {
				buffg.drawImage(Missile_img, ms.x, ms.y, this);
			}
			
			//적
			if(ms.who==1) {
				buffg.drawImage(Missile2_img, ms.x, ms.y, this);
			}
		}
	}

	public void draw_Enemy() {// 적 이미지를 그리는 부분
		for (int i = 0; i < Enemy_List.size(); ++i) {
			en = (Enemy) (Enemy_List.get(i));
			buffg.drawImage(Enemy_img, en.x, en.y, this);
		}
	}
	
	public void draw_Explosion() {
		//이펙트
		
		for (int i = 0; i < Explosion_List.size(); ++i) {
			//폭팔 이펙트 존재 유무 체크하며 리스트를 받음
			ex = (Explosion) Explosion_List.get(i);
			
			if(ex.damage == 0) {
				//설정값이 0이면 폭발용 이미지 그리기
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
					//폭발은 따로 카운터를 계산하여 이미지를 순차적으로 그림
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
					//단순 피격 또한 순차적으로 이미지를 그리지만 구분을 위해 약간 다른 방식으로 그림
					Explosion_List.remove(i);
					ex.ex_cnt=0;
				}
			}
		}
	}

	public void draw_StatusText() {
		//상태 체크용 텍스트
		
		//폰트 설정 , 기본 굵게 사이즈 20
		buffg.setFont(new Font("Default",Font.BOLD,20));
		
		//좌표 x : 1000, y : 70에 스코어 표시
		buffg.drawString("SCORE : " + game_Score, 1000, 70);
		
		//좌표 x : 1000, y : 90에 플레이어 체력 표시
		buffg.drawString("HP : "+player_HP,1000, 90);
		
		//좌표 x : 1000, y : 110에 스코어 표시
		buffg.drawString("Missile Count : " + Missile_List.size(), 1000, 110);
		
		//좌표 x : 1000, y : 130에 플레이어 체력 표시
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
