package com.mysoft.b2b.bizsupport.mapper;

import java.util.List;

import com.mysoft.b2b.bizsupport.api.VerifyCodeFeedback;

public interface VerifyCodeFeedbackMapper {
	/**
	 * 保存验证码反馈信息
	 * 
	 * @param verifyCodeFeedback
	 * @return
	 */
	void saveVerifyCodeFeedback(VerifyCodeFeedback verifyCodeFeedback);

	/**
	 * 根据主键ID删除验证码反馈信息
	 * 
	 * @param uid
	 * @return
	 */
	int deleteVerifyCodeFeedbackByUid(String uid);

	/**
	 * 更新验证码反馈信息
	 * 
	 * @param verifyCodeFeedback
	 * @return
	 */
	int updateVerifyCodeFeedback(VerifyCodeFeedback verifyCodeFeedback);

	/**
	 * 查询验证码反馈信息
	 * 
	 * @param verifyCodeFeedback
	 * @return
	 */
	List<VerifyCodeFeedback> getVerifyCodeFeedbackList(VerifyCodeFeedback verifyCodeFeedback);
}
