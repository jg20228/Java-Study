package GameFrameWork;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MyGame extends JFrame implements KeyListener{

	
	//static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	final public int gGameWidth = 640;
	final public int gGameHeight = 480;
	
	GameScreen gamescreen;
	
	public static void main(String[] args){
		
		new MyGame();
	}
	
	MyGame(){
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int f_xpos = (int) (screen.getWidth() / 2 - gGameWidth / 2);//â ��ġ�� ����� ȭ���� �߾ӿ� ��ġ��Ű�� ���� ��
		int f_ypos = (int) (screen.getHeight() / 2 - gGameHeight / 2);
		
		//â ����
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//â �ݱ� ����
		setUndecorated(true);//������ ����
		//set
		setBackground(new Color(0xffffff));//������ �⺻ ���� ���� (R=ff, G=ff, B=ff : �Ͼ��)
		setTitle("�������ۿ� ���� �����ӿ�ũ");//������ �̸� ����
		setLayout(null);//�������� ���̾ƿ��� ������ ����
		setBounds(f_xpos,f_ypos,gGameWidth,gGameHeight);//�������� ���� ��ġ�� �ʺ� ���� ����
		setResizable(false);//�������� ũ�⸦ ������ �� ����
		setVisible(true);//������ ǥ��

		addKeyListener(this);//Ű ������ ���
		
		gamescreen=new GameScreen(this);//ȭ�� ��ȭ�� ���� ĵ���� ��ü
		gamescreen.setBounds(0,0,gGameWidth,gGameHeight);
		add(gamescreen);//Canvas ��ü�� �����ӿ� �ø���
	}

	//Ű �Է� ó��
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("" + e);
		gamescreen.keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("" + e);
		gamescreen.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("" + e);
		gamescreen.keyReleased(e);
	}


}

class GameScreen extends Canvas implements Runnable{
	
	MyGame frame;
	
	BufferedImage buff;//������۸��� �����
	Graphics2D gc2;//������۸��� �׷��� ���ؽ�Ʈ
	
	BufferedImage ImgBuf;
	BufferedImage ImgBuf2;
	
	Random rnd = new Random();
	
	int dCnt;//ȭ�� �׸���� cnt
	int pCnt;//process�� cnt
	int delay;//���� ������. 1/1000�� ����.
	long pretime;//���� ������ �����ϱ� ���� �ð� üũ��
	
	int mode;//���� ��� ���� ȭ�� ��ü ���º���
	boolean isPause;//���� �Ͻ�����
	
