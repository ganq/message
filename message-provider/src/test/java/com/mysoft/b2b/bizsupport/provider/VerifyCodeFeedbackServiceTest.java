package com.mysoft.b2b.bizsupport.provider;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysoft.b2b.bizsupport.api.VerifyCodeFeedback;
import com.mysoft.b2b.bizsupport.api.VerifyCodeFeedbackService;
import com.mysoft.b2b.bizsupport.test.BaseTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
public class VerifyCodeFeedbackServiceTest extends BaseTestCase {

	private static final Logger log = Logger.getLogger(VerifyCodeFeedbackServiceTest.class);

	@Autowired
	private VerifyCodeFeedbackService verifyCodeFeedbackService;

	@Test
	public void testMethod() {
		log.info("--------------test--------------");
	}

//	@Test
//	public void testSave() {
//		log.info("--------------test save--------------");
//		VerifyCodeFeedback vo = new VerifyCodeFeedback();
//		vo.setUid("111");
//		vo.setToken("222");
//		vo.setVerifyCode("333");
//		vo.setMobile("444");
//
//		vo.setApplyTime(new Date());
//		vo.setStatus(1);
//
//		boolean ret = verifyCodeFeedbackService.saveVerifyCodeFeedback(vo);
//		log.info("=============ret:====>" + ret);
//	}
//
//	@Test
//	public void testUpdate() {
//		log.info("--------------test update--------------");
//		VerifyCodeFeedback vo = new VerifyCodeFeedback();
//		vo.setUid("111");
//		vo.setToken("222x");
//		vo.setVerifyCode("333x");
//		vo.setMobile("444x");
//
//		vo.setApplyTime(new Date());
//		vo.setStatus(1);
//
//		boolean ret = verifyCodeFeedbackService.updateVerifyCodeFeedback(vo);
//		log.info("=============ret:====>" + ret);
//	}
//
//	@Test
//	public void testQuery() {
//		log.info("--------------test query--------------");
//		VerifyCodeFeedback vo = new VerifyCodeFeedback();
//		vo.setUid("111");
//		vo.setToken("222x");
//		vo.setVerifyCode("333x");
//		vo.setMobile("444x");
//
//		List<VerifyCodeFeedback> list = verifyCodeFeedbackService.getVerifyCodeFeedbackList(vo);
//		log.info("=============ret:====>" + list);
//	}
//
//	@Test
//	public void testDelete() {
//		log.info("--------------test delete--------------");
//		String uid = "111";
//		boolean ret = verifyCodeFeedbackService.deleteVerifyCodeFeedbackByUid(uid);
//		log.info("=============ret:====>" + ret);
//	}
}
