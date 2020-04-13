package ch13;

// OS는 Runnable 타입의 heap 공간에 run 메서드를 호출해야 된다는걸 이미 알고 있음.
class Sub implements Runnable {// extends Thread도 가능하나 다중상속이 안되어서 잘안씀
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("서브 쓰레드 : " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx01 {

	// 메인 쓰레드
	public static void main(String[] args) {
		Thread t1 = new Thread(new Sub()); // Thread(target 지정) - run만 실행하게 약속되어있다.
		t1.start();// OS 요청->새로운 스레드 생성->heap의 run 실행

		for (int i = 1; i < 6; i++) {
			System.out.println("메인 쓰레드 : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 스택 메서드
				// 해당쓰레드는 다른 쓰레드에 의해서 간섭이 오면 프로그램이 뻗는다.
				// 그래서 try catch가 필요함 Interrupted = 방해하다

		}
		//익명 클래스 스레드
		new Thread(new Runnable() {
			@Override
			public void run() {

			}
		}).start();//
	}
}