	GameScreen(MyGame frame){
		
		this.frame = frame;
		setFocusable(false);
		
		dCnt = 0;
		pCnt = 0;
		mode = 0;
		delay = 15;
		isPause = false;
		
		ImgBuf = makeBufferedImage("magiczone.png") ;
		ImgBuf2 = makeBufferedImage("my_00.png") ;
		
		Thread thread = new Thread(this);
		thread.start();
		
		System.out.println("(0,0) to (100,0)'s degree = " + getAngle(0, 0, 100, 0));
		System.out.println("(0,0) to (100,100)'s degree = " + getAngle(0, 0, 100, 100));
		System.out.println("(0,0) to (0,100)'s degree = " + getAngle(0, 0, 0, 100));
		System.out.println("(100,100) to (200,0)'s degree = " + getAngle(100, 100, 200, 0));
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if(gc2==null){
			
			buff = new BufferedImage(frame.gGameWidth, frame.gGameHeight, BufferedImage.TYPE_INT_ARGB);//������ũ�� ����
			if(buff!=null)
				gc2 = buff.createGraphics();
			return;
		}
		update(g);
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if(gc2==null) return;
		
		dblpaint();//������ũ�� ���ۿ� �׸���
		g.drawImage((Image)buff, 0,0, frame.gGameWidth, frame.gGameHeight, this);//������ũ�� ���۸� ����ȭ�鿡 �׸���.
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				pretime=System.currentTimeMillis();
				process();
				repaint();

				if(System.currentTimeMillis()-pretime<delay) Thread.sleep(delay-System.currentTimeMillis()+pretime);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	void process(){
		
		if(isPause){
			//������ ���ϸ� pause�� ������ mode������..
			process_PAUSE();//�Ͻ������߿� ó���� �������� ����
			return;//�Ͻ������߿��� ��� process�� �����Ѵ�
		}

		switch(mode){
		case 0:
			process_TITLE();
			break;
		case 1:
			process_INTRO();
			break;
		case 2:
			process_PLAY();
			break;
		case 3:
			process_GAMEOVER();
			break;
		default:
			break;
		}

		pCnt++;
		
	}

	void dblpaint(){
		
		//ȭ�� ������ isPause�� ������ ���� �ʴ´�
		//��, �׷��� ���ؼ� draw_������ � �׸��� ���º�ȭ�� �־�� �ȵȴ�.
		//process��� draw�� cnt�� ���� �����°� ����..

		gc2.setColor(Color.WHITE);
		gc2.fillRect(0,  0, frame.gGameWidth, frame.gGameHeight);
		
		switch(mode){
		
		case 0:
			draw_TITLE();
			break;
		case 1:
			draw_INTRO();
			break;
		case 2:
			draw_PLAY();
			break;
		case 3:
			draw_GAMEOVER();
			break;
		default:
			break;
		}
		
		dCnt++;
		
		//test
		drawBImage(gc2, getRotateImage(getScaledImage(ImgBuf2, 240+Math.abs(dCnt%100-50),240+Math.abs(dCnt%100-50)), 360-pCnt%360), 320, 240, this);
		drawBImage(gc2, getRotateImage(getScaledImage(ImgBuf, 360,240), pCnt%360), 0, 0, this);
		drawBImage(gc2, getRotateImage(getScaledImage(ImgBuf, 240,360), 360-pCnt%360), 640, 0, this);
		drawBImage(gc2, getRotateImage(getScaledImage(ImgBuf, 480,480), 360-pCnt%360), 0, 480, this);
		drawBImage(gc2, getRotateImage(getScaledImage(ImgBuf, 360,360), pCnt%360), 640, 480, this);
	}
	
	
	//�� �κ��� ������(?) ä���ִ´�
	void process_TITLE(){
		
	}
	void process_INTRO(){
		
	}
	void process_PLAY(){
		
	}
	void process_GAMEOVER(){
		
	}
	void process_PAUSE(){
		
	}
	
	//��draw~ ������ �׸��� ���³� ��ġ�� ���� �������� �ʵ��� �ϴ°� ����
	void draw_TITLE(){
		
	}
	void draw_INTRO(){
		
	}
	void draw_PLAY(){
		
	}
	void draw_GAMEOVER(){
		
	}
	
	//Ű �Է� ������ ���ʿ���..
	public void keyTyped(KeyEvent e){
		
	}
	public void keyPressed(KeyEvent e){
		
	}
	public void keyReleased(KeyEvent e){
		
		//�Ͻ����� �׽�Ʈ
		if(e.getKeyCode()==KeyEvent.VK_0)
			isPause = !isPause;
	}
	
	/*
	 * �ڹ� ���� ���α׷��ֿ��� �������� ����� �� �ִ� ��ƾ ���� 
	 * 
	 * �̹��� ũ�� ����(Ȯ��/���)
	 * �̹��� ȸ��
	 * ������� ����
	 * ȿ���� �߻�
	 * ���� ������ ���� ���ϱ�
	 * �� ������ �ٸ� ���� ���� ����(degree) ���ϱ�
	 * �� �� ������ �Ÿ� ���ϱ�
	 * �����浹 ����
	 * 
	 */

	//�߽��� ��Ŀ�� ����� �׸���
	void drawBImage(Graphics2D g, BufferedImage image, int x, int y, ImageObserver obs){
		//center anchor draw
		int w = image.getWidth();
		int h = image.getHeight();
		
		g.drawImage(image, x-w/2, y-h/2, obs);
	}
	
	//Ȯ�� ��ҵ� BufferedImage ���
	BufferedImage getScaledImage(BufferedImage image, int width, int height){
		
		GraphicsConfiguration gc = frame.getGraphicsConfiguration();
		BufferedImage result = gc.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		
		double w = image.getWidth();
		double h = image.getHeight();
		g.scale((double)width/w, (double)height/h);
		g.drawRenderedImage(image, null);
		g.dispose();
		
		return result;
	}

	//ȸ����Ų BufferedImage ���
	BufferedImage getRotateImage(BufferedImage image, double angle){//angle : degree
		
		double _angle = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(_angle));
		double cos = Math.abs(Math.cos(_angle));
		double w = image.getWidth();
		double h = image.getHeight();
		int newW = (int)Math.floor(w*cos + h*sin);
		int newH = (int)Math.floor(w*sin + h*cos);
		
		GraphicsConfiguration gc = frame.getGraphicsConfiguration();
		BufferedImage result = gc.createCompatibleImage(newW, newH, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		
		g.translate((newW-w)/2, (newH-h)/2);
		g.rotate(_angle, w/2, h/2);
		g.drawRenderedImage(image, null);
		g.dispose();
		
		return result;
	}

	//Image ���ҽ� �о���̱�
	public Image makeImage(String furl){
		Image img;
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage(furl);
		try {
			//�������
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 0);
			mt.waitForID(0);
			//�������, getImage�� �о���� �̹����� �ε��� �Ϸ�ƴ��� Ȯ���ϴ� �κ�
		} catch (Exception ee) {
			ee.printStackTrace();
			return null;
		}	
		return img;
	}
	
