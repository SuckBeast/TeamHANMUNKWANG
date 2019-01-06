package Controller;

public class MemberController {
public boolean passCheck(String pw ,String pwcheck) {
	if(pw.equals(pwcheck)) {
		return true;
	}else {
		return false;
	}
}
}
