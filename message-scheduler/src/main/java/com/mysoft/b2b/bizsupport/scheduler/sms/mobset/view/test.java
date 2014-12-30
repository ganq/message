package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.view;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataObjectBean bean = DataObjectFactory.getInstance();
		bean.setServerIP("192.168.1.119");
		System.out.println(bean.getServerIP());
		bean = DataObjectFactory.getInstance();
		System.out.println(bean.getServerIP());
	}

}