	//BufferedImage ���ҽ� �о���̱� - Image�� BufferedImage�� �ٲٴ� ��� 
	public BufferedImage makeBufferedImage(String furl){
		
		Image img = null;
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage(furl);
		try {
			//�������
			MediaTracker mt = new MediaTracker(this);
			mt.addImage(img, 0);
			mt.waitForID(0);
			//�������, getImage�� �о���� �̹����� �ε��� �Ϸ�ƴ��� Ȯ���ϴ� �κ�
		} catch (Exception ee) {
			ee.printStackTrace();
			return null;
		}	

		BufferedImage bImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D bGr = bImg.createGraphics();
		bGr.drawImage(img, 0,0, null);
		bGr.dispose();

		return bImg;
	}

	//������� ���� - ���� ���� ����
	Clip bgmclip;
	public void playBgm(File file, boolean loop){
		try{
			//BGM�� ������ �������� ������ų �� �־�� �ϹǷ� �������� ���� Clip�� ����Ѵ�
			bgmclip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			bgmclip.open(AudioSystem.getAudioInputStream(file));
			bgmclip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					// TODO Auto-generated method stub
					System.out.println("" + event.getType());
					if(event.getType()==LineEvent.Type.STOP){
						bgmclip.close();
					}
				}
			});
			bgmclip.start();
			if(loop)
				bgmclip.loop(bgmclip.LOOP_CONTINUOUSLY);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//������� ����
	public void stopBgm(){
		
		if(bgmclip!=null && bgmclip.isRunning()){
			bgmclip.stop();
			bgmclip.close();
		}
	}
	//ȿ���� �߻� - Ƚ�� ����
	public void playSound(File file, int repeat){
		try{
			final Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					// TODO Auto-generated method stub
					System.out.println("" + event.getType());
					if(event.getType()==LineEvent.Type.STOP){
						//�� �κ��� ������ ȿ������ �޸𸮿� ���� �׿��� ������ ũ���õȴ�
						clip.close();
					}
				}
			});
			clip.loop(repeat);
			clip.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//���� ������ ���� ���ϱ�
	public int RAND(int startnum, int endnum) //��������(startnum���� ramdom����), �������� ����� ����.
	{
		int a, b;
		if(startnum<endnum)
			b = endnum - startnum; //b�� ���� ���� �߻� ��
		else
			b = startnum - endnum;
		a = Math.abs(rnd.nextInt()%(b+1));
		return (a+startnum);
	}
	//�� ������ �ٸ� ���� ���� ���� ���ϱ�
	int getAngle(int sx, int sy, int dx, int dy){
		int vx=dx-sx;
		int vy=dy-sy;
		double rad=Math.atan2(vy,vx);
		int degree=(int)(rad*57.3f)+90;
		if(degree<0)
			degree+=360;
		return degree;
	}
	//�� �� ������ �Ÿ� ���ϱ�
	public int getDistance(int x1,int y1,int x2,int y2){
		return Math.abs((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
		//���� ȯ��� �Ÿ��� �ƴ϶�� ���� ����
	}
	//�����浹 �����ϱ�
	public boolean getCollision(int x1, int y1, Rectangle rect1, int x2, int y2, Rectangle rect2){
		
		boolean ret = false;

		if(rect1==null)
			return false;
		
		if(rect2==null)
			return false;

		Rectangle _rect1 = new Rectangle(x1+rect1.x, y1+rect1.y, rect1.width, rect1.height);
		Rectangle _rect2 = new Rectangle(x2+rect2.x, y2+rect2.y, rect2.width, rect2.height);
		
		if(
		_rect1.x < (_rect2.x+_rect2.width) &&
		_rect2.x < (_rect1.x+_rect1.width) &&
		_rect1.y < (_rect2.y+_rect2.height) &&
		_rect2.y < (_rect1.y+_rect1.height)
				)
			ret = true;
		
		return ret;
	}
	//�����浹 �����ϱ� (������ǥ)
	public boolean getCollisionAb(Rectangle rect1, Rectangle rect2){
		
		boolean ret = false;

		if(rect1==null)
			return false;
		
		if(rect2==null)
			return false;

		if(
		rect1.x < (rect2.x+rect2.width) &&
		rect2.x < (rect1.x+rect1.width) &&
		rect1.y < (rect2.y+rect2.height) &&
		rect2.y < (rect1.y+rect1.height)
				)
			ret = true;
		
		return ret;
	}
	//�̹����κ��� ������ ������ǥ���� ����
	public Rectangle getRectfromImage(BufferedImage image, int x, int y, float scale){
		
		Rectangle rect = new Rectangle(0,0, -1,-1);
		
		float width = ((float)image.getWidth() * scale);
		float height = ((float)image.getHeight() * scale);
		
		x = x - (int)width*50;
		y = y - (int)height*50;
		
		rect.x = x/100;
		rect.y = y/100;
		rect.width = (int)width;
		rect.height = (int)height;
		
		return rect;
	}
	
	//�� a���� ����, �Ÿ��� �ִ� �� b ���ϱ�
	public Point getDegreePosition(int fx, int fy, int degree, int dist){
		
		Point pos = new Point(-1,-1);
		
		double rad = (degree-90)%360*Math.PI / 180;
		pos.x = (int)(fx + dist*Math.cos(rad));
		pos.y = (int)(fy + dist*Math.sin(rad));
		
		return pos;
	}
	
	//���� ���ڿ��� , �ֱ�
	public String numComma(String numStr){
		
		DecimalFormat df = new DecimalFormat("#,###");
		numStr = df.format(Integer.parseInt(numStr));

		return numStr;
	}
	//�׸����� �׸���
	public void drawNumber(Graphics2D g, BufferedImage image, String numStr, int x, int y, ImageObserver obs){
		
		int width = image.getWidth(this)/11;
		int height = image.getHeight(this);
		
		int _xx = x;
		for(int i=0;i<numStr.length();i++)
			if(numStr.charAt(i)==',')
				drawImageClip(g, image, _xx+i*width, y, 10*width, 0, width,height, 0);
			else
				drawImageClip(g, image, _xx+i*width, y, (numStr.charAt(i)-'0')*width, 0, width,height, 0);
	}
	//�̹��� Ŭ����
	public void drawImageClip(Graphics2D g, BufferedImage img, int x, int y, int sx,int sy, int wd,int ht, int anc){//sx,sy���� wd,ht��ŭ Ŭ�����ؼ� �׸���.
		if(x<0) {
			wd+=x;
			sx-=x;
			x=0;
		}
		if(y<0) {
			ht+=y;
			sy-=y;
			y=0;
		}
		if(wd<0||ht<0) return;
		x=x-(anc%3)*(wd/2);
		y=y-(anc/3)*(ht/2);
		g.setClip(x, y, wd, ht);
		g.drawImage(img, x-sx, y-sy, this);
		g.setClip(0,0, frame.gGameWidth,frame.gGameHeight);
	}
	//�̹����� ���� ������ ������ȭ�Ͽ� �߾����ķ� ���
	public void drawFrame(Graphics2D g, BufferedImage img, int x, int y, int widthFrame, int heightFrame, int frameNum, float scale){
	
		int width = img.getWidth() / widthFrame;
		int height = img.getHeight() / heightFrame;
		int sx = (frameNum % widthFrame) * width;
		int sy = (frameNum / heightFrame) * height;

		if(scale==1.0f)
			drawImageClip(g, img, x, y, sx, sy, width, height, 4);
		else
			drawImageClip(g, getScaledImage(img, (int)(img.getWidth()*scale), (int)(img.getHeight()*scale)), x, y, (int)(sx*scale), (int)(sy*scale), (int)(width*scale), (int)(height*scale), 4);
	}
}
