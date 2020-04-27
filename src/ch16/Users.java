package ch16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//모델, Beans(콩)
//DB의 레코드를 자바세계의 오브젝트로 바꾸는것 = 모델링
@Data
@NoArgsConstructor //빈 생성자
@AllArgsConstructor //모든걸 채운 생성자
public class Users {
	private int id;
	private String name;
	private String email;
	private String password;
}
