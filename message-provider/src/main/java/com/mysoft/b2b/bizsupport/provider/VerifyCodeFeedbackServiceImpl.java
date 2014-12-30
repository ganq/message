package com.mysoft.b2b.bizsupport.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysoft.b2b.bizsupport.api.IdGenerationService;
import com.mysoft.b2b.bizsupport.api.VerifyCodeFeedback;
import com.mysoft.b2b.bizsupport.api.VerifyCodeFeedbackService;
import com.mysoft.b2b.bizsupport.mapper.VerifyCodeFeedbackMapper;

@Service("verifyCodeFeedbackService")
public class VerifyCodeFeedbackServiceImpl implements VerifyCodeFeedbackService {
	private static final Logger LOG = Logger.getLogger(VerifyCodeFeedbackServiceImpl.class);

	@Autowired
	private VerifyCodeFeedbackMapper verifyCodeFeedbackMapper;

	@Autowired
	private IdGenerationService idGenerationService;

	@Override
	public boolean saveVerifyCodeFeedback(VerifyCodeFeedback verifyCodeFeedback) {
		if (verifyCodeFeedback == null) {
			LOG.info("saveVerifyCodeFeedback error, verifyCodeFeedback=null.");
			return false;
		}

		String uid = "" + idGenerationService.getNextId("b2b_support.bizp_verify_code_feedback");
		verifyCodeFeedback.setUid(uid);
		verifyCodeFeedback.setApplyTime(new Date());
		if (verifyCodeFeedback.getStatus() == null) {
			verifyCodeFeedback.setStatus(1);
		}

		try {
			verifyCodeFeedbackMapper.saveVerifyCodeFeedback(verifyCodeFeedback);
			LOG.info("saveVerifyCodeFeedback success.");
			return true;
		} catch (Exception ex) {
			LOG.error("saveVerifyCodeFeedback fail, exception:" + ex.getMessage(), ex);
		}
		return false;
	}

	@Override
	public boolean deleteVerifyCodeFeedbackByUid(String uid) {
		if (StringUtils.isBlank(uid)) {
			LOG.info("deleteVerifyCodeFeedbackByUid error, uid=null.");
			return false;
		}

		int result = verifyCodeFeedbackMapper.deleteVerifyCodeFeedbackByUid(uid);

		if (result > 0) {
			LOG.info("deleteVerifyCodeFeedbackByUid success.");
			return true;
		}

		LOG.info("deleteVerifyCodeFeedbackByUid fail.");
		return false;
	}

	@Override
	public boolean updateVerifyCodeFeedback(VerifyCodeFeedback verifyCodeFeedback) {
		if (verifyCodeFeedback == null) {
			LOG.info("updateVerifyCodeFeedback fail, verifyCodeFeedback=null.");
			return false;
		}
		if (StringUtils.isBlank(verifyCodeFeedback.getUid())) {
			LOG.info("updateVerifyCodeFeedback fail, uid=null.");
			return false;
		}

		int result = verifyCodeFeedbackMapper.updateVerifyCodeFeedback(verifyCodeFeedback);
		if (result > 0) {
			LOG.info("updateVerifyCodeFeedback success.");
			return true;
		}

		LOG.info("updateVerifyCodeFeedback fail.");
		return false;
	}

	@Override
	public List<VerifyCodeFeedback> getVerifyCodeFeedbackList(VerifyCodeFeedback verifyCodeFeedback) {
		if (verifyCodeFeedback == null) {
			LOG.info("verifyCodeFeedback is null ,return empty list.");
			return new ArrayList<VerifyCodeFeedback>();
		}

		List<VerifyCodeFeedback> result = verifyCodeFeedbackMapper.getVerifyCodeFeedbackList(verifyCodeFeedback);
		if (result == null) {
			return new ArrayList<VerifyCodeFeedback>();
		}

		return result;
	}

}
