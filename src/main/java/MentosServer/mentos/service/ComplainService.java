package MentosServer.mentos.service;

import MentosServer.mentos.config.BaseException;
import MentosServer.mentos.model.dto.GetComplainReq;
import org.springframework.stereotype.Service;

import static MentosServer.mentos.config.BaseResponseStatus.EMAIL_MAKE_ERROR;

@Service
public class ComplainService {
	
	public String makeMailText(int memberId, GetComplainReq req) throws BaseException{
		try{
			String str = "";
			int flag = req.getFlag();
			if(flag == 1) str = "멘토쓰 글";
			else if(flag == 2) str = "프로필";
			else str = "채팅";
			
			return "멤버로부터 신고가 들어왔습니다!\n" +
					"신고 한 멤버 아이디 = " + memberId + "\n" +
					"신고 분류 = " + str + "\n" +
					"신고 당한 멤버 아이디 또는 멘토쓰 글 번호 = " + req.getNumber() + "\n" +
					"신고 내용 = " + req.getText() + "\n";
		} catch (Exception exception) {
			throw new BaseException(EMAIL_MAKE_ERROR);
		}
	}
}
