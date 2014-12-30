package com.mysoft.b2b.bizsupport.api;

import java.util.List;

/**
 * 验证码反馈服务
 * 
 * @author subh
 * 
 */
public interface VerifyCodeFeedbackService {
	/**
	 * 保存验证码反馈信息
	 * 
	 * @param verifyCodeFeedback
	 * @return
	 */
	boolean saveVerifyCodeFeedback(VerifyCodeFeedback verifyCodeFeedback);

	/**
	 * 根据主键ID删除验证码反馈信息
	 * 
	 * @param uid
	 * @return
	 */
	boolean deleteVerifyCodeFeedbackByUid(String uid);

	/**
	 * 更新验证码反馈信息
	 * 
	 * @param verifyCodeFeedback
	 * @return
	 */
	boolean updateVerifyCodeFeedback(VerifyCodeFeedback verifyCodeFeedback);

	/**
	 * 查询验证码反馈信息
	 * 
	 * @param verifyCodeFeedback
	 * @return
	 */
	List<VerifyCodeFeedback> getVerifyCodeFeedbackList(VerifyCodeFeedback verifyCodeFeedback);
}
